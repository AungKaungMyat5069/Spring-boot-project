package org.example.studentmappingdemo.dao;

import org.example.studentmappingdemo.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceDao extends JpaRepository<Province, Integer> {
}
