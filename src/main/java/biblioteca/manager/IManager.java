package biblioteca.manager;


public interface IManager {
    void showList();//打印数据集

    void checkOutByName(String name);//通过name检出相关数据

    void returnByName(String name);//通过name返回对应数据
}
