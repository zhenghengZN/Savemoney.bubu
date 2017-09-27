package so.bubu.lib.helper;

import java.io.File;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;

import so.bubu.lib.base.BaseApplication;

/**
 * function: 设备信息 助手类
 * 
 * @author:linhuan
 */
public class DeviceHelper {
	
	// 牌子
	public static final String BRAND_SUMSUNG = "samsung";   // 三星
	public static final String BRAND_LENOVO = "LENOVO";   	// 联想
	public static final String BRAND_MEIZU = "Meizu";		// 魅族
    public static final String BRAND_HUAWEI = "Huawei";		// 华为
	private static final String ROOT = "/root";				// root判断
    private static int[] sScreenSize = null;
    private static int[] sWindowsSize = null;

    /**
     * function: 取得屏幕尺寸(0:宽度; 1:高度)
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:50:32
     */
    public static int[] getScreenSize() {
        if (Helper.isNull(sScreenSize)) {
            sScreenSize = new int[2];
            DisplayMetrics dm = BaseApplication.getInstance().getResources().getDisplayMetrics();
            sScreenSize[0] = dm.widthPixels;
            sScreenSize[1] = dm.heightPixels;
        }
        return sScreenSize;
    }

    /**
     * function: 取得屏幕宽度
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:50:38
     */
    public static int getScreenWidth() {
        return getScreenSize()[0];
    }

    /**
     * function: 取得屏幕高度
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:50:45
     */
    public static int getScreenHeight() {
        return getScreenSize()[1];
    }
    
    /**
     * function: 取得屏幕尺寸(0:宽度; 1:高度)
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:50:32
     */
    public static int[] getWindowsSize(Activity act) {
        if (Helper.isNull(sWindowsSize)) {
        	sWindowsSize = new int[2];
            Display display = act.getWindowManager().getDefaultDisplay();
            sWindowsSize[0] = display.getWidth();
            sWindowsSize[1] = display.getHeight();
        }
        return sScreenSize;
    }

    /**
     * function: 取得屏幕宽度
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:50:38
     */
    public static int getWindowsWidth(Activity act) {
        return getWindowsSize(act)[0];
    }

    /**
     * function: 取得屏幕高度
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:50:45
     */
    public static int getWindowsHeight(Activity act) {
        return getWindowsSize(act)[1];
    }
    
    /**
     * function: 是否ROOT
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:54:15
     */
    public static boolean isRoot() {
        return new File(ROOT).canRead();
    }
    
    /**
     * function: 取得设备唯一值
     * 默认为deviceId，其次为mac地址，若都获取失败则改用OpenUDID
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:57:46
     */
    public static String getDeviceUniqueString() {
        String result = getDeviceId();
        if (Helper.isEmpty(result)) {
            result = getMacAddress();
        }
//        if (Helper.isEmpty(result)) {
//            result = getOpenUDID(context);
//        }
        return result;
    }
    
    /**
     * function: 获取设备id
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:54:52
     */
    public static String getDeviceId() {
        try {
            TelephonyManager tm = (TelephonyManager) BaseApplication.getInstance().getSystemService(Context.TELEPHONY_SERVICE);
            return tm.getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * function: 获取app包名
     *
     * @return
     *
     * @author:linhuan 2014年7月15日 下午5:54:52
     */
    public static String getAppPackage() {
        try {
            PackageInfo packageInfo =  BaseApplication.getInstance().getApplicationContext().getPackageManager().getPackageInfo(BaseApplication.getInstance().getApplicationContext().getPackageName(), 0);
            return packageInfo.packageName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    

    /**
     * function: 取得mac地址
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:56:06
     */
    public static String getMacAddress() {
        try {
            WifiManager wifi = (WifiManager) BaseApplication.getInstance().getSystemService(Context.WIFI_SERVICE);
            return wifi.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
//   /**
//    * function: 获取OpenUDID
//    * 确保manifest中application节点有添加OpenUDID的service信息，详情查看doc/说明.txt
//    *
//    * @return
//    *
//    * @author:linhuan 2014年7月15日 下午5:56:54
//    */
//    public static String getOpenUDID() {
//        if (!OpenUDID_manager.isInitialized()) {
//            OpenUDID_manager.sync(BaseApplication.getInstance());
//        }
//        return OpenUDID_manager.getOpenUDID();
//    }

    /**
     * function: 得到sdk版本号
     * android.os.Build.VERSION.INCREMENTAL 比如4.0.3
     *
     * @return
     * 
     * @author:linhuan 2014年7月16日 下午12:04:55
     */
	public static int getSDKVersion() {
		return Build.VERSION.SDK_INT;
	}

    /**
     * function: 得到sdk版本号
     * android.os.Build.VERSION.INCREMENTAL 比如4.0.3
     *
     * @return
     * 
     * @author:linhuan 2014年7月16日 下午12:04:55
     */
	public static String getSDKIncremental() {
		return Build.VERSION.RELEASE;
	}
	
	/**
	 * function: 是否为某个牌子
	 *
	 * @return
	 * 
	 * @author:linhuan on 2014-5-14上午11:05:04
	 */
	public static boolean isBrand(String brand) {
		if (brand.equalsIgnoreCase(Build.BRAND)) {
			return true;
		} else {
			return false;
		}
	}
	
}
