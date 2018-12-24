package com.utils;

import org.springframework.stereotype.Component;

@Component("ehcacheConsts")
public class EhcacheConsts {

    //元素最大数量
    public static final int MAX_ELEMENTS_IN_MEMORY = 1000;
    //是否把溢出数据持久化到硬盘
    public static final boolean OVER_FLOW_TO_DISK = true;
    //是否会死亡
    public static boolean ETERNAL = false;
    //缓存间歇时间
    public static final int TIME_TO_IDLE_SECONDS = 300;
    //缓存存活时间
    public static final int TIME_TO_LIVE_SECONDS = 600000;
    //是否需要持久化到硬盘
    public static final boolean DISK_PERSISTENT = false;
    //内存存取策略
    public static String MEMORY_STORE_EVICTION_POLICY = "LRU";
}
