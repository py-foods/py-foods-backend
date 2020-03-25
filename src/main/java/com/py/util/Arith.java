package com.py.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public final class Arith {

	private static final int DEF_DIV_SCALE = 2;
	private static final DecimalFormat PRICE_FORMAT = new DecimalFormat("0.0000");
	private static final String ILLEGAL_ARGUMENT_MESSAGE = "The scale must be a positive integer or zero";

	private Arith() {
	}

	public static BigDecimal formatDec(String v1) {
		return new BigDecimal(v1);
	}

	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();
	}

	public static BigDecimal add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2);
	}

	public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
		return v1.add(v2);
	}

	public static double sub(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	public static BigDecimal sub(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2);
	}

	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		return v1.subtract(v2);
	}

	public static double mul(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}

	public static BigDecimal mul(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2);
	}

	public static BigDecimal mul(BigDecimal b1, BigDecimal b2) {
		return b1.multiply(b2);
	}

	public static double div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static BigDecimal div(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal divUp(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_UP);
	}

	public static BigDecimal divDown(String v1, String v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2, scale, BigDecimal.ROUND_DOWN);
	}

	public static double round(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static BigDecimal roundUp(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_UP);
	}

	public static BigDecimal roundDown(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}

		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_DOWN);
	}

	public static int compareTo(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.compareTo(b2);
	}

	public static int compareTo(BigDecimal v1, BigDecimal v2) {
		return v1.compareTo(v2);
	}

	public static String addDouble(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return PRICE_FORMAT.format(b1.add(b2));
	}

	public static String subDouble(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return PRICE_FORMAT.format(b1.subtract(b2));
	}

	public static String mulDouble(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return PRICE_FORMAT.format(b1.multiply(b2));
	}

	public static String divDouble(double v1, double v2) {
		return PRICE_FORMAT.format(div(v1, v2, DEF_DIV_SCALE));
	}

	public static String divDouble(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return PRICE_FORMAT.format(b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP));
	}

	public static String roundDouble(double v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return PRICE_FORMAT.format(b.divide(one, scale, BigDecimal.ROUND_HALF_UP));
	}

	public static String getString(Double v) {
		if (v == null) {
			return "0.0000";
		}
		return PRICE_FORMAT.format(v);
	}

	public static BigDecimal decimal(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_DOWN);
	}

	public static BigDecimal jingdu(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}

		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal roundUpDecimal(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_UP);
	}

	public static BigDecimal roundDownDecimal(BigDecimal v, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
		}
		BigDecimal one = new BigDecimal("1");
		return v.divide(one, scale, BigDecimal.ROUND_DOWN);
	}
}
