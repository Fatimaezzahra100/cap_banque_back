package com.capBanque.capBanque.service;
import com.capBanque.capBanque.exeption.UserNotFoundException;
import com.capBanque.capBanque.model.*;
import com.capBanque.capBanque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(
                "Account by id" + id + "was not found"));
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User updateUser(User user, Long id) {
        User userToUpdate = findUserById(id);
        userToUpdate.setUserId(user.getUserId());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setUserName(user.getUserName());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setTel(user.getTel());
        return userRepository.save(userToUpdate);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public CompteCourant getUserCC(Long user_id){
        User user = findUserById(user_id);
        return user.getCompteCourant();
    }

    public List<CompteEpargne> getUserCEs(Long user_id){
        User user = findUserById(user_id);
        return user.getComptesEpargne();
    }

    public List<Operation> getUserOps(Long user_id){
        User user = findUserById(user_id);
        return user.getOperations();
    }

    public void addUserCE(CompteEpargne compteEpargne, Long user_id){
        User user = findUserById(user_id);
        List<CompteEpargne> compteEpargnes = user.getComptesEpargne();
        compteEpargnes.add(compteEpargne);
        user.setComptesEpargne(compteEpargnes);
    }

    public void addUserOpIn(OperationInterne operation, Long user_id){
        User user = findUserById(user_id);
        List<Operation> operations = user.getOperations();
        operations.add(operation);
        user.setOperations(operations);
    }

    public void addUserOpEx(OperationExterne operation, Long user_id){
        User user = findUserById(user_id);
        List<Operation> operations = user.getOperations();
        operations.add(operation);
        user.setOperations(operations);
    }




}
