package com.hello.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Holloworld entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "holloworld", catalog = "helloworld")
public class Holloworld implements java.io.Serializable {

	// Fields

	private Integer id;
	private String say;
	private String sayAgain;

	// Constructors

	/** default constructor */
	public Holloworld() {
	}

	/** full constructor */
	public Holloworld(String say, String sayAgain) {
		this.say = say;
		this.sayAgain = sayAgain;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Say", length = 45)
	public String getSay() {
		return this.say;
	}

	public void setSay(String say) {
		this.say = say;
	}

	@Column(name = "sayAgain", length = 45)
	public String getSayAgain() {
		return this.sayAgain;
	}

	public void setSayAgain(String sayAgain) {
		this.sayAgain = sayAgain;
	}

}