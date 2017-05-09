package com.nyt.gecco.kaoyanbang.pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.nyt.gecco.kaoyanbang.javabean.DocList;
import com.nyt.gecco.kaoyanbang.javabean.UnversityDetail;
import org.apache.http.util.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nieyutan on 17/5/8.
 */
@PipelineName("createFile")
public class CreateFile implements Pipeline<DocList> {
    public static List<String> filePaths = new ArrayList<String>();
    //需要过滤的集合
    private String[] mUnwanted = new String[]{"政治", "中山大学", "华中科技大学", "华南理工大学", "西北工业大学", "四川大学", "北京师范大学", "南京大学", "英语",
            "数学", "医学", "西医综合", "中医综合", "法硕（非法学）", "经综", "心理学", "历史学", "教育学", "管综", "计算机", "农学", "法硕（法学）"};
    @Override
    public void process(DocList unName) {
        //针对大学的
        //一级分类  北京
        String firstCategory = unName.getFileFirstPath();

        if (!TextUtils.isEmpty(firstCategory)) {
            for (int i = 0; i <mUnwanted.length ; i++) {
                if(!mUnwanted[i].contains(firstCategory)){

                    String path = "/Users/nieyutan/Documents/爬虫/考研帮/" + firstCategory;
                    File file = new File(path);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    //大学二级分类
                    for (UnversityDetail uname : unName.getUnName()) {
                        if (!TextUtils.isEmpty(uname.getDocName())) {
                            File unNameFile = new File(path + "/" + uname.getDocName());
                            if (!unNameFile.exists()) {
                                unNameFile.mkdir();
                                filePaths.add(unNameFile.getPath());
                            }
                        }

                    }
                }
            }

        }
    }
}
