
package com.gouuse.goengine.permission;

import android.content.Context;

import java.util.List;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public interface Rationale {

    /**
     * Show rationale of permissions to user.
     *
     * @param context     context.
     * @param permissions show rationale permissions.
     * @param executor    executor.
     */
    void showRationale(Context context, List<String> permissions, RequestExecutor executor);
}