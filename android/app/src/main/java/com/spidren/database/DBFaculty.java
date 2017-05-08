package com.spidren.database;

public class DBFaculty {
	private int id;
	
	private String name,
				   post;
	
	private long last_update,
				 last_image_update;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public long getLast_update() {
		return last_update;
	}

	public void setLast_update(long last_update) {
		this.last_update = last_update;
	}

	public long getLast_image_update() {
		return last_image_update;
	}

	public void setLast_image_update(long last_image_update) {
		this.last_image_update = last_image_update;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == null || !(obj instanceof DBFaculty))
			return false;
		
		if(obj == this)
			return true;
		
		DBFaculty faculty = (DBFaculty) obj;
		
		if(faculty.getId() == id)
			return true;
		
		return false;
	}
	
	
	
}
