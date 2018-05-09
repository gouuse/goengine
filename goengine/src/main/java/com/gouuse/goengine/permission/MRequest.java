
package com.gouuse.goengine.permission;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;

import com.gouuse.goengine.permission.checker.DoubleChecker;
import com.gouuse.goengine.permission.checker.PermissionChecker;
import com.gouuse.goengine.permission.checker.StandardChecker;
import com.gouuse.goengine.permission.source.Source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
@RequiresApi(api = Build.VERSION_CODES.M)
class MRequest implements Request, RequestExecutor, PermissionActivity.PermissionListener {

    private static final PermissionChecker CHECKER = new StandardChecker();
    private static final PermissionChecker DOUBLE_CHECKER = new DoubleChecker();

    private Source mSource;

    private String[] mPermissions;
    private Rationale mRationaleListener;
    private Action mGranted;
    private Action mDenied;

    private String[] mDeniedPermissions;

    MRequest(Source source) {
        this.mSource = source;
    }

    @NonNull
    @Override
    public Request permission(String... permissions) {
        this.mPermissions = permissions;
        return this;
    }

    @NonNull
    @Override
    public Request permission(String[]... groups) {
        List<String> permissionList = new ArrayList<>();
        for (String[] group : groups) {
            permissionList.addAll(Arrays.asList(group));
        }
        this.mPermissions = permissionList.toArray(new String[permissionList.size()]);
        return this;
    }


    @NonNull
    @Override
    public Request rationale(Rationale listener) {
        this.mRationaleListener = listener;
        return this;
    }

    @NonNull
    @Override
    public Request onGranted(Action granted) {
        this.mGranted = granted;
        return this;
    }

    @NonNull
    @Override
    public Request onDenied(Action denied) {
        this.mDenied = denied;
        return this;
    }

    @Override
    public void start() {
        List<String> deniedList = getDeniedPermissions(CHECKER, mSource, mPermissions);
        mDeniedPermissions = deniedList.toArray(new String[deniedList.size()]);
        if (mDeniedPermissions.length > 0) {
            List<String> rationaleList = getRationalePermissions(mSource, mDeniedPermissions);
            if (rationaleList.size() > 0 && mRationaleListener != null) {
                mRationaleListener.showRationale(mSource.getContext(), rationaleList, this);
            } else {
                execute();
            }
        } else {
            callbackSucceed();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void execute() {
        PermissionActivity.requestPermission(mSource.getContext(), mDeniedPermissions, this);
    }

    @Override
    public void cancel() {
        onRequestPermissionsResult(mDeniedPermissions);
    }

    @Override
    public void onRequestPermissionsResult(@NonNull String[] permissions) {
        List<String> deniedList = getDeniedPermissions(DOUBLE_CHECKER, mSource, permissions);
        if (deniedList.isEmpty()) {
            callbackSucceed();
        } else {
            callbackFailed(deniedList);
        }
    }

    /**
     * Callback acceptance status.
     */
    private void callbackSucceed() {
        if (mGranted != null) {
            List<String> permissionList = asList(mPermissions);
            try {
                mGranted.onAction(permissionList);
            } catch (Exception e) {
                if (mDenied != null) {
                    mDenied.onAction(permissionList);
                }
            }
        }
    }

    /**
     * Callback rejected state.
     */
    private void callbackFailed(@NonNull List<String> deniedList) {
        if (mDenied != null) {
            mDenied.onAction(deniedList);
        }
    }

    /**
     * Get denied permissions.
     */
    private static List<String> getDeniedPermissions(PermissionChecker checker, @NonNull Source source, @NonNull String... permissions) {
        List<String> deniedList = new ArrayList<>(1);
        for (String permission : permissions) {
            if (!checker.hasPermission(source.getContext(), permission)) {
                deniedList.add(permission);
            }
        }
        return deniedList;
    }

    /**
     * Get permissions to show rationale.
     */
    private static List<String> getRationalePermissions(@NonNull Source source, @NonNull String... permissions) {
        List<String> rationaleList = new ArrayList<>(1);
        for (String permission : permissions) {
            if (source.isShowRationalePermission(permission)) {
                rationaleList.add(permission);
            }
        }
        return rationaleList;
    }
}