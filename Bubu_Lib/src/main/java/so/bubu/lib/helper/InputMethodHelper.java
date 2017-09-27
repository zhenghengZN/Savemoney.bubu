package so.bubu.lib.helper;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import so.bubu.lib.base.BaseApplication;

/**
 * function: 输入法控制
 * 
 * @author:linhuan 2011-11-10
 */
public class InputMethodHelper {

	/**
	 * function: 如输入法关闭则打开
	 * 
	 * @author:linhuan 2011-11-10 下午03:15:44
	 */
	public static void openInputMethod(View view) {
		view.requestFocus();
		InputMethodManager imm = (InputMethodManager) BaseApplication.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
	}

	/**
	 * function: 如输入法打开则关闭
	 * 
	 * @param act
	 *
	 *  @author:linhuan 2011-11-10 下午03:27:59
	 */
	public static void closeInputMethod(Activity act) {
		if (Helper.isNotNull(act.getCurrentFocus())) {
			InputMethodManager imm = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(act.getCurrentFocus().getWindowToken(),	0);
		}
	}

	/**
	 * function: 切换输入法的状态
	 * 
	 * @author:linhuan 2011-11-10 下午03:16:25
	 */
	public static void toggleInputMethod() {
		InputMethodManager imm = (InputMethodManager) BaseApplication.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
	}
	
}