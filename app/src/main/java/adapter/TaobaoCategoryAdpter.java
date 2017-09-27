package adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.avos.avoscloud.LogUtil;

import so.bubu.Coupon.AliTrade.fragment.TaobaoContentFragment;


/**
 * Created by zhengheng on 17/9/12.
 */
public class TaobaoCategoryAdpter extends FragmentPagerAdapter {

//    private List<Category> categoryList = new ArrayList<>();
    public static String[] categoryList;
    private TaobaoContentFragment taobaoFragment;
    public TaobaoCategoryAdpter(FragmentManager fm) {
        super(fm);
    }

    public TaobaoCategoryAdpter(FragmentManager fm, String[] categoryList) {
        super(fm);
//        categoryList.clear();
//        categoryList.addAll(categoryList);
        this.categoryList = categoryList;
    }


    @Override
    public Fragment getItem(int position) {
        taobaoFragment = new TaobaoContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString("category",categoryList[position]);
        taobaoFragment.setArguments(bundle);
        return taobaoFragment;
    }

    @Override
    public int getCount() {
        if(categoryList != null) {
            return categoryList.length;
        }
        return 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(categoryList != null) {
            LogUtil.log.e("getPageTitle","getPageTitle"+categoryList[position]);
            return categoryList[position];
        }
        return "";
    }
}
