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

import com.example.demo.Services.DangKyService;
import com.example.demo.Services.QLUserService;
import com.example.demo.dto.Md5;
import com.example.demo.models.DangKy;

@Controller
@RequestMapping("/DangKy")
public class DangKyController {
	@Autowired
	DangKyService DangKyService;
	@Autowired
	QLUserService QLUserService;
	@RequestMapping("/")
	public String index(Model model) {
		DangKy dto=new DangKy();
		model.addAttribute("DangKy",dto);
		model.addAttribute("action","/DangKy/saveorupdate");
		return "register-DangKy";
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
	public String save(ModelMap model,@ModelAttribute("DangKy")DangKy DangKy) {
		DangKy.setId(random());
		DangKy.setPassword(Md5.md5(DangKy.getPassword()));
		DangKy.setIsdelete(0);
		for(int i=0;i<QLUserService.getAll().size();i++) {
			if(QLUserService.getAll().get(i).getTendangnhap().equalsIgnoreCase(DangKy.getTendangnhap())) {
				DangKyService.insert(DangKy.getId(),DangKy.getTendangnhap(),DangKy.getPassword(),DangKy.getIsdelete());
				//model.addAttribute("tinhtrang","dang ky thanh cong");
				return "redirect:/Login/";
			}
		}
		//DangKyService.insert(DangKy.getId(),DangKy.getTendangnhap(),DangKy.getPassword(),DangKy.getIsdelete());
	    DangKy u=new DangKy();
		model.addAttribute("DangKy",u);
		model.addAttribute("tinhtrang","dang ky thatbai");
		return "register-DangKy";
		
		}
	@PostMapping("/update")
	public String update(ModelMap model,@ModelAttribute("DangKy")DangKy DangKy) {
		//DangKyService.update(DangKy.getName(),DangKy.getGender(),DangKy.getBirthday(),DangKy.getEmail()
			//	,DangKy.getPhone(),DangKy.getPassword(),DangKy.getAddress(),DangKy.getId());
		DangKy.setPassword(Md5.md5(DangKy.getPassword()));
		DangKyService.update(DangKy.getTendangnhap(),DangKy.getPassword(),DangKy.getId());
		model.addAttribute("DangKy",DangKy);
		return "register-DangKy";

		}
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")long id) {
		Optional<DangKy> u= DangKyService.findById(id);
		if(u.isPresent()) {
			model.addAttribute("DangKy", u.get());
		}else {
			model.addAttribute("DangKy", new DangKy());
		}
		model.addAttribute("action", "/DangKy/update");
		
	return "register-DangKy";
	}
	 @Autowired
	    JdbcTemplate jdbcT;
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id")Long id
			,HttpServletRequest request,RedirectAttributes redirect) {
	//employeeService.isdelete(id);
	 String sql="update DangKy set isdelete=1 where id=?";
	 DangKy DangKy=new  DangKy(id);
	 jdbcT.update(sql,new Object[] {DangKy.getId()});
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	//model.addAttribute("list1",employeeService.findAll());

	return "redirect:/DangKy/page/{id}";
	}
	@RequestMapping("/xoanhieu")
	public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
			HttpServletRequest request,RedirectAttributes redirect) {
		for(int i=0;i<ll.size();i++) {
			System.out.println("so la : "+ll.get(i));
			Long g=ll.get(i);
			 String sql="update DangKy set isdelete=1 where id=?";
			 DangKy DangKy =new  DangKy(g);
			 jdbcT.update(sql,new Object[] {DangKy.getId()});
			//employeeService.isdelete(g);
		}
		
		request.getSession().setAttribute("employeelist", null);
		 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
		return "redirect:/DangKy/page/{id}";
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
		return "redirect:/DangKy/page/{id}";
	}
	@GetMapping("/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		//model.addAttribute("customer",customerService.findAll());
		List<DangKy> list =(List<DangKy>) DangKyService.findAll();
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
		String baseUrl = "/DangKy/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);

		return "view-DangKy";
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
			return "/DangKy/page";	
		}	
		List<DangKy> list = DangKyService.findByTendangnhap(xuly(s));	
		if (list == null) {	
			return "/DangKy/page";	
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
		String baseUrl = "/DangKy/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-DangKy";	
	}
	@GetMapping("/search/pageNumber")	
	public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
			) {	
		if (s.equals("")) {	
			return "/DangKy/page";	
		}	
		List<DangKy> list = DangKyService.findAll();	
		if (list == null) {	
			return "/DangKy/page";	
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
		String baseUrl = "/DangKy/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-DangKy";	
	}
}
