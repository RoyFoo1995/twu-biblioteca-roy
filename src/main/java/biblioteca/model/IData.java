package biblioteca.model;

import java.util.ArrayList;

public interface IData<T> {
    void generateData();//读取xml文件生成数据
    ArrayList<T> getData();//返回当前数据集
    T getTheClassByName(String name);//通过名字获取对应类
}
