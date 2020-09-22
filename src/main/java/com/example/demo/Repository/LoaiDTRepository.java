package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DienThoai;
import com.example.demo.models.LoaiDT;

@Repository
public interface LoaiDTRepository extends CrudRepository<LoaiDT,String> {
	@Query(value = "select * from loaidt where isdelete=0",nativeQuery=true)
	List<LoaiDT> getAll();
	@Query(value = "select * from loaidt where maloaidt=? and isdelete=0",nativeQuery=true)
	Optional<LoaiDT> find(String id);
	@Query(value = "SELECT * FROM loaidt WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<LoaiDT> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM loaidt WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<LoaiDT> findlk(String name);
	
	
}
