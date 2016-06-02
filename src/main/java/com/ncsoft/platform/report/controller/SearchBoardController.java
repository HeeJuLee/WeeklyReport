package com.ncsoft.platform.report.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncsoft.platform.report.domain.Board;
import com.ncsoft.platform.report.domain.Criteria;
import com.ncsoft.platform.report.domain.PageMaker;
import com.ncsoft.platform.report.domain.SearchCriteria;
import com.ncsoft.platform.report.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);	

	@Inject
	BoardService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria searchCri, Model model) throws Exception {
		
		logger.info(searchCri.toString());
		
		model.addAttribute("list", service.listSearch(searchCri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(searchCri);
		pageMaker.setTotalCount(service.countSearching(searchCri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno,
			@ModelAttribute("cri") SearchCriteria cri,
			Model model) throws Exception {
		
		logger.info("readPage ......");

		model.addAttribute(service.read(bno));	
	}
	
	@RequestMapping(value="/removePage", method=RequestMethod.POST)
	public String removePage(@RequestParam("bno") int bno,
			SearchCriteria cri,
			RedirectAttributes attr) throws Exception {
		
		logger.info("removePage ......");

		service.remove(bno);
		attr.addAttribute("page", cri.getPage());
		attr.addAttribute("perPageNum", cri.getPerPageNum());
		attr.addAttribute("keyword", cri.getKeyword());
		attr.addAttribute("searchType", cri.getSearchType());
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";
	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyPageGET(@RequestParam("bno") int bno,
			@ModelAttribute("cri") SearchCriteria cri,
			Model model) throws Exception {
		
		logger.info("modifyPage get ......");
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPagePOST(Board board,
			SearchCriteria cri,
			RedirectAttributes attr) throws Exception {
		
		logger.info("modifyPage post ......");
		
		service.modify(board);
		
		attr.addAttribute("page", cri.getPage());
		attr.addAttribute("pagePerNum", cri.getPerPageNum());
		attr.addAttribute("keyword", cri.getKeyword());
		attr.addAttribute("searchType", cri.getSearchType());
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(Board board, Model model) throws Exception {
		
		logger.info("register get ......");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(Board board, RedirectAttributes attr) throws Exception {
		
		logger.info("register post ......");
		logger.info(board.toString());
		
		service.regist(board);
		
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";
	}
}
