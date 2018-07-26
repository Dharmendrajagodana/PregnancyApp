package utilities;

import android.app.Activity;
import android.net.ConnectivityManager;

public class AppData {

     public  static boolean checkNONetWork(Activity activity){

    ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(activity.CONNECTIVITY_SERVICE);

             return cm.getActiveNetworkInfo() == null;

     }

}
