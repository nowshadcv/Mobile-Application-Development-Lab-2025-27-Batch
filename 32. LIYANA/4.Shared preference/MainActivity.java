package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etNumber, etEmail;
    EditText etPassword, etConfirmPassword;
    Button btnRegister;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Initialize SharedPreferences
        preferences = getSharedPreferences(
                "RegistrationData",
                MODE_PRIVATE
        );

        // Register button click
        btnRegister.setOnClickListener(v -> {

            String name = etName.getText().toString().trim();
            String number = etNumber.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString();
            String confirmPassword =
                    etConfirmPassword.getText().toString();

            // Check empty fields
            if (name.isEmpty() || number.isEmpty()
                    || email.isEmpty() || password.isEmpty()
                    || confirmPassword.isEmpty()) {

                Toast.makeText(
                        MainActivity.this,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            // Validate email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter a valid email");
                etEmail.requestFocus();
                return;
            }

            // Validate phone number
            if (!number.matches("[0-9]{10}")) {
                etNumber.setError(
                        "Enter a valid 10-digit phone number"
                );
                etNumber.requestFocus();
                return;
            }

            // Validate password length
            if (password.length() < 8) {
                etPassword.setError(
                        "Password must contain at least 8 characters"
                );
                etPassword.requestFocus();
                return;
            }

            // Confirm password
            if (!password.equals(confirmPassword)) {
                etConfirmPassword.setError(
                        "Passwords do not match"
                );
                etConfirmPassword.requestFocus();
                return;
            }

            // Save non-sensitive registration data
            SharedPreferences.Editor editor = preferences.edit();

            editor.putString("name", name);
            editor.putString("number", number);
            editor.putString("email", email);

            // Never store plain-text passwords.
            editor.apply();

            // Show success message
            Toast.makeText(
                    MainActivity.this,
                    "Registration Successful",
                    Toast.LENGTH_LONG
            ).show();

            // Clear all fields
            etName.setText("");
            etNumber.setText("");
            etEmail.setText("");
            etPassword.setText("");
            etConfirmPassword.setText("");
        });
    }
}