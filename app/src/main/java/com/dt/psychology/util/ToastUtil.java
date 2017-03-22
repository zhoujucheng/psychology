package com.dt.psychology.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by dnnt9 on 2017/3/17.
 */

public class ToastUtil {
    private static Toast mToast;

    public static void showToast(Context context,String content){
        if (mToast == null){
            mToast = Toast.makeText(context,content,Toast.LENGTH_LONG);
        }else mToast.setText(content);
        mToast.show();
    }
}
