package com.example.demo.Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.example.demo.models.BaoHanh;
import com.example.demo.models.Customer;
import com.example.demo.models.Customers;
import com.example.demo.models.DangBaoHanh;
import com.example.demo.models.DienThoai;
import com.example.demo.Services.DangBaoHanhService;
import com.example.demo.Services.DienThoaiService;
import com.example.demo.Services.PhuKienService;
import com.example.demo.Services.BaoHanhService;
import com.example.demo.Services.CustomerService;
import com.example.demo.models.Employee;
import com.example.demo.models.PhuKien;

@Controller
@RequestMapping("/DangBaoHanh")
public class DangBaoHanhController {
	@Autowired
	DangBaoHanhService DangBaoHanhService;
	@Autowired
	BaoHanhService BaoHanhService;
	@Autowired
	CustomerService CustomerService;
	@Autowired
	DienThoaiService DienThoaiService;
	@Autowired
	PhuKienService PhuKienService;
	SimpleDateFormat d=new SimpleDateFormat("dd/MM/yyyy");
	@ModelAttribute(name="baohanh")
	public List<BaoHanh> getall1(){
		return (List<BaoHanh>) BaoHanhService.getAll();
	}
	@ModelAttribute(name="customer")
	public List<Customers> getall2(){
		return  (List<Customers>) CustomerService.getAll();
	}
	@ModelAttribute(name="dienthoai")
	public List<DienThoai> getall3(){
		return  (List<DienThoai>) DienThoaiService.getAll();
	}
	@ModelAttribute(name="phukien")
	public List<PhuKien> getall4(){
		return  (List<PhuKien>) PhuKienService.getAll();
	}
	@RequestMapping("/")
	public String findma(Model model,@ModelAttribute("mabh")String mabh) {
		Optional<BaoHanh> bh=BaoHanhService.findma(mabh);
		BaoHanh baohanh=bh.get();
		DangBaoHanh dto=new DangBaoHanh();
		dto.setMabh(baohanh.getMabh());
		dto.setNgaybatdau(new Date());
		dto.setIdcustomer(baohanh.getDienthoaiid());
		model.addAttribute("DangBaoHanh",dto);
		model.addAttribute("action","/DangBaoHanh/register");
		return "register-DangBaoHanh";
	}
	@RequestMapping("/register")
	public String index(Model model) {
		DangBaoHanh dto=new DangBaoHanh();
		model.addAttribute("DangBaoHanh",dto);
		model.addAttribute("action","/DangBaoHanh/saveorupdate");
		return "register-DangBaoHanh";
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
	public String save(ModelMap model,@ModelAttribute("DangBaoHanh")DangBaoHanh DangBaoHanh) {
		DangBaoHanh.setId(random());
		DangBaoHanh.setIsdelete(0);
		
		DangBaoHanhService.save(DangBaoHanh);
	    DangBaoHanh u=new DangBaoHanh();
		model.addAttribute("DangBaoHanh",u);
		return "register-DangBaoHanh";
		
		}
	
	public static long idd=0;
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Long id) {
		Optional<DangBaoHanh> u= DangBaoHanhService.findById(id);
		
		if(u.isPresent()) {
			model.addAttribute("DangBaoHanh", u.get());
			idd=id;
		}else {
			model.addAttribute("DangBaoHanh", new DangBaoHanh());
		}
		model.addAttribute("action", "/DangBaoHanh/update");
		
	return "register-DangBaoHanh";
	}
	 @Autowired
	    JdbcTemplate jdbcT;
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id")Long id
			,HttpServletRequest request,RedirectAttributes redirect) {
	//employeeService.isdelete(id);
	 String sql="update DangBaoHanh set isdelete=1 where id=?";
	 DangBaoHanh DangBaoHanh=new  DangBaoHanh(id);
	 jdbcT.update(sql,new Object[] {DangBaoHanh.getId()});
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	//model.addAttribute("list1",employeeService.findAll());

	return "redirect:/DangBaoHanh/page/{id}";
	}
	@RequestMapping("/xoanhieu")
	public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
			HttpServletRequest request,RedirectAttributes redirect) {
		for(int i=0;i<ll.size();i++) {
			System.out.println("so la : "+ll.get(i));
			Long g=ll.get(i);
			 String sql="update DangBaoHanh set isdelete=1 where id=?";
			 DangBaoHanh DangBaoHanh =new  DangBaoHanh(g);
			 jdbcT.update(sql,new Object[] {DangBaoHanh.getId()});
			//employeeService.isdelete(g);
		}
		
		request.getSession().setAttribute("employeelist", null);
		 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
		return "redirect:/DangBaoHanh/page/{id}";
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
		return "redirect:/DangBaoHanh/page/{id}";
	}
	@GetMapping("/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		//model.addAttribute("customer",customerService.findAll());
		List<DangBaoHanh> list =(List<DangBaoHanh>) DangBaoHanhService.getAll();
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
		String baseUrl = "/DangBaoHanh/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);

		return "view-DangBaoHanh";
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
			return "/DangBaoHanh/page";	
		}	
		List<DangBaoHanh> list = DangBaoHanhService.findup(xuly(s));	
		if (list == null) {	
			return "/DangBaoHanh/page";	
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
		String baseUrl = "/DangBaoHanh/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-DangBaoHanh";	
	}
	@GetMapping("/search/pageNumber")	
	public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
			) {	
		if (s.equals("")) {	
			return "/DangBaoHanh/page";	
		}	
		List<DangBaoHanh> list = DangBaoHanhService.findAll();	
		if (list == null) {	
			return "/DangBaoHanh/page";	
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
		String baseUrl = "/DangBaoHanh/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-DangBaoHanh";	
	}
}
