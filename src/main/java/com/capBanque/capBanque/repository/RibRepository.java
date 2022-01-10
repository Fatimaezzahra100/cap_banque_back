package com.capBanque.capBanque.repository;

import com.capBanque.capBanque.model.Rib;
import com.capBanque.capBanque.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RibRepository extends JpaRepository<Rib, Long> {
}
