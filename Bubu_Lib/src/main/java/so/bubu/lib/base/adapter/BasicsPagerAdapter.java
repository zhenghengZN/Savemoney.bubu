package so.bubu.lib.base.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import so.bubu.lib.helper.Helper;

/**
 * function: 分页适配器基类
 * @param <T>
 * 
 * @ author:linhuan
 */
public abstract class BasicsPagerAdapter<T> extends PagerAdapter {
	
	public final int TOPIC_TYPE = 0;					// 图片类型
	public final int VIEW_TYPE = 1;						// 其他类型
	
	public List<T> dataList;							// 数据
	private int TYPE;									

	public BasicsPagerAdapter(List<T> dataList) {
		this.dataList = dataList;
		this.TYPE = setType();
	}
	
	@Override
	public int getCount() {
		return Helper.isNull(dataList) ? 0 : dataList.size();
	}
	
	/**
	 * 删除图片
	 */
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == object;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		View view = getShowView(container, position);
		switch (TYPE) {
		
		case TOPIC_TYPE:
			container.addView(
					view, 
					LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT);
			break;

		case VIEW_TYPE:
			container.addView(view);
			break;
			
		}
		
		return view;
	}
	
	/**
	 * function: 获取显示数据
	 *
	 * @param container
	 * @param position
	 * @return
	 * 
	 * @ author:linhuan 2015-1-13 下午4:16:29
	 */
	protected abstract View getShowView(ViewGroup container, int position);
	
	/**
	 * function: 展示内容的类型
	 *
	 * @return
	 * 
	 * @ author:linhuan 2015-1-13 下午4:29:48
	 */
	protected abstract int setType();
	
}
