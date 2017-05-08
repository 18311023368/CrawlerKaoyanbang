package com.nyt.gecco.kaoyanbang.pipeline;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by nieyutan on 17/4/28.
 * 将数据存到文件中
 */
@PipelineName("filePipeline")
public class FilePipeline implements Pipeline<SpiderBean> {
    public void process(SpiderBean spiderBean) {
        try {

            PrintWriter pw = new PrintWriter(new FileWriter("/Users/nieyutan/Documents/爬虫/Demo/Example/file/data.txt", true));
            // pw.println(JSON.toJSONString(bean));
            pw.println(JSON.toJSONString(spiderBean));
            pw.flush();
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
