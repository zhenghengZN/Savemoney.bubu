package so.bubu.lib.helper;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

import so.bubu.lib.base.BaseApplication;

/**
 * function: application助手类
 * 
 * @author:linhuan
 */
public class ApplicationHelper {
	
	/**
	 * getIP:获取IP
	 * 
	 * @return
	 * 
	 * @author linhuan 2015-10-19下午8:21:57
	 */
	public static String getIP() {
		// 获取wifi服务
        WifiManager wifiManager = (WifiManager) BaseApplication.getInstance().getSystemService(Context.WIFI_SERVICE);
        // 判断wifi是否开启
        String ip = "";
        if (wifiManager.isWifiEnabled()) {
        	// 开启
        	WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        	int ipAddress = wifiInfo.getIpAddress();
            ip = intToIp(ipAddress);
        } else {
        	// 未开启
        	try {
        		for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                    NetworkInterface intf = en.nextElement();
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            ip = inetAddress.getHostAddress().toString();
                        }
                    }
                }
			} catch (Exception e) {}
        }
        return ip;
	}
	
	/**
	 * intToIp:转换IP
	 * 
	 * @param i
	 * @return
	 * 
	 * @author linhuan 2015-10-19下午8:19:17
	 */
	public static String intToIp(int i) {       
		return (i & 0xFF ) + "." + ((i >> 8 ) & 0xFF) + "." + ((i >> 16 ) & 0xFF) + "." + ( i >> 24 & 0xFF) ;  
	}   
	
	/**
	 * getAndroidOSVersion:获取sdk版本号
	 * 
	 * @return
	 * 
	 * @author linhuan 2015-10-19下午8:11:55
	 */
	public static int getAndroidOSVersion() {
         int osVersion;
         try {
            osVersion = Integer.valueOf(Build.VERSION.SDK);
         } catch (NumberFormatException e) {  
            osVersion = 0;  
         }
         return osVersion;
   }
    
    /**
     * function: 取得当前软件版本
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:51:35
     */
    public static int getCurrentVersion(Context context) {
        int versionCode = 0;
        try {
            PackageInfo info = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            versionCode = info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * function: 取得当前软件版本名称
     *
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午5:51:43
     */
    public static String getCurrentVersionName(Context act) {
        String versionName = "";
        try {
            PackageInfo info = act.getPackageManager().getPackageInfo(act.getPackageName(), 0);
            versionName = info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * function: 判断指定的服务是否已启动
     *
     * @param serviceFullName 服务全名(包括包名)
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午6:04:20
     */
    public static boolean isServiceRunning(String serviceFullName) {
        return isServiceRunning(BaseApplication.getInstance(), serviceFullName);
    }

    /**
     * function:  判断指定的服务是否已启动
     *
     * @param context
     * @param serviceFullName 服务全名(包括包名)
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午6:04:32
     */
    public static boolean isServiceRunning(Context context, String serviceFullName) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runningServices = manager.getRunningServices(40);
        if (Helper.isNotEmpty(runningServices)) {
            for (ActivityManager.RunningServiceInfo runningService : runningServices) {
                if (runningService.service.getClassName().equals(serviceFullName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * function: 判断是否安装过应用
     *
     * @param context
     * @param packageName 包名
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午6:06:52
     */
    public static boolean isAppInstalled(Context context, String packageName) {
        if (Helper.isEmpty(packageName)) {
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return packageInfo != null;
    }

    /**
     * function: 打开指定包名的应用
     *
     * @param context 上下文
     * @param packageName 包名
     * @return 启动成功与否
     * 
     * @author:linhuan 2014年7月16日 上午9:13:57
     */
    public static boolean launchApp(Context context, String packageName) {
        if (Helper.isNull(context) || Helper.isEmpty(packageName)) {
            return false;
        }
        // 获取指定包名的启动Intent
        PackageManager pm = context.getPackageManager();
        Intent intent = pm.getLaunchIntentForPackage(packageName);
        // 判断是否安装
        if (Helper.isNull(intent)) {
            return false;
        } else {
            context.startActivity(intent);
            return true;
        }
    }

    /**
     * function: 复制到剪贴板
     *
     * @param content 要复制的内容
     * 
     * @author:linhuan 2014年7月16日 上午9:15:58
     */
    public static void copyToClipboard(String content) {
        copyToClipboard(BaseApplication.getInstance(), content);
    }

    /**
     * 
     * function: 复制到剪贴板
     *
     * @param context 上下文
     * @param content 要复制的内容
     * 
     * @author:linhuan 2014年7月16日 上午9:16:28
     */
    public static void copyToClipboard(Context context, String content) {
        if (Helper.isNull(context)) {
            context = BaseApplication.getInstance();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            android.content.ClipboardManager newClipboardManager = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            newClipboardManager.setPrimaryClip(android.content.ClipData.newPlainText(content, content));
        } else {
            android.text.ClipboardManager oldClipboardManager = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            oldClipboardManager.setText(content);
        }
    }

    public static boolean hasActivity(String packageName, String className) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);

        return null != BaseApplication.getInstance().getPackageManager().resolveActivity(intent, 0);
    }
    
}
