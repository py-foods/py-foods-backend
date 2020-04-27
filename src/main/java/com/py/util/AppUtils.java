package com.py.util;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 * @author vmdat
 * @create 23/03/2020
 */
@Component
public class AppUtils {

	private static final Integer PAGE_DEFAULT = 12;

	public Pageable getPageable(Integer page, Integer size, String field, Boolean isDesc) {
		if (field == null || field.isEmpty() || isDesc == null) {
			return PageRequest.of(page == null ? 0 : page, size == null ? PAGE_DEFAULT : size);
		}
		return PageRequest.of(page == null ? 0 : page, size == null ? PAGE_DEFAULT : size,
				isDesc ? Sort.Direction.DESC : Sort.Direction.ASC, field);
	}

	public static Long parseLong(String val) {
		try {
			return Long.parseLong(val);
		} catch (Exception e) {
			return null;
		}
	}

	public static Integer parseInt(String val) {
		try {
			return Integer.parseInt(val);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convert list object from object type A to object type B by mapping function
	 * 
	 * @param source List<S> source object
	 * @param func mappingFunction
	 * @return
	 */
	public static final <S, T> List<T> toList(List<S> source, Function<S, T> func) {
		if (source == null || source.isEmpty()) {
			return Collections.emptyList();
		}
		return source.stream().map(func).collect(Collectors.toList());
	}
}
