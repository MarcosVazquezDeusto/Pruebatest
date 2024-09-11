package com.example.prueba_test;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private UserRepository userRepository;

    public LoginViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {
        return userRepository.login(username, password);
    }
}

