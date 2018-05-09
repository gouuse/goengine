
package com.gouuse.goengine.permission.checker;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.RequiresPermission;

import java.util.List;

/**
 * Created by reiserx on 2018/4/4.
 * desc :
 */
class LocationTest implements PermissionTest {

    private LocationManager mManager;

    LocationTest(Context context) {
        this.mManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @RequiresPermission(anyOf = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
    @Override
    public boolean test() throws Throwable {
        List<String> list = mManager.getProviders(true);

        if (list.contains(LocationManager.GPS_PROVIDER)) {
            return true;
        } else if (list.contains(LocationManager.NETWORK_PROVIDER)) {
            return true;
        } else {
            mManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 0F, new MLocationListener(mManager));
        }
        return true;
    }

    private static class MLocationListener implements LocationListener {
        private LocationManager mManager;

        public MLocationListener(LocationManager manager) {
            mManager = manager;
        }

        @RequiresPermission(anyOf = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
        @Override
        public void onLocationChanged(Location location) {
            mManager.removeUpdates(this);
        }

        @RequiresPermission(anyOf = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            mManager.removeUpdates(this);
        }

        @RequiresPermission(anyOf = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
        @Override
        public void onProviderEnabled(String provider) {
            mManager.removeUpdates(this);
        }

        @RequiresPermission(anyOf = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION})
        @Override
        public void onProviderDisabled(String provider) {
            mManager.removeUpdates(this);
        }
    }
}