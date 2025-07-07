package com.labuta.Labuta.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DiaristaRepository {
    public interface UserRepository extends  JpaRepository<SecurityProperties.User, Long> {
    
    }

}
