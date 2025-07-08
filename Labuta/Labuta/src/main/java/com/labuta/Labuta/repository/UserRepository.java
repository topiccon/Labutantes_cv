package com.labuta.Labuta.repository;

import com.labuta.Labuta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // pode adicionar métodos customizados aqui se quiser depois
}
