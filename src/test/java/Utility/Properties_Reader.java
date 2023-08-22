package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Properties_Reader {
    static FileInputStream fs;
    static Properties prop = new Properties();

    public static String browserName() throws IOException {
        fs = new FileInputStream("./src/test/resources/configuration.properties");
        prop.load(fs);
        String bsrName = prop.getProperty("Browser");
        return bsrName;

    }
}
