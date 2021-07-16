package Singleton;

public class SingletonInnerClass {
    private static class InstanceHolder{
        private static SingletonInnerClass intance = new SingletonInnerClass();
    }

    private SingletonInnerClass(){}

    public SingletonInnerClass getInstance(){
        return InstanceHolder.intance;
    }
}
