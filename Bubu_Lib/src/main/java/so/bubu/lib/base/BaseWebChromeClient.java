package so.bubu.lib.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import so.bubu.lib.R;

/**
 * BaseWebChromeClient 基类
 *
 * @author linhuan 2015年7月11日 上午10:45:14
 */
public class BaseWebChromeClient extends WebChromeClient {

	Activity act;
	
	public BaseWebChromeClient(Activity act) {
		this.act = act;
	}
	
	// 对话框
	@Override
	public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
		// 构建一个Builder来显示网页中的alert对话框
		Builder builder = new Builder(act);
		builder.setTitle(R.string.builder_prompt);
		builder.setMessage(message);
		builder.setPositiveButton(R.string.builder_determine, new AlertDialog.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				result.confirm();
			}
		});
		builder.setCancelable(false);
		builder.create();
		builder.show();
		return true;
	}
	
//	// 带按钮的对话框
//	@Override
//	public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
//		Builder builder = new Builder(act);
//		builder.setTitle(R.string.builder_prompt);
//		builder.setMessage(message);
//		builder.setPositiveButton(R.string.builder_determine,
//				new AlertDialog.OnClickListener() {
//
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						result.confirm();
//					}
//
//				});
//		builder.setNeutralButton(android.R.string.cancel,
//				new AlertDialog.OnClickListener() {
//
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						result.cancel();
//					}
//
//				});
//		builder.setCancelable(false);
//		builder.create();
//		builder.show();
//		return true;
//	}
//	
//	// 带输入框的对话框
//	@Override
//	public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
//		LayoutInflater inflater = LayoutInflater.from(act);
//		final View v = inflater.inflate(R.layout.prom_dialog, null);
//		// 设置 TextView对应网页中的提示信息
//		((TextView) v.findViewById(R.id.TextView_PROM)).setText(message);
//		// 设置EditText对应网页中的输入框
//		((EditText) v.findViewById(R.id.EditText_PROM)).setText(defaultValue);
//		Builder builder = new Builder(act);
//		builder.setTitle("带输入的对话框");
//		builder.setView(v);
//		builder.setPositiveButton(android.R.string.ok,
//				new AlertDialog.OnClickListener() {
//
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//
//						String value = ((EditText) v.findViewById(R.id.EditText_PROM)).getText().toString();
//						result.confirm(value);
//					}
//				});
//		builder.setNegativeButton(android.R.string.cancel,
//				new AlertDialog.OnClickListener() {
//
//					@Override
//					public void onClick(DialogInterface dialog, int which) {
//						// TODO Auto-generated method stub
//						result.cancel();
//					}
//				});
//		builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
//
//					@Override
//					public void onCancel(DialogInterface dialog) {
//						// TODO Auto-generated method stub
//						result.cancel();
//					}
//
//				});
//		builder.create();
//		builder.show();
//		return true;
//	}
//	
//	// 设置网页加载的进度条
//	public void onProgressChanged(WebView view, int newProgress) {
//		act.getWindow().setFeatureInt(Window.FEATURE_PROGRESS, newProgress * 100);
//		super.onProgressChanged(view, newProgress);
//	}
//
//	// 设置应用程序的标题
//	public void onReceivedTitle(WebView view, String title) {
//		act.setTitle(title);
//		super.onReceivedTitle(view, title);
//	}
	
}
