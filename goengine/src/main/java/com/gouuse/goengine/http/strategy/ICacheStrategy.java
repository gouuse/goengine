package com.gouuse.goengine.http.strategy;


import com.gouuse.goengine.http.core.ApiCache;
import com.gouuse.goengine.http.mode.CacheResult;

import java.lang.reflect.Type;

import io.reactivex.Observable;

/**
 * Created by reiserx on 2018/3/29.
 * desc :缓存策略
 */
public interface ICacheStrategy<T> {
    <T> Observable<CacheResult<T>> execute(ApiCache apiCache, String cacheKey, Observable<T> source, Type type);
}
