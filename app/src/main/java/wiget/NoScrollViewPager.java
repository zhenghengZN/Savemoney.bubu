package wiget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 通过开关禁止开启viewpager左右滑动
 *
 * Created by Administrator on 2016/3/23.
 */
public class NoScrollViewPager extends ViewPager {

    // true:不可滑动 false:可滑动
    private boolean noScroll = true;

    private boolean isNesting = false;

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public void setNoScroll(boolean noScroll) {
        this.noScroll = noScroll;
    }

    public void setNesting(boolean nesting) {
        isNesting = nesting;
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onTouchEvent(arg0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (noScroll)
            return false;
        else
            return super.onInterceptTouchEvent(arg0);
    }

    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v != this && v instanceof ViewPager && isNesting) {
            return true;
        }
        return v.getClass().getName().equals("com.baidu.mapapi.map.MapView")
                || v.getClass().getName().equals("com.amap.api.maps.MapView")
                || super.canScroll(v, checkV, dx, x, y);


    }
}
