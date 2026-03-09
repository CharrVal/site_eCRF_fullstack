package com.example.crf.service;

import com.example.crf.dto.UserResponseDTO;
import com.example.crf.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDTO findById(Long id);
    List<UserResponseDTO> findAll();
    UserResponseDTO toDTO(User user);
}
