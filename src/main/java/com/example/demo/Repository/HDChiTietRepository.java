package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.HDChiTiet;
import com.example.demo.models.HDChiTiet;

@Repository
public interface HDChiTietRepository extends CrudRepository<HDChiTiet,Long>{
	@Query(value = "select * from HDChiTiet where isdelete=0",nativeQuery=true)
	List<HDChiTiet> getAll();
	@Query(value = "select * from HDChiTiet where id=? and isdelete=0",nativeQuery=true)
	Optional<HDChiTiet> find(long id);
	@Query(value = "SELECT * FROM HDChiTiet WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<HDChiTiet> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM HDChiTiet WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<HDChiTiet> findlk(String name);
}
