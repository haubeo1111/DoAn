package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.ChucVu;

public interface ChucVuService {

	int delete(ChucVu chucvu);

	int edit(ChucVu chucvu);

	Optional<ChucVu> findById(int id);

	int save(ChucVu chucvu);

	List<ChucVu> findAll();

}
