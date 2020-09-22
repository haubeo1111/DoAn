package com.example.demo.Controllers;

import java.awt.Dialog.ModalExclusionType;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.TienLuongService;
import com.example.demo.models.KhuyenMai;
import com.example.demo.models.vidu;

@Controller
//@Validated
public class viduController {
	@Autowired
	TienLuongService tienluongService;
	@RequestMapping("/tien")
	public String tien(ModelMap model) {
		String a="2466551089525275455";
		Long id=Long.parseLong(a);
		int ngay=tienluongService.ngaylam(id);
		model.addAttribute("tienluong",ngay);
		return "view-TienLuong";
		
	}
	@RequestMapping("/kl")
	public String kl() {
		return "kl";
	}
//	@GetMapping("/hello")
////	public String hello(@RequestParam @Min(10) Integer id) {
//		return id + "";
//	}
	@RequestMapping("/vidu3")
	public String vv(ModelMap model) {
		vidu dto=new vidu();
		model.addAttribute("vidu",dto);
		model.addAttribute("action","/vidu3s");
		return "vidu3";
	}
	//@PostMapping("/student")
	//public String student(@Valid @RequestBody Student student) {
	//	return student.getName();
	//}
	@RequestMapping("/vidu3s")
	public String vidu3(@Valid @ModelAttribute("vidu") vidu vidu,BindingResult binding) {
		if(binding.hasErrors()) {
			System.out.println("da co loi");
		} 
		return 	"vidu3";
	}
	@RequestMapping("/mm")

	public String mm(Model model ) {
		return "m1";
	}
@RequestMapping("/vidu")

public String vidu(Model model ) {
	String aa[]= {"hau","ha","hao"};
	model.addAttribute("hkt",aa);
	return "vidu";
}
@RequestMapping("/vidu1")

public String vidu1(Model model ) {
	String aa[]= {"hau","ha","hao"};
	model.addAttribute("hkt",aa);
	return "vidu1";
}
@RequestMapping("/vidu2")

public String vidu2(Model model ) {
	String aa[]= {"hau","ha","hao"};
	model.addAttribute("hkt",aa);
	return "vidu2";
}
@RequestMapping("/tudong1")
public String tudong(Model model ) {
	String aa[]= {"hau","ha","hao","ngan","diep","thu","tien","phuong"};
	model.addAttribute("hau",aa);
	return "tudong1";
}
@RequestMapping("/")
public String vv(Model model) {
return "index";

}
}
