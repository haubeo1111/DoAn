package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BangluongRepository;
import com.example.demo.models.BangLuong;

@Service
public class BangLuongServiceImpl implements BangLuongService{
@Autowired
BangluongRepository  bangluongRepository;

@Override
public List<BangLuong> getAll() {
	return bangluongRepository.getAll();
}

@Override
public Optional<BangLuong> find(int id) {
	return bangluongRepository.find(id);
}

@Override
public List<BangLuong> findup(String name) {
	return bangluongRepository.findup(name);
}

@Override
public BangLuong save(BangLuong entity) {
	return bangluongRepository.save(entity);
}

@Override
public List<BangLuong>  saveAll(List<BangLuong> entities) {
	return (List<BangLuong>) bangluongRepository.saveAll(entities);
}

@Override
public Optional<BangLuong> findById(Integer id) {
	return bangluongRepository.findById(id);
}

@Override
public boolean existsById(Integer id) {
	return bangluongRepository.existsById(id);
}

@Override
public List<BangLuong> findAll() {
	return (List<BangLuong>) bangluongRepository.findAll();
}

@Override
public List<BangLuong> findAllById(List<Integer> ids) {
	return (List<BangLuong>) bangluongRepository.findAllById(ids);
}

@Override
public long count() {
	return bangluongRepository.count();
}

@Override
public void deleteById(Integer id) {
	bangluongRepository.deleteById(id);
}

@Override
public void delete(BangLuong entity) {
	bangluongRepository.delete(entity);
}

@Override
public void deleteAll(List<BangLuong> entities) {
	bangluongRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	bangluongRepository.deleteAll();
}

}
