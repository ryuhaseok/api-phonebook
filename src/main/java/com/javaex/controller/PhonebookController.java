package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PersonVo;

@RestController
public class PhonebookController {
	
	@Autowired
	private PhonebookService phonebookService;
	
	
	//삭제
	@DeleteMapping("/api/phonebooks/delete")
	public JsonResult deletePhonebook(@RequestBody int no) {
		System.out.println("PhonebookController.deletePhonebook()");
		
		phonebookService.exeDelete(no);
	
		return JsonResult.success("삭제했습니다.");
	}
	
	//수정폼 정보가져오기
	@GetMapping("/api/phonebooks/modify")
	public PersonVo modifyForm(@RequestParam(value="personId") int no) {
		System.out.println("PhonebookController.modifyForm()");
		
		PersonVo personVo = phonebookService.exeModifyForm(no);
		
		return personVo;
	}
	
	//수정
	@PutMapping("/api/phonebooks/modify")
	public JsonResult modify(@RequestBody PersonVo personVo) {
		System.out.println("PhonebookController.modify()");
		
		phonebookService.exeModify(personVo);
		
		return JsonResult.success("수정했습니다.");
	}
	
	//등록
	@PostMapping("/api/phonebooks/write")
	public JsonResult write(@RequestBody PersonVo personVo) {
		System.out.println("PhonebookController.write()");
		
		phonebookService.exeWrite(personVo);
		
		return JsonResult.success("등록 성공했습니다.");
	}
	
	//리스트
	@GetMapping(value="/api/phonebooks")
	public List<PersonVo> list() {
		System.out.println("PhonebookController.list()");
		
		List<PersonVo> pList = phonebookService.exeList();
		System.out.println(pList);
		
		return pList;
	}

}
