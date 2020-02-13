package com.uau.android.uau_edu.Start_Login_Register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.uau.android.uau_edu.EditTextMasks.MaskCepTelData;
import com.uau.android.uau_edu.EditTextMasks.MaskCpfCnpj;
import com.uau.android.uau_edu.EditTextMasks.MoneyTextWatcher;
import com.uau.android.uau_edu.MainActivity;
import com.uau.android.uau_edu.R;

public class CompleteCadastroActivity extends AppCompatActivity {

    private Button button_register;
    private EditText nome;
    private EditText cpf;
    private EditText filiacao;
    private EditText nascimento;
    private EditText end_residencial;
    private EditText end_comercial;
    private EditText telefone;
    private EditText celular;
    private EditText profissao;
    private EditText renda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_cadastro);

        button_register = findViewById(R.id.btn_continue_images);
        nome = findViewById(R.id.edit_text_nome_completo);
        cpf = findViewById(R.id.edit_text_cpf);
        cpf.addTextChangedListener(MaskCpfCnpj.insert(cpf));
        filiacao = findViewById(R.id.edit_text_filiacao);
        nascimento = findViewById(R.id.edit_text_nascimento);
        nascimento.addTextChangedListener(MaskCepTelData.mask(nascimento, MaskCepTelData.FORMAT_DATE));
        end_residencial = findViewById(R.id.edit_text_endereco_residencial);
        end_comercial = findViewById(R.id.edit_text_endereco_comercial);
        telefone = findViewById(R.id.edit_text_telefone);
        telefone.addTextChangedListener(MaskCepTelData.mask(telefone, MaskCepTelData.FORMAT_TEL));
        celular = findViewById(R.id.edit_text_celular);
        celular.addTextChangedListener(MaskCepTelData.mask(celular, MaskCepTelData.FORMAT_CELL));
        profissao = findViewById(R.id.edit_text_profissao);
        renda = findViewById(R.id.edit_text_renda);
        renda.addTextChangedListener(new MoneyTextWatcher(renda));

        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompleteCadastroActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
    }
}
