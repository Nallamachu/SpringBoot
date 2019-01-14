package com.filtering.filter.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.filtering.filter.bean.DynamicFilterBean;

@RestController
public class DynamicFilterController {

	@GetMapping(path = "/dynamic-filter")
	public MappingJacksonValue staticFilter() {
		DynamicFilterBean bean = new DynamicFilterBean(1001L, "Subbu", "xyz", "Bangalore");

		SimpleFilterProvider filters = getSimpleFilterProvider();

		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filters);
		return mapping;
	}

	@GetMapping(path = "/dynamic-filter-list")
	public MappingJacksonValue staticFilterList() {

		List<DynamicFilterBean> beanList = Arrays.asList(new DynamicFilterBean(1001L, "Subbu", "xyz", "Bangalore"),
				new DynamicFilterBean(1002L, "Nallamachu", "ABC", "Hyderabad"));
		
		SimpleFilterProvider filters = getSimpleFilterProvider();

		MappingJacksonValue mapping = new MappingJacksonValue(beanList);
		mapping.setFilters(filters);
		return mapping;
	}

	public SimpleFilterProvider getSimpleFilterProvider() {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "location");
		SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("FilterBean", filter);
		return filters;
	}
}
