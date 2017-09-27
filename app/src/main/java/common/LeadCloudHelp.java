package common;

import android.content.Context;

import com.avos.avoscloud.AVAnalytics;

/**
 * Created by Administrator on 2016/3/22.
 */
public class LeadCloudHelp {

    /**
     * activity onResume中调用
     *
     * @param context
     */
    public static void onResume(Context context) {
        // leadcloud
        AVAnalytics.onResume(context);
    }

    /**
     * activity onPause中调用
     *
     * @param context
     */
    public static void onPause(Context context) {
        // leadcloud
        AVAnalytics.onPause(context);
    }

    /**
     * fragment opPause调用
     *
     * @param simpleName
     */
    public static void onPause(String simpleName) {
        AVAnalytics.onFragmentEnd(simpleName);
    }

    /**
     * fragment onResume调用
     *
     * @param simpleName
     */
    public static void onResume(String simpleName) {
        AVAnalytics.onFragmentStart(simpleName);
    }

}
