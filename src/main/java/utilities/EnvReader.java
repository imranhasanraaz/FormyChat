package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class EnvReader {
    public static String ReadEnv(String value){
        String getValue = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/.env");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            getValue =  properties.getProperty(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getValue;
    }
}
