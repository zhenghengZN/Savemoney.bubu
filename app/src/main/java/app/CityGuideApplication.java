package app;


import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Pair;

import com.alibaba.baichuan.android.trade.AlibcTradeSDK;
import com.alibaba.baichuan.android.trade.callback.AlibcTradeInitCallback;
import com.avos.avoscloud.AVAnalytics;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVInstallation;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.LogUtil;
import com.avos.avoscloud.PushService;
import com.avos.avoscloud.SaveCallback;

import common.ApiTokenManager;
import common.LeanCloudConfig;
import iconicfont.util.LearnCloudService;
import so.bubu.lib.base.BaseApplication;
import so.bubu.lib.helper.DeviceHelper;
import so.bubu.Coupon.AliTrade.activity.MainActivity;
import utils.SharedPreferencesHelp;
import utils.dbUtils.DbManager;

import static app.AppConfig.INSTALLATIION_KEY;
import static app.AppConfig.PACKAGE_KEY;


/**
 * 应用程序入口
 */
public class CityGuideApplication extends BaseApplication {

	public static LearnCloudService learnCloudService;
	@Override
	public void onCreate() {
		super.onCreate();

		initLeanCloud();
		DbManager.getInstance().initialize();

		AlibcTradeSDK.asyncInit(this, new AlibcTradeInitCallback() {
			@Override
			public void onSuccess() {

			}

			@Override
			public void onFailure(int i, String s) {
				LogUtil.log.e("asyncInit", s);
			}
		});

		addAsynTask(0);
		learnCloudService = new LearnCloudService(this);
	}

	@Override
	protected void startBackground(int type) {
//		PlaceListFragment.initPlaceMapData();
//		PlaceImgListFragment.initGuideMapData();
	}

	/**
	 * 初始化leancloud
	 */
	private void initLeanCloud() {

		if (LeanCloudConfig.IS_DEBUG) {
			Pair<String, String> devApiToken = ApiTokenManager.getInstance().getAvoCloudDebugApiToken();
			AVOSCloud.initialize(this.getApplicationContext(), devApiToken.first, devApiToken.second);
			AVOSCloud.setLastModifyEnabled(true);
			AVOSCloud.setDebugLogEnabled(true);
		} else {
			Pair<String, String> devApiToken = ApiTokenManager.getInstance().getAvoCloudReleaseApiToken();
			AVOSCloud.initialize(this.getApplicationContext(), devApiToken.first, devApiToken.second);

		}
		AVAnalytics.enableCrashReport(this, true);
//
//		AVOSCloud.setLastModifyEnabled(true);
//		AVOSCloud.setDebugLogEnabled(true);


		// 保存 installation 到服务器
		AVInstallation.getCurrentInstallation().saveInBackground(new SaveCallback() {
			@Override
			public void done(AVException e) {
				AVInstallation.getCurrentInstallation().saveInBackground();
				String installationId = AVInstallation.getCurrentInstallation().getInstallationId();
				SharedPreferencesHelp.setInstallationId(INSTALLATIION_KEY, installationId);
				SharedPreferencesHelp.setInstallationId(PACKAGE_KEY, DeviceHelper.getAppPackage());
//				LogHelper.e(installationId);

			}
		});
		// 设置默认打开的 Activity
		PushService.setDefaultPushCallback(this, MainActivity.class);
		PushService.subscribe(this, "CommonPushMsg", MainActivity.class);


	}

	public String getVersionName() {

		String version="";
		try {
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			version = info.versionName;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return version;
	}

	public String getPackagename() {

//		String packageName = "";
//		PackageManager manager = this.getPackageManager();
//		try {
//			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
//			packageName = info.packageName;
//
//		} catch (PackageManager.NameNotFoundException e) {
//			e.printStackTrace();
//		}
//		return packageName;
		return getPackageName();
	}

	public String getIpaddress() {

		WifiManager wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		//判断wifi是否开启
		if (!wifiManager.isWifiEnabled()) {
			wifiManager.setWifiEnabled(true);
		}
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		int ipAddress = wifiInfo.getIpAddress();
		String ip = intToIp(ipAddress);
		return ip;
	}

	private String intToIp(int i) {

		return (i & 0xFF ) + "." +
				((i >> 8 ) & 0xFF) + "." +
				((i >> 16 ) & 0xFF) + "." +
				( i >> 24 & 0xFF) ;
	}
}
