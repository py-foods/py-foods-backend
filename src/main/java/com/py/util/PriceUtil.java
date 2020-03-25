package com.py.util;

import java.math.BigDecimal;

import com.py.constant.DiscountType;

public class PriceUtil {

	private PriceUtil() {
	}

	public static BigDecimal getSalePrice(BigDecimal price, String discountType, Float discount) {
		// set default sale_price is cost_price
		BigDecimal salePrice = price;
		if (DiscountType.AMOUNT.contentEquals(discountType)) {
			// sale_price = cost_price - discount
			salePrice = Arith.sub(salePrice, BigDecimal.valueOf(discount));
		} else if (DiscountType.PERCENT.contentEquals(discountType)) {
			// sale_price = (cost_price) - (cost_price * (discount/100))
			BigDecimal percentAmt = Arith.mul(price, BigDecimal.valueOf(Arith.div(discount, 100F, 2)));
			salePrice = Arith.sub(salePrice, percentAmt);
		}
		return salePrice;
	}
}
