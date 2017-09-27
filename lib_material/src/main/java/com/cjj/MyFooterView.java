package com.cjj;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

/**
 * Created by zhengheng on 17/9/19.
 */

public class MyFooterView extends FrameLayout implements MaterialHeadListener {

    private boolean isFirst = true, isRepeat = false, isShutDown = false;

    private AirImageView airImageView;
    private Animation translateAnimation;
    private ShutDown shutDown;

    public MyFooterView(Context context) {
        this(context, null);
    }

    public MyFooterView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        /**
         * 这里偷懒了，如果你想在xml配置太阳的各个属性，可以在这里设置，然后传给SunFaceView和SunLineView就可以了
         */
//        View view = LayoutInflater.from(context).inflate(R.layout.item_header, null, false);

//        addView(view);

        setBackgroundColor(getResources().getColor(R.color.color_bg));

        Context context = getContext();

        ViewGroup.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Util.dip2px(context, 120));
        setLayoutParams(layoutParams);

        BgImageView bgImageView = new BgImageView(context);
        addView(bgImageView);

        airImageView = new AirImageView(context);
        addView(airImageView);

    }

    @Override
    public void onComlete(MaterialRefreshLayout materialRefreshLayout) {
//        cancelSunLineAnim();
//        ViewCompat.setScaleX(this, 0);
//        ViewCompat.setScaleY(this, 0);
        if (null != airImageView) {
            airImageView.clearAnimation();
        }
    }

    @Override
    public void onBegin(MaterialRefreshLayout materialRefreshLayout) {

//        ViewCompat.setScaleX(this, 0.001f);
//        ViewCompat.setScaleY(this, 0.001f);
//        ViewCompat.setScaleX(this, 1f);
//        ViewCompat.setScaleY(this, 1f);
        if (isFirst) {
            setVisibility(INVISIBLE);
        }
    }

    @Override
    public void onPull(MaterialRefreshLayout materialRefreshLayout, float fraction) {
//        float a = Util.limitValue(1, fraction);
//        if (a >= 0.7) {
//            mLineView.setVisibility(View.VISIBLE);
//        } else {
//            mLineView.setVisibility(View.GONE);
//        }
//        mSunView.setPerView(mSunRadius, a);
//        ViewCompat.setScaleX(this, a);
//        ViewCompat.setScaleY(this, a);
//        ViewCompat.setAlpha(this, a);

        if (isFirst) {
            isFirst = false;
            setVisibility(VISIBLE);
        }
    }

    @Override
    public void onRelease(MaterialRefreshLayout materialRefreshLayout, float fraction) {
    }

    @Override
    public void onRefreshing(MaterialRefreshLayout materialRefreshLayout) {
//        startSunLineAnim(mLineView);
        isRepeat = false;
        if (null == translateAnimation) {
            translateAnimation = new TranslateAnimation(0, Util.dip2px(getContext(), 160), 0, 0);
            translateAnimation.setDuration(1000);
            translateAnimation.setRepeatCount(-1);
            translateAnimation.setFillAfter(true);
            translateAnimation.setRepeatMode(Animation.RESTART);
            translateAnimation.setAnimationListener(animationListener);
        }
        if (null != airImageView) {
            airImageView.startAnimation(translateAnimation);
        }
    }

    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            isRepeat = true;
            if (isShutDown && null != shutDown) {
                isShutDown = false;
                shutDown.isShutDown();
            }
        }
    };

    public void setShutDown(ShutDown shutDown) {
        this.shutDown = shutDown;
    }

    public boolean isRepeat() {
        isShutDown = true;
        return isRepeat;
    }

    public interface ShutDown {

        void isShutDown();

    }

}
