
package com.gouuse.goengine.permission.checker;

import android.os.Environment;

import java.io.File;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
class StorageReadTest implements PermissionTest {

    StorageReadTest() {
    }

    @Override
    public boolean test() throws Throwable {
        File directory = Environment.getExternalStorageDirectory();
        if (directory.exists() && directory.canRead()) {
            long modified = directory.lastModified();
            String[] pathList = directory.list();
            return modified > 0 && pathList != null;
        }
        return false;
    }
}