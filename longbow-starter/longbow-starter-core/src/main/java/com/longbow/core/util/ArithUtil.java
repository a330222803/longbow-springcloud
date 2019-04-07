package com.longbow.core.util;

import java.math.BigDecimal;

/**
 * 使用Java，double 进行运算时，经常出现精度丢失的问题，总是在一个正确的结果左右偏0.0000**1。
 * 特别在实际项目中，通过一个公式校验该值是否大于0，如果大于0我们会做一件事情，小于0我们又处理其他事情。
 * 这样的情况通过double计算出来的结果去和0比较大小，尤其是有小数点的时候，经常会因为精度丢失而导致程序处理流程出错。
 * 所以一般对double类型进行运算时，做好对结果进行处理，然后拿这个值去做其他事情。
 * http://zhaow-381002134.iteye.com/blog/420369
 * 在大多数情况下，使用double和float计算的结果是准确的，但是在一些精度要求很高的系统中，这种问题是非常严重的。
 * 在《Effective Java》中提到一个原则，那就是float和double只能用来作科学计算或者是工程计算，
 * 但在商业计算中我们要用java.math.BigDecimal，通过使用BigDecimal类我们可以解决上述问题
 * http://blog.csdn.net/yinan9/article/details/17283081
 * Created by zhangbin on 2017/4/6.
 */
public final class ArithUtil {

    private static final int DEF_DIV_SCALE = 10;

    private ArithUtil() {
    }

    /**
     * double 相加
     *
     * @param d1 一个数
     * @param d2 一个数
     * @return 求和结果
     */
    public static double add(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();

    }

    /**
     * double 相减
     *
     * @param d1 被减数
     * @param d2 减数
     * @return 差值
     */
    public static double sub(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.subtract(b2).doubleValue();

    }

    /**
     * double 乘法
     *
     * @param d1 一个因子
     * @param d2 另个因子
     * @return 积
     */
    public static double mul(double d1, double d2) {
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.multiply(b2).doubleValue();

    }

    /**
     * double 除法
     *
     * @param d1 被除数
     * @param d2 除数
     * @return 值
     */
    public static double div(double d1, double d2) {
        return div(d1, d2, DEF_DIV_SCALE);
    }

    /**
     * double 除法
     *
     * @param d1    被除数
     * @param d2    除数
     * @param scale 四舍五入
     * @return 值
     */
    public static double div(double d1, double d2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(d1));
        BigDecimal b2 = new BigDecimal(Double.toString(d2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
