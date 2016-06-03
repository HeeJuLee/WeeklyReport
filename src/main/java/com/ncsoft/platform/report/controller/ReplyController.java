package com.ncsoft.platform.report.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ncsoft.platform.report.domain.Reply;
import com.ncsoft.platform.report.service.ReplyService;

@Controller
@RequestMapping("/replies")
public class ReplyController {

	@Inject
	private ReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody Reply reply) {
		
		ResponseEntity<String> entity = null;
		try {
			service.regist(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/all/{bno}", method=RequestMethod.GET)
	public ResponseEntity<List<Reply>> list(@PathVariable("bno") Integer bno) {
		
		ResponseEntity<List<Reply>> entity = null;
		try {
			entity = new ResponseEntity<List<Reply>>(service.list(bno), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value="/{rno}", method=RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("rno") Integer rno, @RequestBody Reply reply) {
		
		ResponseEntity<String> entity = null;
		try {
			reply.setRno(rno);
			service.modify(reply);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
