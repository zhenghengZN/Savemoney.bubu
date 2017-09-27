package so.bubu.lib.helper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;

import java.io.File;
import java.util.List;

import so.bubu.lib.R;
import so.bubu.lib.base.BaseActionBarActivity;
import so.bubu.lib.base.BaseActivity;
import so.bubu.lib.base.BaseCompatActivity;
import so.bubu.lib.base.BaseConstants;
import so.bubu.lib.base.BaseFragmentActivity;


/**
 * 	function: 导航、跳转(startActivity、startActivityForResult、finish) 助手类
 *
 *  slideActivity：默认进入动画从左到右，后退动画从右到左
 *  slideActivityForResult
 *	pushupActivity：默认进入动画从下推出，后退动画从上推入
 *	pushupActivityForResult
 *	showActivity: 显示类似窗口的页面
 *
 *	startActivity：可自定义动画
 *	startActivityForResult：可自定义动画
 *
 *	finish: 代替finish
 *
 * @author:linhuan
 */
public class NavigationHelper {

	private static final int ANDROID_NOT_HAS_CROP = 4;											// 当Android系统不存在截图时


	/**
	 * 欢迎页出现
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param finish 是否关闭当前界面
	 */
	public static final void fadeInActivity(Activity act, Class<?> toActivity, Bundle bundle, boolean finish) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_ALPHA);
		startActivity(act, toActivity, bundle, finish, android.R.anim.fade_in, android.R.anim.fade_out, 0, 0);
	}

	/**
	 * 渐变出现
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param finish 是否关闭当前界面
	 */
	public static final void alphaActivity(Activity act, Class<?> toActivity, Bundle bundle, boolean finish) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_ALPHA);
		startActivity(act, toActivity, bundle, finish, R.anim.push_alpha_in, R.anim.push_alpha_out, 0, 0);
	}

	/**
	 * 渐变出现
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param searchTypeData
	 * @param finish 是否关闭当前界面
	 */
	public static final void alphaActivityAddsearchTypeData(Activity act, Class<?> toActivity, int searchTypeData,Bundle bundle, boolean finish) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_ALPHA);
		startActivityAddIntent(act, toActivity, searchTypeData, bundle, finish, R.anim.push_alpha_in, R.anim.push_alpha_out, 0, 0);
	}

	/**
	 * 渐变出现
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param requestCode
	 */
	public static final void alphaActivityForResult(Activity act, Class<?> toActivity, Bundle bundle, int requestCode) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_ALPHA);
		startActivityForResult(act, toActivity, bundle, requestCode, R.anim.push_alpha_in, R.anim.push_alpha_out, 0, 0);
	}

	/**
	 * 从右往左
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param finish 是否关闭当前界面
	 */
	public static final void slideActivity(Activity act, Class<?> toActivity, Bundle bundle, boolean finish) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_SLIDE);
		startActivity(act, toActivity, bundle, finish, R.anim.push_left_in, R.anim.push_left_out, 0, 0);
	}

	/**
	 * 从右往左，接收返回数据
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param requestCode
	 */
	public static final void slideActivityForResult(Activity act, Class<?> toActivity, Bundle bundle, int requestCode) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_SLIDE);
		startActivityForResult(act, toActivity, bundle, requestCode, R.anim.push_left_in, R.anim.push_left_out, 0, 0);
	}

	/**
	 * 从下往上
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param finish
	 */
	public static final void pushupActivity(Activity act, Class<?> toActivity, Bundle bundle, boolean finish) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_PUSHUP);
		startActivity(act, toActivity, bundle, finish, R.anim.push_up_in, R.anim.push_up_out, 0, 0);
	}

	/**
	 * 从上往下
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param finish
	 */
	public static final void pushHeadActivity(Activity act, Class<?> toActivity, Bundle bundle, boolean finish) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_PUSHUP);
		startActivity(act, toActivity, bundle, finish, R.anim.pull_head_in, R.anim.pull_head_out, 0, 0);
	}



	/**
	 * 从下往上，接收返回数据
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param requestCode
	 */
	public static final void pushupActivityForResult(Activity act, Class<?> toActivity, Bundle bundle, int requestCode) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_PUSHUP);
		startActivityForResult(act, toActivity, bundle, requestCode, R.anim.push_up_in, R.anim.push_up_out, 0, 0);
	}

	/**
	 * 从下往上
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param finish
	 */
	public static final void centerActivity(Activity act, Class<?> toActivity, Bundle bundle, boolean finish) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_CENTER);
		startActivity(act, toActivity, bundle, finish, R.anim.push_center_in, R.anim.push_center_out, 0, 0);
	}

	/**
	 * 从下往上，接收返回数据
	 *
	 * @param act
	 * @param toActivity
	 * @param bundle
	 * @param requestCode
	 */
	public static final void centerActivityForResult(Activity act, Class<?> toActivity, Bundle bundle, int requestCode) {
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putString(BaseConstants.ActivityInfo.BUNDLEKEY_ACTIVITYANIMTYPE, BaseConstants.ActivityInfo.ACTIVITYANIMTYPE_CENTER);
		startActivityForResult(act, toActivity, bundle, requestCode, R.anim.push_center_in, R.anim.push_center_out, 0, 0);
	}


	public static final void startActivity(Activity act, Class<?> toActivity, Bundle bundle, boolean finish, int enterAnim, int exitAnim, int backEnterAnim, int backExitAnim) {
		Intent intent = new Intent(act, toActivity);
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putInt(BaseConstants.ActivityInfo.BUNDLEKEY_BACKENTERANIM, backEnterAnim);
		bundle.putInt(BaseConstants.ActivityInfo.BUNDLEKEY_BACKEXITANIM, backExitAnim);
		intent.putExtras(bundle);
		act.startActivity(intent);
		if (finish) {
			act.finish();
		}
		act.overridePendingTransition(enterAnim, exitAnim);
	}

	public static final void startActivityAddIntent(Activity act, Class<?> toActivity, int searchTypeData,Bundle bundle, boolean finish, int enterAnim, int exitAnim, int backEnterAnim, int backExitAnim) {
		Intent intent = new Intent(act, toActivity);
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putInt(BaseConstants.ActivityInfo.BUNDLEKEY_BACKENTERANIM, backEnterAnim);
		bundle.putInt(BaseConstants.ActivityInfo.BUNDLEKEY_BACKEXITANIM, backExitAnim);
		intent.putExtras(bundle);
		intent.putExtra("search_type",searchTypeData);
		act.startActivity(intent);
		if (finish) {
			act.finish();
		}
		act.overridePendingTransition(enterAnim, exitAnim);
	}

	public static final void startActivityForResult(Activity act, Class<?> toActivity, Bundle bundle, int requestCode, int enterAnim, int exitAnim, int backEnterAnim, int backExitAnim) {
		Intent intent = new Intent(act, toActivity);
		if (Helper.isNull(bundle)) {
			bundle = new Bundle();
		}
		bundle.putInt(BaseConstants.ActivityInfo.BUNDLEKEY_BACKENTERANIM, backEnterAnim);
		bundle.putInt(BaseConstants.ActivityInfo.BUNDLEKEY_BACKENTERANIM, backExitAnim);
		intent.putExtras(bundle);
		act.startActivityForResult(intent, requestCode);
		act.overridePendingTransition(enterAnim, exitAnim);
	}

	/**
	 * 关闭界面
	 *
	 * @param act
	 * @param resultCode
	 * @param intent
	 */
	public static final void finish(Activity act, int resultCode, Intent intent) {
		if (Helper.isNull(intent)) {
			act.setResult(resultCode);
		} else {
			act.setResult(resultCode, intent);
		}
		act.finish();
		if (act instanceof BaseActionBarActivity) {
			((BaseActionBarActivity) act).setBackAnim();
		} else if (act instanceof BaseActivity) {
			((BaseActivity) act).setBackAnim();
		} else if (act instanceof BaseCompatActivity) {
			((BaseCompatActivity) act).setBackAnim();
		} else if (act instanceof BaseFragmentActivity) {
			((BaseFragmentActivity) act).setBackAnim();
		}
	}

	/**
	 * 设置返回数据
	 *
	 * @param act
	 * @param resultCode
	 * @param intent
	 */
	public static void setResult(Activity act, int resultCode, Intent intent) {
		if (Helper.isNull(intent)) {
			act.setResult(resultCode);
		} else {
			act.setResult(resultCode, intent);
		}
	}

	/**
	 * function: 去拨号页面
	 *
	 * @param context
	 * @param phoneNumber
	 *
	 * @author:linhuan 2011-11-17 下午03:27:57
	 */
	public static void goCallPhone(Context context, String phoneNumber) {
		Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}

	/**
	 * function: 直接打电话
	 *
	 * @param context
	 * @param phoneNumber
	 *
	 * @author:linhuan 2011-12-27 下午05:16:57
	 */
