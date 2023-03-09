package com.custom.validation.dto;


import com.custom.validation.customannotation.GenderCheck;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "name should not be null")
    private String name;

    @Email(message = "Invalid Email Address")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile Number Entered")
    private String mobile;

    @GenderCheck
    private String gender;

    @Min(18)
    @Max(60)
    private int age;

    @NotBlank
    private String nationality;
}
