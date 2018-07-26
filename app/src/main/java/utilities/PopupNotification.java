package utilities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class PopupNotification {


    private Activity activity;

    public PopupNotification(Activity ac) {
        this.activity = ac;
        openDialog();
    }

    private void openDialog() {
        new AlertDialog.Builder(activity)
                .setTitle("ALERT!!!")
                .setMessage("Cross check your network connectivity")
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                if (AppData.checkNONetWork(activity)) {
                                    openDialog();
                                }
                                // do something...
                            }
                        }
                ).show();
    }
}
