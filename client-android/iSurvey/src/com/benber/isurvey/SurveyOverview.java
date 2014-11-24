package com.benber.isurvey;

import java.util.Date;

public class SurveyOverview {

	public static final int SURVEY_TYPE_NORMAL = 0;

	private int id;
	private int type;
	private Date date;
	private Date expire;
	private String title;
	private String desc;
	private int time;

	public SurveyOverview() {
		id = 0;
		type = SURVEY_TYPE_NORMAL;
		date = new Date(0);
		expire = null;
		title = "";
		desc = "";
		time = 0;
	}

	public SurveyOverview(int id, int type, Date date, Date expire,
			String title, String desc, int time) {
		this.id = id;
		this.type = type;
		this.date = date;
		this.expire = expire;
		this.title = title;
		this.desc = desc;
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public int getType() {
		return type;
	}

	public String getDate() {
		return date.toString();
	}

	public String getExpire() {
		if (expire == null)
			return "";
		return expire.toString();
	}

	public String getTitle() {
		return title;
	}

	public String getDesc() {
		return desc;
	}

	public int getTime() {
		return time;
	}
}
