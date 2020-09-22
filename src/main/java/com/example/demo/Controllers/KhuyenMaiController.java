package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Services.KhuyenMaiService;
import com.example.demo.Services.LoaiDTService;
import com.example.demo.Services.LoaiKMService;
import com.example.demo.models.KhuyenMai;
import com.example.demo.models.LoaiDT;
import com.example.demo.models.LoaiKM;
import com.example.demo.models.DienThoai;

@Controller
@RequestMapping("/KhuyenMai")
public class KhuyenMaiController {
@Autowired
KhuyenMaiService khuyenMaiService;
@Autowired
LoaiKMService loaiKMService;
@Autowired
LoaiDTService LoaiDTService;
@RequestMapping("/")
public String index(Model model) {
	KhuyenMai dto=new KhuyenMai();
	model.addAttribute("KhuyenMai",dto);
	model.addAttribute("action","/KhuyenMai/saveorupdate");
	return "register-KhuyenMai";
}

@ModelAttribute(name="loaiKM")
public List<LoaiKM> getAll(){
	
return  (List<LoaiKM>) loaiKMService.findAll();
}
@ModelAttribute(name="loaidt")
public List<LoaiDT> getAll1(){
	
return  (List<LoaiDT>) LoaiDTService.getAll();
}
public long random() {
	Random rd = new Random();
	long longNumber = rd.nextLong();
	if(longNumber<0) {return (-1*longNumber);}
	return longNumber;
}
//Kiem Tra Loi
//tat ca loi co the xay ra
//chon dong tren trang
//hien thi tong so
//tim kiem giu lai
//
@PostMapping("/saveorupdate")
public String save(ModelMap model,@ModelAttribute("KhuyenMai")KhuyenMai KhuyenMai) {
	KhuyenMai.setId(random());
	khuyenMaiService.save(KhuyenMai);
    KhuyenMai u=new KhuyenMai();
	model.addAttribute("KhuyenMai",u);
	return "register-KhuyenMai";
	
	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("KhuyenMai")KhuyenMai KhuyenMai) {
	//KhuyenMaiService.update(KhuyenMai.getName(),KhuyenMai.getGender(),KhuyenMai.getBirthday(),KhuyenMai.getEmail()
		//	,KhuyenMai.getPhone(),KhuyenMai.getPassword(),KhuyenMai.getAddress(),KhuyenMai.getId());
	khuyenMaiService.save(KhuyenMai);
	model.addAttribute("KhuyenMai",KhuyenMai);
	return "register-KhuyenMai";

	}
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")Long id) {
	Optional<KhuyenMai> u= khuyenMaiService.findById(id);
	if(u.isPresent()) {
		model.addAttribute("KhuyenMai", u.get());
	}else {
		model.addAttribute("KhuyenMai", new KhuyenMai());
	}
	model.addAttribute("action", "/KhuyenMai/update");
	
return "register-KhuyenMai";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")long id
		,HttpServletRequest request,RedirectAttributes redirect) {
//employeeService.isdelete(id);
 String sql="update KhuyenMai set isdelete=1 where id=?";
 KhuyenMai KhuyenMai=new  KhuyenMai(id);
 jdbcT.update(sql,new Object[] {KhuyenMai.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());

return "redirect:/KhuyenMai/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		long g=ll.get(i);
		 String sql="update KhuyenMai set isdelete=1 where id=?";
		 KhuyenMai KhuyenMai =new  KhuyenMai(g);
		 jdbcT.update(sql,new Object[] {KhuyenMai.getId()});
		//employeeService.isdelete(g);
	}
	
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/KhuyenMai/page/{id}";
}
@GetMapping("/page")
public String index(Model model,HttpServletRequest request
		,RedirectAttributes redirect) {
	request.getSession().setAttribute("employeelist", null);
	// RedirectView redirectView = new RedirectView();
	  //  redirectView.setUrl("http://www.yahoo.com");
	    //return redirectView;
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	   //return "redirect:/accounts/{id}";
	//if(model.asMap().get("success") != null)
	//	redirect.addFlashAttribute("success",model.asMap().get("success").toString());
	return "redirect:/KhuyenMai/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("customer",customerService.findAll());
	List<KhuyenMai> list =(List<KhuyenMai>) khuyenMaiService.getAll();
	System.out.println(list.size());
	if (pages == null) {
		pages = new PagedListHolder<>(list);
		pages.setPageSize(pagesize);
	} else {
		final int goToPage = pageNumber - 1;
		if (goToPage <= pages.getPageCount() && goToPage >= 0) {
			pages.setPage(goToPage);
		}
	}
	request.getSession().setAttribute("employeelist", pages);
	int current = pages.getPage() + 1;
	int begin = Math.max(1, current - list.size());
	int end = Math.min(begin + 5, pages.getPageCount());
	int totalPageCount = pages.getPageCount();
	String baseUrl = "/KhuyenMai/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-KhuyenMai";
}
public String xuly(String name) {
name.trim();
String tim="";
List<String> T=new ArrayList<>();
String[] words = name.split("\\s");
for (String w : words) {
	   System.out.println(w);
	   T.add(w);
}
for(int i=0;i<T.size();i++) {
	if(i==T.size()-1) {
		tim=tim+T.get(i);
	}else {
	tim=tim+T.get(i)+"|" ;
	}
}
 System.out.println("so ls: "+ tim);
			return tim;
}
@GetMapping("/search")	
public String search(@RequestParam("s") String s, Model model, HttpServletRequest request	
	) {	
	if (s.equals("")) {	
		return "/KhuyenMai/page";	
	}	
	List<KhuyenMai> list = khuyenMaiService.findup(xuly(s));	
	if (list == null) {	
		return "/KhuyenMai/page";	
	}	
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");	
	int pagesize = 3;	
	pages = new PagedListHolder<>(list);	
	pages.setPageSize(pagesize);	
		
	//final int goToPage = pageNumber - 1;	
	//if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
	//	pages.setPage(goToPage);	
	//}	
	//request.getSession().setAttribute("employeelist", pages);	
	int current = pages.getPage() + 1;	
	int begin = Math.max(1, current - list.size());	
	int end = Math.min(begin + 5, pages.getPageCount());	
	int totalPageCount = pages.getPageCount();	
	String baseUrl = "/KhuyenMai/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-KhuyenMai";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/KhuyenMai/page";	
	}	
	List<KhuyenMai> list = khuyenMaiService.getAll();	
	if (list == null) {	
		return "/KhuyenMai/page";	
	}	
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");	
	int pagesize = 3;	
	pages = new PagedListHolder<>(list);	
	pages.setPageSize(pagesize);	
		
	final int goToPage = Integer.parseInt(s) - 1;	
	if (goToPage <= pages.getPageCount() && goToPage >= 0) {	
		pages.setPage(goToPage);	
	}	
	request.getSession().setAttribute("employeelist", pages);	
	int current = pages.getPage() + 1;	
	int begin = Math.max(1, current - list.size());	
	int end = Math.min(begin + 5, pages.getPageCount());	
	int totalPageCount = pages.getPageCount();	
	String baseUrl = "/KhuyenMai/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-KhuyenMai";	
}
}
