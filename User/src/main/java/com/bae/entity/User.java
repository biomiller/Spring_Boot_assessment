package com.bae.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
	
    private Long memberNumber;
	private String name;
	
	public User() {
		super();
	}

	public Long getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	

}
