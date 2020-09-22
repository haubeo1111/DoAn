package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.query.criteria.internal.expression.function.LengthFunction;
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

import com.example.demo.Services.VaiTroService;
import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.GroupUserService;
import com.example.demo.Services.PhongBanService;
import com.example.demo.Services.VaitroChucNangService;
import com.example.demo.Services.UserChucNangService;
import com.example.demo.Services.ChucNangService;
import com.example.demo.models.VaitroChucNang;
import com.example.demo.models.VaiTro;
import com.example.demo.models.UserChucNang;
import com.example.demo.models.ChucNang;

import com.example.demo.models.ChucVu;
import com.example.demo.models.Employee;
import com.example.demo.models.GroupUser;
import com.example.demo.models.LoaiKM;
import com.example.demo.models.PhongBan;

@Controller
@RequestMapping("/VaitroChucNang")
public class VaiTroChucNangController {
@Autowired
VaitroChucNangService VaitroChucNangService ;
@Autowired
ChucNangService ChucNangService ;
@Autowired
GroupUserService GroupUserService;
@Autowired
PhongBanService PhongBanService ;
@Autowired
VaiTroService VaiTroService;
@Autowired
UserChucNangService UserChucNangService;

@RequestMapping("/")
public String index(Model model) {
	VaitroChucNang dto=new VaitroChucNang();
	model.addAttribute("VaitroChucNang",dto);
	model.addAttribute("action","/VaitroChucNang/saveorupdate");
	return "register-VaitroChucNang";
}
@ModelAttribute(name="vaitro")
public List<VaiTro> getAll2(){
	
return  (List<VaiTro>) VaiTroService.findAll();
}
@ModelAttribute(name="userchucnang")
public List<UserChucNang> getAll5(){
	
return  (List<UserChucNang>) UserChucNangService.findAll();
}
@ModelAttribute(name="phongban")
public List<PhongBan> getAll1(){
	
return  (List<PhongBan>) PhongBanService.getAll();
}
@ModelAttribute(name="groupuser")
public List<GroupUser> getAll(){
	
return  (List<GroupUser>) GroupUserService.getAll();
}
@ModelAttribute(name="chucnang")
public List<ChucNang> getAll3(){
	
return  (List<ChucNang>) ChucNangService.getAll();
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
public String save(ModelMap model,@ModelAttribute("VaitroChucNang")VaitroChucNang VaitroChucNang,
		@RequestParam("chon")List<Long> lk
		) {
	List<String> ls=new ArrayList<>();
	//UserChucNang ucn=new UserChucNang();
	
	for(int i=0;i<lk.size();i++) {
		VaitroChucNang.setId(random());
		VaitroChucNang.setIsdelete(0);
		VaitroChucNang.setIdcn(lk.get(i));
		
		VaitroChucNangService.save(VaitroChucNang);
		ls.add(Long.toString(lk.get(i)));
	}
	String ss="";
	for(int i=0;i<ls.size();i++) {
		ss=ss+ls.get(i)+";";
	}
	
	
	
	
    VaitroChucNang u=new VaitroChucNang();
	model.addAttribute("VaitroChucNang",u);
	
	return "register-VaitroChucNang";
	
	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("VaitroChucNang")VaitroChucNang VaitroChucNang,
		@RequestParam("chon")List<Long> lk
		) {
	//System.out.println("day la"+VaitroChucNang.getId()+"  "+VaitroChucNang.getIdvt());
	List<VaitroChucNang> hh=VaitroChucNangService.findiduser(idd);
	//System.out.println("nnmj"+hh.size());
	VaitroChucNangService.deleteAll(hh);
	VaitroChucNang.setIdvt(idd);
	List<String> ls=new ArrayList<>();
	for(int i=0;i<lk.size();i++) {
		VaitroChucNang.setId(random());
		VaitroChucNang.setIsdelete(0);
		VaitroChucNang.setIdcn(lk.get(i));
		
		VaitroChucNangService.save(VaitroChucNang);
		//if(UserChucNangService.findidcn(id))
		ls.add(Long.toString(lk.get(i)));
	}
	String ss="";
	for(int i=0;i<ls.size();i++) {
		ss=ss+ls.get(i)+";";
	}
	
	//VaitroChucNangService.update(VaitroChucNang.getName(),VaitroChucNang.getGender(),VaitroChucNang.getBirthday(),VaitroChucNang.getEmail()
		//	,VaitroChucNang.getPhone(),VaitroChucNang.getPassword(),VaitroChucNang.getAddress(),VaitroChucNang.getId());
	VaitroChucNangService.save(VaitroChucNang);
	
	model.addAttribute("VaitroChucNang",VaitroChucNang);
idd=0;
	return "register-VaitroChucNang";

	}
public static long idd=0;
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")Long id) {
	//Optional<VaitroChucNang> u= VaitroChucNangService.findById(id);
	List<VaitroChucNang> as=VaitroChucNangService.findiduser(id);
	//List<ChucNang> nh=new ArrayList<>();
	//ChucNang hg=new ChucNang();
	//List<Long>hr=new ArrayList<>();
	//hr=idcn(u.get().getIdcn());
	//for(int i=0;i<hr.size();i++) {
	//	hg=ChucNangService.findById(hr.get(i)).get();
	//	nh.add(hg);
	//}
	model.addAttribute("chucnangc",as);
	idd=id;
	VaitroChucNang cn=new VaitroChucNang((long)2,id);
	
	//model.addAttribute("chucnangc",nh);

		model.addAttribute("VaitroChucNang",cn);
	
	model.addAttribute("action", "/VaitroChucNang/update");
	
return "edit-VaitroChucNang";
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
@RequestMapping("/xemcn/{id}")
public String xemcn(ModelMap model,@PathVariable(name="id")Long id) {
	//Optional<VaitroChucNang> u= VaitroChucNangService.findById(id);
	List<VaitroChucNang> as=VaitroChucNangService.findiduser(id);
	System.out.println(as.size()+"  jj");
	List<ChucNang> nh=new ArrayList<>();
	
	ChucNang hg=new ChucNang();
	List<Long>hr=new ArrayList<>();
	//hr=idcn(u.get().getChucnang());
	for(int i=0;i<hr.size();i++) {
		hg=ChucNangService.findById(hr.get(i)).get();
		nh.add(hg);
	}
	model.addAttribute("chucnangc",as);
	//model.addAttribute("chucnangc",nh);
	
		model.addAttribute("VaitroChucNang", new VaitroChucNang());
	
	model.addAttribute("action", "/VaitroChucNang/update");
	
return "view-CNVaitroChucNang";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")long id
		,HttpServletRequest request,RedirectAttributes redirect) {
//employeeService.isdelete(id);
 String sql="update VaitroChucNang set isdelete=1 where id=?";
 VaitroChucNang VaitroChucNang=new  VaitroChucNang(id);
 jdbcT.update(sql,new Object[] {VaitroChucNang.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());

return "redirect:/VaitroChucNang/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		long g=ll.get(i);
		 String sql="update VaitroChucNang set isdelete=1 where id=?";
		 VaitroChucNang VaitroChucNang =new  VaitroChucNang(g);
		 jdbcT.update(sql,new Object[] {VaitroChucNang.getId()});
		//employeeService.isdelete(g);
	}
	
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/VaitroChucNang/page/{id}";
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
	return "redirect:/VaitroChucNang/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("customer",customerService.findAll());
	List<VaiTro> list =(List<VaiTro>) VaiTroService.getAll();
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
	int end = Math.min(begin + 3, pages.getPageCount());
	int totalPageCount = pages.getPageCount();
	String baseUrl = "/VaitroChucNang/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-VaitroChucNang";
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
		return "/VaitroChucNang/page";	
	}	
	List<VaitroChucNang> list = VaitroChucNangService.findup(xuly(s));	
	if (list == null) {	
		return "/VaitroChucNang/page";	
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
	String baseUrl = "/VaitroChucNang/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-VaitroChucNang";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/VaitroChucNang/page";	
	}	
	List<VaitroChucNang> list = VaitroChucNangService.getAll();	
	if (list == null) {	
		return "/VaitroChucNang/page";	
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
	int end = Math.min(begin + 3, pages.getPageCount());	
	int totalPageCount = pages.getPageCount();	
	String baseUrl = "/VaitroChucNang/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-VaitroChucNang";	
}
}
