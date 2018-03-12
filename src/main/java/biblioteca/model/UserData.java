package biblioteca.model;

import biblioteca.entity.User;
import biblioteca.util.XMLUtil;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Iterator;

public class UserData implements IData<User> {
    private ArrayList<User> users;
    private static UserData userData;

    private UserData() {
    }
    public static UserData getInstance(){
        if (userData == null) {
            synchronized (BookData.class) {
                if (userData == null) {
                    userData = new UserData();
                    userData.generateData();
                }
            }
        }
        return userData;
    }
    @Override
    public void generateData() {
        try {
            users = new ArrayList<>();
            Element root = XMLUtil.getRootElement("/userList.xml");
            Element foo;
            for (Iterator i = root.elementIterator("user"); i.hasNext(); ) {
                foo = (Element) i.next();
                String number = foo.elementText("number");
                String password = foo.elementText("password");
                String name = foo.elementText("name");
                String email = foo.elementText("email");
                String phone = foo.elementText("phone");
                User user = new User(number,password,name,email,phone);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getData() {
        return users;
    }

    @Override
    public User getTheClassByName(String name) {
        for (User user:users){
            if (user.getLibraryNumber().equals(name)){
                return user;
            }
        }
        return null;
    }
}
