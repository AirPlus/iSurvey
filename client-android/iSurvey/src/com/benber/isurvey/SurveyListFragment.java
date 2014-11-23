package com.benber.isurvey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SurveyListFragment extends Fragment {
	private SimpleAdapter listAdapter;
	private ListView listView;
	private ArrayList<Map<String, String>> listData;
	private HashMap<String, String> listItem;

	public SurveyListFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_survey_list,
				container, false);
		listView = (ListView) rootView.findViewById(R.id.listView1);
		listData=new ArrayList<Map<String,String>>();
		int i;
		for (i = 1; i <= 10; i++) {
			listItem = new HashMap<String, String>();
			listItem.put("title", "Test survey " + i);
			listItem.put("detail",
					"This is just a simple survey posted. It's just for testing the app.");
			listData.add(listItem);
		}
		listAdapter = new SimpleAdapter(getActivity(), listData,
				R.layout.item_survey, new String[] { "title", "detail" },
				new int[] { R.id.textTitle, R.id.textDetail });
		listView.setAdapter(listAdapter);
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity)
				.onSectionAttached(MainActivity.DRAWER_POSITION_SURVEY_LIST);
	}
}