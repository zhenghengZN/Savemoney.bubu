package so.bubu.lib.base;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import so.bubu.lib.helper.Helper;

/**
 * BaseWebViewClient 基类
 *
 * @author linhuan 2015年7月11日 上午10:44:36
 */
public class BaseWebViewClient extends WebViewClient {
	
	WebView webview;
	
	public BaseWebViewClient(WebView webview) {
		this.webview = webview;
	}
	
	@Override
	public void onPageFinished(WebView view, String url) {
		super.onPageFinished(view, url);
		
		if (Helper.isNotNull(webview) && !webview.getSettings().getLoadsImagesAutomatically()) {
			webview.getSettings().setLoadsImagesAutomatically(true);
		}
	}
	
	// 在本页面跳转
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		webview.loadUrl(url, null);
		return true;
	}
	
}
