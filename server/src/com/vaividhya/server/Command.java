package com.vaividhya.server;

public class Command {

	public static final String file_type = ".jpg";
	
	//connect
	public static final int WS_ANDROID = 1001;
	public static final int WS_WEBSITE_ADMIN = 1002;
	
	//website admin
	public static final int WS_ADMIN_LOGIN = 2001;
	public static final int WS_ADMIN_PING = 2002;
	public static final int WS_ADMIN_GET_NAME_ID_LIST = 2003;
	public static final int WS_ADMIN_GET_EVENT_BY_ID = 2004;
	public static final int WS_ADMIN_UPDATE_EVENT = 2005;
	public static final int WS_ADMIN_ADD_EVENT = 2006;
	public static final int WS_ADMIN_DELETE_EVENT = 2007;
	
	//student admin
	public static final int WS_ADMIN_GET_STUDET_NAME_ID_LIST = 2100;
	public static final int WS_ADMIN_GET_STUDENT_BY_ID = 2101;
	public static final int WS_ADMIN_DELETE_STUDENT = 2102;
	public static final int WS_ADMIN_UPDATE_STUDENT = 2103;
	public static final int WS_ADMIN_ADD_STUDENT = 2104;
	
	//faculty admin
	public static final int WS_ADMIN_GET_FACULTY_NAME_ID_LIST = 2200;
	public static final int WS_ADMIN_GET_FACULTY_BY_ID = 2201;
	public static final int WS_ADMIN_DELETE_FACULTY = 2202;
	public static final int WS_ADMIN_UPDATE_FACULTY = 2203;
	public static final int WS_ADMIN_ADD_FACULTY = 2204;
	
	//sponsor admin
	public static final int WS_ADMIN_GET_SPONSOR_NAME_ID_LIST = 2300;
	public static final int WS_ADMIN_GET_SPONSOR_BY_ID = 2301;
	public static final int WS_ADMIN_DELETE_SPONSOR = 2302;
	public static final int WS_ADMIN_UPDATE_SPONSOR = 2303;
	public static final int WS_ADMIN_ADD_SPONSOR = 2304;
	
	//news admin
	public static final int WS_ADMIN_GET_NEWS_NAME_ID_LIST = 2400;
	public static final int WS_ADMIN_GET_NEWS_BY_ID = 2401;
	public static final int WS_ADMIN_DELETE_NEWS = 2402;
	public static final int WS_ADMIN_UPDATE_NEWS = 2403;
	public static final int WS_ADMIN_ADD_NEWS = 2404;
	
	
	
	
	//android client
	public static final int WS_ANDROID_GET_EVENT_LIST = 3001;
	public static final int WS_ANDROID_GET_STUDENT_LIST = 3002;
	public static final int WS_ANDROID_GET_FACULTY_LIST = 3003;
	public static final int WS_ANDROID_GET_SPONSOR_LIST = 3004;
	public static final int WS_ANDROID_GET_NEWS_LIST = 3005;
	
	
	//public static final int WS_ANDROID_REFRESH_FOR_UPDATE = 3101;
	public static final int WS_ANDROID_REFRESH_FOR_UPDATE_EVENT = 3101;
	public static final int WS_ANDROID_REFRESH_FOR_UPDATE_STUDENT = 3102;
	public static final int WS_ANDROID_REFRESH_FOR_UPDATE_FACULTY = 3103;
	public static final int WS_ANDROID_REFRESH_FOR_UPDATE_SPONSOR = 3104;
	public static final int WS_ANDROID_REFRESH_FOR_UPDATE_NEWS = 3105;
	
	
	
}
