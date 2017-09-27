package so.bubu.Coupon.AliTrade.activity.Taobao;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.LogUtil;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


import adapter.BaseCallFunctionBackListener;
import adapter.SearchAdapter;
import adapter.SearchHistoryAdapter;
import app.CommonData;
import bean.TaobaoContentBean;
import common.base.TitleAppCompatActivity;
import greendao.bean.History;
import greendao.dao.HistoryDao;
import iconicfont.IconicFontUtil;
import iconicfont.icon.CityGuideIcon;
import so.bubu.lib.base.BaseApplication;
import so.bubu.lib.helper.DelayTaskHelper;
import so.bubu.lib.helper.DeviceHelper;
import so.bubu.lib.helper.Helper;
import so.bubu.lib.helper.InputMethodHelper;
import so.bubu.lib.helper.NavigationHelper;
import so.bubu.lib.helper.ToastHelper;
import so.bubu.lib.wiget.DelayTask;
import so.bubu.Coupon.AliTrade.R;
import utils.AVAnalyticsHelper;
import utils.InformationHelper;
import utils.dbUtils.DbManager;
import wiget.NoScrollListView;

/**
 * 搜索界面
 *
 * Created by Administrator on 2016/4/12.
 */
public class SearchActivity<T> extends TitleAppCompatActivity {

    private static final int SEARCH = 0;
    private static final int SEARCH_HISTORY = 1;
    private static final int DELAY_POP_UP_KEYBOARD = 300;
    private static final int DELAY_POP_DOWN_KEYBOARD = 300;

    public static final String SEARCH_TYPE = "search_type";
    public static final int POI_COUNT = 20;

    private ScrollView svSelect;
    private EditText etSearch;
    private NoScrollListView nsllSelectHistory;
    private RecyclerView lvSearch;
    private TextView tv_title;

//    private boolean isInputShow;
    private int searchTypeData;
    private String searchType, lastSearchKey;
    private History history;
    private List<T> placeList;
    private List<T> lastplaceList;
    private List<History> histories;

    private SearchHistoryAdapter searchHistoryAdapter;
    private SearchAdapter searchAdapter;
    private String searchString;

