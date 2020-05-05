package com.py.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;
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

	public static Integer parseInt(String val, Integer defaultValue) {
		try {
			return Integer.parseInt(val);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	/**
	 * Cast a list to another one by mapping function
	 * 
	 * @param source
	 * @param func
	 * @return
	 */
	public static final <S, T> List<T> asList(List<S> source, Function<S, T> func) {
		if (source == null || source.isEmpty()) {
			return Collections.emptyList();
		}
		return source.stream().map(func).collect(Collectors.toList());
	}

	/**
	 * Cast a set to another one by mapping function
	 * 
	 * @param source
	 * @param func
	 * @return
	 */
	public static final <S, T> Set<T> asSet(Set<S> source, Function<S, T> func) {
		if (source == null || source.isEmpty()) {
			return Collections.emptySet();
		}
		return source.stream().map(func).collect(Collectors.toSet());
	}
}
