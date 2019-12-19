package medicine.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class BackupDB {


    public static void createBackUp(String path) {
        try {

            Properties prop = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream stream = loader.getResourceAsStream("config.properties");
            prop.load(stream);          

            String userName = prop.getProperty("user");
            String password = prop.getProperty("password");
            String dbName = prop.getProperty("database");
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String datestring = dateFormat.format(date);
            String newdbName = dbName.concat(datestring);

            Process p = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                p = runtime.exec("lib//mysqldump.exe -u" + userName + " -p" + password + " --add-drop-database -B " + dbName + " -r " + path + newdbName + ".sql");

            } catch (IOException e) {
                System.out.println(e);
            }

        } catch (IOException e) {
            System.out.println("Cannot Establish Database Connection.");
        }

    }
}
