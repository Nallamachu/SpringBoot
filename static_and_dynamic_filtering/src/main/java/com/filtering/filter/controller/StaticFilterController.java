package com.filtering.filter.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filtering.filter.bean.StaticFilterBean;

@RestController
public class StaticFilterController {

	@GetMapping(path = "/static-filter")
	public StaticFilterBean staticFilter() {
		return new StaticFilterBean(1001L, "Subbu", "xyz", "Bangalore");
	}

	@GetMapping(path = "/static-filter-list")
	public List<StaticFilterBean> staticFilterList() {

		return Arrays.asList(new StaticFilterBean(1001L, "Subbu", "xyz", "Bangalore"),
				new StaticFilterBean(1002L, "Nallamachu", "ABC", "Hyderabad"));

	}

}
