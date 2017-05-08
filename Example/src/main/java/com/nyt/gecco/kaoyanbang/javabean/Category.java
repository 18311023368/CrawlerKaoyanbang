package com.nyt.gecco.kaoyanbang.javabean;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/4/28.
 */
public class Category implements HtmlBean{
    private static final long serialVersionUID = -1808704248579938878L;
    //分类名称 比如:北京  ,北京大学
    @Text
    @HtmlField(cssPath = " h2 > a")
    private String unName;

    /**

     * 链接地址
     */
    @Href(click = true)
    @HtmlField(cssPath = " h2 > a")
    private String unNameUrl;

    /**
     *每个分类下有多少数量的资料  例如 "1234份资料"
     */
    @Text
    @HtmlField(cssPath = " p")
    private String  docNum;

    public String getUnName() {
        return unName;
    }

    public void setUnName(String unName) {
        this.unName = unName;
    }

    public String getUnNameUrl() {
        return unNameUrl;
    }

    public void setUnNameUrl(String unNameUrl) {
        this.unNameUrl = unNameUrl;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }
}
