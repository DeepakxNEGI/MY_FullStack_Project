package com.DeepaksProject.foodapi.service;

import com.DeepaksProject.foodapi.io.UserRequest;
import com.DeepaksProject.foodapi.io.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRequest request);

    String findByUserId();
}
