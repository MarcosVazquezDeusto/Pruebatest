package com.example.prueba_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView errorMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        errorMessageTextView = findViewById(R.id.error_message);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                if (username.equals("correctUser") && password.equals("correctPassword")) {
                    // Inicio de sesión exitoso, mostrar la pantalla principal
                    errorMessageTextView.setVisibility(View.GONE);
                    Intent intent = new Intent(MainActivity.this, MainScreenActivity.class);
                    startActivity(intent);
                } else {
                    // Credenciales incorrectas, mostrar mensaje de error
                    errorMessageTextView.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}