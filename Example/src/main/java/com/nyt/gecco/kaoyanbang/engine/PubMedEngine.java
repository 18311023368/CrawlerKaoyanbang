package com.nyt.gecco.kaoyanbang.engine;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.nyt.gecco.kaoyanbang.pipeline.AllSortPipeline;
import com.nyt.gecco.kaoyanbang.pipeline.FourSortPipeline;
import com.nyt.gecco.kaoyanbang.pipeline.SecondSortPipeline;
import com.nyt.gecco.kaoyanbang.pipeline.ThirdSortPipeline;

/**
 * Created by nieyutan on 17/4/28.
 * 程序主入口,抽取http://download.kaoyan.com/ 下的所有分类
 */
public class PubMedEngine {
    public static void main(String[] args) {
        HttpGetRequest start = new HttpGetRequest("http://download.kaoyan.com/");
        start.setCharset("GBK");

        String classpath="com.nyt.gecco.kaoyanbang";
        //此处将分类归纳成htmlbean
        GeccoEngine.create()
                //工程的包路径
                .classpath(classpath)
                //开始抓取的页面地址
                .start(start)
                //开启几个爬虫线程
                .thread(10)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(100)
                //循环抓取
                .loop(false)
                //使用pc端userAgent
                .mobile(false)
                //开始运行
                .run();

//         //负责抓取每一个省市下级的分类
//        GeccoEngine.create().classpath(classpath).start(AllCategoryPipeline.cateRequests).thread(10).interval(2000).start();
        //         //负责抓取每一个省市下级的分类
        GeccoEngine.create().classpath(classpath).start(AllSortPipeline.cateRequests).thread(10).interval(100).run();
        GeccoEngine.create().classpath(classpath).start(SecondSortPipeline.cateRequests).thread(10).interval(100).run();
        GeccoEngine.create().classpath(classpath).start(FourSortPipeline.cateRequests).thread(10).interval(100).run();
        GeccoEngine.create().classpath(classpath).start(ThirdSortPipeline.cateRequests).thread(1).interval(100).run();

    }

}
