package com.longbow.core.util;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 货币转换的工具类
 * <p>
 * Created by zhangbin on 2017/7/6.
 */
public class CurrencyUtils {

    public static final int DEFAULT_SCALE = 2;

    protected static final Map<String, NumberFormat> FORMAT_CACHE = new ConcurrentHashMap<>();

    /**
     * 提供一种缓存的方式来提高获取货币区域
     *
     * @param locale   the Locale
     * @param currency the Currency
     * @return either a new NumberFormat instance, or one taken from the cache
     */
    public static NumberFormat getNumberFormatFromCache(Locale locale, Currency currency) {
        String key = locale.toString() + currency.getCurrencyCode();
        if (!FORMAT_CACHE.containsKey(key)) {
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            format.setCurrency(currency);
            FORMAT_CACHE.put(key, format);
        }
        return FORMAT_CACHE.get(key);
    }

    public static NumberFormat getNumberFormatFromCache(Locale locale) {
        Currency currency = Currency.getInstance(locale);
        String key = locale.toString() + currency.getCurrencyCode();
        if (!FORMAT_CACHE.containsKey(key)) {
            NumberFormat format = NumberFormat.getCurrencyInstance(locale);
            format.setCurrency(currency);
            FORMAT_CACHE.put(key, format);
        }
        return FORMAT_CACHE.get(key);
    }

    /**
     * 获取精度
     *
     * @param currency
     * @return
     */
    public static int getScaleForCurrency(Currency currency) {
        if (currency != null) {
            return currency.getDefaultFractionDigits();
        } else {
            return DEFAULT_SCALE;
        }
    }

    /**
     * Attempts to load a default currency by using the default locale.
     * {@link Currency#getInstance(Locale)} uses the country component of the locale to resolve the currency.
     * In some instances, the locale may not have a country component, in which case the default currency can be controlled with a
     * system property.
     *
     * @return The default currency to use when none is specified
     */
    public static Currency defaultCurrency() {
        if (System.getProperty("currency.default") != null) {
            return Currency.getInstance(System.getProperty("currency.default"));
        }
        Locale locale = Locale.getDefault();
        if (locale.getCountry() != null && locale.getCountry().length() == 2) {
            return Currency.getInstance(locale);
        }
        return Currency.getInstance("CNY");
    }
}
