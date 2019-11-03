package com.ayp.project.ayp;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    @Query(value = "SELECT * from Registration WHERE PhoneNo = ?1",nativeQuery = true)
    public Registration findByPhone(@Param("PhoneNo") String PhoneNo);

    @Query(value = "SELECT RegId from Registration WHERE PhoneNo = ?1",nativeQuery = true)
    public int GetRegId(@Param("PhoneNo") String PhoneNo);



}


