package com.wu.weixinnavidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Viewdoor extends Activity {

	private ImageView mLeft;// ������ƶ���ͼƬ
	private ImageView mRight;// ���ұ��ƶ���ͼƬ
	
	private Handler mHandler = new Handler();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewdoor);

		mLeft = (ImageView) findViewById(R.id.img_left);
		mRight = (ImageView) findViewById(R.id.img_right);

		

		mHandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				AnimationSet anim = new AnimationSet(true);// ��������һ�������ڼ��ϵĹ���
				TranslateAnimation mytranslateanim = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
						-1f, Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, 0f);
				mytranslateanim.setDuration(3000);// ���ö���ʱ��
				anim.addAnimation(mytranslateanim);// ��Ӷ���
				anim.setFillAfter(true);// ���ö�������ʱͣ�ڽ���λ��
				mLeft.startAnimation(anim);// ��ʼ��������ͬ��

				AnimationSet anim1 = new AnimationSet(true);
				TranslateAnimation mytranslateanim1 = new TranslateAnimation(
						Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF,
						+1f, Animation.RELATIVE_TO_SELF, 0f,
						Animation.RELATIVE_TO_SELF, 0f);
				mytranslateanim1.setDuration(3000);
				anim1.addAnimation(mytranslateanim1);
				anim1.setFillAfter(true);
				mRight.startAnimation(anim1);
				
				new Handler().postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Intent it = new Intent(Viewdoor.this, MainActivity.class);
						startActivity(it);
					}
				}, 3000);
			}
		}, 1000);

	}

}
