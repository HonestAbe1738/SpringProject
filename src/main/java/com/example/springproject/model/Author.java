package com.example.springproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("AUTHORS")
public class Author {
    
    @Id
    private Long id;
    
    private String name;
    private String biography;
}
