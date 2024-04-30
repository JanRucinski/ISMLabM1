package io.swagger.service;

import io.swagger.model.InlineResponse200;

public interface UserService {
    InlineResponse200 loginUser(String email, String password);
    InlineResponse200 logoutUser();
    InlineResponse200 createUser(String email, String password);
}
