package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.LoaiPK;


@Repository
public interface LoaiPKRepository extends CrudRepository<LoaiPK,String>{
	@Query(value = "select * from LoaiPK where isdelete=0",nativeQuery=true)
	List<LoaiPK> getAll();
	@Query(value = "select * from LoaiPK where maLoaiPK=? and isdelete=0",nativeQuery=true)
	Optional<LoaiPK> find(String id);
	@Query(value = "SELECT * FROM LoaiPK WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<LoaiPK> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM LoaiPK WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<LoaiPK> findlk(String name);
}
