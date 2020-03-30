package com.py.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.py.dto.PageDTO;

@Component
public class PageMapper {

	@Autowired
	private ModelMapper modelMapper;

	public PageDTO toDto(Page<?> page) {
		PageDTO pageDTO = modelMapper.map(page, PageDTO.class);
		pageDTO.setHasNext(page.hasNext());
		pageDTO.setHasPrevious(page.hasPrevious());
		return pageDTO;
	}
}
