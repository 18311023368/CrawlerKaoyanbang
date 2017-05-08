package com.nyt.gecco.test;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * ma
 * Created by nieyutan on 17/4/18.
 */
@Gecco(matchUrl = "http://download.kaoyan.com/" ,pipelines={""})
public class GeccoTest  implements HtmlBean{

    private static final long sericalVersionUID=-7127412585200687225L;

    @Request
    private HttpRequest request;
    //分类集合
    @HtmlField(cssPath = "#hotclass > tbody > tr > th")
    private List<Type> typeList;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<Type> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Type> typeList) {
        this.typeList = typeList;
    }

    public static void main(String[] args) {
        GeccoEngine.create()
                //工程的包路径
                .classpath("com.nyt.gecco.test")
                //开始抓取的页面地址
                .start("http://download.kaoyan.com/")
                //开启几个爬虫线程
                .thread(5)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(500)
                //循环抓取
                .loop(false)
                //使用pc端userAgent
                .mobile(false)
                //开始运行
                .run();
        //         //负责抓取每一个省市下级的分类
//        GeccoEngine.create().classpath("com.nyt.gecco.test").start(AllCategoryPipeline.cateRequests).thread(10).interval(2000).start();
    }


}
