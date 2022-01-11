package com.capBanque.capBanque.repository;

import com.capBanque.capBanque.model.Compte;
import com.capBanque.capBanque.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
}
