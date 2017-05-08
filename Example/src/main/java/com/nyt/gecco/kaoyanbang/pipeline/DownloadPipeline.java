package com.nyt.gecco.kaoyanbang.pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.nyt.gecco.kaoyanbang.exec.DownloadAction;
import com.nyt.gecco.kaoyanbang.exec.Executors;
import com.nyt.gecco.test.Download;

import java.net.URLDecoder;

/**
 * Created by nieyutan on 17/5/4.
 */
@PipelineName("downloadPipeline")
public class DownloadPipeline implements Pipeline<Download> {

    //    @Resource(name = "pictureServiceImpl")
//    private PictureService pictureService;

    //    @Value("${local.path}")
    private String fileSavePath="/Users/nieyutan/Documents/爬虫/Demo/Example/file/";

    private Executors executors = Executors.create();

    @Override
    public void process(Download bean) {
//        pic.setPicinfo(bean.getCode());
        int lastIndex = bean.getDocLastUrl().lastIndexOf(".");

        String substring = bean.getDocLastUrl().substring(lastIndex, bean.getDocLastUrl().length());

        String decode = URLDecoder.decode(bean.getDocLastUrl());
        int i = decode.lastIndexOf("/");
        String docName = decode.substring(i, decode.length());

//        System.out.println("地址1:"+decode);


        //文件的后缀名 有时候是pdf有时候的rar

        String localPath = fileSavePath + docName;
//        System.out.println("地址2:"+localPath);

        executors.getDefaultActionQueue().enqueue(
                new DownloadAction(executors.getDefaultActionQueue(), bean.getDocLastUrl(), localPath));
    }
}
