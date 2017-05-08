package com.nyt.gecco.kaoyanbang.exec;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2017/4/9/009.
 */
public class Executors {

    private AbstractActionQueue defaultActionQueue;
    private ThreadPoolExecutor pool;

    /**

     * 执行action队列的线程池

     *

     * @param corePoolSize

     *            最小线程数，包括空闲线程

     * @param keepAliveTime

     *            当线程数大于核心时，终止多余的空闲线程等待新任务的最长时间

     * @param prefix

     *            线程池前缀名称

     */
    public Executors(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, String prefix) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
        if (prefix == null) {
            prefix = "";
        }
        ThreadFactory threadFactory = new MyThreadFactory(prefix);
        pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory,
                handler);
        defaultActionQueue = new AbstractActionQueue(this);
    }

    public void execute(Action action) {
        pool.execute(action);
    }

    public AbstractActionQueue getDefaultActionQueue() {
        return defaultActionQueue;
    }

    public static Executors create() {
        int corePoolSize = 5;
        int maximumPoolSize = 64;
        long keepAliveTime = 1;
        TimeUnit unit = TimeUnit.MINUTES;
        String prefix = "download";
        return new Executors(corePoolSize, maximumPoolSize, keepAliveTime, unit, prefix);
    }

}