//	public static void callPhone(Context context, String phoneNumber) {
//		Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
//		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//		if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE)) {
//			//    ActivityCompat#requestPermissions
//			// here to request the missing permissions, and then overriding
//			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//			//                                          int[] grantResults)
//			// to handle the case where the user grants the permission. See the documentation
//			// for ActivityCompat#requestPermissions for more details.
//			return;
//		}
//		context.startActivity(intent);
//	}
	
	/**
	 * function: 打开图片
	 *
	 * @param act
	 * @param filePath
	 * @param requestCode
	 * 
	 * @author:linhuan 2011-11-24 上午09:42:20
	 */
	public static void openImage(Activity act, String filePath, int requestCode) {
		try {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setDataAndType(Uri.parse("file://" + filePath), "image/*");
			act.startActivityForResult(intent, requestCode);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(act.getString(R.string.errormsg_cantopenimage));
			return;
		}
	}
	
	/**
	 * function: 播放音频
	 *
	 * @param act
	 * @param filePath
	 * @param requestCode
	 * 
	 * @author:linhuan 2011-11-24 上午09:43:00
	 */
	public static void openAudio(Activity act, String filePath, int requestCode) {
		try {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setDataAndType(Uri.parse("file://" + filePath), "audio/*");
			act.startActivityForResult(intent, requestCode);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(act.getString(R.string.errormsg_cantplayaudio));
			return;
		}
	}
	
	/**
	 * function: 打开视频
	 *
	 * @param act
	 * @param filePath
	 * @param requestCode
	 * 
	 * @author:linhuan 2011-11-24 上午09:43:10
	 */
	public static void openVideo(Activity act, String filePath, int requestCode) {
		try {
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setDataAndType(Uri.parse("file://" + filePath), "video/*");
			act.startActivityForResult(intent, requestCode);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(act.getString(R.string.errormsg_cantplayvedio));
			return;
		}
	}
	
	/**
	 * function: 选择图像
	 *
	 * @param act
	 * @param requestCode
	 *
	 * @author:linhuan 2011-11-24 上午09:38:32
	 */
	public static void pickImage(Activity act, int requestCode) {
		Intent i = new Intent(); 
		i.setType("image/*"); 
		i.setAction(Intent.ACTION_GET_CONTENT); 
		act.startActivityForResult(Intent.createChooser(i, act.getString(R.string.fwtitle_selectimage)), requestCode); 
	}
	
	/**
	 * function: pickSystemImage 开启系统相册
	 *
	 * @param act
	 * @param requestCode
	 * 
	 * @author:linhuan 2014-8-7 下午4:26:12
	 */
	public static boolean pickSystemImage(Activity act, int requestCode) {
		Intent intentCrop = new Intent("com.android.camera.action.CROP");    
		intentCrop.setType("image/*");
		List<ResolveInfo> list = act.getPackageManager().queryIntentActivities(intentCrop, 0 );
		if (0 == list.size()) {
			return true;
		} else {
			Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
			intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
			act.startActivityForResult(Intent.createChooser(intent, act.getString(R.string.fwtitle_selectimage)), requestCode);
			return false;
		}
	}
    
    /**
     * function: 裁剪图片
     *
     * @param uri
     * @param width
     * @param act
     * @param requestCode
     * 
     * @author:linhuan 2012-7-11 下午5:27:33
     */
    public static void cropImage(Uri uri, int width, Activity act, int requestCode, String camera) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Helper.isNotNull(uri)) {
			intent.setDataAndType(uri, "image/*");
		}
        
        List<ResolveInfo> list = act.getPackageManager().queryIntentActivities(intent, 0 );
