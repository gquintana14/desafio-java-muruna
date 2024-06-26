package com.muruna.crud.controller;

import com.muruna.crud.exception.CrudException;
import com.muruna.crud.model.Usuarios;
import com.muruna.crud.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UsuariosController {

    @Autowired
    private UsuariosService userService;

    @PostMapping("/login")
    public ResponseEntity getUser(@RequestBody Usuarios login){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.loadUserByUser(login));
        }catch (CrudException e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/createuser")
    public ResponseEntity createNewUser(@RequestBody Usuarios usuarios){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(usuarios));
        }catch (CrudException e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PatchMapping("/modifyUser")
    public ResponseEntity modifyUser(@RequestBody Usuarios usuarios){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.modifyUser(usuarios));
        }catch (CrudException e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/findAllUsers")
    public ResponseEntity getAllUsers(){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.getAllUsers());
        }catch (CrudException e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(value="id") Long id){
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario: " + id + " ha sido eliminado");
        }catch (CrudException e){
            e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
