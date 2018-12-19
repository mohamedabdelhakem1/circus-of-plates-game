package memento;

import gameWorld.GameWorld;

public class SnapShotCommand implements GameCommand{

    private Memento memento;
    private GameWorld gameWorld;
    
    public SnapShotCommand(GameWorld gameWorld){
        this.gameWorld = gameWorld;
    }

    @Override
    public void execute(int i) {
        memento = Caretaker.getMemento(i);
    }
    public void loadSnapShot() {
    	Originator originator = new Originator();
    	originator.RestoreFromMemento(memento);
    	
        gameWorld.setMemento(originator.storeInMemento());
        
    }
}