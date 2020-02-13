package com.uau.android.uau_edu.Start_Login_Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uau.android.uau_edu.MainActivity;
import com.uau.android.uau_edu.R;

public class LoginActivity extends AppCompatActivity {

    private EditText editText_email;
    private EditText editText_password;
    private TextView textView_forgot_password;
    private Button btn_loginWithEmail;
    private ProgressBar progressBar;

    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Entre");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editText_email = findViewById(R.id.editText_email_login);
        editText_password = findViewById(R.id.edit_text_password_register);
        textView_forgot_password = findViewById(R.id.forgot_password);
        progressBar = findViewById(R.id.progressbar_login);
        btn_loginWithEmail = findViewById(R.id.btn_login_with_email);

        btn_loginWithEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editText_email.getText().toString().trim();
                password = editText_password.getText().toString();

                if(email.isEmpty()){
                    editText_email.setError("Digite o e-mail");
                    editText_email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editText_email.setError("Digite um e-mail válido");
                    editText_email.requestFocus();
                    return;
                }
                if(password.isEmpty() || password.length() < 6){
                    editText_password.setError("Senha deve possuir no mínimo 6 caracteres");
                    editText_password.requestFocus();
                    return;
                }

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //loginUser(email, password);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
