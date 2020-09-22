package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.DangkyRepository;
import com.example.demo.models.DangKy;

@Service
public class DangKyServiceImpl implements DangKyService{
@Autowired
DangkyRepository DangkyRepository;

@Override
public int insert(Long id, String tendangnhap, String password, Integer isdelete) {
	return DangkyRepository.insert(id, tendangnhap, password, isdelete);
}

@Override
public int update(String tendangnhap, String password, Long id) {
	return DangkyRepository.update(tendangnhap, password, id);
}

@Override
public DangKy save(DangKy entity) {
	return DangkyRepository.save(entity);
}

@Override
public <S extends DangKy> Optional<S> findOne(Example<S> example) {
	return DangkyRepository.findOne(example);
}

@Override
public int delete(Long id) {
	return DangkyRepository.delete(id);
}

@Override
public Optional<DangKy> findById(Long id) {
	return DangkyRepository.findById(id);
}

@Override
public Page<DangKy> findAll(Pageable pageable) {
	return DangkyRepository.findAll(pageable);
}

@Override
public Optional<DangKy> findBytendangnhap(String tendangnhap) {
	return DangkyRepository.findBytendangnhap(tendangnhap);
}

@Override
public List<DangKy> findAll(Sort sort) {
	return DangkyRepository.findAll(sort);
}

@Override
public List<DangKy> findAll() {
	return DangkyRepository.findAll();
}

@Override
public List<DangKy> findAllById(Iterable<Long> ids) {
	return DangkyRepository.findAllById(ids);
}

@Override
public List<DangKy> findByTendangnhap(String tenchucnang) {
	return DangkyRepository.findByTendangnhap(tenchucnang);
}

@Override
public List<DangKy>  saveAll(List<DangKy> entities) {
	return DangkyRepository.saveAll(entities);
}

@Override
public void flush() {
	DangkyRepository.flush();
}

@Override
public DangKy saveAndFlush(DangKy entity) {
	return DangkyRepository.saveAndFlush(entity);
}

@Override
public boolean existsById(Long id) {
	return DangkyRepository.existsById(id);
}

@Override
public void deleteInBatch(List<DangKy> entities) {
	DangkyRepository.deleteInBatch(entities);
}



@Override
public void deleteAllInBatch() {
	DangkyRepository.deleteAllInBatch();
}

@Override
public DangKy getOne(Long id) {
	return DangkyRepository.getOne(id);
}



@Override
public <S extends DangKy> boolean exists(Example<S> example) {
	return DangkyRepository.exists(example);
}

@Override
public <S extends DangKy> List<S> findAll(Example<S> example) {
	return DangkyRepository.findAll(example);
}

@Override
public long count() {
	return DangkyRepository.count();
}

@Override
public void deleteById(Long id) {
	DangkyRepository.deleteById(id);
}

@Override
public <S extends DangKy> Page<S> findAll(Example<S> example, Pageable pageable) {
	return DangkyRepository.findAll(example, pageable);
}

@Override
public <S extends DangKy> long count(Example<S> example) {
	return DangkyRepository.count(example);
}

@Override
public <S extends DangKy> List<S> findAll(Example<S> example, Sort sort) {
	return DangkyRepository.findAll(example, sort);
}

@Override
public void delete(DangKy entity) {
	DangkyRepository.delete(entity);
}

@Override
public void deleteAll(List<DangKy> entities) {
	DangkyRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	DangkyRepository.deleteAll();
}


}
