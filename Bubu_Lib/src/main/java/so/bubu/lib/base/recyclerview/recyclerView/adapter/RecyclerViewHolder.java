package so.bubu.lib.base.recyclerview.recyclerView.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * description:通用的RecyclerView ViewHolder
 *
 * Created by wangwn on 2016/4/8.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    /**
     * 用于存放listview每个Item的控件，
     */
    private final SparseArray<View> mViews;

    private View mConvertView;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.mViews = new SparseArray<View> ();
        this.mConvertView = itemView;
        mConvertView.setTag(this);
    }

   /**
    * description:通过控件Id获取对应的控件，没有则加入views
    *
    */
    public <T extends View> T getView(int viewId){
        View view = mViews.get(viewId);
        if(view == null){
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }
    /**
     * description:获取单个listview 单个item的view
     *
     */
    public View getConvertView(){
        return mConvertView;
    }
    /**
     * description:设置文本
     *
     */
    public RecyclerViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }
    /**
     * description:设置显示状态
     *
     */
    public RecyclerViewHolder setVisibility(int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }
    /**
     * description:设置文本
     *
     */
    public RecyclerViewHolder setText(int viewId, int textResId) {
        TextView view = getView(viewId);
        view.setText(textResId);
        return this;
    }
    /**
     * description:为IamgeView设置图片
     *
     */
    public RecyclerViewHolder setImageResource(int viewId, int drawableId){
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }
}
