package com.ayp.project.ayp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfilePhotoRepository extends JpaRepository<ProfilePhoto, Integer> {

    @Query(value = "SELECT * from ProfilePhoto WHERE RegId = ?1",nativeQuery = true)
    public ProfilePhoto profilePhotoRegId(@Param("RegId") int RegId);
}
