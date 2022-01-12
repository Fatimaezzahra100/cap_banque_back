package com.capBanque.capBanque.repository;

import com.capBanque.capBanque.model.Operation;
import com.capBanque.capBanque.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
