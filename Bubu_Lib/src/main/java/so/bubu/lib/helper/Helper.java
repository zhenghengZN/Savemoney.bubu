package so.bubu.lib.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

public class Helper {
	
	////////////////////////////////////////////////////////////////////////////////////////////
	// 分隔线：为null或空判断
	////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * function: 判断对象是否为Null
	 *
	 * @param obj
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午2:28:26
	 */
	public static boolean isNull(Object obj) {
		return null == obj;
	}
	
	/**
	 * function: 判断对象不为Null
	 *
	 * @param obj
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午2:29:36
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}
	
	/**
	 * function: 若判断对象为null输出""
	 *
	 * @param obj
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:45:11
	 */
	public static String ifNull(Object obj){
		return Helper.ifNull(obj, "");
	}
	
	/**
	 * function: 若判断对象为null输出默认值
	 *
	 * @param obj
	 * @param defaultValue
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:45:06
	 */
	public static String ifNull(Object obj, String defaultValue){
		if (isNull(obj)){
			return defaultValue;
		} else{
			return obj.toString();
		}
	}
	
	/**
	 * function: 判断对象是否为Null或空，注意：不能判断包含数组
	 *
	 * @param obj
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午2:30:38
	 */
	public static boolean isEmpty(Object obj) {
		boolean result = false;
		if (isNull(obj)) {
			result = true;
		} else {
			if (obj instanceof String){
				result = ((String)obj).equals("");
			} else if (obj instanceof Date) {
				result = ((Date) obj).getTime() == 0;
			} else if (obj instanceof Long){
				result = ((Long)obj).longValue() == Long.MIN_VALUE;
			} else if (obj instanceof Integer){
				result = ((Integer)obj).intValue() == Integer.MIN_VALUE;
			}
			// 无法判断基本类型
//			else if(obj.getClass().isArray()) {
//				result = ((Object[])obj).length == 0;
//			}
			  else if (obj instanceof Collection){
				result = ((Collection<?>)obj).size() == 0;
			} else if (obj instanceof Map){
				result = ((Map<?, ?>)obj).size() == 0;
			} else if (obj instanceof JSONObject){
				result = !((JSONObject)obj).keys().hasNext();
			} else {
				result = obj.toString().equals("");
			}
		}
		
		return result;
	}
	
	/**
	 * function: 判断对象不为Null或空，注意：不能判断包含数组
	 *
	 * @param obj
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午2:30:38
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	// 分隔线：equal判断
	////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * function: 判断两字符串是否相等(区分大小写)
	 *
	 * @param str1
	 * @param str2
	 * @param ignorSpace 是否忽略空格
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午4:02:40
	 */
	public static boolean equalString(String str1, String str2, boolean ignorSpace){
		return Helper.equalString(str1, str2, ignorSpace, false);
	}
	
