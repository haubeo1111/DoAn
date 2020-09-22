package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TKLoaiDT;
import com.example.demo.models.TKLoaiDT;
@Repository
public interface TKLoaiDTRepository extends CrudRepository<TKLoaiDT,Long>{
	@Query(value = "select * from TKLoaiDT where isdelete=0",nativeQuery=true)
	List<TKLoaiDT> getAll();
	@Query(value = "select * from TKLoaiDT where id=? and isdelete=0",nativeQuery=true)
	Optional<TKLoaiDT> find(long id);
	@Query(value = "SELECT * FROM TKLoaiDT WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<TKLoaiDT> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM TKLoaiDT WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<TKLoaiDT> findlk(String name);
	
	
}
