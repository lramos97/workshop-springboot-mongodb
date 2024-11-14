package com.ramoslarissa.workshopmongo.resource;

import com.ramoslarissa.workshopmongo.domain.User;
import com.ramoslarissa.workshopmongo.dto.UserDTO;
import com.ramoslarissa.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserResourse {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {

        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(UserDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {

        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}
