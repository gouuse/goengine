
package com.gouuse.goengine.permission;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public interface RequestExecutor {

    /**
     * Go request permission.
     */
    void execute();

    /**
     * Cancel the operation.
     */
    void cancel();

}
