package utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Environment;
import android.widget.ImageView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import so.bubu.lib.helper.ToastHelper;

/**
 * Created by wangwn on 2016/5/30.
 */
public class ImageHelper {


    /**
     * 保存图片到本地目录
     *
     * @param imageView 图片view
     */
    public static void SaveImageToSysAlbum(Context context, ImageView imageView) {
        BitmapDrawable bmpDrawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bmp = bmpDrawable.getBitmap();
        File saved = null;
        if (bmp != null) {
            try {
                String fileName = System.currentTimeMillis() + ".png";
                String path = "/Download/";
                saved = saveFile(bmp, fileName, path);
                ToastHelper.showToast("图片已保存到" + path + fileName);
            } catch (Exception e) {
                saved = null;
                e.printStackTrace();
            }
        } else {
            ToastHelper.showToast("找不到图片信息");
        }
        //通知更新图库
        if (saved != null) {
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(saved);
            intent.setData(uri);
            context.sendBroadcast(intent);
            context.getApplicationContext().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
        }
    }

    /**
     * 保存图片
     *
     * @param bm       图片bmp
     * @param fileName 保存的文件名
     * @param path     保存的路径
     * @return 保存的File对象
     * @throws IOException
     */
    public static File saveFile(Bitmap bm, String fileName, String path) throws IOException {
        final String SAVE_PIC_PATH = Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED) ? Environment.getExternalStorageDirectory().getAbsolutePath() : "/mnt/sdcard";//保存到SD卡
        String subForder = SAVE_PIC_PATH + path;
        File foder = new File(subForder);
        if (!foder.exists()) {
            foder.mkdirs();
        }
        File myCaptureFile = new File(subForder, fileName);
        if (!myCaptureFile.exists()) {
            myCaptureFile.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.PNG, 100, bos);
        bos.flush();
        bos.close();
        return myCaptureFile;
    }
}
