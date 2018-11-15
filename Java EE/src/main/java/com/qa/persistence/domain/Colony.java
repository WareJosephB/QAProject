package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Colony {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "playid")
	private long id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
