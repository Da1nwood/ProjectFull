package Pars;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {
        protected static FileInputStream fileInputStream;
        protected static java.util.Properties PROPERTIES;

        static {
            try {
                fileInputStream = new FileInputStream("C:\\Users\\Никита\\Desktop\\ProjectFull\\src\\main\\resources\\Mysql.properties");
                PROPERTIES = new java.util.Properties();
                PROPERTIES.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fileInputStream != null)
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }

        public static String getProperty(String key) {
            return PROPERTIES.getProperty(key);
        }
    }
