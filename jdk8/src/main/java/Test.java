import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zmh
 * @create 2017-09-20 12:45
 **/
public class Test {
    String haha = "ssss";
    Object hahaah = new Object();
    static String[] sksksk = new String[]{"sss", "ssdfd"};
    static HashMap<String, Object> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("2", "22");
//        map.put("2", "33");
//        for (int i = 0; i < 100000 ; i++) {
//            if (i == 768  ) {
//                System.out.println();
//            }
//            if (i == 6144  ) {
//                System.out.println();
//            }
//            if (i == 12288  ) {
//                System.out.println();
//            }
//            map.put(String.valueOf(i), "sssss");
//        }

//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        for (String item : list) {
//            if ("1".equals(item)) {
//                list.remove(item);
//            }
//        }
//        System.out.println(list);

        BlockingQueue bq = new BlockingQueue(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bq.enqueue("2");
                    bq.enqueue("2");
                    bq.enqueue("2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    bq.dequeue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        System.out.println(bq.limit);

        ArrayBlockingQueue abq = new ArrayBlockingQueue(10);

        ConcurrentHashMap chm = new ConcurrentHashMap();
    }

    static class BlockingQueue {

        private List queue = new LinkedList();

        private int limit = 10;

        public BlockingQueue(int limit) {

            this.limit = limit;
        }

        public synchronized void enqueue(Object item) throws InterruptedException {

            while (this.queue.size() == this.limit) {
                wait();
            }
            if (this.queue.size() == 0) {
                notifyAll();
            }
            this.queue.add(item);
        }

        public synchronized Object dequeue() throws InterruptedException {
            while (this.queue.size() == 0) {
                wait();
            }
            if (this.queue.size() == this.limit) {
                notifyAll();
            }
            return this.queue.remove(0);
        }
    }
}
