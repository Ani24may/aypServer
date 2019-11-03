package com.ayp.project.ayp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FamilyInfoRepository extends JpaRepository<FamilyInfo, Integer> {

    @Query(value = "SELECT * from FamilyInfo WHERE RegId = ?1",nativeQuery = true)
    public FamilyInfo familyRegId(@Param("RegId") int RegId);

}
