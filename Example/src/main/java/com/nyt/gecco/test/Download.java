package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/5/8.
 */
@Gecco(matchUrl = "http://download.kaoyan.com/{download}.html" ,pipelines = { "consolePipeline","downloadPipeline"})
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
}
