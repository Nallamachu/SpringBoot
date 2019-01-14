package com.boot.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
public class TestController {
	@Autowired
	EurekaClient discoveryClient;

	@GetMapping(path = "/")
	public String serviceUrl() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("EUREKA_PRODUCER", false);
		return instance.getHomePageUrl();
	}

	@GetMapping(path = "/url")
	public String serviceURL1() {
		Application application = discoveryClient.getApplication("EUREKA_PRODUCER");
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String hostname = instanceInfo.getHostName();
		int port = instanceInfo.getPort();
		return "http://"+hostname + ":" + port;
	}
}
