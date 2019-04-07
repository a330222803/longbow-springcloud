package com.longbow.core.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Object常用的工具
 * 
 * @author yonghua.cao
 *
 */
public class ObjectUtil {

	public static boolean isEmpty(final Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof CharSequence) {
			return StringUtils.isBlank(object.toString());
		}
		if (object instanceof Collection) {
			return ((Collection<?>) object).isEmpty();
		}
		if (object instanceof Map) {
			return ((Map<?, ?>) object).isEmpty();
		}
		return false;
	}

	public static boolean isAnyEmpty(final Object... objects) {
		if (ArrayUtils.isEmpty(objects)) {
			return true;
		}
		for (final Object object : objects) {
			if (isEmpty(object)) {
				return true;
			}
		}
		return false;
	}
}
