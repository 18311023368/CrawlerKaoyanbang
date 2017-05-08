package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by nieyutan on 17/4/28.
 */
public class Type implements HtmlBean{


    private static final long serialVersionUID = -1808704248579938878L;

    @Text
    @HtmlField(cssPath = " h2 > a")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**

     *分类 例如   "北京"
     */
    @Href(click = true)
    @HtmlField(cssPath = " h2 > a")
    private String typeName;

    /**
     *每个分类下有多少数量的资料  例如 "1234份资料"
     */
    @Text
    @HtmlField(cssPath = " p")
    private String  docNum;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String  getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }
}
