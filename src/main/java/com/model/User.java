package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author y15079
 * @create 2017-10-23 18:48
 * @desc
 **/
public class User implements Serializable {
	private static final long serialVersionUID = -7085862637232732641L;

	private String id;

	private String name;

	private String age;

	public User() {
	}

	public User(String id, String name, String age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age == null ? null : age.trim();
	}
}
