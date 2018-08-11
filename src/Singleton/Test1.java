package Singleton;
//饿汉模式：在类初始化阶段就实例化，不管是否需要。缺点是无法做到延迟创建对象。但是我们很多时候都希望对象可以尽可能地延迟加载，从而减小负载
public class Test1 {
    private Test1(){};
    private static Test1 Instance = new Test1();
    //如有需要，就给
    public static Test1 getInstance(){
        return Instance;
    }
}
