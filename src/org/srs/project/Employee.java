package org.srs.project;

import java.sql.Date;

public class Employee {
	String name;
	String title;
	Date doj;
	
	public Employee(String name, String title, Date doj) {
		super();
		this.name = name;
		this.title = title;
		this.doj = doj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

}
