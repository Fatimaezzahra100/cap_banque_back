package com.capBanque.capBanque.service;

import com.capBanque.capBanque.exeption.UserNotFoundException;
import com.capBanque.capBanque.model.Operation;
import com.capBanque.capBanque.model.OperationExterne;
import com.capBanque.capBanque.model.OperationInterne;
import com.capBanque.capBanque.repository.CompteRepository;
import com.capBanque.capBanque.repository.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    public OperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public Operation virementInterne(OperationInterne operation) {
        return operationRepository.save(operation);
    }

    public Operation virementExterne(OperationExterne operation) {
        return operationRepository.save(operation);
    }

    public List<Operation> getOperations() {
        return operationRepository.findAll();
    }

    public Operation getOperation(Long id) {
        return operationRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "Operation by id" + id + "was not found"));
    }

}
