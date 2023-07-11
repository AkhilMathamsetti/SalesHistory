package com.cg.sales.dto;

import java.math.BigDecimal;

public interface SalesResponse {
	public BigDecimal getAmountSold();
	public Integer getProdId();
	public Integer getSalesId();
}