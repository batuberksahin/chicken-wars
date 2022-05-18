package ChickenWars.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected static boolean isDebug = true;
    
    public static void log(String logString) {
        if (!isDebug) return;
        
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        
        System.out.println(formatter.format(date) + ": " + logString);
    }
}
