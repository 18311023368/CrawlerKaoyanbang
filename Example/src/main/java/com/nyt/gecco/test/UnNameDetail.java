package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/5/3.
 */
public class UnNameDetail implements HtmlBean {



    /**
     * 获取请求对象，从该对象中可以获取抓取的是哪个url
     */

    /**
     * 大学名称
     */
    @Text
    @HtmlField(cssPath = "  h2 > a")
    private String docName;
    /**
     * 地址
     */
    @Href(click = true)
    @HtmlField(cssPath = " h2 > a")
    private String docUrl;
    /**
     * 每个分类下有多少数量的资料  例如 "1234份资料"
     */
    @Text
    @HtmlField(cssPath = " p")
    private String docNum;

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }


    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }




}
