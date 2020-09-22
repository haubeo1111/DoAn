package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.TangKem;
import com.example.demo.models.TangKem;

@Repository
public interface TangKemRepository extends CrudRepository<TangKem,Long>{
	@Query(value = "select * from TangKem where isdelete=0",nativeQuery=true)
	List<TangKem> getAll();
	@Query(value = "select * from TangKem where id=? and isdelete=0",nativeQuery=true)
	Optional<TangKem> find(long id);
	@Query(value = "SELECT * FROM TangKem WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<TangKem> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM TangKem WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<TangKem> findlk(String name);
	
	List<TangKem> findByNameLike(String name);
}
