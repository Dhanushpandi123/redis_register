package com.redis_register.redis_register.service;

import com.redis_register.redis_register.dto.RegisterDTO;
import com.redis_register.redis_register.entities.RegisterEntities;
import com.redis_register.redis_register.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpHeaders;
import java.util.List;

@Service
@AllArgsConstructor
public class RegisterService {
    private final RegisterRepository registerRepository;

    @CacheEvict(value = {"Register","RegisterAll"},allEntries = true)
    public RegisterDTO add(RegisterDTO registerDTO) {
        RegisterEntities registerEntities = RegisterEntities.builder()
                .name(registerDTO.getName())
                .age(registerDTO.getAge())
                .email(registerDTO.getEmail())
                .build();

        RegisterEntities savedEntity=registerRepository.save(registerEntities);

        return RegisterDTO.builder()
                .id(savedEntity.getId())
                .name(savedEntity.getName())
                .age(savedEntity.getAge())
                .email(savedEntity.getEmail())
                .build();
    }
    @Cacheable(value = "Register" , key = "#id")
    public RegisterDTO get(String id) {
        RegisterEntities registerEntities=registerRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Register not found"));

        return RegisterDTO.builder()
                .id(registerEntities.getId())
                .name(registerEntities.getName())
                .age(registerEntities.getAge())
                .email(registerEntities.getEmail())
                .build();
    }
    @Cacheable(value = "RegisterAll")
    public List<RegisterEntities>getAll() {
        return registerRepository.findAll();
    }
    @CacheEvict(value = {"Register","RegisterAll"},allEntries = true)
    public RegisterDTO update(String id, RegisterDTO registerDTO) {
        RegisterEntities registerEntities = registerRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Register not found"));

        registerEntities.setName(registerDTO.getName());
        registerEntities.setAge(registerDTO.getAge());
        registerEntities.setEmail(registerDTO.getEmail());

        RegisterEntities updatedEntity = registerRepository.save(registerEntities);
        return RegisterDTO.builder()
                .id(updatedEntity.getId())
                .name(updatedEntity.getName())
                .age(updatedEntity.getAge())
                .email(updatedEntity.getEmail())
                .build();
    }
    @CacheEvict(value = {"Register","RegisterAll"},allEntries = true)
    public String delete(String id) {
        RegisterEntities registerEntities =registerRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Register not found"));
        registerRepository.delete(registerEntities);
        return "Delete successfully";
    }
}
