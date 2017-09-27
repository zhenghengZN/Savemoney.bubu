package so.bubu.lib.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import so.bubu.lib.base.BaseApplication;

/**
 * function: SharedPreferences辅助类
 * 
 * 说明：可操作多个SharedPreferences,取得时通过getInstance方法进行选择
 * 
 * @author:linhuan
 */
public class PreferencesHelper {

	private static PreferencesHelper sInstance = new PreferencesHelper();
	
	private static String sLastSharedPreferencesName = null;
	
	private SharedPreferences mSharePreferences = null;
	
	private PreferencesHelper(){
		
	}
	
	/**
	 * function: 取得实例
	 *
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:13:00
	 */
	public static PreferencesHelper getInstance() {
		return getInstance();
	}
	
	/**
	 * function: 通过名称取得实例
	 *
	 * @param sharedPreferencesName 文件名称
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:13:04
	 */
	public static PreferencesHelper getInstance(String sharedPreferencesName){
		if (Helper.isNull(sInstance)) {
			sInstance = new PreferencesHelper();
		}
		boolean useDefault = true;

		if (Helper.isNull(sInstance.mSharePreferences) || (Helper.isEmpty(sharedPreferencesName) && Helper.isEmpty(sLastSharedPreferencesName))) {
			useDefault = Helper.isEmpty(sharedPreferencesName);
		} else if (!Helper.equalString(sharedPreferencesName, sLastSharedPreferencesName, true)) {
			useDefault = Helper.isEmpty(sharedPreferencesName);
		} else {
			return sInstance;
		}
		
		if (useDefault) {
			sInstance.mSharePreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getInstance());
			sLastSharedPreferencesName = null;
		} else {
			sInstance.mSharePreferences = BaseApplication.getInstance().getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE);
			sLastSharedPreferencesName = sharedPreferencesName;
		}
		return sInstance;
	}
	
	/**
	 * contains:是否有数据
	 * 
	 * @param key
	 * @return
	 * 
	 * @author linhuan 2015年7月15日上午9:22:20
	 */
	public boolean contains(String key) {
		return mSharePreferences.contains(key);
	}
	
	/**
	 * function: 获取String类型
	 *
	 * @param key
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:16:54
	 */
	public String getString(String key) {
		return mSharePreferences.getString(key, "");
	}

	/**
	 * function: 获取String类型
	 *
	 * @param key
	 * @param def
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:17:01
	 */
	public String getString(String key, String def) {
		return mSharePreferences.getString(key, def);
	}

	/**
	 * function: 获取float类型
	 *
	 * @param key
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:17:10
	 */
	public float getFloat(String key) {
		return mSharePreferences.getFloat(key, 0f);
	}
	
	/**
	 * function: 获取float类型
	 *
	 * @param key
	 * @param def
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:17:18
	 */
	public float getFloat(String key, float def) {
		return mSharePreferences.getFloat(key, def);
	}
	
	/**
	 * function: 获取int类型
	 *
	 * @param key
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:17:27
	 */
	public int getInt(String key) {
		return mSharePreferences.getInt(key, 0);
	}

	/**
	 * function: 获取int类型
	 *
	 * @param key
	 * @param def
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:17:34
	 */
	public int getInt(String key, int def) {
		return mSharePreferences.getInt(key, def);
	}

	/**
	 * function: 获取long类型
	 *
	 * @param key
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:17:42
	 */
	public long getLong(String key) {
		return mSharePreferences.getLong(key, 0);
	}

	/**
	 * function: 获取long类型
	 *
	 * @param key
	 * @param def
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:17:56
	 */
	public long getLong(String key, long def) {
		return mSharePreferences.getLong(key, def);
	}

	/**
	 * function: 获取boolean类型
	 *
	 * @param key
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:18:05
	 */
	public boolean getBoolean(String key) {
		return mSharePreferences.getBoolean(key, false);
	}

	/**
	 * function: 获取boolean类型
	 *
	 * @param key
	 * @param def
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午5:18:13
	 */
	public boolean getBoolean(String key, boolean def) {
		return mSharePreferences.getBoolean(key, def);
	}

	/**
	 * function: 设置String类型
	 *
	 * @param key
	 * @param value
	 * 
	 * @author:linhuan 2014年7月15日 下午5:18:19
	 */
	public void putString(String key, String value) {
		SharedPreferences.Editor ed = mSharePreferences.edit();
		ed.putString(key, value);
		ed.commit();
	}

	/**
	 * function: 设置Int类型
	 *
	 * @param key
	 * @param value
	 * 
	 * @author:linhuan 2014年7月15日 下午5:19:01
	 */
	public void putInt(String key, int value) {
		SharedPreferences.Editor ed = mSharePreferences.edit();
		ed.putInt(key, value);
		ed.commit();
	}

	/**
	 * function: 设置Long类型
	 *
	 * @param key
	 * @param value
	 * 
	 * @author:linhuan 2014年7月15日 下午5:19:09
	 */
	public void putFloat(String key, float value) {
		SharedPreferences.Editor ed = mSharePreferences.edit();
		ed.putFloat(key, value);
		ed.commit();
	}

	/**
	 * function: 设置Long类型
	 *
	 * @param key
	 * @param value
	 *
	 * @author:linhuan 2014年7月15日 下午5:19:17
	 */
	public void putLong(String key, long value) {
		SharedPreferences.Editor ed = mSharePreferences.edit();
		ed.putLong(key, value);
		ed.commit();
	}

	/**
	 * function: 设置Boolean类型
	 *
	 * @param key
	 * @param value
	 *
	 * @author:linhuan 2014年7月15日 下午5:19:23
	 */
	public void putBoolean(String key, boolean value) {
		SharedPreferences.Editor ed = mSharePreferences.edit();
		ed.putBoolean(key, value);
		ed.commit();
	}
	
	/**
	 * 获取用户数据
	 * 
	 * @param key
	 * @return null 说明空  每一个数据都要序列化
	 * 
	 * @author linhuan on 2014-6-6下午3:43:42
	 */
	 public Object getObject(String key) {
		 String passwordinbase64 = mSharePreferences.getString(key, null);
		 Object object = null;
		 if (Helper.isNotNull(passwordinbase64)) {
			 byte[] base64Bytes = Base64.decode(passwordinbase64,Base64.DEFAULT);
			 ByteArrayInputStream bais = new ByteArrayInputStream(base64Bytes);
			 ObjectInputStream ois = null;
		
			 try {
				 ois = new ObjectInputStream(bais);
				 object = ois.readObject();
			 } catch (Exception e) {

			 }
		 }
		 return object;
	 }
	 
	 /**
	  * 保存本次用户信息
	  * 
	  * @param key
	  * @param object 每一个数据都要序列化
	  * 
	  * @author linhuan on 2014-6-6下午3:44:25
	  */
	 public void putObject(String key, Object object) {
		 SharedPreferences.Editor ed = mSharePreferences.edit();
		 ByteArrayOutputStream toByte = new ByteArrayOutputStream();
		 ObjectOutputStream oos = null;
		
		 try {
			 oos = new ObjectOutputStream(toByte);
			 oos.writeObject(object);
		 } catch (Exception e) {
			 
		 }
		
		 //对byte[]进行Base64编码
		 String PasswordMapBase64 = new String(Base64.encode(toByte.toByteArray(),Base64.DEFAULT));
		 ed.putString(key, PasswordMapBase64);
		
		 // 提交保存
		 ed.commit();
	 }
	
	/**
	 * function: 清除
	 * 
	 * @author:linhuan 2014年7月15日 下午5:19:30
	 */
	public void clear() {
		if (Helper.isNull(mSharePreferences)) {
			SharedPreferences.Editor ed = mSharePreferences.edit();
			ed.clear();
			ed.commit();
		}
	}

}
