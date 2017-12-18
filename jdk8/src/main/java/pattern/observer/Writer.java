package pattern.observer;

import java.util.Observable;

/**
 * @author zmh
 * @create 2017-11-15 16:47
 **/
public class Writer extends Observable{
    private String newNovel;
    private String name;

    public Writer(String name) {
        super();
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    public void createNewNovel(String novelName) {
        newNovel = novelName;
        setChanged();
        notifyObservers();

    }

    public String getNewNovel() {
        return newNovel;
    }

    public void setNewNovel(String newNovel) {
        this.newNovel = newNovel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
