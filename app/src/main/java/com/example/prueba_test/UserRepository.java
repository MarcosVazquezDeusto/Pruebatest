package com.example.prueba_test;

public class UserRepository {

    // Método para simular el inicio de sesión
    public boolean login(String username, String password) {
        // Aquí puedes agregar la lógica para verificar las credenciales
        // Por ejemplo, podrías verificar contra una base de datos o una lista de usuarios
        if ("correctUser".equals(username) && "correctPassword".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
