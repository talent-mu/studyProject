package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zmh
 * @create 2017-10-24 17:03
 **/
public class ProxyHandler implements InvocationHandler {

    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    private void before() {
        System.out.println("--------------------------");
    }

    private void after() {
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        People people = new ZhangSan();
        ProxyHandler proxyHandler = new ProxyHandler(people);
        People proxy = proxyHandler.getProxy();
        proxy.say();
    }
}
