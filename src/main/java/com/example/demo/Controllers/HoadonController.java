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

import com.example.demo.Services.CustomerService;
import com.example.demo.Services.HoadonServices;
import com.example.demo.models.ChucVu;
import com.example.demo.models.Customers;
import com.example.demo.models.Hoadon;
@Controller
@RequestMapping("/hoadon")
public class HoadonController {
	@Autowired
	HoadonServices hoadonServices ;
	@Autowired
	CustomerService customerService;
	@RequestMapping("/")
	public String index(Model model) {
		Hoadon dto=new Hoadon();
		model.addAttribute("hoadon",dto);
		model.addAttribute("action","/hoadon/saveorupdate");
		return "register-hoadon";
	}

	@ModelAttribute(name="customer")
	public List<Customers> getAll(){
		
	return  (List<Customers>) customerService.findAll();
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
	public String save(ModelMap model,@ModelAttribute("hoadon")Hoadon hoadon) {
		hoadon.setId(random());
		hoadonServices.save(hoadon);
	    Hoadon u=new Hoadon();
		model.addAttribute("hoadon",u);
		return "register-hoadon";
		
		}
	@PostMapping("/update")
	public String update(ModelMap model,@ModelAttribute("hoadon")Hoadon hoadon) {
		//hoadonService.update(hoadon.getName(),hoadon.getGender(),hoadon.getBirthday(),hoadon.getEmail()
			//	,hoadon.getPhone(),hoadon.getPassword(),hoadon.getAddress(),hoadon.getId());
		hoadonServices.save(hoadon);
		model.addAttribute("hoadon",hoadon);
		return "register-hoadon";

		}
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Long id) {
		Optional<Hoadon> u= hoadonServices.findById(id);
		if(u.isPresent()) {
			model.addAttribute("hoadon", u.get());
		}else {
			model.addAttribute("hoadon", new Hoadon());
		}
		model.addAttribute("action", "/hoadon/update");
		
	return "register-hoadon";
	}
	 @Autowired
	    JdbcTemplate jdbcT;
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id")Long id
			,HttpServletRequest request,RedirectAttributes redirect) {
	//employeeService.isdelete(id);
	 String sql="update hoadon set isdelete=1 where id=?";
	 Hoadon hoadon=new  Hoadon(id);
	 jdbcT.update(sql,new Object[] {hoadon.getId()});
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	//model.addAttribute("list1",employeeService.findAll());
	 model.addAttribute("customer",customerService.findAll());
	return "redirect:/hoadon/page/{id}";
	}
	@RequestMapping("/xoanhieu")
	public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
			HttpServletRequest request,RedirectAttributes redirect) {
		for(int i=0;i<ll.size();i++) {
			System.out.println("so la : "+ll.get(i));
			Long g=ll.get(i);
			 String sql="update hoadon set isdelete=1 where id=?";
			 Hoadon hoadon =new  Hoadon(g);
			 jdbcT.update(sql,new Object[] {hoadon.getId()});
			//employeeService.isdelete(g);
		}
		model.addAttribute("customer",customerService.findAll());
		request.getSession().setAttribute("employeelist", null);
		 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
		return "redirect:/hoadon/page/{id}";
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
		return "redirect:/hoadon/page/{id}";
	}
	@GetMapping("/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		model.addAttribute("customer",customerService.findAll());
		List<Hoadon> list =(List<Hoadon>) hoadonServices.getAll();
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
		String baseUrl = "/hoadon/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);

		return "view-hoadon";
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
			return "/hoadon/page";	
		}	
		List<Hoadon> list = hoadonServices.findup(xuly(s));	
		if (list == null) {	
			return "/hoadon/page";	
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
		String baseUrl = "/hoadon/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-hoadon";	
	}
	@GetMapping("/search/pageNumber")	
	public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
			) {	
		if (s.equals("")) {	
			return "/hoadon/page";	
		}	
		List<Hoadon> list = hoadonServices.getAll();	
		if (list == null) {	
			return "/hoadon/page";	
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
		String baseUrl = "/hoadon/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-hoadon";	
	}
}
