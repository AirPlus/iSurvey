package com.benber.isurvey;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class LaunchActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Go full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_launch);

		// Fill the login panel placeholder
		if (savedInstanceState == null)
			getSupportFragmentManager().beginTransaction()
					.add(R.id.login, new LoginFragment()).commit();

		// Wait to display the panel
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Animation animation = AnimationUtils.loadAnimation(
						LaunchActivity.this, R.anim.login_show);
				findViewById(R.id.login).setVisibility(View.VISIBLE);
				findViewById(R.id.login).startAnimation(animation);
				animation = AnimationUtils.loadAnimation(LaunchActivity.this,
						R.anim.welcome_show);
				findViewById(R.id.welcome).setVisibility(View.VISIBLE);
				findViewById(R.id.welcome).startAnimation(animation);
				animation = AnimationUtils.loadAnimation(LaunchActivity.this,
						R.anim.logo_up);
				findViewById(R.id.logo).startAnimation(animation);
			}
		}, 2500);

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// Disable the Menu button, which may be a bug when in FULLSCREEN mode
		// TODO The reason is to be found...
		if (keyCode == KeyEvent.KEYCODE_MENU)
			return true;
		return super.onKeyDown(keyCode, event);
	}

	public static class LoginFragment extends Fragment implements
			OnClickListener {
		public LoginFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_login,
					container, false);
			rootView.findViewById(R.id.btnLogin).setOnClickListener(this);
			return rootView;
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btnLogin:
				LaunchActivity parent = (LaunchActivity) getActivity();
				Intent intent = new Intent(parent, MainActivity.class);
				startActivity(intent);
				parent.overridePendingTransition(android.R.anim.fade_in,
						android.R.anim.fade_out);
				parent.finish();
				break;
			}
		}
	}

}
