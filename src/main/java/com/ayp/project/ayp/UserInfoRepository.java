package com.ayp.project.ayp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    @Query(value = "SELECT * from UserInfo WHERE RegId = ?1",nativeQuery = true)
    public UserInfo userRegId(@Param("RegId") int RegId);


}
