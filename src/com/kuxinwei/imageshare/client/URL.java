package com.kuxinwei.imageshare.client;

import java.util.HashMap;
import java.util.Map;

public class URL {

	public final static String ROOT = "http://192.168.56.1/ImageShare";
	public final static String REGISTER_POST = ROOT + "/ajax/create_user.php";

	public static Map<String, String> getDefaultMapParmas() {
		Map<String, String> parmas = new HashMap<String, String>();
		parmas.put("mail", "kuxinweiTest@163.com");
		parmas.put("password", "12345678");
		parmas.put("userName", "testtest");
		return parmas;
	};
}
