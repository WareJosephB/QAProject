package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Corporation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "corpid")
	private long id;
	private String name;
	private int extraPreludes;
	private int extraColonies;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExtraPreludes() {
		return extraPreludes;
	}

	public void setExtraPreludes(int extraPreludes) {
		this.extraPreludes = extraPreludes;
	}

	public int getExtraColonies() {
		return extraColonies;
	}

	public void setExtraColonies(int extraColonies) {
		this.extraColonies = extraColonies;
	}

}
