package com.example.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Customers;
import com.example.demo.models.Employee;
import com.example.demo.models.NhanVien;

@Repository
public interface CustomerRepository extends CrudRepository<Customers,Long> {
	
	@Query(value = "select * from customers where isdelete=0",nativeQuery=true)
	List<Customers> getAll();
	@Query(value = "select * from customers where id=? and isdelete=0",nativeQuery=true)
	Optional<Customers> find(long id);
	@Query(value = "SELECT * FROM customers WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<Customers> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM customers WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<Customers> findlk(String name);
	
	List<Customers> findByNameLike(String name);
	 
	 
	@Modifying
	@Transactional
	@Query(value = "update customers set name=?1,gender=?2,birthday=?3,"
			+ "email=?4,phone=?5,password=?6,address=?7 where id=?8",nativeQuery = true)
	int update(String name,int gender,Date birthday,String email,String phone,
			String password,String address,Long id);
}
