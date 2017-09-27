package com.cjj;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * @author linhuan on 16/8/12 上午10:30
 */
public class BgImageView extends ImageView {

    public BgImageView(Context context) {
        this(context, null);
    }

    public BgImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BgImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        Context context = getContext();

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Util.dip2px(context, 262), Util.dip2px(context, 87));
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        setLayoutParams(layoutParams);
        setScaleType(ScaleType.FIT_XY);

        setBackgroundResource(R.drawable.pho_bg_loading);
    }

}
