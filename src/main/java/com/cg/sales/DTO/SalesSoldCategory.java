package com.cg.sales.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesSoldCategory {

	private String productCategory;
	private BigDecimal TotalAmount;
}
