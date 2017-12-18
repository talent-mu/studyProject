package pattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author zmh
 * @create 2017-11-15 16:46
 **/
public class Reader implements Observer {
    private String name;

    public Reader(String name) {
        this.name = name;
    }

    public void subscribe(String name) {
        WriterManager.getInstance().get(name).addObserver(this);
    }

    public void unsubscribe(String name) {
        WriterManager.getInstance().get(name).deleteObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Writer) {
            Writer writer = (Writer) o;
            System.out.println("读者（" + name + "）知道了作者（" + writer.getName() + ")发不了新作品（" + writer.getNewNovel() + ")");
        }
    }
}
