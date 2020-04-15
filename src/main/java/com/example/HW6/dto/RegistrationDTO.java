package com.example.HW6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    private String login;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String pass;

}
