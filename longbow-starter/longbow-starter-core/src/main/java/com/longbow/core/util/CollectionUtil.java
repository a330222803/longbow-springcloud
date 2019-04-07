package com.longbow.core.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.HashSet;

@Slf4j
public class CollectionUtil {

	public static Collection<String> getString(String arrString) {
		if (StringUtils.isBlank(arrString)) {
			return null;
		}
		try {
			Collection<String> collection = new HashSet<String>();
			String[] arr = arrString.split(",");
			for (String item : arr) {
				if (!ObjectUtil.isEmpty(item)) {
					collection.add(item);
				}
			}
			if (collection == null || collection.size() == 0) {
				return null;
			} else {
				return collection;
			}
		} catch (Exception e) {
			log.info("getLong, Exception:{}", e.toString());
			return null;
		}
	}

	public static Collection<Long> getLong(String arrString) {
		if (StringUtils.isBlank(arrString)) {
			return null;
		}
		try {
			Collection<Long> collection = new HashSet<Long>();
			String[] arr = arrString.split(",");
			for (String item : arr) {
				if (StringUtils.isNotBlank(item) && StringUtils.isNumeric(item)) {
					collection.add(Long.parseLong(item));
				}
			}
			if (collection == null || collection.size() == 0) {
				return null;
			} else {
				return collection;
			}
		} catch (Exception e) {
			log.info("getLong, Exception:{}", e.toString());
			return null;
		}
	}

	public static Collection<Integer> getInteger(String arrString) {
		if (StringUtils.isBlank(arrString)) {
			return null;
		}
		try {
			Collection<Integer> collection = new HashSet<Integer>();
			String[] arr = arrString.split(",");
			for (String item : arr) {
				if (StringUtils.isNotBlank(item) && StringUtils.isNumeric(item)) {
					collection.add(Integer.parseInt(item));
				}
			}
			if (collection == null || collection.size() == 0) {
				return null;
			} else {
				return collection;
			}
		} catch (Exception e) {
			log.info("getInteger, Exception:{}", e.toString());
			return null;
		}
	}

	public static Collection<Integer> getInteger(String arrString, Collection<Integer> defaultValue) {
		Collection<Integer> res = getInteger(arrString);
		if (ObjectUtil.isEmpty(res)) {
			return defaultValue;
		} else {
			return res;
		}
	}

	public static Collection<Byte> getByte(String arrString) {
		if (StringUtils.isBlank(arrString)) {
			return null;
		}
		try {
			Collection<Byte> collection = new HashSet<Byte>();
			String[] arr = arrString.split(",");
			for (String item : arr) {
				if (StringUtils.isNotBlank(item) && StringUtils.isNumeric(item)) {
					collection.add(Byte.parseByte(item));
				}
			}
			if (collection == null || collection.size() == 0) {
				return null;
			} else {
				return collection;
			}
		} catch (Exception e) {
			log.info("getInteger, Exception:{}", e.toString());
			return null;
		}
	}

	public static Collection<Byte> getByte(String arrString, Collection<Byte> defaultValue) {
		Collection<Byte> res = getByte(arrString);
		if (ObjectUtil.isEmpty(res)) {
			return defaultValue;
		} else {
			return res;
		}
	}

	public static String getQueryStr(CharSequence charSequence) {
		if (StringUtils.isBlank(charSequence)) {
			return null;
		}
		try {
			String arrString = charSequence.toString();
			if (arrString.endsWith(",")) {
				arrString = arrString.substring(0, arrString.length() - 1);
			}
			if (arrString.length() > 0) {
				return arrString;
			}
			return null;
		} catch (Exception e) {
			log.info("getQueryStr, Exception:{}", e.toString());
			return null;
		}
	}

	public static String getQueryStr(Collection<?> arr) {
		if (arr == null || arr.size() == 0) {
			return null;
		}
		try {
			StringBuffer buffer = new StringBuffer();
			for (Object o : arr) {
				if (o != null) {
					buffer.append(o.toString()).append(",");
				}
			}
			return getQueryStr(buffer.toString());
		} catch (Exception e) {
			log.info("getQueryStr, Exception:{}", e.toString());
			return null;
		}
	}

	public static String getQueryStr(Object[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		try {
			StringBuffer buffer = new StringBuffer();
			for (Object o : arr) {
				if (o != null) {
					buffer.append(o.toString()).append(",");
				}
			}
			return getQueryStr(buffer.toString());
		} catch (Exception e) {
			log.info("getQueryStr, Exception:{}", e.toString());
			return null;
		}
	}

}
