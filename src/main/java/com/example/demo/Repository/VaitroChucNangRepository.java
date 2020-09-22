package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.VaitroChucNang;
import com.example.demo.models.VaitroChucNang;

@Repository
public interface VaitroChucNangRepository extends CrudRepository<VaitroChucNang,Long>{
	@Query(value = "select * from VaitroChucNang where isdelete=0",nativeQuery=true)
	List<VaitroChucNang> getAll();
	@Query(value = "select * from VaitroChucNang where id=? and isdelete=0",nativeQuery=true)
	Optional<VaitroChucNang> find(long id);
	@Query(value = "select * from VaitroChucNang where idcn=? and isdelete=0",nativeQuery=true)
	Optional<VaitroChucNang> findidcn(long id);
	@Query(value = "select * from VaitroChucNang where idvt=? and isdelete=0",nativeQuery=true)
	List<VaitroChucNang> findiduser(long id);
	@Query(value = "SELECT * FROM VaitroChucNang WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<VaitroChucNang> findup(String name);
}
