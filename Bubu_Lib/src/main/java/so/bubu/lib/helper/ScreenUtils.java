package so.bubu.lib.helper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * 获得屏幕相关的辅助类
 * 
 * @ClassName ScreenUtils
 * @Description TODO(这里用一句话描述这个类的作用)
 * @date 2015年1月5日
 * 
 */
public class ScreenUtils {

	private ScreenUtils() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * 获得屏幕宽度
	 * 
	 * @param context
	 * @return
	 */
	public static int getScreenWidth(Context context) {
		DisplayMetrics outMetrics = new DisplayMetrics();
		getDisplay(context).getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}

	/**
	 * 获得屏幕高度
	 * 
	 * @param context
	 * @return
	 */
	public static int getScreenHeight(Context context) {
		DisplayMetrics outMetrics = new DisplayMetrics();
		getDisplay(context).getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}

	/**
	 * 获取Display
	 *
	 * @param context
	 * @return
	 */
	public static Display getDisplay(Context context) {
		WindowManager manager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		return manager.getDefaultDisplay();
	}

	/**
	 * 设置为竖屏
	 * @param activity
	 */
	public static void setVerticalScreen(Activity activity){
		activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	/**
	 * 设置为横屏
	 * @param activity
	 */
	public static void setHorizontalScreen(Activity activity){
		activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	/**
	 * 获取当前屏幕亮度值（0~255）
	 *
	 * @param activity
	 */
	public static int getScreenBrightness(Activity activity) {
		int screenBrightness = 50;
		try {
			screenBrightness = Settings.System.getInt(activity.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return screenBrightness;
	}
	/**
	 * 保存当前的屏幕亮度值，并使之生效
	 *
	 * @param activity
	 * @param brightnessValue
	 *            亮度值（0~255）
	 */
	public static void setScreenBrightness(final Activity activity, final int brightnessValue) {
		Window localWindow = activity.getWindow();
		WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
		if (brightnessValue > 15 && brightnessValue <= 255) {
			float f = brightnessValue / 255.0F;
			localLayoutParams.screenBrightness = f;// 0-1 -> 暗-亮
			localWindow.setAttributes(localLayoutParams);
		} else if (brightnessValue >= 0 && brightnessValue <= 15) {// 预留6%不会全部变暗
			float f = 15 / 255.0F;
			localLayoutParams.screenBrightness = f;
			localWindow.setAttributes(localLayoutParams);
		}
	}

	/**
	 * 获得状态栏的高度
	 * 
	 * @param context
	 * @return
	 */
	public static int getStatusHeight(Context context) {

		int statusHeight = -1;
		try {
			Class<?> clazz = Class.forName("com.android.internal.R$dimen");
			Object object = clazz.newInstance();
			int height = Integer.parseInt(clazz.getField("status_bar_height")
					.get(object).toString());
			statusHeight = context.getResources().getDimensionPixelSize(height);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusHeight;
	}

	/**
	 * 获取当前屏幕截图，包含状态栏
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithStatusBar(Activity activity) {
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, 0, width, height);
		view.destroyDrawingCache();
		return bp;

	}

	/**
	 * 获取当前屏幕截图，不包含状态栏
	 * 
	 * @param activity
	 * @return
	 */
	public static Bitmap snapShotWithoutStatusBar(Activity activity) {
		View view = activity.getWindow().getDecorView();
		view.setDrawingCacheEnabled(true);
		view.buildDrawingCache();
		Bitmap bmp = view.getDrawingCache();
		Rect frame = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
		int statusBarHeight = frame.top;

		int width = getScreenWidth(activity);
		int height = getScreenHeight(activity);
		Bitmap bp = null;
		bp = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
		view.destroyDrawingCache();
		return bp;
	}
	
}
