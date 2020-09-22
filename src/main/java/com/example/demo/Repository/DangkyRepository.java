package com.example.demo.Repository;
import com.example.demo.models.DangKy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository
public interface DangkyRepository extends JpaRepository<DangKy, Long>{
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO dangky(id,tendangnhap,password, isdelete) VALUES (?, ?, ?, ?);", nativeQuery = true)
	int insert(@Param("id") Long id, @Param("tendangnhap") String tendangnhap, @Param("password") String password,  @Param("isdelete") Integer isdelete);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE dangky SET  tendangnhap=?, password=?   WHERE id=?;", nativeQuery = true)
	int update( @Param("tendangnhap") String tendangnhap, @Param("password") String password,    @Param("id") Long id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE dangky SET isdelete=1 WHERE id=?", nativeQuery = true)
	int delete(@Param("id") Long id);
	
	@Transactional
	@Query(value = "select id, tendangnhap,password,isdelete  from dangky where id = ?;", nativeQuery = true)
	Optional<DangKy>  findById(Long id);

	@Transactional
	@Query(value = "select id,tendangnhap,password,isdelete from dangky where tendangnhap = ? and isdelete=0;", nativeQuery = true)
	Optional<DangKy> findBytendangnhap(@Param("tendangnhap") String tendangnhap);
	@Modifying
	@Transactional
	@Query(value = "select id, tendangnhap,password,isdelete from dangky where isdelete = 0", nativeQuery = true)
	List<DangKy> findAll();
	@Modifying
	@Transactional
	@Query(value = "SELECT * FROM dangky WHERE tendangnhap @@ to_tsquery(?1)", nativeQuery = true)
	List<DangKy> findByTendangnhap(String tenchucnang);
}
