package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.KhuyenMaiRepository;
import com.example.demo.models.KhuyenMai;

@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService{
@Autowired
KhuyenMaiRepository khuyenMaiRepository ;

@Override
public List<KhuyenMai> getAll() {
	return khuyenMaiRepository.getAll();
}

@Override
public Optional<KhuyenMai> find(int id) {
	return khuyenMaiRepository.find(id);
}

@Override
public List<KhuyenMai> findup(String name) {
	return khuyenMaiRepository.findup(name);
}

@Override
public KhuyenMai save(KhuyenMai entity) {
	return khuyenMaiRepository.save(entity);
}

@Override
public List<KhuyenMai>  saveAll(List<KhuyenMai> entities) {
	return (List<KhuyenMai>) khuyenMaiRepository.saveAll(entities);
}

@Override
public Optional<KhuyenMai> findById(Long id) {
	return khuyenMaiRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return khuyenMaiRepository.existsById(id);
}

@Override
public Iterable<KhuyenMai> findAll() {
	return khuyenMaiRepository.findAll();
}

@Override
public List<KhuyenMai> findAllById(Iterable<Long> ids) {
	return (List<KhuyenMai>) khuyenMaiRepository.findAllById(ids);
}

@Override
public long count() {
	return khuyenMaiRepository.count();
}

@Override
public void deleteById(Long id) {
	khuyenMaiRepository.deleteById(id);
}

@Override
public void delete(KhuyenMai entity) {
	khuyenMaiRepository.delete(entity);
}

@Override
public void deleteAll(List<KhuyenMai> entities) {
	khuyenMaiRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	khuyenMaiRepository.deleteAll();
}

}
