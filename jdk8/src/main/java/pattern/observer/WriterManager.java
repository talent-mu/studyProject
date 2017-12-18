package pattern.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zmh
 * @create 2017-11-15 16:57
 **/
public class WriterManager {
    private Map<String, Writer> writerMap = new HashMap<>();

    private WriterManager() {

    }

    public static WriterManager getInstance() {
        return WriterManagerInstance.instance;
    }

    private static class WriterManagerInstance {
        private static WriterManager instance = new WriterManager();
    }

    public void add(Writer writer) {
        writerMap.put(writer.getName(), writer);
    }

    public Writer get(String name) {
        return writerMap.get(name);
    }






}