    private MaterialRefreshLayout mrlrefresh;
    private boolean hasAgainData = false;
    private int skip = 0;
    private FrameLayout searchview;

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_search);
    }

    @Override
    protected void initView() {
        super.initView();

        setVisibility(R.id.et_search, View.VISIBLE);

        setSearch();

        svSelect = findView(R.id.sv_select);

        // 键盘延迟弹出
        etSearch = findView(R.id.et_content_search);
        etSearch.setOnKeyListener(onKeyListener);
//        etSearch.setFocusable(false);
//        etSearch.setFocusableInTouchMode(false);
        etSearch.clearFocus();
//        etSearch.addTextChangedListener(textWatcher);
        findViewById(R.id.et_search).setOnClickListener(onClickListener);
        findViewById(R.id.rl_search).setOnClickListener(null);

        lvSearch = findView(R.id.lv_search);
        lvSearch.setVisibility(View.GONE);
        lvSearch.setHasFixedSize(true);
        nsllSelectHistory = findView(R.id.nsll_select_history);
        svSelect.setVisibility(View.GONE);
        nsllSelectHistory.setOnItemClickListener(onItemClickListener);
        nsllSelectHistory.setOnScrollListener(new CommonOnScrollListener());
        lvSearch.setOnScrollListener(new CommonRecyclerOnScroll());

        findViewById(R.id.iv_search_imageview).setBackground(IconicFontUtil.createIconicFont(CityGuideIcon.ICON_SEARCH, BaseApplication.getInstance().getResources().getColor(R.color.color_menu_infor)));
        findViewById(R.id.iv_back_poi_imageview).setBackground(IconicFontUtil.createIconicFont(CityGuideIcon.ICON_BACK));
        findViewById(R.id.iv_back_poi).setOnClickListener(onClickListener);
        findViewById(R.id.tv_clear_history).setOnClickListener(onClickListener);
        findViewById(R.id.ll_content).setOnClickListener(onClickListener);
        findViewById(R.id.iv_search_poi).setOnClickListener(onClickListener);

        mrlrefresh = (MaterialRefreshLayout) findViewById(R.id.mrl_refresh);
        mrlrefresh.setMaterialRefreshListener(materialRefreshListener);
        mrlrefresh.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {
        super.initData();

        lastSearchKey = "";
        searchTypeData = getIntent().getIntExtra(SEARCH_TYPE, -1);


         if (searchTypeData == CommonData.TAOBAO) {
            searchType = "taobao";
             }

        histories = new ArrayList<>();
        searchHistoryAdapter = new SearchHistoryAdapter(this, histories);
        nsllSelectHistory.setAdapter(searchHistoryAdapter);

        lvSearch.setLayoutManager(new LinearLayoutManager(this));
        placeList = new ArrayList<>();
        searchAdapter = new SearchAdapter(this, placeList, searchTypeData);
        searchAdapter.setSearchInterface(searchInterface);
        lvSearch.setAdapter(searchAdapter);

        // 搜索框动画
        findViewById(R.id.ll_history).setVisibility(View.GONE);
        if (DeviceHelper.isBrand(DeviceHelper.BRAND_HUAWEI)) {
            // 华为
            findViewById(R.id.ll_history).setVisibility(View.VISIBLE);
        } else {
            showAnim(R.anim.view_search_top_in, R.id.rl_search, true);
        }

        addAsynTask(SEARCH_HISTORY);

        DelayTaskHelper.doDelayTask(DELAY_POP_UP_KEYBOARD, new SearchOnDelayExecuteListener(SEARCH));
    }

    private class InitSearchAnimListener implements Animation.AnimationListener {

        private boolean searchFlag;

        public InitSearchAnimListener(boolean searchFlag) {
            this.searchFlag = searchFlag;
        }

        @Override
        public void onAnimationStart(Animation animation) {}

        @Override
        public void onAnimationEnd(Animation animation) {
            if (searchFlag) {
                findViewById(R.id.rl_search).clearAnimation();
                findViewById(R.id.ll_history).setVisibility(View.VISIBLE);
                showAnim(R.anim.view_search_top_in, R.id.ll_history, false);
            } else {
                findViewById(R.id.ll_history).clearAnimation();
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {}
    }

    private void showAnim(int animId, int viewAnimId, boolean animFlag) {
        Animation animation = AnimationUtils.loadAnimation(this, animId);
        animation.setAnimationListener(new InitSearchAnimListener(animFlag));
        findViewById(viewAnimId).startAnimation(animation);
    }

    private SearchAdapter.SearchInterface searchInterface = new SearchAdapter.SearchInterface() {
        @Override
        public void searchInterface() {
            InputMethodHelper.closeInputMethod(SearchActivity.this);
        }
    };



    private class CommonRecyclerOnScroll extends RecyclerView.OnScrollListener {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            switch (newState) {

                // 滚动状态关闭软键盘
                case RecyclerView.SCROLL_STATE_DRAGGING:
                    // 触摸后滚动关闭软键盘
                case RecyclerView.SCROLL_STATE_SETTLING:
//                    if (isInputShow) {
                    InputMethodHelper.closeInputMethod(SearchActivity.this);
//                        isInputShow = false;
//                    }
                    break;

            }
        }
    }

    private class CommonOnScrollListener implements AbsListView.OnScrollListener {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {
//            super.onScrollStateChanged(view, scrollState);
            switch (scrollState) {

                // 滚动状态关闭软键盘
                case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                    // 触摸后滚动关闭软键盘
                case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
//                    if (isInputShow) {
                    InputMethodHelper.closeInputMethod(SearchActivity.this);
//                        isInputShow = false;
//                    }
                    break;

            }
        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        }
    }

    @Override
    protected boolean isSwipeback() {
        return false;
    }

    class SearchOnDelayExecuteListener implements DelayTask.OnDelayExecuteListener {

        private int type;

        public SearchOnDelayExecuteListener(int type) {
            this.type = type;
        }

        @Override
        public void onProgressUpdate() {}

        @Override
        public void onPreExecute() {}

        @Override
        public void onPostExecute() {
            switch (type) {

                case SEARCH:
                    etSearch.setFocusable(true);
                    etSearch.setFocusableInTouchMode(true);
                    etSearch.requestFocus();
               //     InputMethodHelper.openInputMethod(etSearch);
//                    isInputShow = true;
                    break;

                case SEARCH_HISTORY:
                    NavigationHelper.finish(SearchActivity.this, RESULT_OK, null);
                    break;

            }
        }

    }

    private View.OnKeyListener onKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (KeyEvent.KEYCODE_ENTER == keyCode && KeyEvent.ACTION_DOWN == event.getAction()) {
                if (etSearch.getText().toString().equals(lastSearchKey)) {
                    setResultshow();
                    return false;
                }
                search();
                return true;
            }
            return false;
        }
    };

    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AVAnalyticsHelper.addSearchActions(AVAnalyticsHelper.SEARCH_HISTORY);
            setSearchKey(histories.get(position).getSearchContent(), false);
        }
    };

    @Override
    protected void search() {
        AVAnalyticsHelper.addSearchActions(AVAnalyticsHelper.SEARCH_CLICK);
        setSearchKey(etSearch.getText().toString(), true);
    }

    private void goSearch(String search) {
        if (lastSearchKey.equals(search)) {
            showSearchContent();
            lvSearch.scrollToPosition(0);
            return;
        }
        lastSearchKey = search;
        history = new History(search, searchType, new Date());

        // 先把poi搜索出结果，在异步搜索其他数据
//        if(!iscancle) {
            placeList.clear();

        searchAdapter.notifyDataSetChanged();

        if (CommonData.TAOBAO == searchTypeData) {
            InformationHelper.getInstance().getTaobaoItems(skip, POI_COUNT, null, search, callFunctionBackListener);
        }
        showSearchContent();
        lvSearch.scrollToPosition(0);
    }

    private void selectSearch(String search) {
        if (CommonData.TAOBAO == searchTypeData) {
            InformationHelper.getInstance().getTaobaoItems(skip, POI_COUNT, null, search, callFunctionBackListener);
        }
        showSearchContent();
    }

    private BaseCallFunctionBackListener callFunctionBackListener = new BaseCallFunctionBackListener() {

        @Override
        public void callSuccess(boolean result, String jsonstr) {
            List<T> temporaryList ;

            if (result) {

                    if (hasAgainData) {
                        hasAgainData = false;
                        placeList.clear();
                    }
                    temporaryList = (List<T>) JSON.parseArray(jsonstr, TaobaoContentBean.class);

                finishRefresh(mrlrefresh);
                placeList.addAll(new LinkedList<>(temporaryList));
                skip = placeList.size();
                int i = placeList.size() % POI_COUNT;
                if (i > 0 && i < 20 ) {
                    mrlrefresh.setLoadMore(false);
                }
            } else {
                mrlrefresh.setLoadMore(false);
                mrlrefresh.finishRefreshLoadMore();
            }

            searchAdapter.notifyDataSetChanged();
            showSearchContent();
//            lvSearch.scrollToPosition(0);

        }

        @Override
        public void callFailure(int type, AVException e) {
            super.callFailure(type, e);
            finishRefresh(mrlrefresh);

        }
    };

    private void setSearchKey(String search, boolean isShowHistory) {
        LogUtil.log.e("lvSearch","lvSearch" + lvSearch.getVisibility());
        if (Helper.isEmpty(search)) {
            ToastHelper.showToast(R.string.text_city_no_search_key);
        } else if (View.GONE == mrlrefresh.getVisibility()) {
            etSearch.setText(search);
            LogUtil.log.e("search","search" + search);
            etSearch.setSelection(search.length());

            // 键盘关闭
            InputMethodHelper.closeInputMethod(this);
//            isInputShow = false;

//            searchString = search;
            goSearch(search);

            if (isShowHistory) {
                // 避免数据重复
                boolean isAddHistory = true;
                for (History oldHistory : histories) {
                    if (oldHistory.getSearchContent().equals(search)) {
                        isAddHistory = false;
                        break;
                    }
                }
                if (isAddHistory) {
                    histories.add(0, history);
                    searchAdapter.notifyDataSetChanged();
                    DbManager.getInstance().insertOrReplaceInTx(DbManager.getInstance().getHistoryDao(), history);
                }
            }

        }
    }

    @Override
    protected void startBackground(int type) {
        switch (type) {

            case SEARCH_HISTORY:
                histories.clear();
                histories.addAll(DbManager.getInstance().getSelectData(DbManager.getInstance().getHistoryDao(), HistoryDao.Properties.SearchDate));
                break;

        }
    }

    @Override
    protected void postExecute(int type) {
        switch (type) {

            case SEARCH_HISTORY:
                showSearchHistory();//显示svSelect
                //searchHistoryAdapter.notifyDataSetChanged();
                break;

        }
    }

    private void showSearchContent() {
        mrlrefresh.setVisibility(Helper.isEmpty(placeList) ? View.GONE : View.VISIBLE);
        lvSearch.setVisibility(Helper.isEmpty(placeList) ? View.GONE : View.VISIBLE);
        if (Helper.isNotEmpty(histories)) {
            svSelect.setVisibility(View.GONE);
        }
        setVisibility(R.id.et_search, View.GONE);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText(lastSearchKey);
        setVisibility(R.id.tv_title, View.VISIBLE);
        searchview = (FrameLayout) findViewById(R.id.tv_search);
        changeViewBg(R.id.tv_search_imageview, IconicFontUtil.createIconicFont(CityGuideIcon.ICON_SEARCH));
        searchview.setVisibility(View.VISIBLE);
        searchview.setOnClickListener(onClickListener);
        findViewById(R.id.iv_back_poi_imageview).setVisibility(View.VISIBLE);
        findViewById(R.id.iv_search_poi).setVisibility(View.GONE);
    }

    private void showSearchHistory() {
//        mrlrefresh.setVisibility(Helper.isEmpty(placeList) ? View.GONE : View.VISIBLE);
//        lvSearch.setVisibility(Helper.isEmpty(placeList) ? View.GONE : View.VISIBLE);
        if (Helper.isNotEmpty(histories)) {
            svSelect.setVisibility(View.VISIBLE);
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                // 清空搜索历史
                case R.id.tv_clear_history:
                    AVAnalyticsHelper.addSearchActions(AVAnalyticsHelper.SEARCH_CLEAR_HISTORY);
                    DbManager.getInstance().deleteAll(DbManager.getInstance().getHistoryDao());
                    svSelect.setVisibility(View.GONE);
                    histories.clear();
                    searchHistoryAdapter.notifyDataSetChanged();
                    break;

                // 点击输入框
                case R.id.et_search:
                    showSearchHistory();
//                    isInputShow = true;
                    break;

                // 点击其他区域关闭键盘
                case R.id.iv_back_poi:
                    finish();
                    break;

                case R.id.ll_content:
                    InputMethodHelper.closeInputMethod(SearchActivity.this);
//                    isInputShow = false;
                    DelayTaskHelper.doDelayTask(DELAY_POP_DOWN_KEYBOARD, new SearchOnDelayExecuteListener(SEARCH_HISTORY));
                    break;

                case R.id.tv_search:
                    skip = 0;
                    setVisibility(R.id.et_search, View.VISIBLE);
                    setVisibility(R.id.tv_title, View.GONE);
                    mrlrefresh.setVisibility(View.GONE);
                    lvSearch.setVisibility(View.GONE);
                    findViewById(R.id.iv_back_poi_imageview).setVisibility(View.GONE);
                    findViewById(R.id.iv_search_poi).setVisibility(View.VISIBLE);
                    findViewById(R.id.tv_search).setVisibility(View.GONE);
                    findViewById(R.id.ll_history).setVisibility(View.GONE);
                    if (DeviceHelper.isBrand(DeviceHelper.BRAND_HUAWEI)) {
                        // 华为
                        findViewById(R.id.ll_history).setVisibility(View.VISIBLE);
                    } else {
                        showAnim(R.anim.view_search_top_in, R.id.rl_search, true);
                    }
                    addAsynTask(SEARCH_HISTORY);
                    break;

                case R.id.iv_search_poi:
                    setResultshow();
                    //搜索时没输入过时取消关闭activity,搜索过取消时隐藏布局
                    if (lastSearchKey == null || lastSearchKey.isEmpty()) {
                        SearchActivity.this.finish();
                    }
                    else {
                        skip = placeList.size();
                    }
            }
        }
    };


    private void setResultshow() {
        mrlrefresh.setVisibility(View.VISIBLE);
        lvSearch.setVisibility(View.VISIBLE);
        setVisibility(R.id.et_search, View.GONE);
        setVisibility(R.id.tv_title, View.VISIBLE);
        findViewById(R.id.iv_back_poi_imageview).setVisibility(View.VISIBLE);
        findViewById(R.id.iv_search_poi).setVisibility(View.GONE);
        findViewById(R.id.tv_search).setVisibility(View.VISIBLE);
        InputMethodHelper.closeInputMethod(SearchActivity.this);
    }
    @Override
    protected void doBack(int keyCode, KeyEvent event) {
        NavigationHelper.finish(this, RESULT_OK, null);
    }

    private MaterialRefreshListener materialRefreshListener = new MaterialRefreshListener() {
        @Override
        public void isRefresh(boolean isRefresh) {}

        @Override
        public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
            hasAgainData = true;
            mrlrefresh.setLoadMore(true);
            skip = 0;
            selectSearch(lastSearchKey);
        }

        @Override
        public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
            mrlrefresh.postDelayed(new Runnable() {
                @Override
                public void run() {
                    selectSearch(lastSearchKey);
                }
            }, 1000);

        }
    };

}
