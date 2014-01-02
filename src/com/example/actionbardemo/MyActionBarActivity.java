/**
  * Project name: ActionBarDemo
  * Package name: com.example.actionbardemo
  * Filename: ActionBarActivity.java
  * Created time: 2014-1-2
  * Copyright: Copyright(c) 2013. All Rights Reserved.
  */

package com.example.actionbardemo;

import android.content.Intent;
import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;

/**
 * @ClassName: ActionBarActivity
 * @Description: TODO
 * @author tangwei
 * @date 2014-1-2 上午9:45:21
 *
 */
public class MyActionBarActivity extends SherlockFragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		actionBarSetting();
	}
	
	private void actionBarSetting() {
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}


	/**
	  * @Title: getDefaultIntent
	  * @Description: TODO
	  * @return  
	  * @throws
	  */ 
	private Intent getDefaultIntent() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_TEXT, "hhhaaa");
		intent.setType("text/plain");
		return intent;
	}

}
