package com.example.demo.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.DangKyService;
import com.example.demo.Services.QLUserService;
import com.example.demo.models.Customer;
import com.example.demo.models.DangKy;
import com.example.demo.models.QLUser;
import com.example.demo.models.Response;


@RestController
@RequestMapping("/api/customer")
public class example {
	 List<Customer> cust = new ArrayList<Customer>();
	 @Autowired
	 DangKyService DangKyService;
	  @GetMapping(value = "/all")
	  public Response getResource() {
	    Response response = new Response("Done", cust);
	    return response;
	  }
	 
	  @PostMapping(value = "/save")
	  public Response postCustomer(@RequestBody Customer customer) {
	    cust.add(customer);
	    
	    // Create Response Object
	    Response response = new Response("Done", customer);
	    return response;
	  }
	  @GetMapping(value="/checkten")
	  public  String checkten1() {
		 return "hauba"; 
	  }
	  @Autowired
	  QLUserService QLUserService ;
	  @PostMapping(value="/checkten")
	  public  QLUser checkten(@RequestBody QLUser qluser) {
		  QLUser ql=new QLUser("ten da ton tai");
		 
		  System.out.println(qluser.getTendangnhap()); 
	  	Optional<QLUser> u= QLUserService.findtdn(qluser.getTendangnhap());
	  	Optional<DangKy> dd=DangKyService.findBytendangnhap(qluser.getTendangnhap());
	 // System.out.println(u.get().getTendangnhap()+" "+"haubbo");
	  	if(u.isPresent()) {
	  		System.out.println("nnmmm");
	  		return ql;
	  	}
	  
	  	
	  	
	  		return new QLUser("mm");
	  	}
	  @PostMapping(value="/checkten1")
	  public  QLUser checkten1(@RequestBody QLUser qluser) {
		  QLUser ql=new QLUser("ten khong ton tai");
		  QLUser ql1=new QLUser("ten da duoc dang ky");
		 
	  	Optional<QLUser> u= QLUserService.findtdn(qluser.getTendangnhap());
	  	
		Optional<DangKy> dd=DangKyService.findBytendangnhap(qluser.getTendangnhap());
		 
	  System.out.println("haubbo");
	  	if(!u.isPresent()) {
	  	
	  		return ql;
	  	}
	  	 System.out.println(qluser.getTendangnhap()); 
	  	if(dd.isPresent()) {
	  		System.out.println(dd.get().getTendangnhap()+" "+"haubbo");
	  		return ql1;
	  	}
	  	
	  	
	  		return new QLUser("mm");
	  	}
}
//cxzxbnbvcxz xx1234567890.abstract 89
