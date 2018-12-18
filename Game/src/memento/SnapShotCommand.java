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
        gameWorld.setMemento(memento);
    }
}