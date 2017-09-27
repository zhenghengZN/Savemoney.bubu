package so.bubu.lib.base.adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * description：viewHolder主要帮助convertView存储控件，每个convertView绑定一个viewHolder,
 * viewHolder通过convertView.setTag与之绑定
 *
 * Created by wangwn on 2016/4/8.
 */
public class ViewHolder {
    /**
     * 用于存放listview每个Item的控件，
     */
    private final SparseArray<View> mViews;

    private View mConvertView;
    private Context mContext;

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int postion) {
        this.mContext = context;
        this.mViews = new SparseArray<View> ();
        mConvertView = LayoutInflater.from (context).inflate (layoutId, parent, false);
        mConvertView.setTag (this);
    }

    /**
     * 方法说明：获取一个ViewHoldr
     *
     * @param context
     * @param converView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static ViewHolder get (Context context, View converView, ViewGroup parent, int layoutId, int position) {
        if(converView == null) {
            return new ViewHolder (context, parent, layoutId, position);
        }
        return (ViewHolder) converView.getTag ();
    }

    /**
     * 方法说明： 通过控件Id获取对应的控件，没有则加入views
     * @param viewId
     * @return
     */
    public <T extends View> T getView (int viewId) {
        View view = mViews.get (viewId);
        if(view == null) {
            view = mConvertView.findViewById (viewId);
            mViews.put (viewId, view);
        }
        return (T) view;
    }

    /**
     * 方法说明： 获取单个listview 单个item的view
     * @return
     */
    public View getConvertView () {
        return mConvertView;
    }

    /**
     * 方法说明：设置文本
     * @param viewId
     * @param text
     * @return
     */
    public ViewHolder setText (int viewId, String text) {
        TextView view = getView (viewId);
        view.setText (text);
        return this;
    }
    /**
     * description:设置文本
     */
    public ViewHolder setText (int viewId, int resId) {
        TextView view = getView (viewId);
        view.setText (resId);
        return this;
    }

    public ViewHolder setVisibility(int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }

    /**
     * 方法说明： 为IamgeView设置图片
     * @param viewId
     * @param drawableId
     * @return
     */
    public ViewHolder setImageResource (int viewId, int drawableId) {
        ImageView view = getView (viewId);
        view.setImageResource(drawableId);
        return this;
    }

    public ViewHolder setImageDrawable (int viewId, Drawable mDrawable) {
        ImageView view = getView (viewId);
        view.setImageDrawable(mDrawable);
        return this;
    }

    public ViewHolder setBackgroundDrawable (int viewId, Drawable mDrawable) {
        ImageView view = getView (viewId);
        view.setBackgroundDrawable(mDrawable);
        return this;
    }


}
