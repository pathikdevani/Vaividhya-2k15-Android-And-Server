package com.spidren.database;

public class DBNews {
	
	public int id;
	
	private String title,
		           content;
	private int isNew;
	private long lastUpdate;

	public long getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(long lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int isNew() {
		return isNew;
	}

	public void setNew(int isNew) {
		this.isNew = isNew;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContain() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof DBNews))
			return false;
		
		if(obj == this)
			return true;
		
		DBNews event = (DBNews) obj;
		
		if(event.getId() == id)
			return true;
		
		return false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
