/**
 * 
 */
package com.fairket.app.sample.gb;

import android.app.Activity;
import android.os.Bundle;

import com.fairket.sdk.android.FairketApiClient;
import com.fairket.sdk.android.FairketAppTimeHelper;

/**
 * @author lohith
 * 
 */
public class SecondActivity extends Activity {

	private FairketApiClient mFairketApiClient;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		mFairketApiClient = FairketAppTimeHelper.onCreate(this,
				Constants.FAIRKET_APP_PUBLIC_KEY, Constants.LOG_TAG);
	}

	@Override
	protected void onResume() {
		super.onResume();

		FairketAppTimeHelper.onResume(mFairketApiClient);
	}

	@Override
	protected void onPause() {
		super.onPause();

		FairketAppTimeHelper.onPause(mFairketApiClient);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		FairketAppTimeHelper.onDestroy(mFairketApiClient);
	}
}
