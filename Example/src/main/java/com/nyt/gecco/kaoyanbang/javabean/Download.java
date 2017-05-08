package com.nyt.gecco.kaoyanbang.javabean;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/5/8.
 */
@Gecco(matchUrl = "http://download.kaoyan.com/{download}.html" ,pipelines = { "consolePipeline"})
public class Download implements HtmlBean{
    @Attr(value = "action")
    @HtmlField(cssPath = "#downLoad")
    private  String  docLastUrl;

    public String getDocLastUrl() {
        return docLastUrl;
    }

    public void setDocLastUrl(String docLastUrl) {
        this.docLastUrl = docLastUrl;
    }


    /**
     * 获取请求对象，从该对象中可以获取抓取的是哪个url
     */
    @Request
    private HttpRequest request;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
}
