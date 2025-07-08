package com.labuta.Labuta.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labuta.Labuta.model.User;


@Repository
public class DiariaRepository {
    public interface UserRepository extends  JpaRepository<SecurityProperties.User, Long> {

        User saveAll(User diarista);

        public User save(User diarista);

    }

}
