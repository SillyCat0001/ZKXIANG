package Singleton;

public class HungerSingleObject {
    //缺点：第一次加载SingleObject时就立即创建instance对象。
    private final static HungerSingleObject instance = new HungerSingleObject();

    private HungerSingleObject(){}

    public static HungerSingleObject getInstance(){
        return instance;
    }
}
