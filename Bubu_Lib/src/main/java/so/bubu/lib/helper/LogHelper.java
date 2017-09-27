package so.bubu.lib.helper;

import android.util.Log;

/**
 * 输出log isDebug控制
 * 
 * @author linhuan on 2014-6-6上午11:26:23
 */
public class LogHelper {

	public static boolean isDebug = true;// 是否打开LOG

	private static String applicationTag = "LogHelper";// LOG默认TAG

	private static final String TAG_CONTENT_PRINT = "%s:%s.%s:%d";

	private static StackTraceElement getCurrentStackTraceElement() {
		return Thread.currentThread().getStackTrace()[4];

	}
	
	public static void v(Object tag, Object str) {
		if (isDebug) {
			Log.v(applicationTag,getContents(getCurrentStackTraceElement())+":"+ getString(tag) + ": " + getString(str));
		}
	}

	private static String getString(Object object) {
		if (Helper.isNull(object)) {
			return "Message is Null";
		} else {
			String string = object.toString();
			if (string.length() == 0) {
				return "Message lenght is 0";
			} else {
				return string;
			}
		}
	}

	// 打印LOG
	public static void trace() {
		if (isDebug) {
			Log.d(applicationTag, getContent(getCurrentStackTraceElement()));
		}
	}

	// 获取LOG
	private static String getContent(StackTraceElement trace) {
		return String.format(TAG_CONTENT_PRINT, applicationTag,
				trace.getClassName(), trace.getMethodName(),
				trace.getLineNumber());
	}

	// 获取LOG
	private static String getContents(StackTraceElement trace) {
		return String.format("%s:%s:%d", applicationTag,
				trace.getMethodName(), trace.getLineNumber());
	}

	// 打印默认TAG的LOG
	public static void traceStack() {
		if (isDebug) {
			traceStack(applicationTag, Log.ERROR);
		}
	}

	// 打印Log当前调用栈信息
	public static void traceStack(String tag, int priority) {
		if (isDebug) {
			StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
			Log.println(priority, tag, stackTrace[4].toString());
			StringBuilder str = new StringBuilder();
			String prevClass = null;
			for (int i = 5; i < stackTrace.length; i++) {
				String className = stackTrace[i].getFileName();
				int idx = className.indexOf(".java");
				if (idx >= 0) {
					className = className.substring(0, idx);
				}
				if (Helper.isNull(prevClass) || !prevClass.equals(className)) {
					str.append(className.substring(0, idx));
				}
				prevClass = className;
				str.append(".").append(stackTrace[i].getMethodName())
						.append(":").append(stackTrace[i].getLineNumber())
						.append("->");
			}
			Log.println(priority, tag, str.toString());
		}
	}

	public static void v(String msg) {
		if (isDebug) {
			Log.v(applicationTag, getContents(getCurrentStackTraceElement())
					+ "  ====   " + msg);
		}
	}

	// 指定TAG和指定内容的方法
	public static void d(String tag, String msg) {
		if (isDebug) {
			Log.d(tag, getContent(getCurrentStackTraceElement()) + "  ====   "
					+ msg);
		}
	}

	// 默认TAG和制定内容的方法
	public static void ds(String msg) {
		if (isDebug) {
			Log.d(applicationTag, getContent(getCurrentStackTraceElement())
					+ "===" + msg);
		}
	}

	public static void d(String msg) {
		if (isDebug) {
			Log.d(applicationTag, getContents(getCurrentStackTraceElement())
					+ "  ====   " + msg);
		}
	}

	// 下面的定义和上面方法相同，可以定义不同等级的Debugger
	public static void i(String tag, String msg) {
		if (isDebug) {
			Log.i(tag, getContent(getCurrentStackTraceElement()) + "  ====   "
					+ msg);
		}
	}

	public static void d(String message, Object... args) {
		if (isDebug) {
			d(String.format(message, args));
		}
	}

	public static void w(String tag, String msg) {
		if (isDebug) {
			Log.w(tag, getContent(getCurrentStackTraceElement()) + "  ====   "
					+ msg);
		}
	}

	public static void e(String tag, String msg) {
		if (isDebug) {
			Log.e(tag, getContent(getCurrentStackTraceElement()) + "  ====   "
					+ msg);
		}
	}

	// 默认TAG和制定内容的方法
	public static void i(String msg) {
		if (isDebug) {
			Log.i(applicationTag, getContent(getCurrentStackTraceElement())
					+ "  ====   " + msg);
		}
	}

	// 默认TAG和制定内容的方法
	public static void w(String msg) {
		if (isDebug) {
			Log.w(applicationTag, getContent(getCurrentStackTraceElement())
					+ "  ====   " + msg);
		}
	}

	// 默认TAG和制定内容的方法
	public static void e(String msg) {
		if (isDebug) {
			Log.e(applicationTag, getContent(getCurrentStackTraceElement())
					+ "  ====   " + msg);
		}
	}

	public static void e(Exception exception) {
		if (isDebug) {
			Log.e(applicationTag, getContent(getCurrentStackTraceElement())
					+ "  ====   " + exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void e(Exception exception, String string) {
		if (isDebug) {
			Log.e(applicationTag, getContent(getCurrentStackTraceElement())
					+ "\n  ====   " + exception.getMessage() + "\n  ====   "
					+ exception.getStackTrace() + "   " + string);
			exception.printStackTrace();
		}
	}

	public static void e(String string, Exception exception) {
		if (isDebug) {
			Log.e(applicationTag, getContent(getCurrentStackTraceElement())
					+ "\n  ====   " + exception.getMessage() + "\n  ====   "
					+ exception.getStackTrace() + "   " + string);
			exception.printStackTrace();
		}
	}

	public static void e(String tag, String message, Exception exception) {
		if (isDebug) {
			Log.e(tag, getContent(getCurrentStackTraceElement())
					+ "\n  ====   " + exception.getMessage() + "\n  ====   "
					+ exception.getStackTrace() + "   " + message);
			exception.printStackTrace();
		}
	}

	public static void showLog(String str) {
		int index = 0;
		int maxLength = 3000;
		String finalString;
		while (index < str.length()) {
			if (str.length() <= index + maxLength) {
				finalString = str.substring(index);
			} else {
				finalString = str.substring(index, index + maxLength);
			}
			index += maxLength;
			LogHelper.v(finalString);
		}
	}
	
}