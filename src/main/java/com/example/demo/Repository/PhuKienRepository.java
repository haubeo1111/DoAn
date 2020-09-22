package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PhuKien;


@Repository
public interface PhuKienRepository extends CrudRepository<PhuKien,Long>{
	@Query(value = "select * from PhuKien where isdelete=0",nativeQuery=true)
	List<PhuKien> getAll();
	@Query(value = "select * from PhuKien where id=? and isdelete=0",nativeQuery=true)
	Optional<PhuKien> find(long id);
	@Query(value = "SELECT * FROM PhuKien WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<PhuKien> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM PhuKien WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<PhuKien> findlk(String name);
	
	//List<PhuKien> findByNameLike(String name);
}
