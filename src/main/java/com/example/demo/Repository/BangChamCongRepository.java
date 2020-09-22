package com.example.demo.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.BangChamCong;
import com.example.demo.models.BangChamCong;

@Repository
public interface BangChamCongRepository extends CrudRepository<BangChamCong,Long>{
	@Query(value = "select * from BangChamCong where isdelete=0",nativeQuery=true)
	List<BangChamCong> getAll();
	@Query(value = "select * from BangChamCong where isdelete=0 and ngaycham=?",nativeQuery=true)
	List<BangChamCong> getAll1(Date ngaycham);
	@Query(value = "select * from BangChamCong where id=? and isdelete=0",nativeQuery=true)
	Optional<BangChamCong> find(int id);
	@Query(value = "SELECT * FROM BangChamCong WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<BangChamCong> findup(String name);
}
