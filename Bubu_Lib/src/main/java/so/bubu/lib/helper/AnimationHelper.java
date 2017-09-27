package so.bubu.lib.helper;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

/**
 * 动画帮助类
 *
 * Created by Administrator on 2016/3/23.
 */
public class AnimationHelper {

    /**
     * 初始化动画
     *
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param duration
     * @return
     */
    public static Animation initTranslateAnimation(int startX, int endX, int startY, int endY, long duration) {
        Animation animation = new TranslateAnimation(startX, endX, startY, endY);
        animation.setDuration(duration);
        return animation;
    }

    /**
     * 开始动画
     *
     * @param view
     * @param startX
     * @param endX
     * @param startY
     * @param endY
     * @param duration
     */
    public static void showTranslateAnimation(View view, int startX, int endX, int startY, int endY, long duration) {
        view.startAnimation(initTranslateAnimation(startX, endX, startY, endY, duration));
    }

}
