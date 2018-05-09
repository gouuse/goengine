package com.gouuse.goenginesample.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.view.WindowManager;

import com.gouuse.goenginesample.constant.DialogAction;

/**
 * Created by reiserx on 2018/4/8.
 * desc :Dialog Util
 */
public class DialogUtil {

    /**
     * @param context              context
     * @param msg                  message
     * @param singleButtonCallback callback
     * @return AlertDialog
     */
    public static AlertDialog show(Context context, CharSequence msg, final SingleButtonCallback singleButtonCallback) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setMessage(msg)
                .setCancelable(true)
                .setPositiveButton("sure", (dialog, which) -> singleButtonCallback.onClick(dialog, DialogAction.POSITIVE))
                .setNegativeButton("cancel", (dialog, which) -> singleButtonCallback.onClick(dialog, DialogAction.NEGATIVE))
                .show();
        Window window = alertDialog.getWindow();
        if (window != null) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        }
        return alertDialog;
    }


    /**
     * A callback used for text dialogs.
     */
    public interface SingleButtonCallback {
        /**
         * @param dialog       The dialog of which only has a message.
         * @param dialogAction The button of which only has a message was clicked.
         */
        void onClick(@NonNull DialogInterface dialog, @NonNull DialogAction dialogAction);
    }

}
