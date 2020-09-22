package com.example.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.models.Employee;
import com.example.demo.models.NhanVien;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	// List<Employee> findByNameContaining(String q);
	// Employee findOne(long id);
	//@Query(value = "SELECT * FROM employee WHERE username = ?1 and password =?2", nativeQuery = true)
	@Query(value = "update employee set isdelete=1 where id=?1",nativeQuery=true)
	void isdeletes(long id);
	@Query(value = "select * from employee where isdelete=0",nativeQuery=true)
	List<Employee> getAll();
	@Query(value = "select * from employee where id=? and isdelete=0",nativeQuery=true)
	Optional<Employee> find(long id);
	@Query(value = "SELECT * FROM employee WHERE name @@ to_tsquery(?)",nativeQuery=true)
	List<Employee> findup(String name);
	// String[] words = s1.split("\\s");
	//for (String w : words) {
	  // System.out.println(w);
   //}
	@Query(value = "SELECT * FROM employee WHERE name LIKE '%?%'; ",nativeQuery=true)
	List<Employee> findlk(String name);
	
	List<Employee> findByNameLike(String name);
	//@Modifying
	//@Transactional
	//@Query(value = "INSERT INTO qtht_categories (category_id,category_name,category_key,creat_day,"
	///		+ "creat_by,update_day,update_by,is_delete) VALUES(?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
	//void add(Long category_id,String category_name,String category_key, Date creat_day,
	//		String creat_by,Date update_day,String update_by,Byte is_delete);
	
	//@Modifying
	//@Transactional
	//@Query(value = "update qtht_categories set category_name=?1,category_key=?2,update_day=?3,"
	//		+ "update_by=?4,is_delete=?5 where category_id=?6",nativeQuery = true)
	//int update(String category_name,String category_key,Date update_day,
	//		String update_by,Byte is_delete,Long category_id);
	
	//Category findByCategoryKeyAndIsDelete(String categoryKey, Byte isDelete);
	//
	//List<Category> findByIsDelete(Byte isDelete);

	//Page<Category> findByIsDelete(Byte isDelete, Pageable page);
	
	//List<Category> findByCategoryNameContainingAndIsDelete(String categoryName, Byte isDelete);
	
	//Page<Category> findByCategoryNameContainingAndIsDelete(String categoryName, Byte isDelete ,Pageable page);
}
