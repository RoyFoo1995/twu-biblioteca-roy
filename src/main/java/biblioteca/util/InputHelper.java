package biblioteca.util;


import java.util.Scanner;

/**
 * 输入相关
 */
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

    /**
     * 获取数字
     * @param msg 提示信息
     * @return 输入数字
     */
    public int getNum(String msg) {
        Console.getInstance().println(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * 获取字符串
     * @param msg 提示信息
     * @return 输入字符
     */
    public String getString(String msg){
        Console.getInstance().println(msg);
        return scanner.nextLine();
    }
}
