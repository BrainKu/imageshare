package com.kuxinwei.imageshare.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import android.net.http.AndroidHttpClient;
import android.os.Handler;
import android.os.Message;

public class ApiClient {

	private static AndroidHttpClient defaultClient = AndroidHttpClient
			.newInstance("");

	public static boolean httpPostRequest(String url, Map<String, String> params,
			Handler targetHandler) throws IOException {
		HttpPost httpPost = new HttpPost(url);
		List<NameValuePair> paramsList = new ArrayList<NameValuePair>();
		for (String key : params.keySet()) {
			paramsList.add(new BasicNameValuePair(key, params.get(key)));
		}
		httpPost.setEntity(new UrlEncodedFormEntity(paramsList, HTTP.UTF_8));
		HttpResponse reponse = defaultClient.execute(httpPost);

		if (reponse.getStatusLine().getStatusCode() == 200) {
			Message msg = Message.obtain();
			msg.obj = reponse.getEntity().getContent().toString();
			targetHandler.sendMessage(msg);
			return true;
		}
		return false;
	}
	
	
	
}
