package pattern.proxy;

/**
 * @author zmh
 * @create 2017-10-24 16:26
 **/
public class ZhangSan implements People {
    @Override
    public void say() {
        System.out.println("我是张三，我会说话了");
    }
}
