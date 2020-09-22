package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.VaitroChucNangRepository;
import com.example.demo.models.VaitroChucNang;

@Service
public class VaiTroChucNangServiceImpl implements VaitroChucNangService{
@Autowired
VaitroChucNangRepository vaitroChucNangRepository ;

@Override
public List<VaitroChucNang> getAll() {
	return vaitroChucNangRepository.getAll();
}

@Override
public Optional<VaitroChucNang> find(long id) {
	return vaitroChucNangRepository.find(id);
}

@Override
public Optional<VaitroChucNang> findidcn(long id) {
	return vaitroChucNangRepository.findidcn(id);
}

@Override
public List<VaitroChucNang> findiduser(long id) {
	return vaitroChucNangRepository.findiduser(id);
}

@Override
public VaitroChucNang save(VaitroChucNang entity) {
	return vaitroChucNangRepository.save(entity);
}

@Override
public List<VaitroChucNang> findup(String name) {
	return vaitroChucNangRepository.findup(name);
}

@Override
public List<VaitroChucNang>  saveAll(List<VaitroChucNang> entities) {
	return (List<VaitroChucNang>) vaitroChucNangRepository.saveAll(entities);
}

@Override
public Optional<VaitroChucNang> findById(Long id) {
	return vaitroChucNangRepository.findById(id);
}

@Override
public boolean existsById(Long id) {
	return vaitroChucNangRepository.existsById(id);
}

@Override
public List<VaitroChucNang> findAll() {
	return (List<VaitroChucNang>) vaitroChucNangRepository.findAll();
}

@Override
public List<VaitroChucNang> findAllById(List<Long> ids) {
	return (List<VaitroChucNang>) vaitroChucNangRepository.findAllById(ids);
}

@Override
public long count() {
	return vaitroChucNangRepository.count();
}

@Override
public void deleteById(Long id) {
	vaitroChucNangRepository.deleteById(id);
}

@Override
public void delete(VaitroChucNang entity) {
	vaitroChucNangRepository.delete(entity);
}

@Override
public void deleteAll(List<VaitroChucNang> entities) {
	vaitroChucNangRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	vaitroChucNangRepository.deleteAll();
}


}
