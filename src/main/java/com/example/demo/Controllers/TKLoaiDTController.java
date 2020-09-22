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
import com.example.demo.Services.TKLoaiDTService;

import com.example.demo.Services.ChucVuService;
import com.example.demo.Services.TangKemService;
import com.example.demo.Services.LoaiDTService;
import com.example.demo.models.TKLoaiDT;
import com.example.demo.models.TangKem;
import com.example.demo.models.ChucVu;
import com.example.demo.models.Employee;
import com.example.demo.models.LoaiDT;

@Controller
@RequestMapping("/TKLoaiDT")
public class TKLoaiDTController {
@Autowired
TangKemService tangKemService ;
@Autowired
TKLoaiDTService TKLoaiDTService ;

@Autowired
LoaiDTService LoaiDTService;
@RequestMapping("/")
public String index(Model model) {
	TKLoaiDT dto=new TKLoaiDT();
	model.addAttribute("TKLoaiDT",dto);
	model.addAttribute("action","/TKLoaiDT/saveorupdate");
	return "register-TKLoaiDT";
}
@ModelAttribute(name="loaidt")
public List<LoaiDT> getAll1(){
	
return  (List<LoaiDT>) LoaiDTService.getAll();
}
@ModelAttribute(name="tangkem")
public List<TangKem> getAll2(){
	
return  (List<TangKem>) tangKemService.getAll();
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
public String save(ModelMap model,@ModelAttribute("TKLoaiDT")TKLoaiDT TKLoaiDT) {
	TKLoaiDT.setId(random());
	TKLoaiDT.setIsdelete(0);
	
	TKLoaiDTService.save(TKLoaiDT);
    TKLoaiDT u=new TKLoaiDT();
	model.addAttribute("TKLoaiDT",u);
	return "register-TKLoaiDT";
	
	}
@PostMapping("/update")
public String update(ModelMap model,@ModelAttribute("TKLoaiDT")TKLoaiDT TKLoaiDT) {
	System.out.println(TKLoaiDT.getId());
	//TKLoaiDTService.update(TKLoaiDT.getName(),TKLoaiDT.getGender(),TKLoaiDT.getBirthday(),TKLoaiDT.getEmail()
		//	,TKLoaiDT.getPhone(),TKLoaiDT.getPassword(),TKLoaiDT.getAddress(),TKLoaiDT.getId());
	 String sql="update TKLoaiDT set maloaidt=? ,ngaybatdau=?,ngayketthuc=? ,idtangkem=?  where id=?";
	// TKLoaiDT TKLoaiDT=new  TKLoaiDT(id);
	 jdbcT.update(sql,new Object[] {TKLoaiDT.getMaloaidt(),TKLoaiDT.getNgaybatdau(),TKLoaiDT.getNgayketthuc()
			 ,TKLoaiDT.getIdtangkem(),idd});
	//TKLoaiDTService.save(TKLoaiDT);
	model.addAttribute("TKLoaiDT",TKLoaiDT);
	return "register-TKLoaiDT";

	}
public static long idd=0;
@RequestMapping("/edit/{id}")
public String edit(ModelMap model,@PathVariable(name="id")Long id) {
	Optional<TKLoaiDT> u= TKLoaiDTService.findById(id);
	
	if(u.isPresent()) {
		model.addAttribute("TKLoaiDT", u.get());
		idd=id;
	}else {
		model.addAttribute("TKLoaiDT", new TKLoaiDT());
	}
	model.addAttribute("action", "/TKLoaiDT/update");
	
return "register-TKLoaiDT";
}
 @Autowired
    JdbcTemplate jdbcT;
@RequestMapping("/delete/{id}")
public String delete(ModelMap model,@PathVariable(name="id")Long id
		,HttpServletRequest request,RedirectAttributes redirect) {
//employeeService.isdelete(id);
 String sql="update TKLoaiDT set isdelete=1 where id=?";
 TKLoaiDT TKLoaiDT=new  TKLoaiDT(id);
 jdbcT.update(sql,new Object[] {TKLoaiDT.getId()});
request.getSession().setAttribute("employeelist", null);
 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
//model.addAttribute("list1",employeeService.findAll());

return "redirect:/TKLoaiDT/page/{id}";
}
@RequestMapping("/xoanhieu")
public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
		HttpServletRequest request,RedirectAttributes redirect) {
	for(int i=0;i<ll.size();i++) {
		System.out.println("so la : "+ll.get(i));
		Long g=ll.get(i);
		 String sql="update TKLoaiDT set isdelete=1 where id=?";
		 TKLoaiDT TKLoaiDT =new  TKLoaiDT(g);
		 jdbcT.update(sql,new Object[] {TKLoaiDT.getId()});
		//employeeService.isdelete(g);
	}
	
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	return "redirect:/TKLoaiDT/page/{id}";
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
	return "redirect:/TKLoaiDT/page/{id}";
}
@GetMapping("/page/{pageNumber}")
public String showEmployeePage(HttpServletRequest request, 
		@PathVariable int pageNumber, Model model) {
	PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
	int pagesize = 3;
	//model.addAttribute("customer",customerService.findAll());
	List<TKLoaiDT> list =(List<TKLoaiDT>) TKLoaiDTService.getAll();
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
	String baseUrl = "/TKLoaiDT/page/";

	model.addAttribute("beginIndex", begin);
	model.addAttribute("endIndex", end);
	model.addAttribute("currentIndex", current);
	model.addAttribute("totalPageCount", totalPageCount);
	model.addAttribute("baseUrl", baseUrl);
	model.addAttribute("employees", pages);

	return "view-TKLoaiDT";
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
		return "/TKLoaiDT/page";	
	}	
	List<TKLoaiDT> list = TKLoaiDTService.findup(xuly(s));	
	if (list == null) {	
		return "/TKLoaiDT/page";	
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
	String baseUrl = "/TKLoaiDT/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-TKLoaiDT";	
}
@GetMapping("/search/pageNumber")	
public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
		) {	
	if (s.equals("")) {	
		return "/TKLoaiDT/page";	
	}	
	List<TKLoaiDT> list = TKLoaiDTService.findAll();	
	if (list == null) {	
		return "/TKLoaiDT/page";	
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
	String baseUrl = "/TKLoaiDT/page/";	
	model.addAttribute("beginIndex", begin);	
	model.addAttribute("endIndex", end);	
	model.addAttribute("currentIndex", current);	
	model.addAttribute("totalPageCount", totalPageCount);	
	model.addAttribute("baseUrl", baseUrl);	
	model.addAttribute("employees", pages);	
	return "view-TKLoaiDT";	
}
}
