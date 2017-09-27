package so.bubu.lib.base;

import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import so.bubu.lib.helper.Helper;
import so.bubu.lib.helper.NetWorkHelper;

/**
 * function: webview页面 基类（不能刷新）
 * @param
 * 
 * @author:linhuan
 */
public abstract class BaseWebViewActivity extends BaseActivity {
	
	private static final String TAG = BaseWebViewActivity.class.getSimpleName();

	public WebView mWebView;
	
	/**
	 * initWebView 初始化webview
	 *
	 * @author linhuan 2015-7-11 上午11:12:35
	 */
	public void initWebView(int webViewID) {
		mWebView = (WebView) findViewById(webViewID);
		if (NetWorkHelper.isNetworkAvailable()) {
			mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		} else {
			mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		}
		
		mWebView.getSettings().setLoadsImagesAutomatically(19 > Build.VERSION.SDK_INT ? false : true);
		
		mWebView.getSettings().setSupportZoom(false);
		mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setBlockNetworkImage(false);
		mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		
		mWebView.setWebChromeClient(new BaseWebChromeClient(this));
		mWebView.setWebViewClient(new BaseWebViewClient(mWebView));
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (Helper.isNotNull(mWebView) && mWebView.canGoBack() && KeyEvent.KEYCODE_BACK == keyCode){
			mWebView.goBack(); //goBack()表示返回webView的上一页面 
			return true; 
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
//		if (Helper.isNotNull(mWebView)) {
//			mWebView.destroy();
//		}
	}

}
