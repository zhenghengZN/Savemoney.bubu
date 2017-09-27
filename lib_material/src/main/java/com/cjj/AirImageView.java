package com.cjj;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * @author linhuan on 16/8/12 上午10:30
 */
public class AirImageView extends ImageView {

    public AirImageView(Context context) {
        this(context, null);
    }

    public AirImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AirImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        Context context = getContext();

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Util.dip2px(context, 52), Util.dip2px(context, 18));
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        layoutParams.bottomMargin = Util.dip2px(context, 87);
        layoutParams.rightMargin = Util.dip2px(context, 80);
        setLayoutParams(layoutParams);
        setScaleType(ScaleType.FIT_XY);

        setBackgroundResource(R.drawable.pho_pl);
    }

}
