package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.NhanVien;

public interface NhanVienService {

	int save(NhanVien nhanvien);

	List<NhanVien> findAll();

	Optional<NhanVien> findById(int id);

	int edit(NhanVien nhanvien);

	int delete(NhanVien nhanvien);

}
