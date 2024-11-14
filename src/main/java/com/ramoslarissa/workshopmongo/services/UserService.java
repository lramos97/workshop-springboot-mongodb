package com.ramoslarissa.workshopmongo.services;

import com.ramoslarissa.workshopmongo.domain.User;
import com.ramoslarissa.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }
}
