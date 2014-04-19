package com.kuxinwei;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.os.Handler;

import com.kuxinwei.imageshare.MainActivity;
import com.kuxinwei.imageshare.R;
import com.kuxinwei.imageshare.client.ApiClient;
import com.kuxinwei.imageshare.client.URL;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
	MainActivity mainActivity;
	Handler myHandler;

	@Before
	public void setUp() {
		this.mainActivity = Robolectric.buildActivity(MainActivity.class)
				.create().get();
		myHandler = mainActivity.getHanlder();
	}

	@Test
	public void testActivityIsNotNull() {
		assertNotNull(mainActivity);
	}
	
	@Test
	public void testPostRequestSucceed() throws Exception {
		Robolectric.addPendingHttpResponse(200, "hehe");
		boolean isSuccessed = ApiClient.httpPostRequest(URL.REGISTER_POST, URL.getDefaultMapParmas(), myHandler);
		assertTrue(isSuccessed);
	}
	
	@Test
	public void testCanGetHelloString() throws Exception {
		String hello = mainActivity.getResources().getString(R.string.hello_world);
		assertThat(hello, equalTo("Hello world!"));
	}
}
