package Singleton;

import Array.Test;

//懒汉法:这种方法可以实现延时加载，但是有一个致命弱点：线程不安全。如果有两条线程同时调用getSingleton()方法，就有很大可能导致重复创建对象。
public class Test2 {
    private Test2(){};
    private static Test2 instance = null;
    public static Test2 getInstance(){
        if(instance == null){
            instance = new Test2();
        }
        return instance;
    }

}
