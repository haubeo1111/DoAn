package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Customers;
import com.example.demo.models.Hoadon;

@Repository
public interface HoadonRepository extends CrudRepository<Hoadon,Long>{
	@Query(value = "select * from hoadon where isdelete=0",nativeQuery=true)
	List<Hoadon> getAll();
	@Query(value = "select * from hoadon where id=? and isdelete=0",nativeQuery=true)
	Optional<Hoadon> find(long id);
	@Query(value = "SELECT * FROM hoadon WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<Hoadon> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM Hoadon WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<Hoadon> findlk(String name);
	
}
