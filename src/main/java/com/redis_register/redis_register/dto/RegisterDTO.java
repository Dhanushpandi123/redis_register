package com.redis_register.redis_register.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String age;
    private String email;
}
