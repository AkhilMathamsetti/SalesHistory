package com.cg.sales.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesQtysCategoryYear {

	private String prodCategory;
	private Long totalQuantity;
}
