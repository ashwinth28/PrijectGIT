package gp.HTTP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpService {
	
	public static HttpService httpService = null;
	HttpClient httpClient = HttpClients.createDefault();
	
	static {
		httpService = new HttpService();
	}
	
	private HttpService() {
		
	}
	
	public static HttpService getInstance() {
		return httpService;
	}
	
	
	public List<LinkedHashMap<String, Object>> httpGet(String url, List<NameValuePair> params, String resultName) {
		List<LinkedHashMap<String, Object>> dataList = new ArrayList<>();
		try {
			if (params != null && params.size() > 0) {
				url += "?" + URLEncodedUtils.format(params, "utf-8");
			}
			HttpGet httpGet = new HttpGet(url);
			httpGet.setHeader("Content-Type", "application/octet-stream");
			HttpResponse httpResponse = httpClient.execute(httpGet);
			String jsonResponse = EntityUtils.toString(httpResponse.getEntity());
			ObjectMapper objectMapper = new ObjectMapper();
			LinkedHashMap<String, Object>[] dataMap = objectMapper.readValue(jsonResponse,
					new TypeReference<LinkedHashMap<String, Object>[]>() {
					});
			List<LinkedHashMap<String, Object>> list = new ArrayList<>(Arrays.asList(dataMap));
			System.out.println(dataMap);
			return list;
//			if(dataMap.get(resultName) != null) {
//				dataList.addAll((List<Map<String, Object>>) dataMap.get(resultName));
//			} else if(dataMap.get("data") != null){
//				Map<String, List<Map<String, Object>>> data = (Map<String, List<Map<String, Object>>>) dataMap.get("data");
//				dataList.addAll((List<Map<String, Object>>) data.get(resultName));
//			} else {
//				dataList.add(dataMap);
//			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return dataList;
	}


	public LinkedHashMap<String, Object> httpPost(String url, String jsonData, List<NameValuePair> params) {
		try {
			if (params != null && params.size() > 0) {
				url += "?" + URLEncodedUtils.format(params, "utf-8");
			}
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Content-Type", "application/json");
			StringEntity entity = new StringEntity(jsonData, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			HttpResponse httpPostResponse = httpClient.execute(httpPost);
			String jsonResponse = EntityUtils.toString(httpPostResponse.getEntity());
			ObjectMapper objectMapper = new ObjectMapper();
			LinkedHashMap<String, Object> dataMap = objectMapper.readValue(jsonResponse,
					new TypeReference<LinkedHashMap<String, Object>>() {
					});
			// Bill generated in Zoho Books when dataMap.get("code") = 0
			// when dataMap.get("code") != 0, exception is returned
			return dataMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
