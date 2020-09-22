package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.QLUser;

import com.example.demo.models.QLUser;

@Repository
public interface QLUserRepository extends CrudRepository<QLUser,Long>{
	@Query(value = "update QLUser set isdelete=1 where id=?1",nativeQuery=true)
	void isdeletes(long id);
	@Query(value = "select * from QLUser where isdelete=0",nativeQuery=true)
	List<QLUser> getAll();
	@Query(value = "select * from QLUser where tendangnhap=? and isdelete=0",nativeQuery=true)
	Optional<QLUser> findtdn(String tendangnhap);
	@Query(value = "select * from QLUser where id=? and isdelete=0",nativeQuery=true)
	Optional<QLUser> find(long id);
	@Query(value = "SELECT * FROM QLUser WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<QLUser> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM QLUser WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<QLUser> findlk(String name);
}
