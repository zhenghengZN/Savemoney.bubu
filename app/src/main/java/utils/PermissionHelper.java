package utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * Created by wneng on 16/6/21.
 */

public class PermissionHelper {

    private final Context mContext;

    /**
     * @param context
     */
    public PermissionHelper(Context context) {
        mContext = context.getApplicationContext();
    }


    /**
     * 判断权限是否已授予
     *
     * @param permission
     * @return
     */
    public boolean checkSelfPermission(String permission) {

        return ContextCompat.checkSelfPermission(mContext, permission) != PackageManager.PERMISSION_GRANTED;

    }


    /**
     * 判断权限集合
     *
     * @param permissions
     * @return
     */
    public boolean checkSelfPermissionList(String... permissions) {
        for (String permission : permissions) {
            if (checkSelfPermission(permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 安卓6.0系统以上
     * @return
     */
    public boolean isSDK_M(){

        return Build.VERSION.SDK_INT >= 23;
    }


}
