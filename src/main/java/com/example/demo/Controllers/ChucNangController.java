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

import com.example.demo.Repository.ChucVuRepository;
import com.example.demo.Services.ChucNangChaService;
import com.example.demo.Services.ChucNangService;
import com.example.demo.Services.ChucVuService;
import com.example.demo.Services.EmployeeService;
import com.example.demo.models.ChucNang;
import com.example.demo.models.ChucNangCha;
import com.example.demo.models.ChucVu;
import com.example.demo.models.Employee;

@Controller
@RequestMapping("/ChucNang")
public class ChucNangController {
@Autowired
EmployeeService employeeService ;
@Autowired
ChucNangService ChucNangService ;

@Autowired
ChucNangChaService ChucNangChaService;
@RequestMapping("/")
public String index(Model model) {
	ChucNang dto=new ChucNang();
	model.addAttribute("ChucNang",dto);
	model.addAttribute("action","/ChucNang/saveorupdate");
	return "register-ChucNang";
}
@ModelAttribute(name="nhanvien")
public List<Employee> getAll1(){
	
return  (List<Employee>) employeeService.findAll();
}
@ModelAttribute(name="chucnangcha")
public List<ChucNangCha> getAll2(){
	
return  (List<ChucNangCha>) ChucNangChaService.getAll();
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
public String save(ModelMap model,@ModelAttribute("ChucNang")ChucNang ChucNang) {
	ChucNang.setId(random());
	ChucNang.setIsdelete(0);
	
	ChucNangService.save(ChucNang);
    ChucNang u=new ChucNang();
	model.addAttribute("ChucNang",u);
	return "register-ChucNang";
	
	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("ChucNang")ChucNang ChucNang) {
	System.out.println(ChucNang.getId());
	//ChucNangService.update(ChucNang.getName(),ChucNang.getGender(),ChucNang.getBirthday(),ChucNang.getEmail()
		//	,ChucNang.getPhone(),ChucNang.getPassword(),ChucNang.getAddress(),ChucNang.getId());
	 String sql="update ChucNang set tencn=? ,cnurl=?,macn=? ,cncha=?,mota=?,maapi=?,congkhai=?  where id=?";
	// ChucNang ChucNang=new  ChucNang(id);
	 jdbcT.update(sql,new Object[] {ChucNang.getTencn(),ChucNang.getCnurl(),ChucNang.getMacn()
			 ,ChucNang.getCncha(),ChucNang.getMota(),ChucNang.getMaapi(),ChucNang.isCongkhai(),idd});
	//ChucNangService.save(ChucNang);
	model.addAttribute("ChucNang",ChucNang);
	return "register-ChucNang";

	}
public static long idd=0;
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")Long id) {
	Optional<ChucNang> u= ChucNangService.findById(id);
	
	if(u.isPresent()) {
		model.addAttribute("ChucNang", u.get());
		idd=id;
	}else {
		model.addAttribute("ChucNang", new ChucNang());
	}
	model.addAttribute("action", "/ChucNang/update");
	
return "register-ChucNang";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")Long id
		,HttpServletRequest request,RedirectAttributes redirect) {
//employeeService.isdelete(id);
 String sql="update ChucNang set isdelete=1 where id=?";
 ChucNang ChucNang=new  ChucNang(id);
 jdbcT.update(sql,new Object[] {ChucNang.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());

return "redirect:/ChucNang/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		Long g=ll.get(i);
		 String sql="update ChucNang set isdelete=1 where id=?";
		 ChucNang ChucNang =new  ChucNang(g);
		 jdbcT.update(sql,new Object[] {ChucNang.getId()});
		//employeeService.isdelete(g);
	}
	
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/ChucNang/page/{id}";
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
	return "redirect:/ChucNang/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("customer",customerService.findAll());
	List<ChucNang> list =(List<ChucNang>) ChucNangService.getAll();
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
	String baseUrl = "/ChucNang/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-ChucNang";
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
		return "/ChucNang/page";	
	}	
	List<ChucNang> list = ChucNangService.findup(xuly(s));	
	if (list == null) {	
		return "/ChucNang/page";	
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
	String baseUrl = "/ChucNang/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-ChucNang";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/ChucNang/page";	
	}	
	List<ChucNang> list = ChucNangService.findAll();	
	if (list == null) {	
		return "/ChucNang/page";	
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
	String baseUrl = "/ChucNang/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-ChucNang";	
}
}
