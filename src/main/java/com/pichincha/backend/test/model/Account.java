package com.pichincha.backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tsac_account")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "account_generator",
            sequenceName = "tsac_seq",
            initialValue = 1000
    )
	private Long id;

	private String number;

	@Column(length = 70)
	private String type;

	private LocalDateTime creationDate;

	public String getNumber() {
		return number;
	}

	public void setNumber(String title) {
		this.number = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String content) {
		this.type = content;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

}
