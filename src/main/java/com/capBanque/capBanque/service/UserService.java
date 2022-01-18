package com.capBanque.capBanque.service;
import com.capBanque.capBanque.exeption.UserNotFoundException;
import com.capBanque.capBanque.metier.BanqueMetierImplementation;
import com.capBanque.capBanque.model.*;
import com.capBanque.capBanque.repository.CompteRepository;
import com.capBanque.capBanque.repository.OperationRepository;
import com.capBanque.capBanque.repository.RibRepository;
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
    private CompteRepository compteRepository;

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private RibRepository ribRepository;

    @Autowired
    private BanqueMetierImplementation banque;

    @Autowired
    public UserService(UserRepository userRepository, CompteRepository compteRepository, OperationRepository operationRepository, RibRepository ribRepository, BanqueMetierImplementation banque) {
        this.userRepository = userRepository;
        this.compteRepository = compteRepository;
        this.operationRepository = operationRepository;
        this.ribRepository = ribRepository;
        this.banque = banque;
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
        userRepository.save(user);
        CompteCourant compteCourant = new CompteCourant(user.getUserId());
        compteRepository.save(compteCourant);

        Rib rib = new Rib(user.getUserId());
        ribRepository.save(rib);

        user.setCompteCourantId(compteCourant.getCompteId());
        user.setRibId(rib.getRibId());
        return userRepository.save(user);

    }

    public Compte getUserCC(Long user_id){
        User user = findUserById(user_id);
        Long ccId =  user.getCompteCourantId();
        return compteRepository.findById(ccId).orElseThrow(() -> new UserNotFoundException(
                "Account by id" + ccId + "was not found"));
    }

    public List<CompteEpargne> getUserCEs(Long user_id){
        User user = findUserById(user_id);
        return user.getComptesEpargne();
    }

    public List<Operation> getUserOps(Long user_id){
        User user = findUserById(user_id);
        return user.getOperations();
    }

    public Rib getUserRib(Long user_id){
        User user = findUserById(user_id);
        Long rib_id = user.getRibId();
        return ribRepository.findById(rib_id).orElseThrow(() -> new UserNotFoundException(
                "Rib by id" + rib_id + "was not found"));

    }

    public User getUserByRib(Rib rib){
        Long userId = rib.getUserId();
        return findUserById(userId);
    }

    public User addUserCE(CompteEpargne compteEpargne, Long user_id){

        compteEpargne.setUserId(user_id);
        compteEpargne.setBalance(0.0);
        compteRepository.save(compteEpargne);

        User user = findUserById(user_id);
        List<CompteEpargne> compteEpargnes = user.getComptesEpargne();
        compteEpargnes.add(compteEpargne);
        user.setComptesEpargne(compteEpargnes);
        return userRepository.save(user);



    }

    public User addUserOpIn(OperationInterne operation, Long user_id){
        User user = findUserById(user_id);

        //mise à jour des soldes de l'opération
        banque.virement(operation.getCompteSenderId(), operation.getCompteReceiverId(), operation.getAmount());
        operationRepository.save(operation);

        //mise à jour de la liste d'operations du user
        List<Operation> operations = user.getOperations();
        operations.add(operation);
        user.setOperations(operations);
        return userRepository.save(user);
    }

    public User addUserOpEx(OperationExterne operation, Long user_id){
        User user = findUserById(user_id);

        //mise à jour des soldes de l'opération
        Long userReceiverId = operation.getRibReceiver().getUserId();
        Long compteReceiverId = findUserById(userReceiverId).getCompteCourantId(); //compte courant du user possédant le ribRceuver
        banque.virement(operation.getCompteSenderId(), compteReceiverId, operation.getAmount());
        operationRepository.save(operation);

        //mise à jour de la liste d'operations du user
        List<Operation> operations = user.getOperations();
        operations.add(operation);
        user.setOperations(operations);
        return userRepository.save(user);
    }







}
