package com.wu.weixinnavidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN); // 全屏显示

		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent intent = new Intent(MainActivity.this, Viewpager.class);
				startActivity(intent);
				MainActivity.this.finish();// 结束本Activity
			}
		}, 1000);
	}

}
