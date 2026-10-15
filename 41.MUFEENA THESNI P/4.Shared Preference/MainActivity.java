package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, mobilenum, email, pass1, pass2;
    Button submit;

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Connect Java with XML
        username = findViewById(R.id.username);
        mobilenum = findViewById(R.id.number);
        email = findViewById(R.id.email);
        pass1 = findViewById(R.id.password);
        pass2 = findViewById(R.id.conpassword);
        submit = findViewById(R.id.loginbtn);

        // Shared Preferences
        sharedpreferences = getSharedPreferences(
                "UserDetails",
                MODE_PRIVATE
        );

        editor = sharedpreferences.edit();

        // Submit Button
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String usernames = username.getText().toString().trim();
                String mobile1 = mobilenum.getText().toString().trim();
                String emails = email.getText().toString().trim();
                String pass1s = pass1.getText().toString().trim();
                String pass2s = pass2.getText().toString().trim();

                // Username validation
                if (usernames.isEmpty()) {
                    username.setError("Username is Empty");
                    username.requestFocus();
                    return;
                }

                // Mobile number validation
                if (mobile1.isEmpty()) {
                    mobilenum.setError("Enter Mobile Number");
                    mobilenum.requestFocus();
                    return;
                }

                // Email validation
                if (emails.isEmpty()) {
                    email.setError("Input Email");
                    email.requestFocus();
                    return;
                }

                // Password validation
                if (pass1s.isEmpty()) {
                    pass1.setError("Enter Password");
                    pass1.requestFocus();
                    return;
                }

                // Confirm password validation
                if (pass2s.isEmpty()) {
                    pass2.setError("Enter Password");
                    pass2.requestFocus();
                    return;
                }

                // Password length validation
                if (pass1s.length() < 6) {
                    pass1.setError(
                            "Length must be minimum 6 characters"
                    );
                    pass1.requestFocus();
                    return;
                }

                // Password matching validation
                if (!pass1s.equals(pass2s)) {
                    pass2.setError("Password not Matched");
                    pass2.requestFocus();
                    return;
                }

                // Save data
                editor.putString("keyusername", usernames);
                editor.putString("keymobile", mobile1);
                editor.putString("keyemail", emails);
                editor.putString("keypassword", pass2s);

                editor.apply();

                // Success message
                Toast.makeText(
                        MainActivity.this,
                        "Registration Successful",
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}