package com.cg.sales.DTO;

import java.math.BigDecimal;

public interface SalesResponse {
	public BigDecimal getAmountSold();
	public Integer getProdId();
	public Integer getSalesId();
}