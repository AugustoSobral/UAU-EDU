package com.uau.android.uau_edu.Start_Login_Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.uau.android.uau_edu.MainActivity;
import com.uau.android.uau_edu.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText editText_nome_sobrenome;
    private EditText editText_email;
    private EditText editText_password;
    private EditText editText_password_confirmation;
    private ProgressBar progressBar;
    private Button button_register;
    private String email;
    private String password;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Cadastre-se");

        editText_nome_sobrenome = findViewById(R.id.edit_text_nome_e_sobrenome_register_email_screen);
        editText_email = findViewById(R.id.edit_text_email_register);
        editText_password = findViewById(R.id.edit_text_password_register);
        editText_password_confirmation = findViewById(R.id.edit_text_password_confirmation);
        button_register = findViewById(R.id.btn_continue_images);
        progressBar = findViewById(R.id.progressbar_register_email);

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editText_email.getText().toString().trim();
                password = editText_password.getText().toString();
                nome = editText_nome_sobrenome.getText().toString();
                String passwordConfirmation = editText_password_confirmation.getText().toString();

                if(nome.isEmpty()){
                    editText_nome_sobrenome.setError("Digite seu nome e sobrenome");
                    editText_nome_sobrenome.requestFocus();
                    return;
                }

                if(email.isEmpty()){
                    editText_email.setError("Digite o email");
                    editText_email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editText_email.setError("Digite um email válido");
                    editText_email.requestFocus();
                    return;
                }
                if(password.isEmpty() || password.length() < 6){
                    editText_password.setError("Senha deve possuir no mínimo 6 caracteres");
                    editText_password.requestFocus();
                    return;
                }
                if(!password.equals(passwordConfirmation)){
                    editText_password.setError("Senhas digitadas estão diferentes");
                    editText_password_confirmation.setError("Senhas digitadas estão diferentes");
                    editText_password.requestFocus();
                    return;
                }

                //registerUser(email, password);

                Toast.makeText(RegisterActivity.this, "Conta registrada com sucesso!",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, CompleteCadastroActivity.class);
                startActivity(intent);
            }
        });

    }

    /*@Override
    protected void onStart() {
        super.onStart();

        if(mUser!= null && !mUser.isAnonymous()){
            Intent intent = new Intent(RegisterEmailActivity.this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }*/

}
