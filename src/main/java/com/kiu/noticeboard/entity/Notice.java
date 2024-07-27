package com.kiu.noticeboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;
    @NotBlank(message = "ruleName should not be blank.")
    @NotEmpty(message = "ruleName should not empty.")
    private String ruleName;
    @NotBlank(message = "ruleName should not be blank.")
    @NotEmpty(message = "ruleName should not empty.")
    private String admin;
}
