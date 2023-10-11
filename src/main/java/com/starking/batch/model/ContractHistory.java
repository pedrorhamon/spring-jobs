package com.starking.batch.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

/**
 * @author pedroRhamon
 */
@Entity
@Setter
@Getter
public class ContractHistory {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String contractId;
	private String holderName;
	private int duration;
	private double amount;
	private Date creationDate;
	private String status;
}
