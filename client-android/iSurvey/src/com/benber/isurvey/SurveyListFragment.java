package com.benber.isurvey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class SurveyListFragment extends Fragment {
	private SimpleAdapter listAdapter;
	private ListView listView;
	private ArrayList<Map<String, String>> listData;
	private HashMap<String, String> listItem;
	private ArrayList<SurveyOverview> listSurveyOverview;

	public SurveyListFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_survey_list,
				container, false);
		listView = (ListView) rootView.findViewById(R.id.listView1);
		listData = new ArrayList<Map<String, String>>();
		listSurveyOverview = new ArrayList<SurveyOverview>();

		int i;
		for (i = 1; i <= 10; i++) {
			listItem = new HashMap<String, String>();
			listItem.put("title", "Test survey " + i);
			listItem.put("desc",
					"This is just a simple survey posted. It's just for testing the app.");
			listData.add(listItem);
			SurveyOverview mSurveyOverview =new SurveyOverview();
			mSurveyOverview.setTitle("Test survey " + i);
			mSurveyOverview.setDesc("This is just a simple survey posted. It's just for testing the app.");
			listSurveyOverview.add(mSurveyOverview);

		}
		listAdapter = new SimpleAdapter(getActivity(), listData,
				R.layout.item_survey, new String[] { "title", "desc" },
				new int[] { R.id.textTitle, R.id.textDesc });
		listView.setAdapter(listAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent(getActivity(), RespondActivity.class);
				SurveyOverview mSurveyOverview = listSurveyOverview
						.get(position);
				Bundle mBundle = new Bundle();
				mBundle.putInt("id", mSurveyOverview.getId());
				mBundle.putInt("type", mSurveyOverview.getType());
				mBundle.putString("date", mSurveyOverview.getDate());
				mBundle.putString("expire", mSurveyOverview.getExpire());
				mBundle.putString("title", mSurveyOverview.getTitle());
				mBundle.putString("desc", mSurveyOverview.getDesc());
				mBundle.putInt("responds", mSurveyOverview.getResponds());
				mBundle.putInt("time", mSurveyOverview.getTime());
				intent.putExtra("para", mBundle);
				startActivity(intent);
			}
		});

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity)
				.onSectionAttached(MainActivity.DRAWER_POSITION_SURVEY_LIST);
	}
}