package com.example.demo.repository;

import com.example.demo.model.OldUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDataJpaRepository extends CrudRepository<OldUser, Long> {

    OldUser findByName(String name);

    List<OldUser> findAllByOrderByIdDesc();

    @Query("from OldUser o where o.name = :nameParam")
    OldUser getByName(@Param("nameParam") String nameParam);

    @Query(value = "select * from user o where o.name = :nameParam", nativeQuery = true)
    OldUser getByNameUsingNativeQuery(@Param("nameParam") String nameParam);
}
