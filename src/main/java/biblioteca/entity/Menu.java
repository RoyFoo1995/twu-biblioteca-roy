package biblioteca.entity;

public class Menu {
    //主菜单显示内容
    public static final String[] mainMenu = {"List Books", "List Movies", "CheckOut Book","checkOut Movie", "Return Book","Return Movie","User information", "Quit"};
    //对应关系
    public static final int LIST_BOOK = 1;
    public static final int LIST_MOVIES = 2;
    public static final int CHECKOUT_BOOK = 3;
    public static final int CHECKOUT_MOVIE = 4;
    public static final int RETURN_BOOK = 5;
    public static final int RETURN_MOVIE = 6;
    public static final int USER_INFORMATION = 7;
    public static final int QUIT = 8;
    public static final int CAN_READ = 1001;
    public static final int CHECK_OUTED = 1002;
}
