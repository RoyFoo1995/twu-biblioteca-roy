package biblioteca;


import biblioteca.data.Menu;
import biblioteca.util.Console;
import biblioteca.util.InputHelper;

public class Controller {

    public void showMainMenu() {
        String welComeMsg = "----Welcome to Biblioteca Application----";
        showWelcomeMsg(welComeMsg);
        while (true) {
            for (int i = 0; i < Menu.mainMenu.length; i++) {
                System.out.println((i + 1) + ". " + Menu.mainMenu[i]);
            }
            int i = InputHelper.getInstance().getNum();
            choose(i);
        }
    }

    public void showWelcomeMsg(String welComeMsg) {
        Console.getInstance().println(welComeMsg);
    }


    public void choose(int i) {
        switch (i) {
            case Menu.LISTBOOK:
                showBookList();
                break;
            case Menu.QUIT:
                quit();
            default:
                Console.getInstance().println("Select a valid option!");
        }
    }

    public void quit() {
        Console.getInstance().println("Quit Success!");
        System.exit(0);
    }

    public void showBookList() {

    }
}
