
package com.gouuse.goengine.permission.checker;

import android.os.Environment;

import java.io.File;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
class StorageWriteTest implements PermissionTest {

    StorageWriteTest() {
    }

    @Override
    public boolean test() throws Throwable {
        File directory = Environment.getExternalStorageDirectory();
        if (!directory.exists() || !directory.canWrite()) return false;
        File file = new File(directory, "ANDROID.PERMISSION.TEST");
        if (file.exists()) {
            return file.delete();
        } else {
            return file.createNewFile();
        }
    }
}
