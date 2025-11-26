package com.framework.java.datakeeper.repository;

import com.framework.java.datakeeper.entity.ExcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExcelRepo extends JpaRepository<ExcelEntity,Integer> {

}
