package com.redis_register.redis_register.contoller;

import com.redis_register.redis_register.dto.RegisterDTO;
import com.redis_register.redis_register.entities.RegisterEntities;
import com.redis_register.redis_register.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Register")
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/add")
    public RegisterDTO add(@RequestBody RegisterDTO registerDTO) {
        return registerService.add(registerDTO);
    }

    @GetMapping("/get/{id}")
    public RegisterDTO get(@PathVariable String id) {
        return registerService.get(id);
    }

    @GetMapping("/getAll")
    public List<RegisterEntities> getAll() {

        return registerService.getAll();
    }

    @PutMapping("/update/{id}")
    public RegisterDTO update(@PathVariable String id, @RequestBody RegisterDTO registerDTO) {
        return registerService.update(id, registerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        return registerService.delete(id);
    }
}
