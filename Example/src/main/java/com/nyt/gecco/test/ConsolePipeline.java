package com.nyt.gecco.test;

import com.alibaba.fastjson.JSON;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;

/**
 * 向控制台输出内容
 */
//@PipelineName("consolePipeline")
public class ConsolePipeline implements Pipeline<SpiderBean> {

    @Override
    public void process(SpiderBean bean) {
//        System.out.println("1111111111111");
        System.out.println(JSON.toJSONString(bean));
    }

}
