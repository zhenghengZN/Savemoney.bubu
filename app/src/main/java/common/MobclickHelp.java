package common;

import android.content.Context;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by Administrator on 2016/3/22.
 */
public class MobclickHelp {

    /**
     * onResume中调用
     *
     * @param simpleName
     * @param context
     */
    public static void onResume(String simpleName, Context context) {
        // 友盟
        MobclickAgent.onPageStart(simpleName);
        MobclickAgent.onResume(context);
    }

    /**
     * onPause中调用
     *
     * @param simpleName
     * @param context
     */
    public static void onPause(String simpleName, Context context) {
        // 友盟
        MobclickAgent.onPageEnd(simpleName);
        MobclickAgent.onPause(context);
    }

}
