
package com.gouuse.goengine.permission;

import android.support.annotation.NonNull;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public interface Request {

    /**
     * One or more permissions.
     */
    @NonNull
    Request permission(String... permissions);

    /**
     * One or more permission groups.
     */
    @NonNull
    Request permission(String[]... groups);

    /**
     * Set request rationale.
     */
    @NonNull
    Request rationale(Rationale listener);

    /**
     * Action to be taken when all permissions are granted.
     */
    @NonNull
    Request onGranted(Action granted);

    /**
     * Action to be taken when all permissions are denied.
     */
    @NonNull
    Request onDenied(Action denied);

    /**
     * Request permission.
     */
    void start();

}