package pattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理类
 *
 * @author zmh
 * @create 2017-10-30 10:23
 **/
public class CGLibProxy implements MethodInterceptor {

    private CGLibProxy() {
    }

    private static CGLibProxy instance = new CGLibProxy();

    public static CGLibProxy getInstance() {
        return instance;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void before() {
        System.out.println("----------我是cglib----------------");
    }

    private void after() {
        System.out.println("--------------------------");
    }

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    public static void main(String[] args) {
        Lisi lisi = CGLibProxy.getInstance().getProxy(Lisi.class);
        lisi.say();
    }
}
