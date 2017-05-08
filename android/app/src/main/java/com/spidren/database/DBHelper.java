package com.spidren.database;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.os.Message;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.utils.DiskCacheUtils;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;
import com.spidren.api.macro.MacroTag;
import com.spidren.vaividhya2k15.Config;
import com.spidren.vaividhya2k15.MainActivity;

public class DBHelper extends SQLiteOpenHelper{
	
	private boolean  isRefres = false; 
	

	private String TABLE_EVENT       = "event";
	//total 18
	private String EVENT_ID          		= "id",
				   EVENT_NAME        		= "name",
				   EVENT_TIME      		    = "time",
				   EVENT_TYPE        		= "type",
				   EVENT_TAG         		= "tag",
				   EVENT_LOCATION    		= "location",
				   EVENT_INTRO       		= "intro",
				   EVENT_TASK        		= "task",
				   EVENT_RULE        		= "rule",
				   EVENT_SHARE_LINK  		= "share_link",
				   EVENT_IS_WISED    		= "is_wised",
				   EVENT_CO1_NAME    		= "co1_name",
				   EVENT_CO1_EMAIL    		= "co1_email",
				   EVENT_CO2_NAME    		= "co2_name",
				   EVENT_CO2_EMAIL    		= "co2_email",
				   EVENT_LAST_UPADTE    	= "last_update",
				   EVENT_LAST_POSTER_UPDATE = "last_poster_update",
				   EVENT_COLOR_CODE         = "color_code"
				   
				   ;
	
	
	/*private String TABLE_COORDINATOR      = "coordinator";
	private String COORDINATOR_EVENT_ID   = "event_id",
			       COORDINATOR_NAME       = "name",
			       COORDINATOR_EMAIL      = "email";*/
	
	
	
	
	private String TABLE_STUDENT_OUR_TEAM = "student_our_team";
	private String STUDENET_OUR_TEAM_ID = "id",
			       STUDENET_OUR_TEAM_NAME = "name",
			       STUDENET_OUR_TEAM_POST = "post",
			       STUDENET_OUR_TEAM_LAST_UPDATE = "last_update",
			       STUDENET_OUR_TEAM_LAST_IMAGE_UPDATE = "last_image_update";
	
	
	private String TABLE_FACULTY_OUR_TEAM = "faculty_our_team";
	private String FACULTY_OUR_TEAM_ID = "id",
			       FACULTY_OUR_TEAM_NAME = "name",
			       FACULTY_OUR_TEAM_POST = "post",
			       FACULTY_OUR_TEAM_LAST_UPDATE = "last_update",
			       FACULTY_OUR_TEAM_LAST_IMAGE_UPDATE = "last_image_update";
	
	
	
	private String TABLE_SPONSOR_OUR_TEAM = "sponsor_our_team";
	private String SPONSOR_OUR_TEAM_ID = "id",
				   SPONSOR_OUR_TEAM_NAME = "name",
				   SPONSOR_OUR_TEAM_POST = "post",
				   SPONSOR_OUR_TEAM_LAST_UPDATE = "last_update",
				   SPONSOR_OUR_TEAM_LAST_IMAGE_UPDATE = "last_image_update";
	
	private String TABLE_NEWS = "news";
	private String NEWS_ID = "id",
				   NEWS_TITLE = "title",
				   NEWS_CONTENT = "content",
				   NEWS_IS_NEW = "is_new",
				   NEWS_LAST_UPDATE = "last_update";
	
	private SQLiteDatabase db;
	
	
	
	public DBHelper(Context context) {
		super(context, "pathik", null, 52);
		
		db = getReadableDatabase();
		
		
		if(isRefres){
			isRefres = false;
			//addTemp();
		}
		
	}
	
	
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		isRefres = true;
		
		db.execSQL("create table "+TABLE_EVENT
								  +"("
								  +"no integer primary key autoincrement,"
								  +EVENT_ID          		+" integer,"
								  +EVENT_NAME        		+" text,"
								  +EVENT_TYPE        		+" text,"
								  +EVENT_TIME        		+" text,"
								  +EVENT_TAG         		+" text,"
								  +EVENT_LOCATION    		+" text,"
								  +EVENT_INTRO       		+" text,"
								  +EVENT_RULE        		+" text,"
								  +EVENT_TASK        		+" text,"
								  +EVENT_SHARE_LINK  		+" text,"
								  +EVENT_IS_WISED    		+" text,"
								  
								  +EVENT_CO1_NAME  			+" text,"
								  +EVENT_CO1_EMAIL    		+" text,"
								  
								  +EVENT_CO2_NAME  			+" text,"
								  +EVENT_CO2_EMAIL    		+" text,"
								  
								  +EVENT_LAST_UPADTE  		+" text,"
								  +EVENT_LAST_POSTER_UPDATE +" text,"
								  +EVENT_COLOR_CODE         +" integer"
								  +");");
		
		
	
		
		db.execSQL("create table "+TABLE_STUDENT_OUR_TEAM
				  +"("
				  + STUDENET_OUR_TEAM_ID 				+" integer,"
				  + STUDENET_OUR_TEAM_NAME  			+" text,"
				  + STUDENET_OUR_TEAM_POST 				+" text,"
				  + STUDENET_OUR_TEAM_LAST_UPDATE  		+" text,"
				  + STUDENET_OUR_TEAM_LAST_IMAGE_UPDATE +" text"
				  +");");
		
