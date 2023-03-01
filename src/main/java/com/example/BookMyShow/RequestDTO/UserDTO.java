package com.example.BookMyShow.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String name;

    private String email;

    private int age;

    private String address;

    private String mobile;
}
