package com.wu.weixinnavidemo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Viewpager extends Activity {

	private ViewPager mViewPager;// 声明ViewPager对象
	private PagerTitleStrip mPagerTitleStrip;// 声明动画标题
	private ImageView mPageImg;// 动画图片
	private int currIndex = 0;// 当前页面
	private ImageView mPage0, mPage1, mPage2, mPage3, mPage4, mPage5, mPage6,
			mPage7, mPage8;// 声明导航图片对象

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewpager);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
		mPagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagertitle);

		mPage0 = (ImageView) findViewById(R.id.page0);
		mPage1 = (ImageView) findViewById(R.id.page1);
		mPage2 = (ImageView) findViewById(R.id.page2);
		mPage3 = (ImageView) findViewById(R.id.page3);
		mPage4 = (ImageView) findViewById(R.id.page4);
		mPage5 = (ImageView) findViewById(R.id.page5);
		mPage6 = (ImageView) findViewById(R.id.page6);
		mPage7 = (ImageView) findViewById(R.id.page7);
		mPage8 = (ImageView) findViewById(R.id.page8);

		// 将要分页显示的View装入数组中
		LayoutInflater mLi = LayoutInflater.from(this);
		View view1 = mLi.inflate(R.layout.view1, null);
		View view2 = mLi.inflate(R.layout.view2, null);
		View view3 = mLi.inflate(R.layout.view3, null);
		View view4 = mLi.inflate(R.layout.view4, null);
		View view5 = mLi.inflate(R.layout.view5, null);
		View view6 = mLi.inflate(R.layout.view6, null);
		View view7 = mLi.inflate(R.layout.view7, null);
		View view8 = mLi.inflate(R.layout.view8, null);
		View view9 = mLi.inflate(R.layout.view9, null);

		// 每个页面的view数据
		final ArrayList<View> views = new ArrayList<View>();
		views.add(view1);
		views.add(view2);
		views.add(view3);
		views.add(view4);
		views.add(view5);
		views.add(view6);
		views.add(view7);
		views.add(view8);
		views.add(view9);
		// 每一个也没得标题
		final ArrayList<String> titles = new ArrayList<String>();
		titles.add("①");
		titles.add("②");
		titles.add("③");
		titles.add("④");
		titles.add("⑤");
		titles.add("⑥");
		titles.add("⑦");
		titles.add("⑧");
		titles.add("⑨");

		// 填充ViewPager的数据适配器，我们重写即可
		PagerAdapter mPagerAdapter = new PagerAdapter() {

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return views.size();
			}

			@Override
			public void destroyItem(View container, int position, Object object) {
				((ViewPager) container).removeView(views.get(position));
			}

			@Override
			public CharSequence getPageTitle(int position) {
				return titles.get(position);
			}

			@Override
			public Object instantiateItem(View container, int position) {
				((ViewPager) container).addView(views.get(position));
				return views.get(position);
			}
		};

		mViewPager.setAdapter(mPagerAdapter);// 与ListView用法相同，设置重写的Adapter。这样就实现了ViewPager的滑动效果。
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {

		public void onPageSelected(int arg0) {// 参数arg0为选中的View

			Animation animation = null;// 声明动画对象
			switch (arg0) {
			case 0: // 页面一
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));// 进入第一个导航页面，小圆点为选中状态，下一个页面的小圆点是未选中状态。
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				if (currIndex == arg0 + 1) {
					animation = new TranslateAnimation(arg0 + 1, arg0, 0, 0);// 圆点移动效果动画，从当前View移动到下一个View
				}
				break;
			case 1: // 页面二
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));// 当前View
				mPage0.setImageDrawable(getResources().getDrawable(
						R.drawable.page));// 上一个View
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));// 下一个View
				if (currIndex == arg0 - 1) {// 如果滑动到上一个View
					animation = new TranslateAnimation(arg0 - 1, arg0, 0, 0); // 圆点移动效果动画，从当前View移动到下一个View

				} else if (currIndex == arg0 + 1) {// 圆点移动效果动画，从当前View移动到下一个View，下同。

					animation = new TranslateAnimation(arg0 + 1, arg0, 0, 0);
				}
				break;
			case 2: // 页面三
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage1.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				if (currIndex == arg0 - 1) {
					animation = new TranslateAnimation(arg0 - 1, arg0, 0, 0);
				} else if (currIndex == arg0 + 1) {
					animation = new TranslateAnimation(arg0 + 1, arg0, 0, 0);
				}
				break;
			case 3:
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage4.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage2.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				if (currIndex == arg0 - 1) {
					animation = new TranslateAnimation(arg0 - 1, arg0, 0, 0);

				} else if (currIndex == arg0 + 1) {
					animation = new TranslateAnimation(arg0 + 1, arg0, 0, 0);
				}
				break;
			case 4:
				mPage4.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage3.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage5.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				if (currIndex == arg0 - 1) {
					animation = new TranslateAnimation(arg0 - 1, arg0, 0, 0);
				} else if (currIndex == arg0 + 1) {
					animation = new TranslateAnimation(arg0 + 1, arg0, 0, 0);
				}
				break;
			case 5:
				mPage5.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage4.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage6.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				if (currIndex == arg0 - 1) {
					animation = new TranslateAnimation(arg0 - 1, arg0, 0, 0);
				} else if (currIndex == arg0 + 1) {
					animation = new TranslateAnimation(arg0 + 1, arg0, 0, 0);
				}
				break;
			case 6:
				mPage6.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage5.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage7.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				if (currIndex == arg0 - 1) {
					animation = new TranslateAnimation(arg0 - 1, arg0, 0, 0);
				} else if (currIndex == arg0 + 1) {
					animation = new TranslateAnimation(arg0 + 1, arg0, 0, 0);
				}
				break;
			case 7:
				mPage7.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage8.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				mPage6.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				if (currIndex == arg0 - 1) {
					animation = new TranslateAnimation(arg0 - 1, arg0, 0, 0);
				} else if (currIndex == arg0 + 1) {
					animation = new TranslateAnimation(arg0 + 1, arg0, 0, 0);
				}
				break;
			case 8:
				mPage8.setImageDrawable(getResources().getDrawable(
						R.drawable.page_now));
				mPage7.setImageDrawable(getResources().getDrawable(
						R.drawable.page));
				if (currIndex == arg0 - 1) {
					animation = new TranslateAnimation(arg0 - 1, arg0, 0, 0);
				}
				break;
			}
			currIndex = arg0;// 设置当前View
			animation.setFillAfter(true);// True:设置图片停在动画结束位置
			animation.setDuration(300);// 设置动画持续时间
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}
	}

	public void startbutton(View v) {
		Intent intent = new Intent();
		intent.setClass(Viewpager.this, Viewdoor.class);// 进入到开门效果的Activity
		startActivity(intent);
		Viewpager.this.finish();// 结束本Activity
	}
}
