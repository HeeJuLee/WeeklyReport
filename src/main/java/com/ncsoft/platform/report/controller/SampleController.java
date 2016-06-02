package com.ncsoft.platform.report.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncsoft.platform.report.domain.Sample;

@RestController
@RequestMapping("/sample")
public class SampleController {

	@RequestMapping("/hello")
	public String sayHello() {
		
		return "Hello world";
	}
	
	@RequestMapping("/sendJson")
	public Sample sendSample() {
		
		Sample sample = new Sample();
		sample.setFirstName("힐리");
		sample.setLastName("Lee");
		sample.setMno(1);
		
		return sample;
	}
	
	@RequestMapping("/sendList")
	public List<Sample> sendList() {
		
		List<Sample> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Sample sample = new Sample();
			
			sample.setFirstName("힐리");
			sample.setLastName("Lee");
			sample.setMno(i);
			
			list.add(sample);
		}
		
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, Sample> sendMap() {
		Map<Integer, Sample> map = new HashMap<>();
		
		for(int i = 0; i < 10; i++) {
			Sample sample = new Sample();
			
			sample.setFirstName("힐리");
			sample.setLastName("Lee");
			sample.setMno(i);
			
			map.put(i, sample);
		}
		return map;
	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth() {
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<Sample>> sendListNot() {
		List<Sample> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			Sample sample = new Sample();
			
			sample.setFirstName("힐리");
			sample.setLastName("Lee");
			sample.setMno(i);
			
			list.add(sample);
		}
		// 결과와 상태코드를 같이 전달
		return new ResponseEntity<List<Sample>>(list, HttpStatus.NOT_FOUND);
	}
}
