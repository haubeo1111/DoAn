package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.ChucVuRepository;
import com.example.demo.models.ChucVu;

@Service
public class ChucVuServiceimpl implements ChucVuService {
@Autowired
ChucVuRepository  chucVuRepository;

@Override
public List<ChucVu> findAll() {
	return chucVuRepository.findAll();
}

@Override
public int save(ChucVu chucvu) {
	return chucVuRepository.save(chucvu);
}

@Override
public Optional<ChucVu> findById(int id) {
	return chucVuRepository.findById(id);
}

@Override
public int edit(ChucVu chucvu) {
	return chucVuRepository.edit(chucvu);
}

@Override
public int delete(ChucVu chucvu) {
	return chucVuRepository.delete(chucvu);
}

}
