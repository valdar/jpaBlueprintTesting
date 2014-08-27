package com.redhat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by valdar on 21/08/14.
 */
@Entity
@Table(name = "TestModel")
public class TestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "TestMessage")
    private String testMessage;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTestMessage() {
		return testMessage;
	}
	public void setTestMessage(String testMessage) {
		this.testMessage = testMessage;
	}
}
