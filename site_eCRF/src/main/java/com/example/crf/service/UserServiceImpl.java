package com.example.crf.service;

import com.example.crf.dto.UserResponseDTO;
import com.example.crf.entity.Study;
import com.example.crf.entity.User;
import com.example.crf.repositories.UserRepository;
import com.example.crf.service.Exception.UserServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponseDTO findById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new UserServiceException("User not found with id:" + id));
        return toDTO(user);
    }

    @Override
    public List<UserResponseDTO> findAll() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public UserResponseDTO toDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRoleName(user.getRole().getLibelle());
        dto.setStudyIds(user.getStudies().stream()
                .map(Study::getId)
                .toList());
        return dto;
    }
}
