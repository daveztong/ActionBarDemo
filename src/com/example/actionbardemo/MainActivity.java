package com.example.actionbardemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

@SuppressLint("NewApi")
public class MainActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void gotoAb(View view) {
		startActivity(new Intent(MainActivity.this, MyActionBarActivity.class));
	}

	public void gotoSw(View view) {
		startActivity(new Intent(MainActivity.this, SwipeViews.class));
	}

}
