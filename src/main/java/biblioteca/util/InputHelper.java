package biblioteca.util;


import java.util.Scanner;

public class InputHelper {

    private static Scanner scanner;
    private static InputHelper inputHelper;
    public static InputHelper getInstance() {
        if (inputHelper == null){
            synchronized (InputHelper.class){
                if (inputHelper == null){
                    inputHelper = new InputHelper();
                    scanner = new Scanner(System.in);
                }
            }
        }
        return inputHelper;
    }

    private InputHelper() {
    }


    public int getNum(String msg) {
        Console.getInstance().println(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    public String getString(String msg){
        Console.getInstance().println(msg);
        return scanner.nextLine();
    }
}
