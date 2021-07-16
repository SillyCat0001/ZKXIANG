package Singleton;

//线程安全版本，延迟初始化，但会造成并发性能问题
class DoubleCheck3 {
    private static DoubleCheck3 instance = null;

    private DoubleCheck3(){}

    public DoubleCheck3 getInstance(){
        //首先介绍三条happens-before原则：
        // 1. 依赖规则，如果操作存在依赖关系，那么书写在前面的操作happens-before于后面的操作
        // 2. 锁的happens-before原则：锁的unlock操作happen-before于锁的lock操作。
        // 3. 传递规则，A happens-before B, B happens-before C, 那么A happens-before C。
        //如果两个线程A、B同时进入getInstance，那么锁会保证两个线程按先后顺序执行同步代码块。
        // 并且由于传递规则，线程A的代码执行会早于线程A的unlock（依赖规则），早于B的lock（锁规则），早于B的代码执行（依赖规则）。
        //由于传递规则可以推导A的同步代码执行会happens-before于B的同步代码块的执行。
        //happens-before关系成立，那么A线程同步代码执行对内存的影响对B同步代码来说是可见的。
        synchronized (DoubleCheck3.class){
            if(instance == null)
                instance = new DoubleCheck3();
        }
        return instance;
    }
}



//线程安全的版本，并且除了创建的时候不会产生竞争，创建完成以后也没有锁的操作
//但是存在不安全发布的问题
public class DoubleCheck {
    private static DoubleCheck instance = null;

    private DoubleCheck(){}

    public DoubleCheck getInstance(){
        if(instance == null){
            //在以下同步原语内部的操作是有原子性的，要么不执行，要么全部执行，但不禁止同步原语内部的指令重排序！！！
            //但是由于同步原语内部的指令重排序instance的引用可能会先于对象初始化被发布出去
            //如果此时恰好有另一个线程在这一步拿到引用出去，那么这是它访问到的对象的状态是不可知的。
            //这一段代码的问题在于第一次检查不在同步原语内部，检测到instance不为空也就不会进入同步原语
            //不进入同步原语的后果就是锁的happens-before原则不生效，无法保证对象的状态对另外一个线程可见。
            synchronized (DoubleCheck.class){
                if(instance == null)
                    instance = new DoubleCheck();
            }
        }
        return instance;
    }
}



//线程安全，高效，且不存在不安全发布问题
class DoubleCheck2 {

    //volatile有两个作用：
    // 1.通过lock指令令cpu缓存失效，从主存重新加载从而保证可见性
    // 2.禁止指令重排序，对volatile变量的修改不会被重排。
    //第二条的意思是ABCDEF，如果C是操作volatile变量，那么C永远是第二步，可以是BACEFD,但BA不会晚于C，DEF也不会早于C。
    //通过javap -v分析字节码，发现instance = new DoubleCheck2()可以分解为三步， new, invokeInit, putStatic
    //putstatic是修改volatile变量，由于volatile禁止指令重排，前面的顺序不管，putstatic一定是最后一条执行的指令
    //因此这个也不存在不安全发布的问题。
    private static volatile DoubleCheck2 instance = null;

    private DoubleCheck2(){}

    public DoubleCheck2 getInstance(){

        if(instance == null){
            synchronized (DoubleCheck.class){
                if(instance == null)
                    instance = new DoubleCheck2();
            }
        }
        return instance;
    }
}




