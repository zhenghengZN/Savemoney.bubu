package so.bubu.lib.helper;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import so.bubu.lib.base.BaseApplication;

/**
 * 
 * function: File(包含sd卡) 助手类 提示：设置权限 <uses-permission
 * android:name="android.permission.WRITE_EXTERNAL_STORAGE" /> <uses-permission
 * android:name="android.permission.READ_EXTERNAL_STORAGE" />
 * 
 * @author:linhuan
 */
public class FileHelper {

	public static final long KB = 1024;
	public static final long MB = 1024 * KB;
	private static final String TAG = FileHelper.class.getSimpleName();
	
	private static final String APK = ".apk";		// apk文件

	// private static final long MB = 1048576; // 1024*1024;
	// private static final int CACHE_SIZE = 20;
	// private static final int FREE_SD_SPACE_NEEDED_TO_CACHE = 4;
	// private static final String WHOLESALE_CONV = ".cach";

	// //////////////////////////////////////////////////////////////////////////////////////////
	// 分隔线：sd卡操作
	// //////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * function: 取得SD卡路径(无SD卡则使用RAM)
	 * 
	 * @return 类似这样的路径 /mnt/sdcard
	 * 
	 * @author:linhuan 2014年8月7日 下午2:17:48
	 */
	public static String getExternalStoragePath() {
		File result = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
				&& Environment.getExternalStorageDirectory().canWrite()) {
			result = Environment.getExternalStorageDirectory();
			if (getPathAvailableMemorySize(result) < 5 * MB) {
				result = null;
			}
		}
		if (Helper.isEmpty(result)) {
			result = BaseApplication.getInstance().getCacheDir();
		}
		return result.getAbsolutePath();
	}

	/**
	 * function: 获取目录可用存储空间大小
	 * 
	 * @return
	 * 
	 * @author:linhuan 2014-10-16 下午3:00:56
	 */
	public static long getPathAvailableMemorySize(File path) {
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		return availableBlocks * blockSize;
	}

	public static long getPathAvailableMemorySize(String path) {
		return getPathAvailableMemorySize(new File(path));
	}

	/**
	 * function: 取得基本的缓存路径(无SD卡则使用RAM)
	 * 
	 * @return 类似这样的路径 /mnt/sdcard/Android/data/demo.android/cache/ 或者
	 *         /data/data/demo.android/cache/
	 * 
	 * @author:linhuan 2014年8月7日 下午2:18:23
	 */
	public static String getBaseCachePath() {
		File result = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
				&& Environment.getExternalStorageDirectory().canWrite()) {
			result = BaseApplication.getInstance().getExternalCacheDir();
			if (getPathAvailableMemorySize(result) < 5 * MB) {
				result = null;
			}
		}
		if (Helper.isEmpty(result)) {
			result = BaseApplication.getInstance().getCacheDir();
		}
		return result.getAbsolutePath().concat("/");
	}

	/**
	 * function: 取得默认类型的基本的文件路径(无SD卡则使用RAM)
	 * 
	 * @return 类似这样的路径 /mnt/sdcard/Android/data/demo.android/files/Download/ 或者
	 *         /data/data/demo.android/files/
	 * 
	 *         @author:linhuan 2014年8月7日 下午2:18:38
	 */
	public static String getBaseFilePath() {
		File result = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
				&& Environment.getExternalStorageDirectory().canWrite()) {
			result = BaseApplication.getInstance().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
			if (getPathAvailableMemorySize(result) < 5 * MB) {
				result = null;
			}
		}
		if (Helper.isEmpty(result)) {
			result = BaseApplication.getInstance().getFilesDir();
		}
		return result.getAbsolutePath().concat("/");
	}

	/**
	 * function: 取得指定类型的基本的文件路径(无SD卡则使用RAM)
	 * 
	 * @param type
	 *            type 参见 {@link Context}
	 *            getExternalFilesDir(String type)
	 * 
	 *            Environment常量： DIRECTORY_MUSIC, DIRECTORY_PODCASTS,
	 *            DIRECTORY_RINGTONES, DIRECTORY_ALARMS,
	 *            DIRECTORY_NOTIFICATIONS, DIRECTORY_PICTURES, or
	 *            DIRECTORY_MOVIES.
	 * 
	 * @return 类似这样的路径 /mnt/sdcard/Android/data/demo.android/files/Download/ 或者
	 *         /data/data/demo.android/files/
	 * 
	 * @author:linhuan 2014年8月7日 下午2:19:06
	 */
	public static String getBaseFilePath(String type) {
		if (Helper.isEmpty(type)) {
			return getBaseFilePath();
		} else {
			File result = null;
			if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
					&& Environment.getExternalStorageDirectory().canWrite()) {
				result = BaseApplication.getInstance().getExternalFilesDir(type);
				if (getPathAvailableMemorySize(result) < 5 * MB) {
					result = null;
				}
			}
			if (Helper.isEmpty(result)) {
				result = BaseApplication.getInstance().getFilesDir();
			}
			return result.getAbsolutePath().concat("/");
		}
	}

	public static void createDir(String dir) {
		File file = new File(dir);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	/**
	 * 保存文件到sd卡
	 * 
	 * @param byteArray
	 * @param dir
	 * @param fileName
	 * @return
	 */
	public static File save(byte[] byteArray, String dir, String fileName) {
		if (Helper.isNull(byteArray))
			return null;

		// 创建文件
		if (!createFile(dir, fileName)) {
			return null;
		}

		File mf = new File(dir + fileName);
		OutputStream outputStream = null;

		try {
			outputStream = new FileOutputStream(mf);
			outputStream.write(byteArray);
			byteArray = null;
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(TAG, "下载文件失败:" + e.getMessage());

			return null;
		}

		if (Helper.isNotNull(outputStream)) {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			outputStream = null;
		}
		return mf;
	}

	 /**
	  * function: 删除文件
	  *
	  * @param filePath
	  * @return
	  * 
	  * @author:linhuan 2014-12-25 下午3:29:13
	  */
	public static boolean deleteFile(String filePath){
		boolean result = false;
		if (Helper.isNotEmpty(filePath)){
			try {
				File file = new File(filePath);
				if (file.exists()){
					result = file.delete();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	 
	// // 创建文件到SDCard中
	// // ////////////////////////////////////////////////
	// createFile2SDCard(path, fileName);
	//
	// // ///////////////////////////////////////////////
	// // 将URL内容写入到SD卡中
	// // ////////////////////////////////////////////////
	// URL url = new URL(urlStr);
	//
	// FileUtils.copyURLToFile(url, new File(path + fileName));
	//
	//
	// return path + fileName;
	// }
	//
	//
	//
	//
	// /**
	// *
	// * function: 创建文件到SDCard中: 当文件存在时删除
	// *
	// * @param path
	// * @param fileName
	// * @return
	// *
	// * @author:linhuan 2012-5-10 下午4:09:41
	// */
	// public static void createFile2SDCardWithDelete(String path, String
	// fileName) {
	//
	// // ///////////////////////////////////////
	// // 创建SD卡目录
	// // ///////////////////////////////////////
	// File dir = new File(path);
	//
	// if (!dir.exists()) {
	// boolean flag = dir.mkdirs();
	// if(!flag){
	// System.gc();
	// File dirSon = new File(path);
	// dirSon.mkdir();
	// }
	// }else if(!dir.canWrite()){
	// dir.delete();
	// File dirSon = new File(path);
	// dirSon.mkdirs();
	//
	// }
	//
	// // //////////////////////////////////////////
	// // 创建SD卡文件: 存在时删除
	// // ///////////////////////////////////////////
	// File file = new File(path + fileName);
	//
	// if (file.exists()||file.isFile()) {
	// file.delete();
	// }
	//
	// try {
	// file.createNewFile();
	// } catch (IOException e) {
	//
	// e.printStackTrace();
	// }
	//
	// }
	//
	//
	public static boolean createFile(String path, String fileName) {

		// ///////////////////////////////////////
		// 创建SD卡目录
		// ///////////////////////////////////////
		File dir = new File(path);

		if (!dir.exists()) {
			boolean flag = dir.mkdirs();
			if (!flag) {
				System.gc();
				File dirSon = new File(path);
				dirSon.mkdir();
			}
		} else if (!dir.canWrite()) {
			dir.delete();
			File dirSon = new File(path);
			dirSon.mkdirs();
		}

		// //////////////////////////////////////////
		// 创建SD卡文件
		// ///////////////////////////////////////////
		File file = new File(path + fileName);

		if (file.exists() || file.isFile()) {

			return false;

		} else {

			try {
				file.createNewFile();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return true;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////
	// 分隔线：asset操作
	// //////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * function:
	 * 
	 * @param path
	 * @return
	 * 
	 * @author:linhuan 2014年7月16日 上午11:40:49
	 */
	public static InputStream openAssetFile(String path) {

		InputStream is = null;

		try {
			is = BaseApplication.getInstance().getAssets().open(path);
		} catch (IOException e) {
//			e.printStackTrace();
		}

		return is;
	}

	/**
	 * function: 从assets读取图片
	 * 
	 * @param fileName
	 * @param context
	 * @return
	 * 
	 * @author:linhuan 2014年7月16日 上午11:40:56
	 */
	public static Bitmap getImageFromAssetsFile(String fileName, Context context) {

		Bitmap image = null;
		InputStream is = null;

		try {
			is = context.getAssets().open(fileName);
			image = BitmapFactory.decodeStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (Helper.isNotNull(is)) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return image;
	}

	/**
	 * 检查SD卡是否插入
	 * 
	 * @return
	 * 
	 * @author:linhuan on 2011-1-29 & memoryCat V1.0
	 */
	public static boolean checkSDCARD() {
		String status = Environment.getExternalStorageState();

		if (status.equals(Environment.MEDIA_MOUNTED)) {
			return true;
		}

		return false;
	}

	/**
	 * function: 删除方法 这里只会删除某个文件夹下的文件，如果传入的directory是个文件，将不做处理
	 * 
	 * @param directory
	 * 
	 * @author:linhuan 2014年7月29日 下午5:01:49
	 */
	public static void deleteFilesByDirectory(File directory) {
		if (Helper.isNotNull(directory) && directory.exists() && directory.isDirectory()) {
			for (File item : directory.listFiles()) {
				item.delete();
			}
		}
	}

	/**
	 * function: 计算文件夹大小
	 * 
	 * @param file
	 * @return
	 * 
	 * @author:linhuan 2014年7月29日 下午5:06:06
	 */
	public static double getDirSize(File file) {
		// 判断文件是否存在
		if (file.exists()) {
			// 如果是目录则递归计算其内容的总大小
			if (file.isDirectory()) {
				File[] children = file.listFiles();
				double size = 0;
				for (File f : children)
					size += getDirSize(f);
				return size;
			} else {
				// 如果是文件则直接返回其大小,以“K”为单位
				double size = (double) file.length() / 1024;
				return size;
			}
		} else {
			return 0.0;
		}
	}
	
	/**
	 * function: 判断是否有安装包
	 *
	 * @param filePath 需要扫描的文件夹
	 * @param packageName 判断是否有安装包的存在
	 * @return null说明file数据有问题，正常返回boolean数组
	 * 
	 * @author:linhuan 2014-11-11 上午10:54:39
	 */
	public static boolean[] findAllFile(String filePath, List<String> packageName) {
		return Helper.isNotEmpty(filePath) ? findAllFile(new File(filePath), packageName) : null;
	}

	/**
	 * function: 判断是否有安装包
	 *
	 * @param file 需要扫描的文件夹
	 * @param packageName 判断是否有安装包的存在
	 * @return null说明file数据有问题，正常返回boolean数组
	 * 
	 * @author:linhuan 2014-11-11 上午10:49:14
	 */
	public static boolean[] findAllFile(File file, List<String> packageName) {
		if (!file.exists()) {
			return null;
		}
		if (file.isFile()) {
			return null;
		}
		if (Helper.isNull(packageName)) {
			return null;
		}
		String[] fileName = file.list();
		int size = fileName.length;
		int packageSize = packageName.size();
		boolean[] existFlag = new boolean[packageSize];
		for (int i = 0; i < packageSize; i++) {
			existFlag[i] = false;
		}
		PackageManager pm = BaseApplication.getInstance().getPackageManager();
		String data;
		int temp;
		for (int i = 0; i < size; i++) {
			temp = fileName[i].indexOf(".");
			if (-1 != temp) {
				data = fileName[i].substring(0, temp);
				if (fileName[i].endsWith(APK) && packageName.contains(data)) {
					if (Helper.isNotNull(pm.getPackageArchiveInfo(file.getAbsolutePath() + File.separator + fileName[i], PackageManager.GET_ACTIVITIES))) {
						// 包完整
						existFlag[packageName.indexOf(data)] = true;
					}
				}
			}
		}
		return existFlag;
	}
	
	
	/**
	 * function: 判断是否有安装包
	 *
	 * @param filePath 需要扫描的文件夹
	 * @param packageName 判断是否有安装包的存在
	 * @return 返回boolean
	 * 
	 * @ author:linhuan 2014-11-11 上午11:13:36
	 */
	public static boolean findAllFile(String filePath, String packageName) {
		return Helper.isNotEmpty(filePath) ? findAllFile(new File(filePath), packageName) : false;
	}
	
	/**
	 * function: 判断是否有安装包
	 *
	 * @param file 需要扫描的文件夹
	 * @param packageName 判断是否有安装包的存在
	 * @return boolean 返回
	 * 
	 * @author:linhuan 2014-11-11 上午11:13:36
	 */
	public static boolean findAllFile(File file, String packageName) {
		if (!file.exists()) {
			return false;
		}
		if (file.isFile()) {
			return false;
		}
		if (Helper.isNull(packageName)) {
			return false;
		}
		String[] fileName = file.list();
		int size = fileName.length;
		PackageManager pm = BaseApplication.getInstance().getPackageManager();
		String data;
		for (int i = 0; i < size; i++) {
			if (fileName[i].indexOf(".") != -1) {
				data = fileName[i].substring(0, fileName[i].indexOf("."));
				if (fileName[i].endsWith(APK) && packageName.equals(data)) {
					if (Helper.isNotNull(pm.getPackageArchiveInfo(file.getAbsolutePath() + File.separator + fileName[i], PackageManager.GET_ACTIVITIES))) {
						// 包完整
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * function: 判断是否有安装包
	 *
	 * @param file 需要扫描的文件夹
	 * @param packageName 判断是否有安装包的存在
	 * @return boolean 返回
	 * 
	 * @author:linhuan 2014-11-11 上午11:13:36
	 */
	public static boolean findSimpleAllFile(File file, String packageName) {
		if (!file.exists()) {
			return false;
		}
		if (file.isFile()) {
			return false;
		}
		if (Helper.isNull(packageName)) {
			return false;
		}
		String[] fileName = file.list();
		int size = fileName.length;
		PackageManager pm = BaseApplication.getInstance().getPackageManager();
		for (int i = 0; i < size; i++) {
			if (packageName.equals(fileName[i])) {
				if (Helper.isNotNull(pm.getPackageArchiveInfo(file.getAbsolutePath() + File.separator + fileName[i], PackageManager.GET_ACTIVITIES))) {
						// 包完整
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * function: 判断apk是否完整
	 *
	 * @param filePath 文件路径
	 * @param packageName 包名
	 * @return 1:没有apk包 2:有包未安装 3:无包已安装 4:有包且安装
	 * 
	 * @author:linhuan 2014-12-18 上午9:12:59
	 */
	public static int apkIsIntegrity(String filePath, String packageName) {
		if (Helper.isNotEmpty(packageName) && ApplicationHelper.isAppInstalled(BaseApplication.getInstance().getApplicationContext(), packageName)) {
			return 3;
		}
		if (Helper.isNull(filePath)) {
			return 1;
		}
		File file = new File(filePath);
		if (!file.exists()) {
			return 1;
		}
		if (file.isFile()) {
			return 1;
		}
		PackageManager pm = BaseApplication.getInstance().getPackageManager();
		if (Helper.isNotNull(pm.getPackageArchiveInfo(filePath, PackageManager.GET_ACTIVITIES))) {
			// 包完整
			return ApplicationHelper.isAppInstalled(BaseApplication.getInstance().getApplicationContext(), packageName) ? 4 : 2;
		}
		return 1;
	}
	
	/**
	 * function: 判断文件是否存在
	 *
	 * @param filePath
	 * @return
	 * 
	 * @author:linhuan 2014-12-24 上午9:50:10
	 */
	public static boolean fileIsExistence(String filePath) {
		if (Helper.isNull(filePath)) {
			return false;
		}
		File file = new File(filePath);
		if (!file.exists()) {
			return false;
		}
		return true;
	}

	/**
	 * 获取本地数据
	 *
	 * @param fileName
	 * @return
	 */
	public static String getJson(String fileName) {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			InputStream inputStream = openAssetFile(fileName);
			if (Helper.isNull(inputStream)) {
				return "[]";
			}
			BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String line;
			while (Helper.isNotNull(line = bf.readLine())) {
				stringBuilder.append(line);
			}
		} catch (Exception e) {
//			e.printStackTrace();
			return "[]";
		}
		return stringBuilder.toString();
	}
	
}
