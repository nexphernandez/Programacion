package es.ies.puerto.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {
    
    public static class ConfigProperties{
        private static final Properties properties = new Properties();

        static {
            try {
                properties.load(new FileInputStream("cofig.properties"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static String getProperty(String key) {
            return properties.getProperty(key);
        }

    }
}
