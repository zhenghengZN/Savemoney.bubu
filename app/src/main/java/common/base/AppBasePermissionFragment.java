package common.base;

import com.zhy.m.permission.MPermissions;

import so.bubu.lib.base.BaseFragment;

/**
 * Created by wneng on 16/6/21.
 */

public abstract class AppBasePermissionFragment extends BaseFragment {


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        MPermissions.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
