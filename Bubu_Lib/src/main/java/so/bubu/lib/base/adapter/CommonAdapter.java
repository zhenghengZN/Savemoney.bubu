package so.bubu.lib.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * description:基础listView适配器
 * Created by wangwn on 2016/4/8.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
	protected LayoutInflater mInflater;
	protected Context mContext;
	protected List<T> list;
	protected final int mItemLayoutId;

	public CommonAdapter(Context context, List<T> mDatas, int itemLayoutId) {
		// TODO Auto-generated constructor stub
		this.mInflater = LayoutInflater.from(context);
		this.mContext = context;
		this.list = mDatas;
		this.mItemLayoutId = itemLayoutId;
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(list == null){
           return 0;
		}
		return list.size();
	}

	@Override
	public T getItem(int position) {
		// TODO Auto-generated method stub
		if(list == null && position < list.size()){
          return  null;
		}
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder = this.getViewHolder(position, convertView, parent);
		convert(viewHolder,getItem(position),position);
		return viewHolder.getConvertView();
	}
   
	public abstract void convert(ViewHolder viewHolder, T item,int position);
	
	private ViewHolder getViewHolder(int position,View convertView,ViewGroup parent){
		return ViewHolder.get(mContext, convertView, parent, mItemLayoutId, position);
		
	}
	
}
