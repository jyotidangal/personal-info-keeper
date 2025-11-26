package com.framework.java.datakeeper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="excel")
public class ExcelEntity {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @Column(name="name",nullable=false)
    private List<String> nameList = new ArrayList<>() ;
    @Column(name="email", nullable = false)
    private List<String> emailList = new ArrayList<>() ;
    @Column(name="age",nullable = false)
    private List<Integer> ageList = new ArrayList<>() ;
}
