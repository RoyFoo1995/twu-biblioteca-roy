package biblioteca.util;

public class Console {

    private static Console console;

    private Console() {
    }

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

    public void println(String msg) {
        System.out.println(msg);
    }

    public void print(String msg) {
        System.out.print(msg);
    }
}
