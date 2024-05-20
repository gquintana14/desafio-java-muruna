package com.muruna.crud.service;

import com.muruna.crud.dto.LoginDTO;
import com.muruna.crud.dto.ResponseDTO;
import com.muruna.crud.dto.UsuariosDTO;
import com.muruna.crud.model.Usuarios;

import java.util.List;

public interface UsuariosService {
    LoginDTO loadUserByUser(Usuarios user);
    ResponseDTO createNewUser(Usuarios user);
    ResponseDTO modifyUser(Usuarios user);
    void deleteUser(Long id);
    List<UsuariosDTO> getAllUsers();
}
