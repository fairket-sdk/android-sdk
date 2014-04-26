/**
 * 
 */
package com.fairket.app.sample.gb;

import com.fairket.sdk.android.FairketApiClient;
import com.fairket.sdk.android.FairketHelperForGingerbread;

import android.app.Activity;
import android.os.Bundle;

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
}
