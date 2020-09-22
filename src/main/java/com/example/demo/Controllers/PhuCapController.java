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


import com.example.demo.Services.PhuCapService;
import com.example.demo.Repository.ChucVuRepository;
import com.example.demo.Services.EmployeeService;
import com.example.demo.models.PhuCap;
import com.example.demo.models.ChucVu;
import com.example.demo.models.Employee;

@Controller
@RequestMapping("/PhuCap")
public class PhuCapController {
	@Autowired
	EmployeeService employeeService ;
	@Autowired
	PhuCapService PhuCapService ;
    @Autowired
	ChucVuRepository chucVuRepository;
    
	@RequestMapping("/")
	public String index(Model model) {
		PhuCap dto=new PhuCap();
		model.addAttribute("PhuCap",dto);
		model.addAttribute("action","/PhuCap/saveorupdate");
		return "register-PhuCap";
	}
	@ModelAttribute(name="nhanvien")
	public List<Employee> getAll1(){
		
	return  (List<Employee>) employeeService.findAll();
	}
	@ModelAttribute(name="chucvu")
	public List<ChucVu> getAll2(){
		
	return  (List<ChucVu>) chucVuRepository.findAll();
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
	public String save(ModelMap model,@ModelAttribute("PhuCap")PhuCap PhuCap) {
		PhuCap.setId(random());
		PhuCap.setIsdelete(0);
		
		PhuCapService.save(PhuCap);
	    PhuCap u=new PhuCap();
		model.addAttribute("PhuCap",u);
		return "register-PhuCap";
		
		}
	@PostMapping("/update")
	public String update(ModelMap model,@ModelAttribute("PhuCap")PhuCap PhuCap) {
		System.out.println(PhuCap.getId());
		//PhuCapService.update(PhuCap.getName(),PhuCap.getGender(),PhuCap.getBirthday(),PhuCap.getEmail()
			//	,PhuCap.getPhone(),PhuCap.getPassword(),PhuCap.getAddress(),PhuCap.getId());
		 String sql="update PhuCap set tenphucap=? ,sotien=?,idchucvu=?  where id=?";
		// PhuCap PhuCap=new  PhuCap(id);
		 jdbcT.update(sql,new Object[] {PhuCap.getTenphucap(),PhuCap.getSotien(),PhuCap.getIdchucvu(),idd});
		//PhuCapService.save(PhuCap);
		model.addAttribute("PhuCap",PhuCap);
		return "register-PhuCap";

		}
	public static long idd=0;
	@RequestMapping("/edit/{id}")
	public String edit(ModelMap model,@PathVariable(name="id")Long id) {
		Optional<PhuCap> u= PhuCapService.findById(id);
		
		if(u.isPresent()) {
			model.addAttribute("PhuCap", u.get());
			idd=id;
		}else {
			model.addAttribute("PhuCap", new PhuCap());
		}
		model.addAttribute("action", "/PhuCap/update");
		
	return "register-PhuCap";
	}
	 @Autowired
	    JdbcTemplate jdbcT;
	@RequestMapping("/delete/{id}")
	public String delete(ModelMap model,@PathVariable(name="id")Long id
			,HttpServletRequest request,RedirectAttributes redirect) {
	//employeeService.isdelete(id);
	 String sql="update PhuCap set isdelete=1 where id=?";
	 PhuCap PhuCap=new  PhuCap(id);
	 jdbcT.update(sql,new Object[] {PhuCap.getId()});
	request.getSession().setAttribute("employeelist", null);
	 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
	//model.addAttribute("list1",employeeService.findAll());

	return "redirect:/PhuCap/page/{id}";
	}
	@RequestMapping("/xoanhieu")
	public String deletes(ModelMap model,@RequestParam("xoa[]")List<Long> ll,
			HttpServletRequest request,RedirectAttributes redirect) {
		for(int i=0;i<ll.size();i++) {
			System.out.println("so la : "+ll.get(i));
			Long g=ll.get(i);
			 String sql="update PhuCap set isdelete=1 where id=?";
			 PhuCap PhuCap =new  PhuCap(g);
			 jdbcT.update(sql,new Object[] {PhuCap.getId()});
			//employeeService.isdelete(g);
		}
		
		request.getSession().setAttribute("employeelist", null);
		 redirect.addAttribute("id", 1).addFlashAttribute("message", "Account created!");
		return "redirect:/PhuCap/page/{id}";
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
		return "redirect:/PhuCap/page/{id}";
	}
	@GetMapping("/page/{pageNumber}")
	public String showEmployeePage(HttpServletRequest request, 
			@PathVariable int pageNumber, Model model) {
		PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("employeelist");
		int pagesize = 3;
		//model.addAttribute("customer",customerService.findAll());
		List<PhuCap> list =(List<PhuCap>) PhuCapService.getAll();
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
		String baseUrl = "/PhuCap/page/";

		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", current);
		model.addAttribute("totalPageCount", totalPageCount);
		model.addAttribute("baseUrl", baseUrl);
		model.addAttribute("employees", pages);

		return "view-PhuCap";
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
			return "/PhuCap/page";	
		}	
		List<PhuCap> list = PhuCapService.findup(xuly(s));	
		if (list == null) {	
			return "/PhuCap/page";	
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
		String baseUrl = "/PhuCap/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-PhuCap";	
	}
	@GetMapping("/search/pageNumber")	
	public String searchpage(@RequestParam("sa") String s, Model model, HttpServletRequest request
			) {	
		if (s.equals("")) {	
			return "/PhuCap/page";	
		}	
		List<PhuCap> list = PhuCapService.findAll();	
		if (list == null) {	
			return "/PhuCap/page";	
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
		String baseUrl = "/PhuCap/page/";	
		model.addAttribute("beginIndex", begin);	
		model.addAttribute("endIndex", end);	
		model.addAttribute("currentIndex", current);	
		model.addAttribute("totalPageCount", totalPageCount);	
		model.addAttribute("baseUrl", baseUrl);	
		model.addAttribute("employees", pages);	
		return "view-PhuCap";	
	}
}
