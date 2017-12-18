package classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zmh
 * @create 2017-10-31 15:04
 **/
public class MyClassLoad extends ClassLoader {
    private String name;
    private String path;

    public MyClassLoad(String name, String path) {
        super();
        this.name = name;
        this.path = path;
    }

    public MyClassLoad(ClassLoader parent, String name, String path) {
        super(parent);
        this.name = name;
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] data = readeClassFileToByteArray(name);

        return this.defineClass(name, data, 0, data.length);
    }

    private byte[] readeClassFileToByteArray(String name) {
        InputStream is = null;
        byte[] returnData = null;

        name.replaceAll("\\.", "/");
        String filePath = this.path + name + ".class";
        File file = new File(filePath);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            is = new FileInputStream(file);
            int temp = 0;
            while ((temp = is.read()) != -1) {
                bos.write(temp);
            }
            returnData = bos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnData;
    }

}
