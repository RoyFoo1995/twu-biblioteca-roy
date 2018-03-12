package biblioteca.manager;

import biblioteca.entity.User;
import biblioteca.model.UserData;
import biblioteca.util.Console;


public class UserManager {
    private static User currentUser;
    public static boolean login(String number, String password) {

        User user = UserData.getInstance().getTheClassByName(number);
        if (user != null && user.getPassword().equals(password)) {
            Console.getInstance().println("Login Success!");
            currentUser = user;
            return true;
        }
        Console.getInstance().println("Login Fail!");
        return false;
    }

    public static void checkOutUserInfo(){
        String msg = String.format("name:%-20s email:%-20s phone:%-10s",
                currentUser.getName(),currentUser.getEmail(),currentUser.getPhone());
        Console.getInstance().println(msg);
    }
}
