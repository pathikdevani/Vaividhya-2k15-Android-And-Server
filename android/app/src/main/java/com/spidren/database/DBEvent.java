package com.spidren.database;

public class DBEvent {

	

	private int id;
	private boolean isWised;
	private String name,
				   time,
				   type,
				   tag,
				   location,
				   intro,
				   task,
				   rule,
				   shareLink;
	
	private String co1_name,
				   co1_email,
				   co2_name,
				   co2_email;
				   
    private long last_update,
				 last_poster_update;
	private int color_code;
	
	
	@Override
	public String toString() {
		
		String str = "id =" + id + System.getProperty("line.separator") +
					 "name =" + name + System.getProperty("line.separator") +
					 "time =" + time + System.getProperty("line.separator") +
					 "type =" + type + System.getProperty("line.separator") +
					 "tag =" + tag + System.getProperty("line.separator") +
					 "location =" + location + System.getProperty("line.separator") +
					 "intro =" + intro + System.getProperty("line.separator") +
					 "task =" + task + System.getProperty("line.separator") +
					 "rule =" + rule + System.getProperty("line.separator") +
					 "shareLink =" + shareLink + System.getProperty("line.separator")+
					 "isWised =" + isWised + System.getProperty("line.separator") 
					 ;
		return str;
	}
	public DBEvent(){
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isWised() {
		return isWised;
	}
	public void setWised(boolean isWised) {
		this.isWised = isWised;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	public String getShareLink() {
		return shareLink;
	}
	public void setShareLink(String shareLink) {
		this.shareLink = shareLink;
	}
	public String getCo1_name() {
		return co1_name;
	}
	public void setCo1_name(String co1_name) {
		this.co1_name = co1_name;
	}
	public String getCo1_email() {
		return co1_email;
	}
	public void setCo1_email(String co1_email) {
		this.co1_email = co1_email;
	}
	public String getCo2_name() {
		return co2_name;
	}
	public void setCo2_name(String co2_name) {
		this.co2_name = co2_name;
	}
	public String getCo2_email() {
		return co2_email;
	}
	public void setCo2_email(String co2_email) {
		this.co2_email = co2_email;
	}
	public long getLast_update() {
		return last_update;
	}
	public void setLast_update(long last_update) {
		this.last_update = last_update;
	}
	public long getLast_poster_update() {
		return last_poster_update;
	}
	public void setLast_poster_update(long last_poster_update) {
		this.last_poster_update = last_poster_update;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof DBEvent))
			return false;
		
		if(obj == this)
			return true;
		
		DBEvent event = (DBEvent) obj;
		
		if(event.getId() == id)
			return true;
		
		return false;
	}
	public void set_color_code(int color_code) {
		this.color_code = color_code;
	}
	
	public int get_color_code() {
		return color_code;
	}
	
}
