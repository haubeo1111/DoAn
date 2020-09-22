package com.example.demo.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.Repository.NhanVienRepository.EmployeeRowMapper;
import com.example.demo.models.DienThoai;
import com.example.demo.models.Employee;
import com.example.demo.models.NhanVien;
@Repository
public interface DienThoaiRepository extends CrudRepository<DienThoai,Long>{
	@Query(value = "select * from dienthoai where isdelete=0",nativeQuery=true)
	List<DienThoai> getAll();
	@Query(value = "select * from dienthoai where id=? and isdelete=0",nativeQuery=true)
	Optional<DienThoai> find(long id);
	@Query(value = "SELECT * FROM dienthoai WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<DienThoai> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM dienthoai WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<DienThoai> findlk(String name);
	
	List<DienThoai> findByNameLike(String name);
			 
		  
}
