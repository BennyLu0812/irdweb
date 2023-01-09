package com.ird.portal.ehcahe;

import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import java.util.List;
import java.util.Map;

public class EhcacheUtils {

    private static Cache getCache(String name) {
        EhCacheCacheManager cacheCacheManager = ApplicationContextUtils.getApplicationContext().getBean(EhCacheCacheManager.class);
        return cacheCacheManager.getCache(name);
    }

    public static void put(String cacheName, String key, Object value) {
        getCache(cacheName).put(key, value);
    }

    public static Object get(String cacheName, String key) {
        return getCache(cacheName).get(key, Object.class);
    }

    public static List getList(String cacheName, String key) {
        return getCache(cacheName).get(key, List.class);
    }

    public static Map getMap(String cacheName, String key) {
        return getCache(cacheName).get(key, Map.class);
    }

    public static void delete(String cacheName, String key) {
        getCache(cacheName).evict(key);
    }

    public static String getMapValue(String cacheName, String cacheKey, String mapKey) {
        Map map = getMap(cacheName, cacheKey);
        if (map == null) {
            return "";
        }
        return String.valueOf(map.get(mapKey));
    }
}

