package com.spidren.database;

public class DBEventBox {
	
	
	private int id,color_code;
	private boolean isWised;
	private String name,
				   time,
				   type;
	
	
	@Override
	public String toString() {
		/*String str = "id ="+ id + System.getProperty("line.separator") + 
				     "name ="+ name + System.getProperty("line.separator") +
				     "time ="+ time + System.getProperty("line.separator") +
				     "type ="+ type + System.getProperty("line.separator") +
				     "isWised ="+ isWised + System.getProperty("line.separator")
				     ;*/
		
		String str =  
			     "name ="+ name + System.getProperty("line.separator") +
			     "type ="+ type + System.getProperty("line.separator") 
			     ;
			
		return str;
	}
	public DBEventBox(int id, boolean isWised, String name, String time, String type,int color_code) {
		this.id = id;
		this.isWised = isWised;
		this.name = name;
		this.time = time;
		this.type = type;
		this.color_code = color_code;
	}
	public int getId() {
		return id;
	}
	public boolean isWised() {
		return isWised;
	}
	public String getName() {
		return name;
	}
	public String getTime() {
		return time;
	}
	public String getType() {
		return type;
	}
	public int getColor_code() {
		return color_code;
	}
	public void setColor_code(int color_code) {
		this.color_code = color_code;
	}
	
}
