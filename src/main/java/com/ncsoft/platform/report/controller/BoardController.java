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
import com.ncsoft.platform.report.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET(Board board, Model model) throws Exception {
		
		logger.info("register get ......");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	//public String registerPOST(Board board, Model model) throws Exception {
	public String registerPOST(Board board, RedirectAttributes attr) throws Exception {
		
		logger.info("register post ......");
		logger.info(board.toString());
		
		service.regist(board);
		
		//model.addAttribute("result", "success");
		attr.addFlashAttribute("msg", "SUCCESS");
		
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		
		logger.info("show all list ......");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listCriteria(Criteria cri, Model model) throws Exception {
		
		logger.info("show criteria list ......");
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value="/listPage", method=RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception {
		
		logger.info(cri.toString());
		model.addAttribute("list", service.listCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.countPaging());
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception {
		
		logger.info("read ......");

		model.addAttribute(service.read(bno));	
	}
	
	@RequestMapping(value="/readPage", method=RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno,
			@ModelAttribute("cri") Criteria cri,
			Model model) throws Exception {
		
		logger.info("readPage ......");

		model.addAttribute(service.read(bno));	
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modifyGET(int bno, Model model) throws Exception {
		
		logger.info("modify get ......");
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(Board board, RedirectAttributes attr) throws Exception {
		
		logger.info("modify post ......");
		
		service.modify(board);
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyPageGET(@RequestParam("bno") int bno,
			@ModelAttribute("cri") Criteria cri,
			Model model) throws Exception {
		
		logger.info("modifyPage get ......");
		
		model.addAttribute(service.read(bno));
	}
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPagePOST(Board board,
			Criteria cri,
			RedirectAttributes attr) throws Exception {
		
		logger.info("modifyPage post ......");
		
		service.modify(board);
		
		attr.addAttribute("page", cri.getPage());
		attr.addAttribute("pagePerNum", cri.getPerPageNum());
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes attr) throws Exception {
		
		logger.info("remove ......");

		service.remove(bno);
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/removePage", method=RequestMethod.POST)
	public String removePage(@RequestParam("bno") int bno,
			Criteria cri,
			RedirectAttributes attr) throws Exception {
		
		logger.info("removePage ......");

		service.remove(bno);
		attr.addAttribute("page", cri.getPage());
		attr.addAttribute("perPageNum", cri.getPerPageNum());
		attr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}
}
