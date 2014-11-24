package com.benber.isurvey;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RespondActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_respond);

		if (savedInstanceState == null) {
			SurveyDetailFragment mFragment = new SurveyDetailFragment();
			mFragment.setArguments(getIntent().getBundleExtra("para"));
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, mFragment).commit();

		}
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class SurveyDetailFragment extends Fragment {

		public SurveyDetailFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_survey_detail,
					container, false);
			Bundle mBundle = getArguments();
			((TextView) rootView.findViewById(R.id.textTitle)).setText(mBundle
					.getString("title"));
			((TextView) rootView.findViewById(R.id.textDesc)).setText(mBundle
					.getString("desc"));
			return rootView;
		}
	}

}
