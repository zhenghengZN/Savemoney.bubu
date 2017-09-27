package so.bubu.lib.wiget;

import android.os.AsyncTask;

/**
 * 异步
 *
 * @author linhuan on 16/4/11 下午4:58
 */
public class AsynTask {

    private final String TAG = DelayTask.class.getSimpleName();

    // 延时后执行监听器
    private OnAsynExecuteListener mListener;

    private AsynDelayTask mInnerDelayTask;

    /**
     * 构造方法(无限循环)
     *
     * @param listener 延时后执行监听
     */
    public AsynTask(OnAsynExecuteListener listener){
        this.mListener = listener;
    }

    /**
     * 开始
     */
    public void start(){
//		if (this.mInnerDelayTask == null){
//			this.mInnerDelayTask = new InnerDelayTask();
//		}
        this.mInnerDelayTask = new AsynDelayTask();
        this.mInnerDelayTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
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
    private class AsynDelayTask extends AsyncTask<Void, Void, Void> {

        private final String INNER_TAG = AsynDelayTask.class.getSimpleName();

        @Override
        protected Void doInBackground(Void... arg0) {
            mListener.onStartBackground();
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
    public interface OnAsynExecuteListener{
        void onStartBackground();
        void onProgressUpdate();
        void onPreExecute();
        void onPostExecute();
    }

}
