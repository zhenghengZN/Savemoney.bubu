package so.bubu.lib.helper;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import java.util.Stack;
import so.bubu.lib.base.BaseApplication;

/**
 * activity管理
 *
 * @author linhuan 2016/1/27 0027 10:51
 */
public class AppManager {

    private static Stack<Activity> activityStack;                                               // Activity栈
    private static AppManager instance;                                                         // 单例模式

    private AppManager() {}

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        if (Helper.isNull(instance)) {
            instance = new AppManager();
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (Helper.isNull(activityStack)) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = currentActivity();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (Helper.isNotNull(activity)) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public boolean hasActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0; i < activityStack.size(); i++) {
            if (Helper.isNotNull(activityStack.get(i))) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
            ActivityManager activityMgr = (ActivityManager) BaseApplication.getInstance().getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(BaseApplication.getInstance().getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }

}
