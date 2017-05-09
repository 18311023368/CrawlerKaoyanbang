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
    private String localPath;
    @Override
    public void process(Download bean) {
        String decode = URLDecoder.decode(bean.getDocLastUrl());
        int index = decode.lastIndexOf("/");
        String docName = decode.substring(index, decode.length());
        //文件的后缀名 有时候是pdf有时候的rar
        for (int i = 0; i < CreateFile.filePaths.size(); i++) {
            int d =  CreateFile.filePaths.get(i).lastIndexOf("/");
            String substring =  CreateFile.filePaths.get(i).substring(d,  CreateFile.filePaths.get(i).length());
//            System.out.println(docName+"----"+substring);
            if(docName.contains(substring)){

                localPath =  CreateFile.filePaths.get(i)+"/" + docName;
                executors.getDefaultActionQueue().enqueue(
                        new DownloadAction(executors.getDefaultActionQueue(), bean.getDocLastUrl(), localPath));
            }
        }
    }
}
