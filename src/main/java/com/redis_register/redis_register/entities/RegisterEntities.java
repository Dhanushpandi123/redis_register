package com.redis_register.redis_register.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "Register")
public class RegisterEntities implements Serializable {
     @Id
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String age;
    private String email;
}
