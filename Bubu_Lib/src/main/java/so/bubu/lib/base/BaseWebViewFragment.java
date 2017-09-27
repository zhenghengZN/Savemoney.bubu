package so.bubu.lib.base;

import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import so.bubu.lib.helper.NetWorkHelper;

/**
 * BaseWebViewFragment:webview页面基类
 * 
 * @author linhuan 2015-11-23上午10:33:22
 */
public abstract class BaseWebViewFragment extends BaseFragment {
	
	private static final String TAG = BaseWebViewFragment.class.getSimpleName();

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
		}else {
			mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		}
		
		mWebView.getSettings().setLoadsImagesAutomatically(19 > Build.VERSION.SDK_INT ? false : true);
		
		mWebView.getSettings().setSupportZoom(false);
		mWebView.getSettings().setBuiltInZoomControls(false);
        mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setBlockNetworkImage(false);
		mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		
		mWebView.setWebChromeClient(new BaseWebChromeClient(getActivity()));
		mWebView.setWebViewClient(new BaseWebViewClient(mWebView));
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
//		if (Helper.isNotNull(mWebView)) {
//			mWebView.destroy();
//		}
	}

}
