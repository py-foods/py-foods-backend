package com.py.util;

import java.math.BigDecimal;

import com.py.constant.DiscountType;

public class PriceUtils {

	private PriceUtils() {
	}

	public static BigDecimal getSalePrice(BigDecimal price, String discountType, Float discount) {
		if (DiscountType.AMOUNT.contentEquals(discountType)) {
			// sale_price = cost_price - discount
			return Arith.sub(price, BigDecimal.valueOf(discount));
		}
		if (DiscountType.PERCENT.contentEquals(discountType)) {
			// sale_price = (cost_price) - (cost_price * (discount/100))
			double percent = Arith.div(discount, 100F, 2);
			BigDecimal percentAmt = Arith.mul(price, BigDecimal.valueOf(percent));
			return Arith.sub(price, percentAmt);
		}
		return price;
	}
}
