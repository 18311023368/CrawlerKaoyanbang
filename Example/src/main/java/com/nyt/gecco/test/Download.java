package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/5/8.
 */
//@Gecco(matchUrl = "http://download.kaoyan.com/{download}.html", pipelines = {"consolePipeline", "downloadPipeline"})
public class Download implements HtmlBean {

    @Request
    private HttpRequest httpRequest;

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Attr(value = "action")
    @HtmlField(cssPath = "#downLoad ")
    private String docLastUrl;

    public String getDocLastUrl() {
        return docLastUrl;
    }

    public void setDocLastUrl(String docLastUrl) {
        this.docLastUrl = docLastUrl;
    }


    @Text
    @HtmlField(cssPath = "#centers > h2")
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
