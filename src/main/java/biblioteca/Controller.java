package biblioteca;


import biblioteca.entity.Menu;
import biblioteca.manager.BookManager;
import biblioteca.manager.MovieManager;
import biblioteca.manager.UserManager;
import biblioteca.util.Console;
import biblioteca.util.InputHelper;

/**
 * 项目控制类
 */
public class Controller {

    private boolean isExit = false;
    private BookManager bookManager;
    private MovieManager movieManager;

    Controller() {
        initData();
    }

    public void login() {
        Console.getInstance().println("Please sign in:");
        String number = InputHelper.getInstance().getString("Input your library number:");
        String password = InputHelper.getInstance().getString("Input your password:");
        if (UserManager.login(number, password))
            exec();
        else
            login();
    }

    /**
     * 程序执行入口
     */
    private void exec() {
        String welcomeMsg = "----Welcome to Biblioteca Application----";
        showWelcomeMsg(welcomeMsg);
        while (true) {
            Console.getInstance().println("----Main---Menu----");
            showMainMenu();
            int i = InputHelper.getInstance().getNum("Please input option number:");
            chooseFun(i);
            if (isExit)
                break;
        }
    }

    /**
     * 初始化相关数据
     */
    private void initData() {
        bookManager = new BookManager();
        movieManager = new MovieManager();
    }

    /**
     * 显示菜单
     */
    public void showMainMenu() {
        for (int i = 0; i < Menu.mainMenu.length; i++) {
            Console.getInstance().println((i + 1) + ". " + Menu.mainMenu[i]);
        }
    }

    /**
     * 打印欢迎信息
     *
     * @param welcomeMsg 欢迎信息
     */
    public void showWelcomeMsg(String welcomeMsg) {
        Console.getInstance().println(welcomeMsg);
    }

    /**
     * 选择功能
     *
     * @param i 用户输入序号
     */
    private void chooseFun(int i) {
        switch (i) {
            case Menu.LIST_BOOK:
                bookManager.showList();
                InputHelper.getInstance().getString("please input anything to continue:");
                break;
            case Menu.CHECKOUT_BOOK:
                bookManager.showList();
                bookManager.checkOutByName(InputHelper.getInstance().getString("Please input book name to checkout:"));
                break;
            case Menu.RETURN_BOOK:
                bookManager.returnByName(InputHelper.getInstance().getString("Please input book name to return:"));
                break;
            case Menu.QUIT:
                quit();
                break;
            case Menu.LIST_MOVIES:
                movieManager.showList();
                InputHelper.getInstance().getString("please input anything to continue:");
                break;
            case Menu.CHECKOUT_MOVIE:
                movieManager.showList();
                movieManager.checkOutByName(InputHelper.getInstance().getString("Please input movie name to checkout:"));
                break;
            case Menu.RETURN_MOVIE:
                movieManager.returnByName(InputHelper.getInstance().getString("Please input movie name to return:"));
                break;
            case Menu.USER_INFORMATION:
                UserManager.checkOutUserInfo();
                break;
            default:
                Console.getInstance().println("Select a valid option!");
                break;//序号选择错误
        }
    }

    /**
     * 退出程序功能
     */
    public void quit() {
        Console.getInstance().print("Quit Success!");
        isExit = true;
    }


}
