package com.utils;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Ehcache工具类
 */
@Component("EhcacheUtils")
public class EhcacheUtils {

    private static CacheManager cacheManager = null;

    static {
        EhcacheUtils.initCacheManager();
    }

    /**
     * 初始化缓存管理容器
     * @return
     */
    public static CacheManager initCacheManager() {

        EhCacheCacheManager ehCacheCacheManager = null;
        try{
            if(cacheManager == null) {
                ehCacheCacheManager = (EhCacheCacheManager) ApplicationUtil.getBeanByClass(EhCacheCacheManager.class);
                cacheManager = ehCacheCacheManager.getCacheManager();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return cacheManager;
    }

    /**
     * 初始化内存块
     * @param cacheName
     * @param maxElementsInMemory
     * @param overflowToDisk
     * @param eternal
     * @param timeToIdleSeconds
     * @param timeToLiveSeconds
     * @return
     */
    public static Cache initCache(String cacheName, int maxElementsInMemory, boolean overflowToDisk, boolean eternal, long timeToLiveSeconds, long timeToIdleSeconds) {

        Cache cache = cacheManager.getCache(cacheName);

        try {

            if(null == cache) {
                cache = new Cache(cacheName,maxElementsInMemory,overflowToDisk,eternal,timeToLiveSeconds,timeToIdleSeconds);
                cacheManager.addCache(cache);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cache;

    }

    /**
     * 初始化内存块
     * @param cacheName
     * @param timeToIdleSeconds
     * @param timeToLiveSeconds
     * @return
     */
    public static Cache initCache(String cacheName, long timeToLiveSeconds, long timeToIdleSeconds) {

        return initCache(cacheName, EhcacheConsts.MAX_ELEMENTS_IN_MEMORY, EhcacheConsts.OVER_FLOW_TO_DISK,
                EhcacheConsts.ETERNAL,timeToLiveSeconds,timeToIdleSeconds);

    }



    /**
     * 移除缓存
     * @param cacheName
     */
    public static void removeCache(String cacheName) {
        checkCacheManager();
        Cache cache = cacheManager.getCache(cacheName);
        if(null != cache) {
            cacheManager.removeCache(cacheName);
        }
    }


    /**
     *
     * 获取所有的cache名称
     *
     * @return
     */

    public static String[] getAllCaches() {
        checkCacheManager();
        return cacheManager.getCacheNames();
    }

    /**
     * 移除所有cache
     */

    public static void removeAllCache() {
        checkCacheManager();
        cacheManager.removalAll();
    }

    /**
     * 初始化缓存
     *
     * @param cacheName
     * @return
     */
    public static Cache initCache(String cacheName) {

        checkCacheManager();
        if(null == cacheManager.getCache(cacheName)) {
            cacheManager.addCache(cacheName);
        }
        return cacheManager.getCache(cacheName);

    }



    /**
     * 添加缓存
     * @param cache 缓存块
     * @param key 关键字
     * @param value 值
     */
    public static void put(Cache cache, Object key, Object value) {
        checkCache(cache);
        Element element = new Element(key,value);
        cache.put(element);
    }


    /**
     * 获取值
     * @param cache 缓存块
     * @param key
     * @return
     */
    public static Object get(Cache cache, Object key) {
        checkCache(cache);
        Element element = cache.get(key);
        if(null ==  element) {
            return  null;
        }
        return element.getObjectValue();
    }

    /**
     * 移除key
     * @param cache 缓存块
     * @param key
     */
    public static void remove(Cache cache, String key) {
        checkCache(cache);
        cache.remove(key);
    }

    /**
     * 移除所有元素
     * @param cache 缓存块
     */
    public static void removeAllKey(Cache cache) {
        checkCache(cache);
        cache.removeAll();
    }

    /**
     * 获取 所有的key
     * @param cache 缓存块
     * @return
     */
    public static List getKeys(Cache cache) {
        checkCache(cache);
        return cache.getKeys();
    }


    /**
     * 检测内存管理器是否初始化
     */
    private static void checkCacheManager() {
        if(null == cacheManager) {
            throw new IllegalArgumentException("调用前请先初始化CacheManager值：EHCacheUtil.initCacheManager");
        }
    }

    /**
     * 检查内存块是否存在
     * @param cache
     */
    private static void checkCache(Cache cache) {
        if(null == cache) {
            throw new IllegalArgumentException("调用前请先初始化Cache值：EHCacheUtil.initCache(参数)");
        }
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        EhCacheCacheManager ehCacheCacheManager = (EhCacheCacheManager) ApplicationUtil.getBeanById("ehcacheManager");
        Cache cache1 = EhcacheUtils.initCache("cache1", 60, 30);
        EhcacheUtils.put(cache1, "A11", "a11");
        EhcacheUtils.put(cache1, "A22", "a11");
        EhcacheUtils.put(cache1, "A33", "a11");
        Cache cache2 = EhcacheUtils.initCache("cache2", 50, 20);
        EhcacheUtils.put(cache2, "A55", "b55");
        EhcacheUtils.put(cache2, "A66", "b66");
        EhcacheUtils.put(cache2, "A77", "b77");

//        System.out.println(ehCacheCacheManager.getCache("cache1"));
//        System.out.println(ehCacheCacheManager.getCache("cache2"));
//        System.out.println(ehCacheCacheManager.getCache("sysCache"));
//        System.out.println(ehCacheCacheManager.getCache("userCache"));
        System.out.println(EhcacheUtils.cacheManager.getCache("cache1"));
        System.out.println(EhcacheUtils.cacheManager.getCache("cache2"));
        System.out.println(EhcacheUtils.cacheManager.getCache("sysCache"));
        System.out.println(EhcacheUtils.cacheManager.getCache("userCache"));

    }

}