	/**
	 * function: 判断两字符串是否相等(包含对null的判断)
	 *
	 * @param str1
	 * @param str2
	 * @param ignorSpace 是否忽略空格
	 * @param ignorCase 是否忽略大小写
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午4:01:31
	 */
	public static boolean equalString(String str1, String str2, boolean ignorSpace, boolean ignorCase){
		if (isNull(str1) && isNull(str2)) {
			return true;
		}
		if ((isNull(str1) && isNotNull(str2)) || (isNull(str2) && isNotNull(str1))) {
			return false;
		}
		if (ignorSpace) {
			if (ignorCase) {
				return str1.trim().toLowerCase().equals(str2.trim().toLowerCase());
			} else{
				return str1.trim().equals(str2.trim());
			}
		} else {
			if (ignorCase) {
				return str1.toLowerCase().equals(str2.toLowerCase());
			} else {
				return str1.equals(str2);
			}
		}
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	// 分隔线：String操作
	////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * function: 字符串截取函数.
	 *  当字符串为空,返回长度为0的字符串.
	 *  当字符串str的长度不超过length,直接返回
	 *  当字符串str的长度超过length,截取前length个字符,并在新字符串后加上默认的子串"...".
	 *  如: cutStr("abcdefgh" , 2) 返回的结果为 "ab..."
	 *  注: 注: 按字符截取,非字节
	 *
	 * @param str 需截取的字符串
	 * @param length 截取的长度
	 * @return
	 * 
	 * @author:linhuan 2014年7月16日 下午2:05:13
	 */
	public static String cutStr(String str , int length){
		return cutStr(str, length, "...");
	}
	
	/**
	 * function: 字符串截取函数
	 *  当字符串为空,返回长度为0的字符串.
	 *  当字符串str的长度不超过length,直接返回
	 *  当字符串str的长度超过length,截取前length个字符,并在新字符串后加上ext串.
	 *  如: cutStr("abcdefgh" , 2 , "...") 返回的结果为 "ab..."
	 *  注: 按字符截取,非字节
	 *
	 * @param str  需截取的字符串
	 * @param length 截取的长度
	 * @param ext 截取后,字符串的后缀
	 * @return 返回截取后的字符串
	 * 
	 * @author:linhuan 2014年7月16日 下午2:04:21
	 */
	public static String cutStr(String str, int length, String ext){
		String result = null; 
		if (isEmpty(str)) {
			result = "";
		} else if(str.length() <= length) {
			result = str;
		} else {
			result =  str.substring(0, length) + ext;
		}
		return result;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	// 分隔线：各种类型转换
	////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * function: 字符串转换为int
	 *
	 * @param str
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:40:50
	 */
	public static int toInt(String str){
		int result = 0;
		try {
			result = Integer.valueOf(str);
		} catch(Exception ex) {
			result = Integer.MIN_VALUE;
		}
		return result;
	}
	
	/**
	 * function: 字符串转换int
	 *
	 * @param str
	 * @param defaultValue 默认值
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:41:34
	 */
	public static int toInt(String str, int defaultValue){
		int result = 0;
		try {
			result = Integer.valueOf(str);
		} catch(Exception ex) {
			result = defaultValue;
		}
		return result;
	}
	
	/**
	 * function: 字符串转换为long
	 *
	 * @param str
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:42:42
	 */
	public static long toLong(String str){
		long result = 0;
		try {
			result = Long.valueOf(str);
		} catch(Exception ex) {
			result = Long.MIN_VALUE;
		}
		return result;
	}
	
	/**
	 * function: 字符串转换为float
	 *
	 * @param str
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:43:09
	 */
	public static float toFloat(String str){
		float result = 0;
		try {
			result = Float.valueOf(str);
		} catch(Exception ex) {
			result = Float.MIN_VALUE;
		}
		return result;
	}
	
	/**
	 * function: 字符串转换为double
	 *
	 * @param str
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:43:38
	 */
	public static double toDouble(String str){
		double result = 0;
		try {
			result = Double.valueOf(str);
		} catch(Exception ex) {
			result = Double.MIN_VALUE;
		}
		return result;
	}
	
	/**
	 * function: 浮点数转换整数
	 *
	 * @param f
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:46:29
	 */
	public static int float2Int(float f){
		return Math.round(f);
	}
	
	/**
	 * function: double转换整数
	 *
	 * @param d
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:46:36
	 */
	public static int double2Int(double d){
		return Long.valueOf(Math.round(d)).intValue();
	}
	
	/**
	 * function: collect2String(包含list, set)
	 *
	 * @param obj
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:49:49
	 */
	public static String collect2String(Object obj) {
		String result = "";
		if (isNotEmpty(obj)) {
			if (obj instanceof Collection) {
				Object[] objArray = ((Collection<?>)obj).toArray();
				for (Object tempObj : objArray) {
					if (isNotEmpty(tempObj)) {
						result += "," + tempObj.toString();
					}
				}
				if (result.length() > 0) {
					result = result.substring(1);
				}
			} else {
				result = obj.toString();
			}
		}
		return result;
	}
	
	/**
	 * function: 数组转换成list
	 *
	 * @param array
	 * @return
	 * 
	 * @author:linhuan 2014年7月15日 下午3:52:09
	 */
	public static <T extends Object> List<T> array2List(T[] array){
		List<T> result = new ArrayList<T>();
		if (!Helper.isEmpty(array)) {
			for (T entity : array) {
				result.add(entity);
			}
		}
		return result;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	// 分隔线：随机数
	////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 随机种子
	 */
	private static final String RANDOMSEED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 
	
	/**
	 * 
	 * function: 获取小于最大随机数的任一随机数
	 *
	 * @param maxNum 最大随机数
	 * @return 随机数
	 * 
	 * @author:linhuan 2014年7月15日 下午3:58:14
	 */
    public static int getRandomNum(int maxNum) {
        if (maxNum < 0) {
            return 0;
        }
        return new Random().nextInt(maxNum);
    }
    
    /**
     * function: 随机字符串
     *
     * @param length 字符串随机个数
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午3:59:21
     */
	public static String createRandomString(int length){
		StringBuffer result = new StringBuffer();
		if (length > 0){
			Random random = new Random();
			int seedLength = RANDOMSEED.length();
			for (int i = 0; i < length; i++) {
				result.append(RANDOMSEED.charAt(random.nextInt(seedLength)));
			}
		}
		return result.toString();
	}
	
}
