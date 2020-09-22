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

import com.example.demo.Services.BaoHanhService;
import com.example.demo.Services.DienThoaiService;
import com.example.demo.models.BaoHanh;
import com.example.demo.models.ChucVu;
import com.example.demo.models.DienThoai;

@Controller
@RequestMapping("/baoHanh")
public class BaoHanhController {
@Autowired
BaoHanhService baoHanhService;
@Autowired
DienThoaiService dienThoaiService;
@RequestMapping("/")
public String index(Model model) {
	BaoHanh dto=new BaoHanh();
	model.addAttribute("baoHanh",dto);
	model.addAttribute("action","/baoHanh/saveorupdate");
	return "register-baoHanh";
}

@ModelAttribute(name="dienthoai")
public List<DienThoai> getAll(){
	
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
public String save(ModelMap model,@ModelAttribute("baoHanh")BaoHanh baoHanh) {
	baoHanh.setId(random());
	baoHanhService.save(baoHanh);
    BaoHanh u=new BaoHanh();
	model.addAttribute("baoHanh",u);
	return "register-baoHanh";
	
	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("baoHanh")BaoHanh baoHanh) {
	//baoHanhService.update(baoHanh.getName(),baoHanh.getGender(),baoHanh.getBirthday(),baoHanh.getEmail()
		//	,baoHanh.getPhone(),baoHanh.getPassword(),baoHanh.getAddress(),baoHanh.getId());
	baoHanhService.save(baoHanh);
	model.addAttribute("baoHanh",baoHanh);
	return "register-baoHanh";

	}
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")Long id) {
	Optional<BaoHanh> u= baoHanhService.findById(id);
	if(u.isPresent()) {
		model.addAttribute("baoHanh", u.get());
	}else {
		model.addAttribute("baoHanh", new BaoHanh());
	}
	model.addAttribute("action", "/baoHanh/update");
	
return "register-baoHanh";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")long id
		,HttpServletRequest request,RedirectAttributes redirect) {
//employeeService.isdelete(id);
 String sql="update baoHanh set isdelete=1 where id=?";
 BaoHanh baoHanh=new  BaoHanh(id);
 jdbcT.update(sql,new Object[] {baoHanh.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());

return "redirect:/baoHanh/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		long g=ll.get(i);
		 String sql="update baoHanh set isdelete=1 where id=?";
		 BaoHanh baoHanh =new  BaoHanh(g);
		 jdbcT.update(sql,new Object[] {baoHanh.getId()});
		//employeeService.isdelete(g);
	}
	
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/baoHanh/page/{id}";
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
	return "redirect:/baoHanh/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("customer",customerService.findAll());
	List<BaoHanh> list =(List<BaoHanh>) baoHanhService.getAll();
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
	String baseUrl = "/baoHanh/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-baoHanh";
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
		return "/baoHanh/page";	
	}	
	List<BaoHanh> list = baoHanhService.findup(xuly(s));	
	if (list == null) {	
		return "/baoHanh/page";	
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
	String baseUrl = "/baoHanh/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-baoHanh";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/baoHanh/page";	
	}	
	List<BaoHanh> list = baoHanhService.getAll();	
	if (list == null) {	
		return "/baoHanh/page";	
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
	String baseUrl = "/baoHanh/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-baoHanh";	
}
}
