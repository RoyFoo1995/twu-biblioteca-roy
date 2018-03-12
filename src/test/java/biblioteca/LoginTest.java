package biblioteca;

import biblioteca.manager.UserManager;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    private ByteArrayOutputStream bo;

    @Before
    public void setUp(){
        bo = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bo));
    }

    @Test
    public void successLoginWhenIInputRightAccount() {
        String userName = "";
        String password = "";
        boolean isSuccess = UserManager.login(userName, password);
        assertEquals(isSuccess, false);
        String userName2 = "001-0001";
        String password2 = "123";
        boolean isSuccess2 = UserManager.login(userName2, password2);
        assertEquals(isSuccess2, true);
    }

    @Test
    public void showUserInfoWhenIChooseFun() {
        String userName2 = "001-0001";
        String password2 = "123";
        UserManager.login(userName2, password2);
        UserManager.checkOutUserInfo();
        String msg = "Login Success!\n" +
                "name:Roy                  email:292701927@qq.com     phone:18180431019\n";
        assertEquals(bo.toString(),msg);
    }
}
