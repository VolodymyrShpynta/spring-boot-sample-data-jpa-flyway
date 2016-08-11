package com.sample.repositories;

import com.sample.entity.Lecturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
    List<Lecturer> findByFirstName(String firstName);
}
