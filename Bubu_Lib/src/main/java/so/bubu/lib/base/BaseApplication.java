package so.bubu.lib.base;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

import so.bubu.lib.helper.DelayTaskHelper;
import so.bubu.lib.helper.Helper;
import so.bubu.lib.wiget.AsynTask;

/**
 * function: Application的基类
 * 
 * @author:linhuan
 */
public class BaseApplication extends MultiDexApplication {
	
	private static final String TAG = BaseApplication.class.getSimpleName();
	
	private static BaseApplication sInstance;
	private List<WeakReference<Activity>> activities = new LinkedList<WeakReference<Activity>>();

	public static BaseApplication getInstance() {

		if (Helper.isNull(sInstance)) {
//			Log.e(TAG, "THE APPLICATION OF YOUR PROJECT MUST BE 'BaseApplication', OR SOMEONE EXTEND FROM IT");
		}
		return sInstance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		sInstance = this;
	}

	/**
	 * 添加异步请求
	 *
	 * @param type
	 */
	protected final void addAsynTask(int type) {
		DelayTaskHelper.doAsynTask(new BaseOnAsynExecuteListener(type));
	}

	/**
	 * 异步读取数据
	 */
	class BaseOnAsynExecuteListener implements AsynTask.OnAsynExecuteListener {

		private int type;

		public BaseOnAsynExecuteListener(int type) {
			this.type = type;
		}

		@Override
		public void onStartBackground() {
			startBackground(type);
		}

		@Override
		public void onProgressUpdate() {
			progressUpdate(type);
		}

		@Override
		public void onPreExecute() {
			preExecute(type);
		}

		@Override
		public void onPostExecute() {
			postExecute(type);
		}
	}

	protected void startBackground(int type) {}

	protected void progressUpdate(int type) {}

	protected void preExecute(int type) {}

	protected void postExecute(int type) {}

}
