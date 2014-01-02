/**
 * Project name: ActionBarDemo
 * Package name: com.example.actionbardemo
 * Filename: SwipeViews.java
 * Created time: 2014-1-2
 * Copyright: Copyright(c) 2013. All Rights Reserved.
 */

package com.example.actionbardemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * @ClassName: SwipeViews
 * @Description: TODO
 * @author tangwei
 * @date 2014-1-2 上午11:07:53
 * 
 */
public class SwipeViews extends SherlockFragmentActivity implements
		TabListener, OnPageChangeListener {
	private android.support.v4.view.PagerAdapter pagerAdapter;
	private ViewPager mViewPager;
	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.swipe_views);

		mActionBar = getSupportActionBar();
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		pagerAdapter = new PagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(pagerAdapter);
		mViewPager.setOnPageChangeListener(this);

		// Add 3 tabs, specifying the tab's text and TabListener
		for (int i = 0; i < 10; i++) {
			mActionBar.addTab(mActionBar.newTab().setText("Tab " + (i + 1))
					.setTabListener(this));
		}
	}

	private class PagerAdapter extends FragmentStatePagerAdapter {

		public PagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {
			Fragment fragment = new DemoObjectFragment();
			Bundle args = new Bundle();
			// Our object is just an integer :-P
			args.putInt(DemoObjectFragment.ARG_OBJECT, i + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public CharSequence getPageTitle(int position) {

			return "OBJECT " + (position + 1);
		}

	}

	public static class DemoObjectFragment extends Fragment {
		public static final String ARG_OBJECT = "object";

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// The last two arguments ensure LayoutParams are inflated
			// properly.
			View rootView = inflater.inflate(
					R.layout.fragment_collection_object, container, false);
			Bundle args = getArguments();
			((TextView) rootView.findViewById(R.id.tv_text))
					.setText(Integer.toString(args.getInt(ARG_OBJECT))
							+ "Notice that there are two version for each action bar style property. The first one includes the android: prefix on the property name to support API levels 11 and higher that include these properties in the framework. The second version does not include the android: prefix and is for older versions of the platform, on which the system uses the style property from the support library. The effect for each is the same.");
			return rootView;
		}
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
	}

	@Override
	public void onPageSelected(int pos) {
		mActionBar.setSelectedNavigationItem(pos);
	}
}
