package iconicfont.util;

import android.content.Context;

import com.avos.avoscloud.AVCloud;
import com.avos.avoscloud.FunctionCallback;
import com.avos.avoscloud.LogUtil;

import java.util.HashMap;
import java.util.Map;


import app.CityGuideApplication;
import so.bubu.Coupon.AliTrade.R;
import so.bubu.lib.helper.ResourceHelper;

/**
 * Created by zhengheng on 17/9/23.
 */
public  class LearnCloudService {

    private  Context context ;

    public LearnCloudService(Context context) {
        this.context = context;
    }


    public  <T>  void callFunctionInBackground(String name, Map<String, Object> param, FunctionCallback<T> callback)
    {

        CityGuideApplication applicationContext = (CityGuideApplication) context.getApplicationContext();
        Map<String, Object> appInfo = new HashMap<>();
        appInfo.put("ipAddress", applicationContext.getIpaddress());
        appInfo.put("locationId", "");
        appInfo.put("bundleId", applicationContext.getPackagename());
        appInfo.put("version", applicationContext.getVersionName());


        LogUtil.log.e("appInfo", "appInfo:" + appInfo.get("ipAddress") + "," + appInfo.get("locationId") + "," + appInfo.get("bundleId") + appInfo.get("version"));
        if (param != null) {
            param.putAll(appInfo);
        }

        AVCloud.callFunctionInBackground(name, param, callback);
    }
}
