package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PhongBan;

@Repository
public interface PhongBanRepository extends CrudRepository<PhongBan,Long>{
	@Query(value = "select * from PhongBan where isdelete=0",nativeQuery=true)
	List<PhongBan> getAll();
	@Query(value = "select * from PhongBan where id=? and isdelete=0",nativeQuery=true)
	Optional<PhongBan> find(long id);
	@Query(value = "SELECT * FROM PhongBan WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<PhongBan> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM PhongBan WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<PhongBan> findlk(String name);
	
	List<PhongBan> findByNameLike(String name);
}
