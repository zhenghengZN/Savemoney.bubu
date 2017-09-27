package so.bubu.Coupon.AliTrade.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.LinkedList;

import adapter.BaseCallFunctionBackListener;
import adapter.TaobaoContentAdapter;
import bean.TaobaoContentBean;
import common.base.TitleFragment;


import so.bubu.Coupon.AliTrade.R;
import utils.InformationHelper;
import utils.UIHelper;


public class TaobaoContentFragment extends TitleFragment {

    private int skip = 0;
    private MaterialRefreshLayout mrlrefresh;
    private RecyclerView rcvinformation;
    private String category;
    private LinkedList<TaobaoContentBean> taobaoContentBeans = new LinkedList<>();
    private TaobaoContentAdapter taobaoContentAdapter;
    private boolean hasAgainData = false;
    private static final int POI_COUNT = 20 ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_taobao_content);
    }

    @Override
    protected void initView() {
        super.initView();


        mrlrefresh = (MaterialRefreshLayout) findViewById(R.id.mrl_refresh);
        mrlrefresh.setMaterialRefreshListener(materialRefreshListener);
        rcvinformation = (RecyclerView) findViewById(R.id.rcv_information);
        rcvinformation.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        taobaoContentAdapter = new TaobaoContentAdapter(getActivity(), taobaoContentBeans);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.line, null, false);
        taobaoContentAdapter.setHeaderView(inflate);
        taobaoContentAdapter.setOnItemClickListener(new TaobaoContentAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                if (taobaoContentBeans.size() >= 0) {
                    String couponShareUrl = taobaoContentBeans.get(position).getCouponShareUrl();
                    UIHelper.getInstance().openUrl(getActivity(), couponShareUrl);
                }
            }
        });

        rcvinformation.setAdapter(taobaoContentAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        getCategory();
        hasNetData();
    }

    private void hasNetData() {
        InformationHelper.getInstance().getTaobaoItems(skip, POI_COUNT, category, null, new BaseCallFunctionBackListener() {
            @Override
            public void callSuccess(boolean result, String jsonstr) {
                if (result) {
                    if (hasAgainData) {
                        hasAgainData = false;
                        taobaoContentBeans.clear();
                    }
                    taobaoContentBeans.addAll(JSON.parseArray(jsonstr, TaobaoContentBean.class));
                    Log.e("callSuccess", "callSuccess " + taobaoContentBeans.get(0).getPicUrl());
                    taobaoContentAdapter.notifyDataSetChanged();
                } else {
                    mrlrefresh.setLoadMore(false);
                    mrlrefresh.finishRefreshLoadMore();
                }

                finishRefresh(mrlrefresh);
                skip = taobaoContentBeans.size();
                int i = taobaoContentBeans.size() % POI_COUNT;
                if (i > 0 && i < 20) {
                    mrlrefresh.setLoadMore(false);
                }
            }

            @Override
            public void callFailure(int type, AVException e) {
                finishRefresh(mrlrefresh);
            }
        });
    }

    private MaterialRefreshListener materialRefreshListener = new MaterialRefreshListener() {
        @Override
        public void isRefresh(boolean isRefresh) {}

        @Override
        public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
            hasAgainData = true;
            mrlrefresh.setLoadMore(true);
            skip = 0;
            hasNetData();
        }

        @Override
        public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
            mrlrefresh.postDelayed(new Runnable() {
                @Override
                public void run() {
                    hasNetData();
                }
            }, 1000);

        }
    };

    private void getCategory() {
        Bundle bundle = getArguments();
        category = bundle.getString("category");

    }
}


