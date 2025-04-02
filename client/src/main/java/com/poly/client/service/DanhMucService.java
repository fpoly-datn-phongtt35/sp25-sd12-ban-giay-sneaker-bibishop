package com.poly.client.service;

import com.poly.client.entity.DanhMucEntity;
import com.poly.client.repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucService {

  @Autowired
  DanhMucRepository danhMucRepository;

  public List<DanhMucEntity> findAll() {
    return danhMucRepository.findAll();
  }

}
