package model.clownBuilder.stack;

import java.util.ArrayList;

import model.clownBuilder.stack.Iterator.Container;
import model.clownBuilder.stack.Iterator.Iterator;
import model.clownBuilder.stack.state.EmptyStack;
import model.clownBuilder.stack.state.FullStack;
import model.clownBuilder.stack.state.StackState;
import model.clownBuilder.stack.state.UnfullStack;
import model.gameObjects.shapes.ElipsePlateObject;
import model.gameObjects.shapes.Plate;
import model.gameObjects.shapes.RegtanglePlateObject;

public class Stack implements StackIF, Container {

	private StackState fullstate;
	private StackState unfullstate;
	private StackState emptyState;
	private StackState currentstate;
	private int capacity;
	private ArrayList<Plate> plates;
	private int positionX;
	private int positionY;
	private int stackbottom = 62;
	private int limit = 480 + 62;
	private int RelativeXtoClown; // 51-40 for left // 157-40 for the right

	public Stack(int x) {
		plates = new ArrayList<Plate>();
		RelativeXtoClown = x;
		fullstate = new FullStack(this);
		unfullstate = new UnfullStack(this);
		emptyState = new EmptyStack(this);
		currentstate = emptyState;
	}

	@Override
	public StackState getCurrentState() {
		return currentstate;
	}

	@Override
	public int getRelativeXtoClown() {
		return RelativeXtoClown;
	}

	@Override
	public StackState getEmptyState() {
		return emptyState;
	}

	@Override
	public StackState getFullstackState() {
		return fullstate;
	}

	@Override
	public StackState getUnfullstackState() {
		return unfullstate;
	}

	@Override
	public void setUnfullstackState(StackState state) {
		unfullstate = state;
	}

	@Override
	public void setfullstackState(StackState state) {
		fullstate = state;
	}

	@Override
	public void setEmptystackState(StackState state) {
		emptyState = state;
	}

	@Override
	public void setState(StackState state) {
		currentstate = state;
	}

	@Override
	public void setStack(ArrayList<Plate> plates) {
		this.plates = plates;
	}

	@Override
	public ArrayList<Plate> getStack() {
		// TODO Auto-generated method stub
		return plates;
	}

	@Override
	public boolean addPlate(Plate plate) {
		if (plates.size() == capacity) {
			currentstate = fullstate;
		} else if (plates.size() < capacity) {
			currentstate = unfullstate;
		}
		return currentstate.AddPlate(plate);
	}

	@Override
	public boolean removePlate(Plate plate) {
		return currentstate.removePlate(plate);
	}

	@Override
	public void setCapacity(int capacity) {
		this.capacity = capacity;

	}

	@Override
	public int getCapacity() {

		return capacity;
	}

	@Override
	public int getSize() {
		return plates.size();
	}

	@Override
	public int getPositionX() {
		return positionX;
	}

	@Override
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	@Override
	public int getPositiony() {
		return positionY;
	}

	@Override
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	@Override
	public void notifyPlates(int x) {
		for (int i = 0; i < plates.size(); i++) {
			plates.get(i).updateCoordinates(x + RelativeXtoClown);
		}
	}

	@Override
	public void StopMoving(boolean s) {
		for (int i = 0; i < plates.size(); i++) {
			plates.get(i).setStopMoving(s);
		}

	}

	@Override
	public int getLimit() {
		return limit;
	}

	@Override
	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public ArrayList<Plate> checkStack() {

		return currentstate.checkConsecutivePlate();
	}

	@Override
	public Stack DeepClone() {
		Stack s = new Stack(RelativeXtoClown);
		s.setCapacity(capacity);
		s.setPositionX(positionX);
		s.setPositionY(positionY);
		s.setLimit(limit);
		ArrayList<Plate> pList = new ArrayList<>();
		for (Iterator iterator = getIterator(); iterator.hasNext();) {
			Plate p = (Plate) iterator.next();
			Plate plateTemp;
			if (p instanceof RegtanglePlateObject) {
				plateTemp = new RegtanglePlateObject(p.getX(), p.getY(), p.getWidth(), p.getHeight(),
						((RegtanglePlateObject) p).getColor());
				plateTemp.setattached(true);
				plateTemp.setX(p.getX());
				pList.add(plateTemp);
			} else if (p instanceof ElipsePlateObject) {
				plateTemp = new ElipsePlateObject(p.getX(), p.getY(), p.getWidth(), p.getHeight(),
						((ElipsePlateObject) p).getColor());
				plateTemp.setattached(true);
				plateTemp.setX(p.getX());
				pList.add(plateTemp);
			}
		}
		s.setStack(pList);
		s.setEmptystackState(new EmptyStack(s));
		s.setfullstackState(new FullStack(s));
		s.setUnfullstackState(new UnfullStack(s));
		if (currentstate instanceof EmptyStack) {
			s.setState(s.getEmptyState());
		} else if (currentstate instanceof FullStack) {
			s.setState(s.getFullstackState());
		} else if (currentstate instanceof UnfullStack) {
			s.setState(s.getUnfullstackState());
		}

		return s;
	}

	@Override
	public Iterator getIterator() {
		return new StackIterator(plates);
	}

	private class StackIterator implements Iterator {
		private ArrayList<Plate> list;
		private int index = 0;

		public StackIterator(ArrayList<Plate> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			if (index < list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if (hasNext()) {
				return list.get(index++);
			}
			return null;
		}

	}
}
