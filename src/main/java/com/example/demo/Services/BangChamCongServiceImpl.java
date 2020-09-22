package com.example.demo.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.BangChamCongRepository;
import com.example.demo.models.BangChamCong;

@Service
public class BangChamCongServiceImpl implements BangChamCongService{
@Autowired
BangChamCongRepository bangChamCongRepository;

@Override
public List<BangChamCong> getAll() {
	return bangChamCongRepository.getAll();
}

@Override
public List<BangChamCong> getAll1(Date ngaycham) {
	return bangChamCongRepository.getAll1(ngaycham);
}

@Override
public Optional<BangChamCong> find(int id) {
	return bangChamCongRepository.find(id);
}

@Override
public List<BangChamCong> findup(String name) {
	return bangChamCongRepository.findup(name);
}

@Override
public BangChamCong  save(BangChamCong entity) {
	return bangChamCongRepository.save(entity);
}

@Override
public List<BangChamCong>  saveAll(List<BangChamCong> entities) {
	return (List<BangChamCong>) bangChamCongRepository.saveAll(entities);
}

@Override
public Optional<BangChamCong> findById(Long id) {
	return bangChamCongRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return bangChamCongRepository.existsById(id);
}

@Override
public List<BangChamCong> findAll() {
	return (List<BangChamCong>) bangChamCongRepository.findAll();
}

@Override
public List<BangChamCong> findAllById(List<Long> ids) {
	return (List<BangChamCong>) bangChamCongRepository.findAllById(ids);
}

@Override
public long count() {
	return bangChamCongRepository.count();
}

@Override
public void deleteById(Long id) {
	bangChamCongRepository.deleteById(id);
}

@Override
public void delete(BangChamCong entity) {
	bangChamCongRepository.delete(entity);
}

@Override
public void deleteAll(List<BangChamCong> entities) {
	bangChamCongRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	bangChamCongRepository.deleteAll();
}

}
