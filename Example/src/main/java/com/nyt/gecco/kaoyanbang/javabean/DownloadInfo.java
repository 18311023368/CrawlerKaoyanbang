package com.nyt.gecco.kaoyanbang.javabean;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/5/8.
 */
@Gecco(matchUrl = "http://download.kaoyan.com/{download}.html", pipelines = {"consolePipeline", "down"})
public class DownloadInfo implements HtmlBean{
    @Attr(value = "action")
    @HtmlField(cssPath = "#downLoad")
    private  String  docLastUrl;

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
