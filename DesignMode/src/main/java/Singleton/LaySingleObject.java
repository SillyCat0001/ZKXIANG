package Singleton;

public class LaySingleObject {

    //只有在第一次获取instance的时候才创建
    private static LaySingleObject instance = null;

    private LaySingleObject(){};

    //缺点：线程不安全，多线程情况下，同时获取instance可能导致覆盖，而且存在不安全的发布问题
    public static LaySingleObject getInstance1(){
        if(instance == null)
            instance = new LaySingleObject();
        return instance;
    }


    //缺点：线程安全，但99%情况下不需要同步，浪费性能
    public static synchronized LaySingleObject getInstance2(){
        if(instance == null)
            instance = new LaySingleObject();
        return instance;
    }
}
