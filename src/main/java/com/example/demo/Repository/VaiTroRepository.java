package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.DangKy;
import com.example.demo.models.VaiTro;



@Repository
public interface VaiTroRepository extends CrudRepository<VaiTro, Long>{
	@Query(value = "update vaitro set isdelete=1 where id=?1",nativeQuery=true)
	void isdeletes(long id);
	@Query(value = "select * from vaitro where isdelete=0",nativeQuery=true)
	List<VaiTro> getAll();
	@Query(value = "select * from vaitro where id=? and isdelete=0",nativeQuery=true)
	Optional<VaiTro> find(long id);
	@Query(value = "SELECT * FROM vaitro WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<VaiTro> findup(String name);
	@Modifying
	@Transactional
	@Query(value = "UPDATE vaitro SET  tenvt=?, mavt=? WHERE id=?;", nativeQuery = true)
    int update( @Param("tenvt") String tenvt, @Param("mavt") String mavt,  @Param("id") Long id);
	
	//@Modifying
	 //@Transactional(readOnly=false)
	//@Transactional
	//@Query(value = "INSERT INTO public.qtht_chucnang(id, machucnang, tenchucnang, maapi, congkhai, isdelete) VALUES (?, ?, ?, ?, ?, ?);", nativeQuery = true)
	//int insertChucNang1(@Param("id") Long id, @Param("machucnang") String machucnang, @Param("tenchucnang") String tenchucnang, @Param("maapi") String maapi, @Param("cong khai") String congkhai, @Param("isdelete") Integer isdelete);
	
	//@Modifying
	//@Transactional
	//@Query(value = "UPDATE public.qtht_chucnang SET id=?, tenchucnang=?, maapi=?, congkhai=?, isdelete=? WHERE machucnang=?;", nativeQuery = true)
	//int updateChucNang1(@Param("id") Long id, @Param("tenchucnang") String tenchucnang, @Param("maapi") String maapi, @Param("cong khai") String congkhai, @Param("isdelete") Integer isdelete, @Param("machucnang") String machucnang);
	
	//@Modifying
	//@Transactional
	//@Query(value = "UPDATE public.qtht_chucnang SET isdelete=1 WHERE id=?", nativeQuery = true)
	//int deleteChucNang1(@Param("id") Long id);
	
//	@Transactional
//	@Query(value = "select cn.id, cn.machucnang, cn.tenchucnang, cn.maapi, cn.congkhai, cn.isdelete from qtht_chucnang cn where cn.id = ?;", nativeQuery = true)
	//ChucNang1 findByChucNangId(Long id);
	
//	@Transactional
	//@Query(value = "select cn.id, cn.machucnang, cn.tenchucnang, cn.maapi, cn.congkhai, cn.isdelete from qtht_chucnang cn where cn.machucnang = ?;", nativeQuery = true)
	//Optional<ChucNang1> findByChucNangMachucnang(String machucnang);
	
	//@Transactional
	//@Query(value = "select id, machucnang, tenchucnang, maapi, congkhai, isdelete from qtht_chucnang where isdelete = 0", nativeQuery = true)
	//List<ChucNang1> findAllChucNang1();
	
	//@Transactional
	//@Query(value = "SELECT * FROM qtht_chucnang WHERE tenchucnang @@ to_tsquery(?1)", nativeQuery = true)
	//List<ChucNang1> findByTenchucnang(String tenchucnang);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM quyenhan WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<VaiTro> findlk(String name);
}
