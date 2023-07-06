package com.mycgv_jsp.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycgv_jsp.service.FileServiceImpl;
import com.mycgv_jsp.service.MemberService;
import com.mycgv_jsp.service.NoticeService;
import com.mycgv_jsp.service.PageServiceImpl;
import com.mycgv_jsp.vo.MemberVo;
import com.mycgv_jsp.vo.NoticeVo;

@Controller
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private PageServiceImpl pageService;
	@Autowired
	private FileServiceImpl fileService;
	
	/*
	 *  admin_index.do 관리자 페이지
	 */
	
	@RequestMapping(value="/admin_index.do", method=RequestMethod.GET)
	public String admin_index() {
		return "/admin/admin_index";
	}
	
	
	
	/*
	 *  공지사항 등록하기
	 */
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {
		
		return "admin/notice/admin_notice_write";
	}

	
	/*
	 *  공지사항 등록 proc
	 */
	@RequestMapping(value="/admin_notice_write_proc.do", method=RequestMethod.POST)
	public String admin_notice_write_proc(NoticeVo noticeVo, HttpServletRequest request) throws Exception {
		String viewName = "";
		
		
		
		int result = noticeService.insert(fileService.multiFileCheck(noticeVo));
		if(result == 1) {
			if(!noticeVo.getFiles()[0].getOriginalFilename().equals("")) {
				fileService.multiFileSave(noticeVo, request);
			}
			viewName = "redirect:/admin_notice_list.do";
		}
		return viewName;
	}
	
	
	/*
	 *  공지사항 상세 보기
	 */
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		
		NoticeVo noticeVo = noticeService.getContent(nid);
		/*
		 * if(boardVo != null) { // 조회수 업데이트 DB boardDao.updateHits(bid); }
		 */
		model.addObject("nvo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_content");
		
		return model;
	}
	
	/*
	 *  공지사항 수정하기
	 */
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String nid) {
		ModelAndView model = new ModelAndView();
		
		NoticeVo noticeVo = noticeService.getContent(nid);
		/*
		 * if(boardVo != null) { // 조회수 업데이트 DB boardDao.updateHits(bid); }
		 */
		model.addObject("nvo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_update");
		
		return model;
	}
	
	/*
	 *  공지사항 수정 proc
	 */
	@RequestMapping(value="/admin_notice_update_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_update_proc(NoticeVo noticeVo, HttpServletRequest request) throws Exception {
		
		ArrayList<String> oldFileName = noticeVo.getNsfiles();
		
		ModelAndView model = new ModelAndView();
		int result = noticeService.update(fileService.multiFileCheck(noticeVo));
		
		if(result ==1) {
			fileService.multiFileSave(noticeVo, request);
			fileService.multiFileDelete(noticeVo, request, oldFileName);
		}
		/*
		 * if(boardVo != null) { // 조회수 업데이트 DB boardDao.updateHits(bid); }
		 */
		model.setViewName("redirect:/admin_notice_content.do?nid="+noticeVo.getNid());
		return model;
	}
	
	
	/*
	 *  공지사항 삭제하기 페이지
	 */
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("nid", nid);
		model.setViewName("/admin/notice/admin_notice_delete");
		/*
		 * if(boardVo != null) { // 조회수 업데이트 DB boardDao.updateHits(bid); }
		 */
		
		
		return model;
	}
	
		/*
		 * 공지사항 삭제 proc
		 */
		@RequestMapping(value="/admin_notice_delete_proc.do", method=RequestMethod.POST)
		public ModelAndView admin_notice_delete_proc(String nid) {
			ModelAndView model = new ModelAndView();
			int result = noticeService.delete(nid);
			
			if(result ==1) {
				model.setViewName("redirect:/admin_notice_list.do");
			}
			/*
			 * if(boardVo != null) { // 조회수 업데이트 DB boardDao.updateHits(bid); }
			 */
			
			return model;
		}
	
	
		
		// 회원 페이지 페이징
		@RequestMapping(value = "/admin_member_list.do", method = RequestMethod.GET)
		public ModelAndView admin_member_list(String page) {
			ModelAndView model = new ModelAndView();
			Map<String, Integer> param = pageService.getPageResult(page, "member");


			ArrayList<MemberVo> list = memberService.getList(param.get("startCount"), param.get("endCount"));
			
			model.addObject("list", list);
			model.addObject("totals", param.get("dbCount"));
			model.addObject("pageSize", param.get("pageSize"));
			model.addObject("maxSize", param.get("maxSize"));
			model.addObject("page", param.get("page"));

			model.setViewName("/admin/member/admin_member_list");

			return model;
		}
		
		
	
	
		// 어드민 공지사항 페이지 페이징
		@RequestMapping(value = "/admin_notice_list.do", method = RequestMethod.GET)
		public ModelAndView admin_notice_list(String page) {
			ModelAndView model = new ModelAndView();
			Map<String, Integer> param = pageService.getPageResult(page, "notice");


			ArrayList<NoticeVo> list = noticeService.getList(param.get("startCount"), param.get("endCount"));
			
			model.addObject("list", list);
			model.addObject("totals", param.get("dbCount"));
			model.addObject("pageSize", param.get("pageSize"));
			model.addObject("maxSize", param.get("maxSize"));
			model.addObject("page", param.get("page"));

			model.setViewName("/admin/notice/admin_notice_list");

			return model;
		}
	
	
	
	
	
	
}
