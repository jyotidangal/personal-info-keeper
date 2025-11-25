package com.framework.java.datakeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.framework.java.datakeeper.entity.InformationEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepo extends JpaRepository<InformationEntity, Integer>{
    // to fetch data from the table 
 InformationEntity getInformationById(int id);
}
