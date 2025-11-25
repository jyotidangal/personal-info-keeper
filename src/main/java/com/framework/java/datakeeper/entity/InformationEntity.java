package com.framework.java.datakeeper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name="users_data")



public class InformationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( name="first_name",nullable = false)
    private String firstName;//field defining
    @Column( name="last_name",nullable = false)
    private String lastName;
    @Column( name="email",nullable = false,unique = true)
    private String email;
    @Column( name="address",nullable = false,columnDefinition = "text")
    private String address;
    @Column( name="gender",nullable = false)
    private String gender;
//To store the list of strings
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name="user_images",
//                foreign key contained column
            joinColumns = @JoinColumn(name ="user_id")
    )
//        second column
    @Column( name="image_Path")
    private List<String> imagePaths = new ArrayList<>();
}
