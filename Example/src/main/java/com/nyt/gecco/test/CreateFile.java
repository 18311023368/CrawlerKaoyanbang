package com.nyt.gecco.test;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.apache.http.util.TextUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nieyutan on 17/5/8.
 */
@PipelineName("createFile")
public class CreateFile implements Pipeline<UnName> {
public static List<String> filePaths=new ArrayList<String>();

    @Override
    public void process(UnName unName) {
        //一级分类  北京
        String firstCategory = unName.getFilePath();

        if (!TextUtils.isEmpty(firstCategory)) {

            String path = "/Users/nieyutan/Documents/爬虫/考研帮/" + firstCategory;
            File file = new File(path);
            if (!file.exists()) {
                file.mkdir();
            }
            //大学二级分类
            for (UnNameDetail uname : unName.getDocName()) {
                if (!TextUtils.isEmpty(uname.getDocName())) {
                    File unNameFile = new File(path + "/" + uname.getDocName());
                    if (!unNameFile.exists()) {
                        unNameFile.mkdir();
                        filePaths.add(unNameFile.getPath());
                    }
                }

            }
        }

//        else if(!TextUtils.isEmpty(firstClassCategory)){
//
//
//            System.out.println("2222");
//            String path = "/Users/nieyutan/Documents/爬虫/考研帮/" + firstClassCategory;
//                    System.out.println(path);
//                    File file = new File(path);
//                    if (!file.exists()) {
//                        file.mkdir();
//                    }
//
//        }







    }
}
