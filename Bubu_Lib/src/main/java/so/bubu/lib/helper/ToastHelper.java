package so.bubu.lib.helper;

import android.os.CountDownTimer;
import android.view.Gravity;
import android.widget.Toast;

import so.bubu.lib.base.BaseApplication;

/**
 * 
 * function: Toast助手类
 * 
 * @ author:linjunying
 */
public class ToastHelper {

    private static Toast mToast;

    private static Toast getToast() {
        if (Helper.isNull(mToast)) {
            mToast = Toast.makeText(BaseApplication.getInstance(), "", Toast.LENGTH_SHORT);
        }
        return mToast;
    }
    
    /**
     * function: 显示Toast信息(短)
     *
     * @param text 显示文本
     * 
     * @author:linhuan 2014年7月15日 下午4:39:45
     */
    public static void showToast(CharSequence text) {
//    	if (text.toString().startsWith("requset")) {
//    		text = BaseApplication.getInstance().getString(R.string.hint_networkerror);
//		}
    	showToast(Toast.LENGTH_SHORT, text);
    }

    /**
     * function: 显示Toast信息(短)
     *
     * @param resId 显示文本的资源ID
     * @param formatArgs 字符串格式化参数
     * 
     * @author:linhuan 2014年7月15日 下午4:39:23
     */
    public static void showToast(int resId, Object... formatArgs) {
        showToast(Toast.LENGTH_SHORT, resId, formatArgs);
    }
    
    /**
     * function: 显示Toast信息(短)
     * 
     * @param resId
     * 
     * @author:linhuan 2014-8-1 上午11:59:57
     */
    public static void showToast(int resId) {
    	showToast(Toast.LENGTH_SHORT, ResourceHelper.getString(resId));
    }
    
    /**
     * function: 显示Toast信息(长)
     *
     * @param text 显示文本
     * 
     * @author:linhuan 2014年7月15日 下午4:40:12
     */
    public static void showLongToast(CharSequence text) {
    	showToast(Toast.LENGTH_LONG, text);
    }
    
    /**
     * function: 显示Toast信息(长)
     *
     * @param resId 显示文本的资源ID
     * @param formatArgs 字符串格式化参数
     * 
     * @author:linhuan 2014年7月15日 下午4:40:23
     */
    public static void showLongToast(int resId, Object... formatArgs) {
        showToast(Toast.LENGTH_LONG, resId, formatArgs);
    }
    
    /**
     * @param resId
     * 
     * @author:linhuan 2014-8-1 上午11:59:51
     */
    public static void showLongToast(int resId) {
    	showToast(Toast.LENGTH_LONG, ResourceHelper.getString(resId));
    }

    /**
     * 显示Toast信息
     *
     * @param duration   时长
     * @param resId      显示文本的资源ID
     * @param formatArgs 字符串格式化参数
     */
    private static void showToast(int duration, int resId, Object... formatArgs) {
        try {
            showToast(duration, ResourceHelper.getString(resId, formatArgs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * function: 显示Toast信息
     *
     * @param duration 时长
     * @param text 显示文本
     * 
     * @author:linhuan 2014年7月15日 下午4:41:42
     */
    private static void showToast(int duration, CharSequence text) {
        try {
            final Toast toast = getToast();
            int toastDurationInMilliSeconds = 1000;
            if (Helper.isNotNull(toast)) {
                // 4.0
//				toast.cancel();
                toast.setText(text);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                // Set the countdown to display the toast
                CountDownTimer toastCountDown;
                toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
                    public void onTick(long millisUntilFinished) {
                        toast.show();
                    }
                    public void onFinish() {
                        toast.cancel();
                    }
                };

                // Show the toast and starts the countdown
                toast.show();
                toastCountDown.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
