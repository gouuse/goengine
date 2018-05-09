package com.gouuse.goengine.http.strategy;


import com.gouuse.goengine.http.core.ApiCache;
import com.gouuse.goengine.http.mode.CacheResult;

import java.lang.reflect.Type;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;



/**
 * Created by reiserx on 2018/3/29.
 * desc :缓存策略--缓存和网络
 */
public class CacheAndRemoteStrategy<T> extends CacheStrategy<T> {
    @Override
    public <T> Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, Observable<T> source, final Type type) {
        Observable<CacheResult<T>> cache = loadCache(apiCache, cacheKey, type);
        final Observable<CacheResult<T>> remote = loadRemote(apiCache, cacheKey, source);
        return Observable.concat(cache, remote).filter(new Predicate<CacheResult<T>>() {
            @Override
            public boolean test(CacheResult<T> tCacheResult) throws Exception {
                return tCacheResult != null && tCacheResult.getCacheData() != null;
            }
        });
    }
}
