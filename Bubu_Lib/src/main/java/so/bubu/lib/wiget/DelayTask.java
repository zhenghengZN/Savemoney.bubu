package so.bubu.lib.wiget;

import android.os.AsyncTask;

/**
 * function: AsyncTask封装
 * 
 * @author:linhuan
 */
public class DelayTask {
	
	private final String TAG = DelayTask.class.getSimpleName();
	
	// 延时时间
	private int mDelayMs;
	
	// 重复次数
	private int mRepeatCount = Integer.MAX_VALUE;
	
	// 延时后执行监听器
	private OnDelayExecuteListener mListener;
	
	private InnerDelayTask mInnerDelayTask;

	/**
	 * 构造方法(无限循环)
	 * 
	 * @param delayMS 延时时间(毫秒)
	 * @param listener 延时后执行监听
	 */
	public DelayTask(int delayMS, OnDelayExecuteListener listener){
		this.mDelayMs = delayMS;
		this.mListener = listener;
	}
	
	/**
	 * 构造方法
	 * 
	 * @param delayMS 延时时间(毫秒)
	 * @param repeatCount 重复次数
	 * @param listener 延时后执行监听
	 */
	public DelayTask(int delayMS, int repeatCount, OnDelayExecuteListener listener){
		this.mDelayMs = delayMS;
		this.mRepeatCount = repeatCount;
		this.mListener = listener;
	}
	
	/**
	 * 开始
	 */
	public void start(){
//		if (this.mInnerDelayTask == null){
//			this.mInnerDelayTask = new InnerDelayTask();
//		}
		this.mInnerDelayTask = new InnerDelayTask();
		this.mInnerDelayTask.execute();
	}
	
	/**
	 * 取消
	 */
	public void cancel(){
		this.mInnerDelayTask.cancel(true);
	}

	/**
	 * function: 内部延时任务
	 * 
	 * @author:linhuan
	 */
	private class InnerDelayTask extends AsyncTask<Void, Void, Void> {
		
		private final String INNER_TAG = InnerDelayTask.class.getSimpleName();
		
		@Override
		protected Void doInBackground(Void... arg0) {
			try {
				do{
					Thread.sleep(mDelayMs);
					this.publishProgress();
					if (mRepeatCount > 0 && mRepeatCount != Integer.MAX_VALUE){
						mRepeatCount--;
					}
				} while(mRepeatCount > 0 || mRepeatCount == Integer.MAX_VALUE);
			} catch (InterruptedException e) {
				
			}
			return null;
		}
		
		@Override
		protected void onPreExecute() {
			mListener.onPreExecute();
		}

		@Override
		protected void onPostExecute(Void result) {
			mListener.onPostExecute();
		}
		@Override
		protected void onProgressUpdate(Void... values) {
			mListener.onProgressUpdate();
		}

	}
	
	/**
	 * function: 延时后执行监听器接口
	 * 
	 * @author:linhuan
	 */
	public interface OnDelayExecuteListener{
		void onProgressUpdate();
		void onPreExecute();
		void onPostExecute();
	}
	
}
