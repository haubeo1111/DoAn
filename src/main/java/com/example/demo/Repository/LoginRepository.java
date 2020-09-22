package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login,Long>{
	@Query(value = "select * from Login where isdelete=0",nativeQuery=true)
	List<Login> getAll();
	@Query(value = "select * from Login where id=? and isdelete=0",nativeQuery=true)
	Optional<Login> find(long id);
	@Query(value = "SELECT * FROM Login WHERE tendangnhap = ?1 and password =?2", nativeQuery = true)
	Login checkByUsernameAndPassword(String username,String password);
	@Query(value = "select * from Login where tendangnhap=? and isdelete=0",nativeQuery=true)
	Optional<Login> findten(String name);
	@Query(value = "SELECT * FROM Login WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<Login> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM Login WHERE tendangnhap LIKE '%?%'; ",nativeQuery=true)
	List<Login> findlk(String name);
	
	//List<Login> findByNameLike(String name);
}
