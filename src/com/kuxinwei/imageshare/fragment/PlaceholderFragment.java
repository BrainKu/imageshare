package com.kuxinwei.imageshare.fragment;

import java.io.IOException;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kuxinwei.imageshare.R;
import com.kuxinwei.imageshare.client.ApiClient;
import com.kuxinwei.imageshare.client.URL;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
	private static final String ARG_SECTION_NUMBER = "section_number";

	private static final Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			Log.i("msg", msg.toString());
			Log.i("Thread", Thread.currentThread().getName());
		}
	};
	
	public static PlaceholderFragment newInstance(int sectionNumber) {
		PlaceholderFragment fragment = new PlaceholderFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		Button textView = (Button) rootView.findViewById(R.id.section_label);
		textView.setText(Integer.toString(getArguments().getInt(
				ARG_SECTION_NUMBER)));

		textView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							ApiClient.httpPostRequest(URL.REGISTER_POST,
									URL.getDefaultMapParmas(), handler);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
		});

		return rootView;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

}
