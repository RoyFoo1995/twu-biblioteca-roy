package biblioteca.util;

/**
 * 打印相关
 */
public class Console {

    private static Console console;

    private Console() {
    }

    /**
     * 单例实现
     * @return
     */
    public static Console getInstance() {
        if (console == null) {
            synchronized (Console.class) {
                if (console == null) {
                    console = new Console();
                }
            }
        }
        return console;
    }

    /**
     * 跨行打印
     * @param msg  打印信息
     */
    public void println(String msg) {
        System.out.println(msg);
    }

    /**
     * 普通打印
     * @param msg 打印信息
     */
    public void print(String msg) {
        System.out.print(msg);
    }
}
