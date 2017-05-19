package com.nyt.gecco.kaoyanbang.pipeline;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.nyt.gecco.kaoyanbang.javabean.DocList;
import com.nyt.gecco.kaoyanbang.javabean.UnversityDetail;
import org.apache.http.util.TextUtils;

import java.util.ArrayList;
import java.util.List;

@PipelineName("secondSortPipeline")
public class SecondSortPipeline implements Pipeline<DocList> {

	public static List<HttpRequest> cateRequests = new ArrayList<HttpRequest>();

	@Override
	public void process(DocList allSort) {
		List<UnversityDetail> cellPhones = allSort.getUnName();
		for (UnversityDetail category : cellPhones) {
			// 获取mongo的集合
//			MongoCollection<Document> collection = MongoUtils.getCollection();
//			// 把json转成Document
//			Document doc = Document.parse(JSON.toJSONString(category));
//			// 向集合里边插入一条文档
//			collection.insertOne(doc);
			String hrefs = category.getDocUrl();
			HttpRequest request = allSort.getRequest();
			// 把url保存起来，方便后面开启一个新的引擎进行多线程抓取数据
			if(!TextUtils.isEmpty(hrefs)){
				cateRequests.add(request.subRequest(hrefs));
			}
		}
	}
}
