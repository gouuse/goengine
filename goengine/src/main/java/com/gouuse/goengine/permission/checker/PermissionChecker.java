
package com.gouuse.goengine.permission.checker;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public interface PermissionChecker {

    /**
     * Check if the calling context has a set of permissions.
     *
     * @param context     {@link Context}.
     * @param permissions one or more permissions.
     * @return true, other wise is false.
     */
    boolean hasPermission(@NonNull Context context, @NonNull String... permissions);
    
    /**
     * Check if the calling context has a set of permissions.
     *
     * @param context     {@link Context}.
     * @param permissions one or more permissions.
     * @return true, other wise is false.
     */
    boolean hasPermission(@NonNull Context context, @NonNull List<String> permissions);

}