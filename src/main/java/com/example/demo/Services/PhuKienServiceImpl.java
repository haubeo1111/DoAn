package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.PhuKienRepository;
import com.example.demo.models.PhuKien;

@Service
public class PhuKienServiceImpl implements PhuKienService{
@Autowired
PhuKienRepository phuKienRepository ;

@Override
public List<PhuKien> getAll() {
	return phuKienRepository.getAll();
}

@Override
public Optional<PhuKien> find(long id) {
	return phuKienRepository.find(id);
}

@Override
public List<PhuKien> findup(String name) {
	return phuKienRepository.findup(name);
}

@Override
public List<PhuKien> findlk(String name) {
	return phuKienRepository.findlk(name);
}

@Override
public PhuKien save(PhuKien entity) {
	return phuKienRepository.save(entity);
}



@Override
public List<PhuKien>  saveAll(List<PhuKien> entities) {
	return (List<PhuKien>) phuKienRepository.saveAll(entities);
}

@Override
public Optional<PhuKien> findById(Long id) {
	return phuKienRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return phuKienRepository.existsById(id);
}

@Override
public List<PhuKien> findAll() {
	return (List<PhuKien>) phuKienRepository.findAll();
}

@Override
public List<PhuKien> findAllById(Iterable<Long> ids) {
	return (List<PhuKien>) phuKienRepository.findAllById(ids);
}

@Override
public long count() {
	return phuKienRepository.count();
}

@Override
public void deleteById(Long id) {
	phuKienRepository.deleteById(id);
}

@Override
public void delete(PhuKien entity) {
	phuKienRepository.delete(entity);
}

@Override
public void deleteAll(List<PhuKien> entities) {
	phuKienRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	phuKienRepository.deleteAll();
}

}