//        int size = list.size();
//        if (size == 0) {
//        	Intent intentCrop = new Intent(act, CropImage.class);
//        	intentCrop.putExtra(CropImage.IMAGE_PATH, camera);
//        	intentCrop.putExtra(CropImage.SCALE, true);
//        	intentCrop.putExtra(CropImage.ASPECT_X, 1);
//        	intentCrop.putExtra(CropImage.ASPECT_Y, 1);
//        	intentCrop.putExtra(CropImage.OUTPUT_X, width);
//        	intentCrop.putExtra(CropImage.OUTPUT_Y, width);
//        	act.startActivityForResult(intentCrop, ANDROID_NOT_HAS_CROP);
//        } else {
        	intent.putExtra("crop", "true");    
              // aspectX aspectY 是宽高的比例    
            intent.putExtra("aspectX", 1);    
            intent.putExtra("aspectY", 1);  
              
              // outputX outputY 是裁剪图片宽高    
            intent.putExtra("outputX", width);    
            intent.putExtra("outputY", width);    
              
            intent.putExtra("noFaceDetection", true); 
            intent.putExtra("return-data", true);  
            
            Intent i  = new Intent(intent);
            ResolveInfo res = list.get(0);

            i.setComponent( new ComponentName(res.activityInfo.packageName, res.activityInfo.name));

            act.startActivityForResult(intent, requestCode);
