package com.burak.moviereview.dto;

import jakarta.persistence.Id;

public class UserDto {
    @Id
    private Long id;
    private String username;
    private String email;
    private String profilePicture;
}
