package com.cg.sales.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalesQtysCategory {

	private String prodCategory;
	private Long quantitySold;
}
