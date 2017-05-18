package com.nyt.gecco.test;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/5/4.
 */
//@Gecco(matchUrl = "http://download.kaoyan.com/{listname}.html", pipelines = { "consolePipeline",""})

public class Downinfo implements HtmlBean{


    @Attr(value = "action")
    @HtmlField(cssPath = "#downLoad")
    private  String  docLastUrl;

    public String getDocLastUrl() {
        return docLastUrl;
    }

    public void setDocLastUrl(String docLastUrl) {
        this.docLastUrl = docLastUrl;
    }
    public static void main(String[] args) {
        GeccoEngine.create()
                //工程的包路径@Attr
                .classpath("com.nyt.gecco.test")
                //开始抓取的页面地址
                .start("http://download.kaoyan.com/kaoyan_xiazai_69433.html")
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                //循环抓取
                .loop(false)
                //使用pc端userAgent
                .mobile(false)
                //开始运行
                .run();

    }
}
