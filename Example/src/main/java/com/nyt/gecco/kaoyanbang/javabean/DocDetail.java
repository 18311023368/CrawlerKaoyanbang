package com.nyt.gecco.kaoyanbang.javabean;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/5/2.
 * 学校列表的下的子项 如  北京:北京大学   或者  政治:2015年考研政治真题及答案
 */
public class DocDetail implements HtmlBean{
    private static final long sericalVersionUID=-7127412585200687225L;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    /**
     * 获取请求对象，从该对象中可以获取抓取的是哪个url
     */
    @Request
    private HttpRequest request;

    /**
     * 文档名称
     */
    @HtmlField(cssPath =" span > a" )
    private String docName;

    /**
     * 文档地址
     */
    @Href(click =  true)
    @HtmlField(cssPath =" span > a" )
    private String docNameUrl;


    /**
     * 大学名称,大学名称的话还得继续往下走
     */
    @Text
    @HtmlField(cssPath ="  h2 > a" )
    private String universityName;
    @Href(click =  true)
    @HtmlField(cssPath ="  h2 > a" )
    private String universityNameUrl;



    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getDocNameUrl() {
        return docNameUrl;
    }

    public void setDocNameUrl(String docNameUrl) {
        this.docNameUrl = docNameUrl;
    }

    public String getUniversityNameUrl() {
        return universityNameUrl;
    }

    public void setUniversityNameUrl(String universityNameUrl) {
        this.universityNameUrl = universityNameUrl;
    }


/************文档倒数第二级************/
    //文档下级地址
    @Href
    @HtmlField(cssPath = "td > div.postmessage.defaultpost > div.box.postattachlist > dl > dt > a")
    private String docLastUrl;
    //文档名称
    @Text
    @HtmlField(cssPath = "td > div.postmessage.defaultpost > div.box.postattachlist > dl > dt > a")
    private String  docLastName;

    public String getDocLastName() {
        return docLastName;
    }

    public void setDocLastName(String docLastName) {
        this.docLastName = docLastName;
    }

    public String getDocLastUrl() {
        return docLastUrl;
    }

    public void setDocLastUrl(String docLastUrl) {
        this.docLastUrl = docLastUrl;
    }


    /**************文档最终的下载地址*****************/

    @Attr(value = "action")
    @HtmlField(cssPath = "#downLoad")
    private  String  downLoadLurl;


    public String getDownLoadLurl() {
        return downLoadLurl;
    }

    public void setDownLoadLurl(String downLoadLurl) {
        this.downLoadLurl = downLoadLurl;
    }
}
