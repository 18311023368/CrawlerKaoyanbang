package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * Created by nieyutan on 17/5/5.
 */
@Gecco(matchUrl = "http://download.kaoyan.com/{listName}" ,pipelines = { "consolePipeline","createFile"})
public class UnName implements HtmlBean {


    private static final long sericalVersionUID=-7127412585200687225L;


    //文档详细内容
    @HtmlField(cssPath = "#forum_85 > tbody > tr > th")
    private List<TypeDetail> typeDetails;

    //文档详细内容
    @HtmlField(cssPath = "#hotclass > tbody > tr > th")
    private List<UnNameDetail> docName;

    public List<TypeDetail>  getTypeDetails() {
        return typeDetails;
    }

    public void setTypeDetails(List<TypeDetail>  docName) {
        this.typeDetails = docName;
    }






    public List<UnNameDetail>  getDocName() {
        return docName;
    }

    public void setDocName(List<UnNameDetail>  docName) {
        this.docName = docName;
    }

    /**************************/


//    public String getUnCategory() {
//        return unCategory;
//    }
//
//    public void setUnCategory(String unCategory) {
//        this.unCategory = unCategory;
//    }
//
//    public String getFileCategory() {
//        return fileCategory;
//    }
//
//    public void setFileCategory(String fileCategory) {
//        this.fileCategory = fileCategory;
//    }
    //如果是大学的一级文件目录  例如北京
    @Text
    @HtmlField(cssPath = " body > div> div > h3")
    private String fileFirstPath;



    public String getFileFirstPath() {
        return fileFirstPath;
    }

    public void setFileFirstPath(String fileFirstPath) {
        this.fileFirstPath = fileFirstPath;
    }


    //
    //文档地址
    @Href(click = true)
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


//
//    @Attr(value = "action")
//    @HtmlField(cssPath = "#downLoad")
//    private  String  docLastUrl;
//
//    public String getDocLastUrl() {
//        return docLastUrl;
//    }
//
//    public void setDocLastUrl(String docLastUrl) {
//        this.docLastUrl = docLastUrl;
//    }


}