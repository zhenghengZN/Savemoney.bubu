package so.bubu.lib.helper;

import java.util.List;

import android.graphics.Bitmap;

/**
 * RamHelper 内存释放
 *
 * @author linhuan 2015年7月9日 下午2:52:45
 */
public class RamHelper {

	/**
	 * freedBitmap 释放图片内存
	 *
	 * @param bitmapList
	 *
	 * @author linhuan 2015年7月9日 下午2:55:00
	 */
	public static void freedBitmap(List<Bitmap> bitmapList) {
		for (Bitmap bitmap : bitmapList) {
			freedBitmap(bitmap);
		}
	}
	
	/**
	 * freedBitmap 释放图片内存
	 *
	 * @param bitmap
	 *
	 * @author linhuan 2015年7月9日 下午2:54:32
	 */
	public static void freedBitmap(Bitmap bitmap) {
		if(Helper.isNotNull(bitmap) && !bitmap.isRecycled()){  
		    // 回收并且置为null  
		    bitmap.recycle();  
		    bitmap = null;  
		}  
	}
	
}
