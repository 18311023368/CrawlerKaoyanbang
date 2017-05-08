package com.nyt.gecco.kaoyanbang.pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.nyt.gecco.kaoyanbang.javabean.DocList;
import com.nyt.gecco.kaoyanbang.javabean.UnversityDetail;
import org.apache.http.util.TextUtils;

import java.io.File;

/**
 * Created by nieyutan on 17/5/8.
 */
@PipelineName("createFile")
public class CreateFile implements Pipeline<DocList> {


    @Override
    public void process(DocList docList) {
        //针对大学的
        //一级分类
        String firstCategory = docList.getFilePath();
        if (!TextUtils.isEmpty(firstCategory)) {
            String path = "/Users/nieyutan/Documents/爬虫/考研帮/" + firstCategory;
            System.out.println(path);
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
            //二级分类
            for (UnversityDetail uname : docList.getUnName()) {
                if (!TextUtils.isEmpty(uname.getDocName())) {
                    File unNameFile = new File(path + "/" + uname.getDocName());
                    if (!unNameFile.exists()) {
                        unNameFile.mkdir();
                    }
                }

            }
        }

    }
}
