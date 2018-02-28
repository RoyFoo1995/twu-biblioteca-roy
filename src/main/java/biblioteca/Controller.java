package biblioteca;


import biblioteca.bean.Book;
import biblioteca.data.BookData;
import biblioteca.data.Menu;
import biblioteca.util.Console;
import biblioteca.util.InputHelper;

import java.util.ArrayList;

public class Controller {

    private boolean isExit = false;
    private BookManager bookManager;
    private ArrayList<Book> bookList;
    /**
     * 程序执行入口
     */
    public void exec() {
        initData();
        String welcomeMsg = "----Welcome to Biblioteca Application----";
        showWelcomeMsg(welcomeMsg);
        while (true) {
            showMainMenu();
            int i = InputHelper.getInstance().getNum();
            chooseFun(i);
            if (isExit){
                break;
            }
        }
    }

    private void initData() {
        bookManager = new BookManager();
        bookList = BookData.getInstance().getBookData();
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
    public void chooseFun(int i) {
        switch (i) {
            case Menu.LIST_BOOK:
                bookManager.showBookList(bookList);
                break;
            case Menu.QUIT:
                quit();
            default:
                Console.getInstance().println("Select a valid option!");//序号选择错误
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
