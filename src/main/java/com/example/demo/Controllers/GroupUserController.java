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

import com.example.demo.Services.GroupUserService;
import com.example.demo.Services.ChucNangService;
import com.example.demo.Services.DienThoaiService;
import com.example.demo.Services.GroupUserCNService;
import com.example.demo.models.GroupUser;
import com.example.demo.models.GroupUserCN;
import com.example.demo.models.QLUser;
import com.example.demo.models.UserChucNang;
import com.example.demo.models.ChucNang;
import com.example.demo.models.ChucVu;
import com.example.demo.models.DienThoai;

@Controller
@RequestMapping("/GroupUser")
public class GroupUserController {
@Autowired
GroupUserService GroupUserService;
@Autowired
ChucNangService ChucNangService;
@Autowired
GroupUserCNService GroupUserCNService;
@RequestMapping("/")
public String index(Model model) {
	GroupUser dto=new GroupUser();
	List<GroupUserCN> as=new ArrayList<>();
	model.addAttribute("GroupUser",dto);
	model.addAttribute("action","/GroupUser/saveorupdate");
	model.addAttribute("chucnangc",as);
	return "register-GroupUser";
}

@ModelAttribute(name="chucnang")
public List<ChucNang> getAll(){
	
return  (List<ChucNang>) ChucNangService.findAll();
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
public String save(ModelMap model,@ModelAttribute("GroupUser")GroupUser GroupUser,
		@RequestParam("chon")List<Long> lk
		) {
	GroupUserCN ucn=new GroupUserCN();
	GroupUser.setId(random());
	List<String> ls=new ArrayList<>();
	for(int i=0;i<lk.size();i++) {
		ucn.setId(random());
		ucn.setIdgroupuser(GroupUser.getId());
		ucn.setIdcn(lk.get(i));
		ucn.setIsdelete(0);
		GroupUserCNService.save(ucn);
		ls.add(Long.toString(lk.get(i)));
	}
	for(int i=0;i<lk.size();i++) {
		ls.add(Long.toString(lk.get(i)));
	}
	String ss="";
	for(int i=0;i<ls.size();i++) {
		ss=ss+ls.get(i)+";";
	}
	GroupUser.setChucnang(ss);
	GroupUser.setIsdelete(0);
	GroupUserService.save(GroupUser);
    GroupUser u=new GroupUser();
	model.addAttribute("GroupUser",u);
	List<GroupUserCN> as=new ArrayList<>();
	model.addAttribute("chucnangc",as);
	return "register-GroupUser";
	
	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("GroupUser")GroupUser GroupUser,
		@RequestParam("chon")List<Long> lk
		) {
	//GroupUserService.update(GroupUser.getName(),GroupUser.getGender(),GroupUser.getBirthday(),GroupUser.getEmail()
	
	//	,GroupUser.getPhone(),GroupUser.getPassword(),GroupUser.getAddress(),GroupUser.getId());
	List<GroupUserCN> hh=GroupUserCNService.findiduser(GroupUser.getId());
	GroupUserCNService.deleteAll(hh);
	GroupUserCN ucn=new GroupUserCN();
	List<String> ls=new ArrayList<>();
	for(int i=0;i<lk.size();i++) {
		ucn.setId(random());
		ucn.setIdgroupuser(GroupUser.getId());
		ucn.setIdcn(lk.get(i));
		ucn.setIsdelete(0);
		GroupUserCNService.save(ucn);
		//if(UserChucNangService.findidcn(id))
		ls.add(Long.toString(lk.get(i)));
	}
	for(int i=0;i<lk.size();i++) {
		ls.add(Long.toString(lk.get(i)));
	}
	String ss="";
	for(int i=0;i<ls.size();i++) {
		ss=ss+ls.get(i)+";";
	}
	GroupUser.setChucnang(ss);
	GroupUserService.save(GroupUser);
	model.addAttribute("GroupUser",GroupUser);
	List<GroupUserCN> as=new ArrayList<>();
	model.addAttribute("chucnangc",as);
	return "register-GroupUser";

	}
public List<Long> idcn(String s){
	List<Long> ss=new ArrayList<>();
	String hk=s.substring(0,s.length()-1);
	 String[] words = hk.split(";");
	 for (String w : words) {
		 ss.add(Long.parseLong(w));
		 System.out.println(w  + " -- ");
	 }
	return ss;
}
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")Long id) {
	Optional<GroupUser> u= GroupUserService.findById(id);
	List<GroupUserCN> as=GroupUserCNService.findiduser(id);
	List<ChucNang> nh=new ArrayList<>();
	ChucNang hg=new ChucNang();
	List<Long>hr=new ArrayList<>();
	hr=idcn(u.get().getChucnang());
	for(int i=0;i<hr.size();i++) {
		hg=ChucNangService.findById(hr.get(i)).get();
		nh.add(hg);
	}
	model.addAttribute("chucnangc",as);
	if(u.isPresent()) {
		model.addAttribute("GroupUser", u.get());
	}else {
		model.addAttribute("GroupUser", new GroupUser());
	}
	model.addAttribute("action", "/GroupUser/update");
	
return "register-GroupUser";
}
@RequestMapping("/xemcn/{id}")
public String xemcn(ModelMap model,@PathVariable(name="id")Long id) {
	
	Optional<GroupUser> u= GroupUserService.findById(id);
	List<GroupUserCN> as=GroupUserCNService.findiduser(id);
	
	//System.out.println(as.size()+"  jj");
	List<ChucNang> nh=new ArrayList<>();
	
	ChucNang hg=new ChucNang();
	List<Long>hr=new ArrayList<>();
	hr=idcn(u.get().getChucnang());
	for(int i=0;i<hr.size();i++) {
		hg=ChucNangService.findById(hr.get(i)).get();
		nh.add(hg);
	}
	model.addAttribute("chucnangc",as);
	//model.addAttribute("chucnangc",nh);
	if(u.isPresent()) {
		model.addAttribute("QLUser", u.get());
	}else {
		model.addAttribute("QLUser", new QLUser());
	}
	model.addAttribute("action", "/QLUser/update");
	
return "view-CNqlgroupuser";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")long id
		,HttpServletRequest request,RedirectAttributes redirect) {
//employeeService.isdelete(id);
 String sql="update GroupUser set isdelete=1 where id=?";
 GroupUser GroupUser=new  GroupUser(id);
 jdbcT.update(sql,new Object[] {GroupUser.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());

return "redirect:/GroupUser/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		long g=ll.get(i);
		 String sql="update GroupUser set isdelete=1 where id=?";
		 GroupUser GroupUser =new  GroupUser(g);
		 jdbcT.update(sql,new Object[] {GroupUser.getId()});
		//employeeService.isdelete(g);
	}
	
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/GroupUser/page/{id}";
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
	return "redirect:/GroupUser/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("customer",customerService.findAll());
	List<GroupUser> list =(List<GroupUser>) GroupUserService.getAll();
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
	String baseUrl = "/GroupUser/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-GroupUser";
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
		return "/GroupUser/page";	
	}	
	List<GroupUser> list = GroupUserService.findup(xuly(s));	
	if (list == null) {	
		return "/GroupUser/page";	
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
	String baseUrl = "/GroupUser/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-GroupUser";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/GroupUser/page";	
	}	
	List<GroupUser> list = GroupUserService.getAll();	
	if (list == null) {	
		return "/GroupUser/page";	
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
	String baseUrl = "/GroupUser/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-GroupUser";	
}
}