//		}
    }
    
    /**
     * function: 裁剪图片
     *
     * @param uri
     * @param width
     * @param act
     * @param requestCode
     * 
     * @author:linhuan 2012-7-11 下午5:27:33
     */
    public static void cropImage(Uri uri, int width, Activity act, int requestCode) {    
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");    
        intent.putExtra("crop", "true");    
        
        // aspectX aspectY 是宽高的比例    
        intent.putExtra("aspectX", 1);    
        intent.putExtra("aspectY", 1);  
        
        // outputX outputY 是裁剪图片宽高    
        intent.putExtra("outputX", width);    
        intent.putExtra("outputY", width);    
        
        intent.putExtra("noFaceDetection", true); 
        intent.putExtra("return-data", true);    
        
        act.startActivityForResult(intent, requestCode);    
    }
    
    /**
     * function: 裁剪图片
     *
     * @param uri
     * @param width
     * @param height
     * @param act
     * @param requestCode
     * 
     * @author:linhuan 2014-8-7 下午3:04:59
     */
    public static void cropImage(Uri uri, int width, int height, Activity act, int requestCode) {    
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");    
        intent.putExtra("crop", "true");    
        
        // aspectX aspectY 是宽高的比例    
        intent.putExtra("aspectX", 1);    
        intent.putExtra("aspectY", 1);  
        
        // outputX outputY 是裁剪图片宽高    
        intent.putExtra("outputX", width);    
        intent.putExtra("outputY", height);    
        
        intent.putExtra("noFaceDetection", true); 
        intent.putExtra("return-data", true);    
        
        act.startActivityForResult(intent, requestCode);    
    }
	
	
	/**
	 * function: 选择音频
	 *
	 * @param act
	 * @param requestCode
	 * 
	 * @author:linhuan 2011-11-24 上午09:38:47
	 */
	public static void pickAudio(Activity act, int requestCode) {
		Intent i = new Intent();
		i.setType("audio/*");
		i.setAction(Intent.ACTION_GET_CONTENT); 
		act.startActivityForResult(Intent.createChooser(i, act.getString(R.string.fwtitle_selectaudio)), requestCode); 
	}
	
	/**
	 * function: 选择视频
	 *
	 * @param act
	 * @param requestCode
	 * 
	 * @author:linhuan 2011-11-24 上午09:38:55
	 */
	public static void pickVedio(Activity act, int requestCode) {
		Intent i = new Intent();
		i.setType("video/*");
		i.setAction(Intent.ACTION_GET_CONTENT); 
		act.startActivityForResult(Intent.createChooser(i, act.getString(R.string.fwtitle_selectvedio)), requestCode); 
	}
	
	/**
	 * function: openSystemImage 直接开启系统相机
	 *
	 * @param act
	 * @param requestCode
	 * @param outputPath
	 * 
	 * @author:linhuan 2014-8-7 下午2:13:14
	 */
	public static void openSystemImage(Activity act, int requestCode, String outputPath) {
		try {
			Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			List<ResolveInfo> list = act.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
			for (ResolveInfo resolveInfo : list) {
				if (resolveInfo.activityInfo.applicationInfo.sourceDir.startsWith("/system/app")) {
					intent.setClassName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name);
					break;
				}
			}
			intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(outputPath)));
			act.startActivityForResult(intent, requestCode);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(act.getString(R.string.errormsg_cantopencamera));
			return;
		}
	}
	
	/**
	 * function: 照相
	 *
	 * @param ctx
	 * @param requestCode
	 * @param outputPath
	 * 
	 * @author:linhuan 2011-11-24 上午09:40:55
	 */
	public static void takeImage(Context ctx, int requestCode, String outputPath) {
		try {
			Intent intent = new Intent(); 
			intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(outputPath)));
			((Activity) ctx).startActivityForResult(intent, requestCode);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(ctx.getString(R.string.errormsg_cantopencamera));
			return;
		}
	}
	
	/**
	 * function: 录音
	 *
	 * @param ctx
	 * @param requestCode
	 * 
	 * @author:linhuan 2011-11-24 上午09:41:12
	 */
	public static void takeAudio(Context ctx, int requestCode) {
		try {
			Intent intent = new Intent();
			intent.setAction(Media.RECORD_SOUND_ACTION);
			((Activity) ctx).startActivityForResult(intent, requestCode);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(ctx.getString(R.string.errormsg_cantopentaperecord));
			return;
		}
	}
	
	/**
	 * function: 摄像
	 *
	 * @param ctx
	 * @param requestCode
	 * 
	 * @author:linhuan 2011-11-24 上午09:41:50
	 */
	public static void takeVideo(Context ctx, int requestCode) {
		try {
			Intent intent = new Intent();
			intent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
			((Activity) ctx).startActivityForResult(intent, requestCode);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(ctx.getString(R.string.errormsg_cantopenvideocamera));
			return;
		}
	}
	
	/**
	 * function: 到发送短信页面
	 *
	 * @param ctx
	 * @param content
	 * 
	 * @author:linhuan 2011-12-15 下午03:07:37
	 */
	public static void sendSms(Context ctx, String content) {
		Uri smsUri = Uri.parse("tel:");
		Intent intent = new Intent(Intent.ACTION_VIEW, smsUri);
		intent.putExtra("sms_body", content);
		intent.setType("vnd.android-dir/mms-sms"); 
		ctx.startActivity(intent);
	}
	
	/**
	 * function: 安装apk
	 *
	 * @param path
	 * @param ctx
	 * 
	 * @author:linhuan 2011-12-26 下午03:24:24
	 */
	public static void installApk(String path, Context ctx) {
		Intent intent = new Intent();
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setAction(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.parse("file://" + path), "application/vnd.android.package-archive");
		ctx.startActivity(intent);
	}
	
	/**
	 * function: 用浏览器下载apk, 或者打开html页面
	 *
	 * @param url
	 * @param act
	 * 
	 * @author:linhuan 2012-2-9 上午11:15:29
	 */
	public static void downApkWithBrowse(String url, Activity act) {
		try {
			Intent intent = new Intent(Intent.ACTION_VIEW); 
			intent.setData(Uri.parse(url));
			act.startActivityForResult(intent, 0);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(act.getString(R.string.errormsg_cantopenbrowser));
		}
	}
	
	/**
	 * function: 跳转到手机上拥有的市场中对应该项目的下载页面.可以进行评价等等
	 *
	 * @param act
	 * @param pacakgeName 包名称
	 * @param noMarketMessage 当前手机没有 安装市场平台的提示信息,默认为:亲,您木有安装第三方下载平台!
	 * 
	 * @author:linhuan 2014年7月16日 下午2:20:32
	 */
	public static void turnMarket(Activity act, String pacakgeName, String noMarketMessage){
		try {
			Intent localIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+pacakgeName));
			act.startActivity(localIntent);
		} catch (ActivityNotFoundException e) {
			if (Helper.isEmpty(noMarketMessage)) {
				noMarketMessage = act.getString(R.string.errormsg_cantopenandroidmarket_forinstall);
			}
			ToastHelper.showToast(noMarketMessage);
		}
	}
	
	/**
	 * function: 通过选择浏览器打开连接
	 *
	 * @param url
	 * @param act
	 * 
	 * @author:linhuan 2014年7月16日 下午2:22:49
	 */
	public static void openBrowse(String url, Activity act){
//		try {
//			if (!url.startsWith("http://")) {
//				url = "http://" + url;
//			} else if (!url.startsWith("https://")) {
//				url = "https://" + url;
//			}
			Intent intent = new Intent(Intent.ACTION_VIEW); 
			intent.setData(Uri.parse(url));
//			intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
//			act.startActivityForResult(intent, 0);
			act.startActivityForResult(Intent.createChooser(intent, "请选择浏览器"), 0);
//			act.startActivity(intent);
//		} catch (ActivityNotFoundException e) {
//			ToastHelper.showToast(act.getString(R.string.errormsg_cantopenandroidmarket_forweb));
//		}
	}

	/**
	 * 拨打电话
	 *
	 * @param num
	 * @param act
     */
	public static void openCall(String num, Activity act) {
		try {
			Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num));
			act.startActivity(intent);
		} catch (ActivityNotFoundException e) {
			ToastHelper.showToast(act.getString(R.string.errormsg_cantopenandroidmarket_call));
		}
	}

}
