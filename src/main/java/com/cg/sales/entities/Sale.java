package com.cg.sales.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="sales")
public class Sale {

	@Id
	@Column(name="sales_id")
	private int salesId;

	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="prod_id")
	private Product product;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="cust_id")
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="time_id")
	private Time time;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="channel_id")
	private Channel channel;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="promo_id")
	private Promotion promotion;

	@Column(name="quantity_sold")
	private int quantitySold;
	
	@Column(name="amount_sold")
	private BigDecimal amountSold;
}
