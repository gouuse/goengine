
package com.gouuse.goengine.permission;

import java.util.List;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
public interface Action {

    /**
     * An action.
     *
     * @param permissions the current action under permissions.
     */
    void onAction(List<String> permissions);

}
