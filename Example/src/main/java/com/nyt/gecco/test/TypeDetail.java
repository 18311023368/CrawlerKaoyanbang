package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/5/3.
 */
public class TypeDetail implements HtmlBean{


    /**
     * 获取请求对象，从该对象中可以获取抓取的是哪个url
     */

    /**
     * 文档名称
     */
    @Text
    @HtmlField(cssPath =" span > a" )
    private String  docName;

    @Href(click = true)
    @HtmlField(cssPath =" span > a" )
    private String  docUrl;


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
