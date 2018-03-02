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


    public int getNum() {
        Console.getInstance().println("Please input number:");
        int s = scanner.nextInt();
        scanner.nextLine();
        return s;
    }

    public String getString(){
        Console.getInstance().println("Please input book name to checkout:");
        return scanner.nextLine();
    }
}
