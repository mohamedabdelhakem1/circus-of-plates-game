package starter;


import controller.Controller;
import view.MainMenu;


public class GameStart {
	
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		Controller controller = new Controller(mainMenu);
		mainMenu.setVisible(true);
	
	}


}
