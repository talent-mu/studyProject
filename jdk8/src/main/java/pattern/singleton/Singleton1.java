package pattern.singleton;

/**
 * 懒汉 线程不安全
 *
 * @author zmh
 * @create 2017-10-12 9:26
 **/
public class Singleton1 {
    private Singleton1() {};

    private static Singleton1 singleton = null;

    public static  Singleton1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}
