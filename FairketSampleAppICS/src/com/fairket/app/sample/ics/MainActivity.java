package com.fairket.app.sample.ics;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.fairket.sdk.android.FairketApiClient;
import com.fairket.sdk.android.FairketResult;

/**
 * @author lohith
 * 
 */
public class MainActivity extends ActionBarActivity {

	private FairketApiClient mFairket;

	private String base64PublicKey = "<your-fairket-app-public-key>";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		mFairket = new FairketApiClient(this, base64PublicKey);
	}

	@Override
	protected void onResume() {
		super.onResume();

		mFairket.initialize(new FairketApiClient.OnInitializeListener() {

			@Override
			public void onInitializeFinished(FairketResult result) {
				if (result.isSuccess()) {
					Log.d(Constants.LOG_TAG, "Fairket init successful!");
					mFairket.trackAppTime(null);
				} else {
					Log.d(Constants.LOG_TAG, "Oops, Fairket init failed! "
							+ result.getMessage());
				}
			}
		});

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		mFairket.dispose();
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
			return rootView;
		}
	}

}
