package com.nyt.gecco.kaoyanbang.javabean;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * Created by nieyutan on 17/4/28.
 * 考研帮所有的分类
 */
@Gecco(matchUrl = "http://download.kaoyan.com/" ,pipelines={"consolePipeline"})
public class AllCategory implements HtmlBean{

    private static final long sericalVersionUID=-7127412585200687225L;

    @Request
    private HttpRequest request;
    //分类集合
    @HtmlField(cssPath = "#hotclass > tbody > tr:nth-child(5) > th:nth-child(5)")
    private List<Category> typeList;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<Category> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Category> typeList) {
        this.typeList = typeList;
    }
}
