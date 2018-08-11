package Singleton;
//懒汉模式的优化：种写法考虑了线程安全，将对singleton的null判断以及new的部分使用synchronized进行加锁。同时，对singleton对象使用volatile关键字进行限制，保证其对所有线程的可见性，在类被优化后立刻更新。如此即可从语义上保证这种单例模式写法是线程安全的。
public class Test3 {
    private Test3(){};
    private static volatile Test3 instance = null;
    public static Test3 getInstance(){
        synchronized (Test3.class){
            if( instance == null){
                instance = new Test3();
            }
        }
        return instance;
    }
}
