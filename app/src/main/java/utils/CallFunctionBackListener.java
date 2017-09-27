package utils;

import com.avos.avoscloud.AVException;

/**
 * Created by wangwn on 2016/5/3.
 */
public interface CallFunctionBackListener {
        void callSuccess(boolean result, String jsonstr);
        void callFailure(int type, AVException e);
    }