package com.py.util;

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
}
