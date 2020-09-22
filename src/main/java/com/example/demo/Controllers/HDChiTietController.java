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

import com.example.demo.Services.DienThoaiService;
import com.example.demo.Services.HDChiTietService;
import com.example.demo.Services.HoadonServices;
import com.example.demo.models.Customers;
import com.example.demo.models.DienThoai;
import com.example.demo.models.HDChiTiet;
import com.example.demo.models.Hoadon;

@Controller
@RequestMapping("/HDChiTiet")
public class HDChiTietController {
@Autowired
HoadonServices hoadonServices;
@Autowired
HDChiTietService HDChiTietService;
@Autowired
DienThoaiService dienThoaiService ;
@RequestMapping("/")
public String index(Model model) {
	HDChiTiet dto=new HDChiTiet();
	model.addAttribute("HDChiTiet",dto);
	model.addAttribute("action","/HDChiTiet/saveorupdate");
	return "register-HDChiTiet";
}

@ModelAttribute(name="hoadon")
public List<Hoadon> getAll(){
	
return  (List<Hoadon>) hoadonServices.findAll();
}
@ModelAttribute(name="dienthoai")
public List<DienThoai> getAll1(){
	
return  (List<DienThoai>) dienThoaiService.findAll();
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
public String save(ModelMap model,@ModelAttribute("HDChiTiet")HDChiTiet HDChiTiet) {
	HDChiTiet.setId(random());
	HDChiTiet.setIsdelete(0);
	HDChiTietService.save(HDChiTiet);
	
    HDChiTiet u=new HDChiTiet();
	model.addAttribute("HDChiTiet",u);
	return "register-HDChiTiet";
	
	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("HDChiTiet")HDChiTiet HDChiTiet) {
	//HDChiTietService.update(HDChiTiet.getName(),HDChiTiet.getGender(),HDChiTiet.getBirthday(),HDChiTiet.getEmail()
		//	,HDChiTiet.getPhone(),HDChiTiet.getPassword(),HDChiTiet.getAddress(),HDChiTiet.getId());
	HDChiTietService.save(HDChiTiet);
	model.addAttribute("HDChiTiet",HDChiTiet);
	return "register-HDChiTiet";

	}
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")Long id) {
	Optional<HDChiTiet> u= HDChiTietService.findById(id);
	if(u.isPresent()) {
		model.addAttribute("HDChiTiet", u.get());
	}else {
		model.addAttribute("HDChiTiet", new HDChiTiet());
	}
	model.addAttribute("action", "/HDChiTiet/update");
	
return "register-HDChiTiet";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")Long id
		,HttpServletRequest request,RedirectAttributes redirect) {
//employeeService.isdelete(id);
 String sql="update HDChiTiet set isdelete=1 where id=?";
 HDChiTiet HDChiTiet=new  HDChiTiet(id);
 jdbcT.update(sql,new Object[] {HDChiTiet.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());
 //model.addAttribute("customer",customerService.findAll());
return "redirect:/HDChiTiet/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		Long g=ll.get(i);
		 String sql="update HDChiTiet set isdelete=1 where id=?";
		 HDChiTiet HDChiTiet =new  HDChiTiet(g);
		 jdbcT.update(sql,new Object[] {HDChiTiet.getId()});
		//employeeService.isdelete(g);
	}
	//model.addAttribute("customer",customerService.findAll());
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/HDChiTiet/page/{id}";
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
	return "redirect:/HDChiTiet/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("customer",customerService.findAll());
	List<HDChiTiet> list =(List<HDChiTiet>) HDChiTietService.getAll();
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
	String baseUrl = "/HDChiTiet/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-HDChiTiet";
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
		return "/HDChiTiet/page";	
	}	
	List<HDChiTiet> list = HDChiTietService.findup(xuly(s));	
	if (list == null) {	
		return "/HDChiTiet/page";	
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
	String baseUrl = "/HDChiTiet/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-HDChiTiet";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/HDChiTiet/page";	
	}	
	List<HDChiTiet> list = HDChiTietService.getAll();	
	if (list == null) {	
		return "/HDChiTiet/page";	
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
	String baseUrl = "/HDChiTiet/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-HDChiTiet";	
}
}
