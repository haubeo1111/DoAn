package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.VaiTroRepository;
import com.example.demo.models.DangKy;
import com.example.demo.models.VaiTro;

@Service
public class VaiTroServiceImpl implements VaiTroService {
@Autowired
VaiTroRepository vaiTroRepository;



@Override
public int update(String tenvt, String mavt, Long id) {
	return vaiTroRepository.update(tenvt, mavt, id);
}

@Override
public void isdeletes(long id) {
	vaiTroRepository.isdeletes(id);
}

@Override
public List<VaiTro> getAll() {
	return vaiTroRepository.getAll();
}

@Override
public Optional<VaiTro> find(long id) {
	return vaiTroRepository.find(id);
}

@Override
public List<VaiTro> findup(String name) {
	return vaiTroRepository.findup(name);
}

@Override
public List<VaiTro> findlk(String name) {
	return vaiTroRepository.findlk(name);
}

@Override
public VaiTro  save(VaiTro entity) {
	return vaiTroRepository.save(entity);
}

@Override
public List<VaiTro>  saveAll(List<VaiTro> entities) {
	return (List<VaiTro>) vaiTroRepository.saveAll(entities);
}

@Override
public Optional<VaiTro> findById(Long id) {
	return vaiTroRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return vaiTroRepository.existsById(id);
}

@Override
public List<VaiTro> findAll() {
	return (List<VaiTro>) vaiTroRepository.findAll();
}

@Override
public List<VaiTro> findAllById(Iterable<Long> ids) {
	return (List<VaiTro>) vaiTroRepository.findAllById(ids);
}

@Override
public long count() {
	return vaiTroRepository.count();
}

@Override
public void deleteById(Long id) {
	vaiTroRepository.deleteById(id);
}

@Override
public void delete(VaiTro entity) {
	vaiTroRepository.delete(entity);
}

@Override
public void deleteAll(List<VaiTro> entities) {
	vaiTroRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	vaiTroRepository.deleteAll();
}

}
