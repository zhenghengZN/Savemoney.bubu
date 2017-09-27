package wiget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import so.bubu.lib.helper.DeviceHelper;

/**
 * @author linhuan on 16/8/1 下午6:28
 */
public class FatherViewPager extends ViewPager {

    private static final int MULTIPLE_SLIDE = 50;
    private static final int MULTIPE = DeviceHelper.getScreenWidth() / MULTIPLE_SLIDE;

    private float preX;

    public FatherViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FatherViewPager(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent ev) {

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
//                getParent().requestDisallowInterceptTouchEvent(true);
//                int position = this.getCurrentItem();
//                if (position == 1) {
//                    this.setCurrentItem(0);//这个地方的显示有些突然,因为是跳转,不是滑动,可以设置滑动一定的距离再来跳转,或者大家有其他好办法请不吝赐教哦,多谢~
//                }
                break;
            case MotionEvent.ACTION_UP:

                break;

            default:
                break;
        }
        return super.onTouchEvent(ev);
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean res = super.onInterceptTouchEvent(ev);
//
//        if (MotionEvent.ACTION_DOWN == ev.getAction()) {
//            preX = ev.getX();
//        } else {
//            if (Math.abs(ev.getX() - preX) > MULTIPE) {
//                return true;
//            } else {
//                preX = ev.getX();
//            }
//        }
//        return res;
//    }
}