		db.execSQL("create table "+TABLE_FACULTY_OUR_TEAM
				  +"("
				  + FACULTY_OUR_TEAM_ID 				+" integer,"
				  + FACULTY_OUR_TEAM_NAME  				+" text,"
				  + FACULTY_OUR_TEAM_POST 				+" text,"
				  + FACULTY_OUR_TEAM_LAST_UPDATE  		+" text,"
				  + FACULTY_OUR_TEAM_LAST_IMAGE_UPDATE  +" text"
				  +");");
		
		db.execSQL("create table "+TABLE_SPONSOR_OUR_TEAM
				  +"("
				  + SPONSOR_OUR_TEAM_ID 				+" integer,"
				  + SPONSOR_OUR_TEAM_NAME  				+" text,"
				  + SPONSOR_OUR_TEAM_POST 				+" text,"
				  + SPONSOR_OUR_TEAM_LAST_UPDATE  		+" text,"
				  + SPONSOR_OUR_TEAM_LAST_IMAGE_UPDATE  +" text"
				  +");");
		
		db.execSQL("create table "+TABLE_NEWS
				  +"("
				  + NEWS_ID 				+" integer,"
				  + NEWS_TITLE  			+" text,"
				  + NEWS_CONTENT 			+" text,"
				  + NEWS_IS_NEW  			+" integer,"
				  + NEWS_LAST_UPDATE  		+" text"
				  +");");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_EVENT+";");
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_STUDENT_OUR_TEAM+";");
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_FACULTY_OUR_TEAM+";");
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_SPONSOR_OUR_TEAM+";");
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NEWS+";");
		
		onCreate(db);
	}
	
	
	public boolean isHasUnReadNews(){
		Cursor cursor = db.query(TABLE_NEWS, null,  NEWS_IS_NEW+"=?", new String[]{"0"},null, null, null);
		if(cursor != null && cursor.getCount() >0)
			return true;
		return false;
	}
	
	
	public void set_news_view_to_read(){
		ContentValues values = new ContentValues();
		values.put(NEWS_IS_NEW, 2);
		
		
		db.update(TABLE_NEWS, values, NEWS_IS_NEW +"=?" , new String[]{"1"});
	}
	
	
	public ArrayList<DBNews> getNewsList(){
		ArrayList<DBNews> list = new ArrayList<DBNews>();
		
		String[] columns = new String[]{
				NEWS_ID,
				NEWS_TITLE,
				NEWS_CONTENT,
				NEWS_IS_NEW,
				NEWS_LAST_UPDATE
		};
		
		Cursor cursor = db.query(TABLE_NEWS, columns, null, null, null, null, NEWS_LAST_UPDATE+" DESC");
		if(cursor != null && cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do {
				
				int id = cursor.getInt(0);
				String title = cursor.getString(1);
				String content = cursor.getString(2);
				int isNew = cursor.getInt(3);
				long last_update = Long.parseLong(cursor.getString(4));
				
				
				DBNews news = new DBNews();
				news.setId(id);
				news.setTitle(title);
				news.setContent(content);
				news.setNew(isNew);
				news.setLastUpdate(last_update);
				
				list.add(news);
				
				
			} while (cursor.moveToNext());
			
		}
		
		cursor.close();
		return list;
	}
	
	public void addNews(DBNews news){
		db.execSQL("insert into "+TABLE_NEWS+"("
				 +NEWS_ID +","
				 +NEWS_TITLE +","
				 +NEWS_CONTENT +","
				 +NEWS_IS_NEW +","
				 +NEWS_LAST_UPDATE 
				 +") values(?,?,?,?,?);",new String[]{
						news.getId()+"",
						news.getTitle(),
						news.getContain(),
						news.isNew()+"",
						news.getLastUpdate()+""
		});
	}
	
	public void updateNews(DBNews news){
		ContentValues values = new ContentValues();
		values.put(NEWS_TITLE, news.getTitle());
		values.put(NEWS_CONTENT, news.getContain());
		values.put(NEWS_IS_NEW, news.isNew()+"");
		values.put(NEWS_LAST_UPDATE, news.getLastUpdate());
		
		
		db.update(TABLE_NEWS, values, NEWS_ID +"=?", new String[]{news.getId()+""});
	}
	
	public void removeNews(DBNews news){
		removeNews(news.getId());
	}
	
	public void removeNews(int id){
		db.delete(TABLE_NEWS, NEWS_ID+"=?", new String[]{id+""});
		
	}
	
	public void addNews(ArrayList<DBNews> list_new){
		ArrayList<DBNews> list_old = getNewsList();
		boolean need_notify = false;
		
		for (int i = 0; i < list_new.size(); i++) {
			
			DBNews news_new = list_new.get(i);
			int index = list_old.indexOf(news_new);
			
			if(index >= 0){
				//for exits news
				DBNews news_old = list_old.get(index);
				list_old.set(index, null);
				
				if(news_new.getLastUpdate() > news_old.getLastUpdate()){
					news_new.setNew(0);
					updateNews(news_new);
					need_notify = true;
				}
			}else {
				//for new news
				news_new.setNew(0);
				addNews(news_new);
				need_notify = true;
			}
			
		}
		
		
		
		for (int i = 0; i < list_old.size(); i++) {
			if(list_old.get(i) != null){	
				removeNews(list_old.get(i));
				need_notify = true;
			}
		}
		
		if(need_notify){
			needNotify(5);
		}
			
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<DBStudent> getStudentList(){
		ArrayList<DBStudent> list = new ArrayList<DBStudent>();
		
		String[] columns = new String[]{
				STUDENET_OUR_TEAM_ID,
				STUDENET_OUR_TEAM_NAME,
				STUDENET_OUR_TEAM_POST,
				STUDENET_OUR_TEAM_LAST_UPDATE,
				STUDENET_OUR_TEAM_LAST_IMAGE_UPDATE
		};
		
		Cursor cursor = db.query(TABLE_STUDENT_OUR_TEAM, columns, null, null, null, null, null);
		if(cursor != null && cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do {
				
				int id = cursor.getInt(0);
				String name = cursor.getString(1);
				String post = cursor.getString(2);
				long last_update = Long.parseLong(cursor.getString(3));
				long last_image_update = Long.parseLong(cursor.getString(4));
				
				
				DBStudent student = new DBStudent();
				student.setId(id);
				student.setName(name);
				student.setPost(post);
				student.setLast_update(last_update);
				student.setLast_image_update(last_image_update);
				
				list.add(student);
				
				
			} while (cursor.moveToNext());
			
		}
		
		cursor.close();
		return list;
	}
	
	public void addStudent(DBStudent student){
		db.execSQL("insert into "+TABLE_STUDENT_OUR_TEAM+"("
								 +STUDENET_OUR_TEAM_ID +","
								 +STUDENET_OUR_TEAM_NAME +","
								 +STUDENET_OUR_TEAM_POST +","
								 +STUDENET_OUR_TEAM_LAST_UPDATE +","
								 +STUDENET_OUR_TEAM_LAST_IMAGE_UPDATE 
								 +") values(?,?,?,?,?);",new String[]{
										student.getId()+"",
										student.getName(),
										student.getPost(),
										student.getLast_update()+"",
										student.getLast_image_update()+""
		});
	}
	
	public void updateStudent(DBStudent student){
		ContentValues values = new ContentValues();
		values.put(STUDENET_OUR_TEAM_NAME, student.getName());
		values.put(STUDENET_OUR_TEAM_POST, student.getPost());
		values.put(STUDENET_OUR_TEAM_LAST_UPDATE, student.getLast_update());
		values.put(STUDENET_OUR_TEAM_LAST_IMAGE_UPDATE, student.getLast_image_update());
		
		
		db.update(TABLE_STUDENT_OUR_TEAM, values, STUDENET_OUR_TEAM_ID +"=?", new String[]{student.getId()+""});
	}
	
	public void addStudents(ArrayList<DBStudent> list_new){
		ArrayList<DBStudent> list_old = getStudentList();
		boolean need_notify = false;
		
		for (int i = 0; i < list_new.size(); i++) {
			
			DBStudent student_new = list_new.get(i);
			int index = list_old.indexOf(student_new);
			
			if(index >= 0){
				//for exits student
				DBStudent student_old = list_old.get(index);
				list_old.set(index, null);
				boolean needUpdate = false;
				
				if(student_new.getLast_update() > student_old.getLast_update()){
					needUpdate = true;
				}
				if(student_new.getLast_image_update() > student_old.getLast_image_update()){
					needUpdate = true;
					
					deleteCacheFile(Config.student_image_link(student_new.getId()));
				}
				if(needUpdate){
					updateStudent(student_new);
					need_notify = true;
				}
				
			}else {
				//for new student
				addStudent(student_new);
				need_notify = true;
			}
			
		}
		
		
		
		for (int i = 0; i < list_old.size(); i++) {
			if(list_old.get(i) != null){	
				removeStudent(list_old.get(i));
				need_notify = true;
			}
		}
		
		if(need_notify)
			needNotify(2);
		
		
	}
	
	
	public void removeStudent(DBStudent student){
		removeStudent(student.getId());
		
		
	}
	
	public void removeStudent(int id){
		db.delete(TABLE_STUDENT_OUR_TEAM, STUDENET_OUR_TEAM_ID+"=?", new String[]{id+""});
		
		deleteCacheFile(Config.student_image_link(id));
	}
	
	

	
	
	
	
	
	
	
	
	public ArrayList<DBFaculty> getFacultyList(){
		ArrayList<DBFaculty> list = new ArrayList<DBFaculty>();
		
		String[] columns = new String[]{
				FACULTY_OUR_TEAM_ID,
				FACULTY_OUR_TEAM_NAME,
				FACULTY_OUR_TEAM_POST,
				FACULTY_OUR_TEAM_LAST_UPDATE,
				FACULTY_OUR_TEAM_LAST_IMAGE_UPDATE
		};
		
		Cursor cursor = db.query(TABLE_FACULTY_OUR_TEAM, columns, null, null, null, null, null);
		if(cursor != null && cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do {
				
				int id = cursor.getInt(0);
				String name = cursor.getString(1);
				String post = cursor.getString(2);
				long last_update = Long.parseLong(cursor.getString(3));
				long last_image_update = Long.parseLong(cursor.getString(4));
				
				
				DBFaculty faculty = new DBFaculty();
				faculty.setId(id);
				faculty.setName(name);
				faculty.setPost(post);
				faculty.setLast_update(last_update);
				faculty.setLast_image_update(last_image_update);
				
				list.add(faculty);
				
				
			} while (cursor.moveToNext());
			
		}
		
		cursor.close();
		return list;
	}
	
	public void addFaculty(DBFaculty faculty){
		db.execSQL("insert into "+TABLE_FACULTY_OUR_TEAM+"("
								 +FACULTY_OUR_TEAM_ID +","
								 +FACULTY_OUR_TEAM_NAME +","
								 +FACULTY_OUR_TEAM_POST +","
								 +FACULTY_OUR_TEAM_LAST_UPDATE +","
								 +FACULTY_OUR_TEAM_LAST_IMAGE_UPDATE 
								 +") values(?,?,?,?,?);",new String[]{
										faculty.getId()+"",
										faculty.getName(),
										faculty.getPost(),
										faculty.getLast_update()+"",
										faculty.getLast_image_update()+""
		});
	}
	
	public void updateFaculty(DBFaculty faculty){
		ContentValues values = new ContentValues();
		values.put(FACULTY_OUR_TEAM_NAME, faculty.getName());
		values.put(FACULTY_OUR_TEAM_POST, faculty.getPost());
		values.put(FACULTY_OUR_TEAM_LAST_UPDATE, faculty.getLast_update());
		values.put(FACULTY_OUR_TEAM_LAST_IMAGE_UPDATE, faculty.getLast_image_update());
		
		
		db.update(TABLE_FACULTY_OUR_TEAM, values, FACULTY_OUR_TEAM_ID +"=?", new String[]{faculty.getId()+""});
	}
	
	public void addFacultys(ArrayList<DBFaculty> list_new){
		ArrayList<DBFaculty> list_old = getFacultyList();
		boolean need_notify = false;
		
		for (int i = 0; i < list_new.size(); i++) {
			
			DBFaculty faculty_new = list_new.get(i);
			int index = list_old.indexOf(faculty_new);
			
			if(index >= 0){
				//for exits faculty
				DBFaculty faculty_old = list_old.get(index);
				list_old.set(index, null);
				boolean needUpdate = false;
				
				if(faculty_new.getLast_update() > faculty_old.getLast_update()){
					needUpdate = true;
				}
				if(faculty_new.getLast_image_update() > faculty_old.getLast_image_update()){
					needUpdate = true;
					
					deleteCacheFile(Config.faculty_image_link(faculty_new.getId()));
				}
				
				if(needUpdate){
					updateFaculty(faculty_new);
					need_notify = true;
				}
				
			}else {
				//for new faculty
				addFaculty(faculty_new);
				need_notify = true;
			}
		}
		
		for (int i = 0; i < list_old.size(); i++) {
			if(list_old.get(i) != null){	
				removeFaculty(list_old.get(i));
				need_notify = true;
			}
		}
		
		if(need_notify)
			needNotify(3);
	}
	
	public void removeFaculty(DBFaculty faculty){
		removeFaculty(faculty.getId());
	}
	
	public void removeFaculty(int id){
		db.delete(TABLE_FACULTY_OUR_TEAM, FACULTY_OUR_TEAM_ID+"=?", new String[]{id+""});

		deleteCacheFile(Config.faculty_image_link(id));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<DBSponsor> getSponsorList(){
		ArrayList<DBSponsor> list = new ArrayList<DBSponsor>();
		
		String[] columns = new String[]{
				SPONSOR_OUR_TEAM_ID,
				SPONSOR_OUR_TEAM_NAME,
				SPONSOR_OUR_TEAM_POST,
				SPONSOR_OUR_TEAM_LAST_UPDATE,
				SPONSOR_OUR_TEAM_LAST_IMAGE_UPDATE
		};
		
		Cursor cursor = db.query(TABLE_SPONSOR_OUR_TEAM, columns, null, null, null, null, null);
		if(cursor != null && cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do {
				
				int id = cursor.getInt(0);
				String name = cursor.getString(1);
				String post = cursor.getString(2);
				long last_update = Long.parseLong(cursor.getString(3));
				long last_image_update = Long.parseLong(cursor.getString(4));
				
				
				DBSponsor sponsor = new DBSponsor();
				sponsor.setId(id);
				sponsor.setName(name);
				sponsor.setPost(post);
				sponsor.setLast_update(last_update);
				sponsor.setLast_image_update(last_image_update);
				
				list.add(sponsor);
				
				
			} while (cursor.moveToNext());
			
		}
		
		cursor.close();
		return list;
	}
	public void addSponsor(DBSponsor sponsor){
		db.execSQL("insert into "+TABLE_SPONSOR_OUR_TEAM+"("
								 +SPONSOR_OUR_TEAM_ID +","
								 +SPONSOR_OUR_TEAM_NAME +","
								 +SPONSOR_OUR_TEAM_POST +","
								 +SPONSOR_OUR_TEAM_LAST_UPDATE +","
								 +SPONSOR_OUR_TEAM_LAST_IMAGE_UPDATE 
								 +") values(?,?,?,?,?);",new String[]{
										sponsor.getId()+"",
										sponsor.getName(),
										sponsor.getPost(),
										sponsor.getLast_update()+"",
										sponsor.getLast_image_update()+""
		});
	}
	
	public void updateSponsor(DBSponsor sponsor){
		ContentValues values = new ContentValues();
		values.put(SPONSOR_OUR_TEAM_NAME, sponsor.getName());
		values.put(SPONSOR_OUR_TEAM_POST, sponsor.getPost());
		values.put(SPONSOR_OUR_TEAM_LAST_UPDATE, sponsor.getLast_update());
		values.put(SPONSOR_OUR_TEAM_LAST_IMAGE_UPDATE, sponsor.getLast_image_update());
		
		
		db.update(TABLE_SPONSOR_OUR_TEAM, values, SPONSOR_OUR_TEAM_ID +"=?", new String[]{sponsor.getId()+""});
	}
	
	public void addSponsors(ArrayList<DBSponsor> list_new){
		ArrayList<DBSponsor> list_old = getSponsorList();
		boolean need_notify = false;
		
		for (int i = 0; i < list_new.size(); i++) {
			
			DBSponsor sponsor_new = list_new.get(i);
			int index = list_old.indexOf(sponsor_new);
			
			if(index >= 0){
				//for exits sponsor
				DBSponsor sponsor_old = list_old.get(index);
				list_old.set(index, null);
				boolean needUpdate = false;
				
				if(sponsor_new.getLast_update() > sponsor_old.getLast_update()){
					needUpdate = true;
				}
				if(sponsor_new.getLast_image_update() > sponsor_old.getLast_image_update()){
					needUpdate = true;
					
					deleteCacheFile(Config.sponsor_image_link(sponsor_new.getId()));
				}
				
				if(needUpdate){
					updateSponsor(sponsor_new);
					need_notify = true;
				}
				
			}else {
				//for new sponsor
				addSponsor(sponsor_new);
				need_notify = true;
			}
		}
		
		for (int i = 0; i < list_old.size(); i++) {
			if(list_old.get(i) != null){	
				removeSponsor(list_old.get(i));
				need_notify = true;
			}
		}
		
		if(need_notify)
			needNotify(4);
	}
	
	public void removeSponsor(DBSponsor sponsor){
		removeSponsor(sponsor.getId());
	}
	
	public void removeSponsor(int id){
		db.delete(TABLE_SPONSOR_OUR_TEAM, SPONSOR_OUR_TEAM_ID+"=?", new String[]{id+""});
		
		deleteCacheFile(Config.sponsor_image_link(id));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<DBEvent> getWisedEventList(){
		
		ArrayList<DBEvent> list = new ArrayList<DBEvent>();
		
		String[] columns = new String[]{
                EVENT_ID,
                EVENT_NAME,
                EVENT_TIME,
                EVENT_TYPE,
                EVENT_TAG,
                EVENT_LOCATION,
                EVENT_INTRO,
                EVENT_COLOR_CODE
		};
		Cursor cursor = db.query(TABLE_EVENT, columns, EVENT_IS_WISED + "=?", new String[]{"1"}, null, null, EVENT_TYPE +" ASC");
		if(cursor != null && cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do {
				DBEvent event = new DBEvent();
				event.setId(cursor.getInt(0));
				event.setName(cursor.getString(1));
				event.setTime(cursor.getString(2));
				event.setType(cursor.getString(3));
				event.setTag(cursor.getString(4));
				event.setLocation(cursor.getString(5));
				event.setIntro(cursor.getString(6));
				event.set_color_code(cursor.getInt(7));
				
				list.add(event);
			} while (cursor.moveToNext());
		}
		
		cursor.close();
		return list;
	}
	
	public void addEvent(DBEvent event){
	     db.execSQL("insert into " + TABLE_EVENT +" ( " 
	    		 				   + EVENT_ID            			+","
	    		 				   + EVENT_NAME          			+","
	    		 				   + EVENT_TYPE          			+","
	    		 				   + EVENT_TIME          			+","
	    		 				   + EVENT_TAG           			+","
	    		 				   + EVENT_LOCATION      			+","
	    		 				   + EVENT_INTRO         			+","
	    		 				   + EVENT_RULE          			+","
	    		 				   + EVENT_TASK          			+","
	    		 				   + EVENT_SHARE_LINK    			+","
	    		 				   + EVENT_IS_WISED		 			+","	
	    		 				   
	    		 				   + EVENT_CO1_NAME		 			+","
	    		 				   + EVENT_CO1_EMAIL				+","
	    		 				   
	    		 				   + EVENT_CO2_NAME		 		    +","
	    		 				   + EVENT_CO2_EMAIL		 		+","
	    		 				   
	    		 				   + EVENT_LAST_UPADTE		 		+","
	    		 				   + EVENT_LAST_POSTER_UPDATE		+","
	    		 				   + EVENT_COLOR_CODE		 
	    		 				   + ") values(?,?,?,?,?,?,?,?,?,?,?, ?,?, ?,?, ?,?,?);",new String[]{
	     											event.getId()+"",
	     											event.getName(),
	     											event.getType(),
	     											event.getTime(),
	     											event.getTag(),
	     											
	     											event.getLocation(),
	     											event.getIntro(),
	     											event.getRule(),
	     											event.getTask(),
	     											
	     											event.getShareLink(),
	     											event.isWised() == true ? "1":"0",
	     											
	     											event.getCo1_name(),
	     											event.getCo1_email(),
	     											
	     											event.getCo2_name(),
	     											event.getCo2_email(),
	     											
	     											event.getLast_update()+"",
	     											event.getLast_poster_update()+"",
	     											
	     											event.get_color_code()+""
	     													
	     													
		});
	}
	
	
	public void updateEvent(DBEvent event){
		
		ContentValues values = new ContentValues();
		values.put(EVENT_NAME, event.getName());
		values.put(EVENT_TYPE, event.getType());
		values.put(EVENT_TIME, event.getTime());
		values.put(EVENT_TAG, event.getTag());
		values.put(EVENT_LOCATION, event.getLocation());
		values.put(EVENT_INTRO, event.getIntro());
		values.put(EVENT_RULE, event.getRule());
		values.put(EVENT_TASK, event.getTask());
		values.put(EVENT_SHARE_LINK, event.getShareLink());
		values.put(EVENT_IS_WISED, event.isWised());
		
		values.put(EVENT_CO1_NAME, event.getCo1_name());
		values.put(EVENT_CO1_EMAIL, event.getCo1_email());
		
		values.put(EVENT_CO2_NAME, event.getCo2_name());
		values.put(EVENT_CO2_EMAIL, event.getCo2_email());
		
		values.put(EVENT_LAST_UPADTE, event.getLast_update());
		values.put(EVENT_LAST_POSTER_UPDATE, event.getLast_poster_update());
		values.put(EVENT_COLOR_CODE, event.get_color_code());
		
		db.update(TABLE_EVENT, values, EVENT_ID+"=?", new String[]{event.getId()+""});
	}
	
	public DBEvent getEvent(int id){
		
		String[] columns = new String[]{
				                EVENT_ID,
				                EVENT_NAME,
				                EVENT_TIME,
				                EVENT_TYPE,
				                EVENT_TAG,
				                EVENT_LOCATION,
				                EVENT_INTRO,
				                EVENT_TASK,
				                EVENT_RULE,
				                EVENT_SHARE_LINK,
				                EVENT_IS_WISED,
				                
				                EVENT_CO1_NAME,		 		
				                EVENT_CO1_EMAIL,			
	    		 				   
				                EVENT_CO2_NAME,	 	
				                EVENT_CO2_EMAIL,		 	

				                EVENT_LAST_UPADTE,		 	
				                EVENT_LAST_POSTER_UPDATE,
				                EVENT_COLOR_CODE
						};
		
		DBEvent event = null;
		Cursor cursor = db.query(TABLE_EVENT, columns, EVENT_ID + "=?", new String[]{id+""}, null, null, null);
		if(cursor != null && cursor.getCount() > 0){
			cursor.moveToFirst();
			
			event = new DBEvent();
			event.setId(cursor.getInt(0));
			event.setName(cursor.getString(1));
			event.setTime(cursor.getString(2));
			event.setType(cursor.getString(3));
			event.setTag(cursor.getString(4));
			event.setLocation(cursor.getString(5));
			event.setIntro(cursor.getString(6));
			event.setTask(cursor.getString(7));
			event.setRule(cursor.getString(8));
			event.setShareLink(cursor.getString(9));
			event.setWised(cursor.getString(10).equals("1"));
			
			
			event.setCo1_name(cursor.getString(11));
			event.setCo1_email(cursor.getString(12));
			
			event.setCo2_name(cursor.getString(13));
			event.setCo2_email(cursor.getString(14));
			
			event.setLast_update(Long.parseLong(cursor.getString(15)));
			event.setLast_poster_update(Long.parseLong(cursor.getString(16)));
			event.set_color_code(cursor.getInt(17));
			
		}
		cursor.close();
		return event;
	}
	
	public ArrayList<DBEvent> getEventList(){
		
		ArrayList<DBEvent> list = new ArrayList<DBEvent>();
		String[] columns = new String[]{
				EVENT_ID,
				EVENT_NAME,
				EVENT_TIME,
				EVENT_TYPE,
				EVENT_TAG,
				EVENT_LOCATION,
				EVENT_INTRO,
				EVENT_TASK,
				EVENT_RULE,
				EVENT_SHARE_LINK,
				EVENT_IS_WISED,

				EVENT_CO1_NAME,		 		
				EVENT_CO1_EMAIL,			

				EVENT_CO2_EMAIL,	 	
				EVENT_CO2_EMAIL,		 	

				EVENT_LAST_UPADTE,		 	
				EVENT_LAST_POSTER_UPDATE,	
				EVENT_COLOR_CODE
		};

		Cursor cursor = db.query(TABLE_EVENT, columns, null, null, null, null, null);
		if(cursor != null && cursor.getCount() > 0){
			cursor.moveToFirst();

			do {
				
				DBEvent event = new DBEvent();
				
				event.setId(cursor.getInt(0));
				event.setName(cursor.getString(1));
				event.setTime(cursor.getString(2));
				event.setType(cursor.getString(3));
				event.setTag(cursor.getString(4));
				event.setLocation(cursor.getString(5));
				event.setIntro(cursor.getString(6));
				event.setTask(cursor.getString(7));
				event.setRule(cursor.getString(8));
				event.setShareLink(cursor.getString(9));
				event.setWised(cursor.getString(10).equals("1"));

				event.setCo1_name(cursor.getString(11));
				event.setCo1_email(cursor.getString(12));

				event.setCo2_name(cursor.getString(13));
				event.setCo2_email(cursor.getString(14));

				event.setLast_update(Long.parseLong(cursor.getString(15)));
				event.setLast_poster_update(Long.parseLong(cursor.getString(16)));
				
				event.set_color_code(cursor.getInt(17));

				list.add(event);
				
			} while (cursor.moveToNext());			
		}
		cursor.close();
		return list;
	}
	
	
	public DBEvent getEvent(DBEventBox eventBox){
		return getEvent(eventBox.getId());
	}
	
	public boolean isEventExits(int id){
		Cursor cursor = db.rawQuery("select * from "+TABLE_EVENT+" where id=?", new String[]{id+""});
		if(cursor != null && cursor.getCount() > 0){
			cursor.close();
			return true;
		}

		cursor.close();
		return false;
	}
	
	
	
	public void removeEvent(int id){
		db.delete(TABLE_EVENT, EVENT_ID+"=?", new String[]{id+""});
		
		deleteCacheFile(Config.event_image_link(id));
	}
	
	public void removeEvent(DBEvent event){
		removeEvent(event.getId());
	}
	
	
	public void addEvents(ArrayList<DBEvent> list_new){
		ArrayList<DBEvent> list_old = getEventList();
		boolean need_notify = false;
		
		for (int i = 0; i < list_new.size(); i++) {
			
			DBEvent event_new = list_new.get(i);
			int index = list_old.indexOf(event_new);
			
			if(index >= 0){
				//for exits event
				DBEvent event_old = list_old.get(index);
				list_old.set(index, null);
				boolean needUpdate = false;
				
				if(event_new.getLast_update() > event_old.getLast_update()){
					needUpdate = true;
				}
				if(event_new.getLast_poster_update() > event_old.getLast_poster_update()){
					needUpdate = true;
					deleteCacheFile(Config.event_image_link(event_new.getId()));
				}
				
				if(needUpdate){
					event_new.setWised(event_old.isWised());
					updateEvent(event_new);
					need_notify = true;
				}
				
			}else {
				//for new event
				addEvent(event_new);
				need_notify = true;
			}
		}
		
		
		for (int i = 0; i < list_old.size(); i++) {
			if(list_old.get(i) != null){
				removeEvent(list_old.get(i));
				need_notify = true;
			}
		}
		
		if(need_notify)
			needNotify(1);
	}
		
	
	
	
	public void setWised(int id,boolean isWised){
		
		ContentValues values = new ContentValues();
		values.put(EVENT_IS_WISED, isWised == true ? "1":"0");
		
		db.update(TABLE_EVENT, values, EVENT_ID +"=?", new String[]{id+""});
	}
	
	public void setWised(DBEventBox eventBox,boolean isWised){
		setWised(eventBox.getId(),isWised);
	}
	
	public void setWised(DBEvent event){
		setWised(event.getId(), event.isWised());
	}
	
	
	
	
	public ArrayList<DBEventBox> getEventBoxList(){
		
		ArrayList<DBEventBox> list = new ArrayList<DBEventBox>();
		String[] columns = new String[]{
								EVENT_ID,
						   		EVENT_NAME,
						   		EVENT_TIME,
						   		EVENT_TYPE,
						   		EVENT_IS_WISED,
						   		EVENT_COLOR_CODE
						   };
		
		
		Cursor cursor = db.query(TABLE_EVENT, columns, null, null, null, null, EVENT_TYPE +" ASC");
		if(cursor != null && cursor.getCount() >0){
			cursor.moveToFirst();
			
			do {
				int id = cursor.getInt(0);
				String name = cursor.getString(1);
				String time = cursor.getString(2);
				String type = cursor.getString(3);
				boolean isWised = cursor.getString(4).equals("1");
				int color_code = cursor.getInt(5);
				
				list.add(new DBEventBox(id, isWised, name, time, type,color_code));
			} while (cursor.moveToNext());
			
		}
		cursor.close();
		return list;
	}
	
	
	public void close(){
		if(db != null){
			db.close();
		}
	}
	
	
	public void needNotify(int type){
		
		Handler handler = new Handler(MainActivity.cf.context.getMainLooper()){
			@Override
			public void handleMessage(Message msg) {
				if(msg.what == 1 ){
					MainActivity.macros.run(MacroTag.NOTIFY_EVENT_LIST);
					MainActivity.macros.run(MacroTag.NOTIFY_MY_SCHEDULE_LIST);
				}else if (msg.what == 2) {
					MainActivity.macros.run(MacroTag.NOTIFY_STUDENT_LIST);					
				}else if (msg.what == 3) {
					MainActivity.macros.run(MacroTag.NOTIFY_FACULTY_LIST);										
				}else if (msg.what == 4) {
					MainActivity.macros.run(MacroTag.NOTIFY_SPONSOR_LIST);
				}else if (msg.what == 5) {					
					MainActivity.macros.run(MacroTag.MENU_NOTIFICATION,true);
					MainActivity.macros.run(MacroTag.NOTIFY_NEWS_LIST);
				}
			}
		};
		handler.sendEmptyMessage(type);	
	}
	
	
	public void deleteCacheFile(String url){
		
		//MainActivity.cf.Log("delete file="+url);
		MemoryCacheUtils.removeFromCache(url, ImageLoader.getInstance().getMemoryCache());
		DiskCacheUtils.removeFromCache(url, ImageLoader.getInstance().getDiskCache());
	}
	
	
}
