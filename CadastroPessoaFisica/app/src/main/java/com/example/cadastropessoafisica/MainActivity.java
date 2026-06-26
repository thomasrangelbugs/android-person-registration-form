package com.example.cadastropessoafisica;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editCpf;
    private EditText editTelefone;
    private EditText editEmail;
    private EditText editRua;
    private EditText editNumero;
    private EditText editBairro;
    private EditText editCidade;
    private RadioGroup radioGroupGenero;
    private DatePicker datePickerNascimento;
    private TextView textResumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editCpf = findViewById(R.id.editCpf);
        editTelefone = findViewById(R.id.editTelefone);
        editEmail = findViewById(R.id.editEmail);
        editRua = findViewById(R.id.editRua);
        editNumero = findViewById(R.id.editNumero);
        editBairro = findViewById(R.id.editBairro);
        editCidade = findViewById(R.id.editCidade);
        radioGroupGenero = findViewById(R.id.radioGroupGenero);
        datePickerNascimento = findViewById(R.id.datePickerNascimento);
        textResumo = findViewById(R.id.textResumo);

        MaterialButton buttonExibirCadastro = findViewById(R.id.buttonExibirCadastro);
        buttonExibirCadastro.setOnClickListener(v -> exibirResumo());
    }

    private void exibirResumo() {
        String nome = editNome.getText().toString().trim();
        String cpf = editCpf.getText().toString().trim();

        if (nome.isEmpty() || cpf.isEmpty()) {
            Toast.makeText(this, R.string.mensagem_campos_obrigatorios, Toast.LENGTH_SHORT).show();
            textResumo.setVisibility(View.GONE);
            return;
        }

        String telefone = valorOuNaoInformado(editTelefone.getText().toString().trim());
        String email = valorOuNaoInformado(editEmail.getText().toString().trim());
        String rua = valorOuNaoInformado(editRua.getText().toString().trim());
        String numero = valorOuNaoInformado(editNumero.getText().toString().trim());
        String bairro = valorOuNaoInformado(editBairro.getText().toString().trim());
        String cidade = valorOuNaoInformado(editCidade.getText().toString().trim());
        String genero = obterGeneroSelecionado();
        String dataNascimento = String.format(
                Locale.getDefault(),
                "%02d/%02d/%04d",
                datePickerNascimento.getDayOfMonth(),
                datePickerNascimento.getMonth() + 1,
                datePickerNascimento.getYear()
        );

        String resumo = getString(
                R.string.resumo_formatado,
                nome,
                cpf,
                telefone,
                email,
                genero,
                dataNascimento,
                rua,
                numero,
                bairro,
                cidade
        );

        textResumo.setText(resumo);
        textResumo.setVisibility(View.VISIBLE);
        Toast.makeText(this, R.string.mensagem_sucesso, Toast.LENGTH_SHORT).show();
    }

    private String obterGeneroSelecionado() {
        int selectedId = radioGroupGenero.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return getString(R.string.nao_informado);
        }

        RadioButton radioButton = findViewById(selectedId);
        return radioButton.getText().toString();
    }

    private String valorOuNaoInformado(String valor) {
        return valor.isEmpty() ? getString(R.string.nao_informado) : valor;
    }
}
