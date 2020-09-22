package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.NhanVienRepository;
import com.example.demo.models.NhanVien;

@Service
public class NhanVienServiceimpl implements NhanVienService {
@Autowired
NhanVienRepository nhanVienRepository;

@Override
public List<NhanVien> findAll() {
	return nhanVienRepository.findAll();
}

@Override
public int save(NhanVien nhanvien) {
	return nhanVienRepository.save(nhanvien);
}

@Override
public Optional<NhanVien> findById(int id) {
	return nhanVienRepository.findById(id);
}

@Override
public int delete(NhanVien nhanvien) {
	return nhanVienRepository.delete(nhanvien);
}

@Override
public int edit(NhanVien nhanvien) {
	return nhanVienRepository.edit(nhanvien);
}

}
