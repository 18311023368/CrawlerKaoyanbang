package com.nyt.gecco.kaoyanbang.javabean;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * Created by nieyutan on 17/4/28.
 * 每个分类下子分类,如果是省市的话还会有下级列表DocListSon,如果 是科目的直接就是文档列表
 */
@Gecco(matchUrl = "http://download.kaoyan.com/{listName}" ,pipelines = { "consolePipeline","createFile","secondSortPipeline","fourSortPipeline","thirdSortPipeline"})
public class DocList implements HtmlBean{

    private static final long sericalVersionUID=-7127412585200687225L;
    /**
     * 获得列表的当前页
     */
    @Text
    @HtmlField(cssPath=" div > b")
    private String currPage;
    /**
     * 获得列表的总页数
     */
    @Text
    @HtmlField(cssPath=" div.pages_btns > div > a")
    private List<String> totalPage;


    /**
     * 获取请求对象，从该对象中可以获取抓取的是哪个url
     */
    @Request
    private HttpRequest request;
    //文档详细
    @HtmlField(cssPath = "#forum_85 > tbody >tr:nth-child(5) > th")
    private List<DocDetail> docName;


    /**
     * 大学详细名称
     */
    @HtmlField(cssPath = "#hotclass > tbody > tr:nth-child(1) > th :nth-child(1)")
    private List<UnversityDetail> unName;

//    @HtmlField(cssPath = " h2 > a")
//    private List<HrefBean> details;



    public HttpRequest getRequest() {
        return request;
    }

    public List<UnversityDetail> getUnName() {
        return unName;
    }

    public void setUnName(List<UnversityDetail> unName) {
        this.unName = unName;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }


    public List<DocDetail> getDocName() {
        return docName;
    }

    public void setDocName(List<DocDetail> docName) {
        this.docName = docName;
    }


//    public List<HrefBean> getDetails() {
//        return details;
//    }
//
//    public void setDetails(List<HrefBean> details) {
//        this.details = details;
//    }


    public String getCurrPage() {
        return currPage;
    }

    public void setCurrPage(String currPage) {
        this.currPage = currPage;
    }

    public List<String> getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(List<String> totalPage) {
        this.totalPage = totalPage;
    }

    /**************************/
    //如果是大学的一级文件目录  例如北京
    @Text
    @HtmlField(cssPath = " body > div> div > h3")
    private String fileFirstPath;


//    //二级目录  北京大学
//    @Text
//    @HtmlField(cssPath = "#infosidemain > div > h3")
//    private String fileSecondPath;

    public String getFileFirstPath() {
        return fileFirstPath;
    }

    public void setFileFirstPath(String fileFirstPath) {
        this.fileFirstPath = fileFirstPath;
    }

//    public String getFileSecondPath() {
//        return fileSecondPath;
//    }
//
//    public void setFileSecondPath(String fileSecondPath) {
//        this.fileSecondPath = fileSecondPath;
//    }

    //
    //文档地址
    @Href
    @HtmlField(cssPath = "td > div.postmessage.defaultpost > div.box.postattachlist > dl > dt > a")
    private String docTwoUrl;
    //文档名称
    @Text
    @HtmlField(cssPath = "td > div.postmessage.defaultpost > div.box.postattachlist > dl > dt > a")
    private String  docNameTwo;


    public String getDocNameTwo() {
        return docNameTwo;
    }

    public void setDocNameTwo(String docNameTwo) {
        this.docNameTwo = docNameTwo;
    }

    public String getDocTwoUrl() {
        return docTwoUrl;
    }

    public void setDocTwoUrl(String docUrl) {
        this.docTwoUrl = docUrl;
    }




}
