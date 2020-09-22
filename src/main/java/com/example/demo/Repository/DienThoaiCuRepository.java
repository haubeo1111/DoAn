package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DienThoaiCu;
@Repository
public interface DienThoaiCuRepository extends CrudRepository<DienThoaiCu,Long>{
	@Query(value = "select * from DienThoaiCu where isdelete=0",nativeQuery=true)
	List<DienThoaiCu> getAll();
	@Query(value = "select * from DienThoaiCu where id=? and isdelete=0",nativeQuery=true)
	Optional<DienThoaiCu> find(long id);
	@Query(value = "select * from DienThoaiCu where madt=? and isdelete=0",nativeQuery=true)
	Optional<DienThoaiCu> findma(String madt);
	@Query(value = "SELECT * FROM DienThoaiCu WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<DienThoaiCu> findup(String name);
}
