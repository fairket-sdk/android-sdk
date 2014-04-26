package com.fairket.app.sample.gb;

import com.fairket.sdk.android.FairketApiClient;
import com.fairket.sdk.android.FairketHelperForGingerbread;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private FairketApiClient mFairketApiClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		mFairketApiClient = FairketHelperForGingerbread.onCreate(this,
				Constants.FAIRKET_APP_PUBLIC_KEY, Constants.LOG_TAG);
	}

	@Override
	protected void onResume() {
		super.onResume();

		FairketHelperForGingerbread.onResume(mFairketApiClient);
	}

	@Override
	protected void onPause() {
		super.onPause();

		FairketHelperForGingerbread.onPause(mFairketApiClient);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		FairketHelperForGingerbread.onDestroy(mFairketApiClient);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			Button btn = (Button) rootView.findViewById(R.id.btnGoToSecond);
			btn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					startActivity(new Intent(getActivity(),
							SecondActivity.class));

				}
			});
			return rootView;
		}
	}

}
