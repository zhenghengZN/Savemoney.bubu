package adapter;

import android.view.View;

import com.avos.avoscloud.AVException;
import com.cjj.MaterialRefreshLayout;


import so.bubu.Coupon.AliTrade.R;
import so.bubu.lib.helper.Helper;
import so.bubu.lib.helper.ToastHelper;

import utils.CallFunctionBackListener;

/**
 * @author linhuan on 16/6/24 下午7:12
 */
public class BaseCallFunctionBackListener implements CallFunctionBackListener {

    private View view;

    public BaseCallFunctionBackListener() {

    }

    public BaseCallFunctionBackListener(View view) {
        this.view = view;
    }

    public void finishRefresh(View view) {
        if (Helper.isNotNull(view)) {
            if (view instanceof MaterialRefreshLayout) {
                ((MaterialRefreshLayout) view).finishRefresh();
                ((MaterialRefreshLayout) view).finishRefreshLoadMore();
            }
        }
    }

    @Override
    public void callSuccess(boolean result, String jsonstr) {

    }

    @Override
    public void callFailure(int type, AVException e) {
        ToastHelper.showToast(R.string.text_net_no);
        finishRefresh(view);
    }

}
