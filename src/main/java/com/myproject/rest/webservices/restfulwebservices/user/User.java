package com.myproject.rest.webservices.restfulwebservices.user;

import lombok.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class User {

    private Integer id;

    @Size(min = 2, message = "Name should have at least two characters")
    private String name;
    @Past
    private Date birthDate;
}
