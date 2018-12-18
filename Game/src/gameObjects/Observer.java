package gameObjects;

public interface Observer {
	public void updateCoordinates(int x) ;
	public void setattached() ;

	void setStopMoving(boolean s);
}
