package so.bubu.lib.helper;

import java.lang.reflect.Field;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import so.bubu.lib.base.BaseApplication;

/**
 * function: 与resource资源、R相关
 * 
 * @author:linhuan
 */
public class ResourceHelper {
	/**
	 * sp转成px
	 * @param spValue
	 * @return
	 * @author dengxiumao
	 */
	public static int Sp2Px(float spValue) {
		final float fontScale = BaseApplication.getInstance().getResources().getDisplayMetrics().scaledDensity;
		return (int) (spValue * fontScale + 0.5f);
	}
	
	/**
	 * function:dp转成px
	 * 
	 * @param dp
	 * @return
	 * 
	 * @author:linhuan 2015-5-12 下午9:10:33
	 */
	public static int Dp2Px(float dp) {
	    final float scale = BaseApplication.getInstance().getResources().getDisplayMetrics().density;
	    return (int) (dp * scale + 0.5f); 
	}

	/**
	 * function: dip转成px
	 *
	 * @param dip
	 * @return
	 * 
	 * @author:linhuan 2014年8月28日 上午9:40:05
	 */
	public static int getPxFromDip(float dip) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, BaseApplication.getInstance().getResources().getDisplayMetrics());
	}
	
	/**
	 * function: sp转成px
	 *
	 * @param sp
	 * @return
	 * 
	 * @author:linhuan 2014年8月28日 上午9:39:40
	 */
	public static int getPxFromSp(float sp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, BaseApplication.getInstance().getResources().getDisplayMetrics());
	}

	/**
	 * function: 取得资源字符串
	 *
	 * @param resId 资源id
	 * @return 字符串
	 * 
	 * @author:linhuan 2014年7月15日 下午4:21:38
	 */
    public static String getString(int resId) {
        return BaseApplication.getInstance().getString(resId);
    }
    
    /**
     * function: 取得资源字符串(格式化字符串)
     *
     * @param resId 资源id
     * @param formatArgs 格式化参数
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:21:53
     */
    public static String getString(int resId, Object... formatArgs) {
        return BaseApplication.getInstance().getString(resId, formatArgs);
    }
    
    /**
     * function: 取得指定名称的bitmap
     *
     * @param imageName 图片名称
     * @return 图片对象
     * 
     * @author:linhuan 2014年7月15日 下午4:24:08
     */
    public static Bitmap getBitmapByName(String imageName) {
        Bitmap result = null;
        try {
            int resId = getImageResId(imageName);
            if (resId > 0) {
                result = BitmapFactory.decodeResource(BaseApplication.getInstance().getResources(), resId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * function: 取得指定名称的Drawable
     *
     * @param imageName 图片名称
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:24:54
     */
    public static Drawable getDrawableByName(String imageName) {
        Drawable result = null;
        try {
            int resId = getImageResId(imageName);
            if (resId > 0) {
                result = BaseApplication.getInstance().getResources().getDrawable(resId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * function: 获取平铺背景
     *
     * @param resId 资源id
     * @return
     * 
     * see: http://stackoverflow.com/questions/7586209/xml-drawable-bitmap-tilemode-bug
     * 
     * @author:linhuan 2014年7月15日 下午4:30:42
     */
    public static Drawable getRepeatBackground(int resId) {
        Context context = BaseApplication.getInstance();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resId);
        BitmapDrawable drawable = new BitmapDrawable(context.getResources(), bitmap);
        drawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        drawable.setDither(true);
        return drawable;
    }
    
    /**
     * function: 取得指定名称的资源id
     *
     * @param idName 资源名
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:36:03
     */
    public static int getIdResId(String idName) {
        return getResId(idName, "id");
    }
    
    /**
     * function: 取得指定名称的字符串资源ID
     *
     * @param stringName 字符串名称
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:34:48
     */
    public static int getStringResId(String stringName) {
    	return getResId(stringName, "string");
    }
    
    /**
     * function: 取得指定名称的图片资源ID
     *
     * @param imageName 图片名称
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:23:21
     */
    public static int getImageResId(String imageName) {
        return getResId(imageName, "drawable");
    }
    
    /**
     * function: 取得指定名称的布局资源id
     *
     * @param layoutName 布局名字
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:34:59
     */
    public static int getLayoutResId(String layoutName) {
        return getResId(layoutName, "layout");
    }
    
    /**
     * function: 取得指定名称的动画资源id
     *
     * @param animName 动画名字
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:35:17
     */
    public static int getAnimResId(String animName) {
        return getResId(animName, "anim");
    }
    
    /**
     * function: 取得指定名称的样式id
     *
     * @param styleableString 样式名
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:36:26
     */
    public static int getStyleableResId(String styleableString) {
        return getResId(styleableString, "styleable");
    }
    
    /**
     * function: 通过名字和类型取得res id
     *
     * @param resName
     * @param type
     * @return
     * 
     * @author:linhuan 2014年7月15日 下午4:34:12
     */
    private static int getResId(String resName, String type) {
        return BaseApplication.getInstance().getResources()
                .getIdentifier(resName, type, BaseApplication.getInstance().getPackageName());
    }
    
    /**
     * function: 取得指定名称的数组资源
     *
     * @param arrayName 数组名称
     * @return 数组
     * 
     * @author:linhuan 2014年7月16日 上午10:34:00
     */
    public static String[] getStringArray(String arrayName) {
    	Resources r = BaseApplication.getInstance().getResources();
    	return r.getStringArray(r.getIdentifier(arrayName, "array", BaseApplication.getInstance().getPackageName()));
    }
    
	/**
	 * 加载布局
	 * 
	 * @param context
	 * @param layoutId
	 * @return
	 * 
	 * @author:linhuan on 2014-6-9上午11:17:08
	 */
	public static final View loadLayout(Context context,int layoutId) {
		return loadLayout(context, layoutId, null);
	}
	
	public static final View loadLayout(Context context, int layoutId, ViewGroup gp) {
		return loadLayout(context, layoutId, gp, Helper.isNotNull(gp));
	}
	
	/**
	 * 从名称获取id，没有该资源返回-1
	 *
	 * @param name 资源名
	 * @param clazz 资源类型  R.drawable.class
	 * @return
	 *
	 * @author:linhuan on 2014-6-6上午10:54:57
	 */
	public static final int getId(String name, Class<?> clazz) {
		int id;
		try {
			Field field = clazz.getField(name);
			id = (Integer) field.get(null);
		} catch (Exception e) {
			e.printStackTrace();
			id = -1;
		}
		return id;
	}

	/**
	 * 获取本地资源
	 *
	 * @param imgId
	 * @return
     */
	public static final String getDrawable(int imgId) {
		return "drawable://" + imgId;
	}

	public static final View loadLayout(Context context,int layoutId, ViewGroup gp, boolean attach) {
		return LayoutInflater.from(context).inflate(layoutId, gp, attach);
	}

}
