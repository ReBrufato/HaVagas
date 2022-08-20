package com.example.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.havagas.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding amb;

    private String nome;
    private  String email;
    private Boolean receberEmails;
    private String telefone;
    private String tipoTelefone;
    private String celular;
    private String sexo;
    private String data;
    private String formacao;
    private String vagasInteresse;
    private String anoFormatura;
    private String anoConclusao;
    private String instituicao;
    private String tituloMonografia;
    private String orientador;
    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amb = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(amb.getRoot());

        //seleção do checkbox celular
        amb.checkTelCel.setOnClickListener(view -> {
            if (amb.checkTelCel.isChecked()){
                amb.llTelCel.setVisibility(View.VISIBLE);
            }else{
                amb.llTelCel.setVisibility(View.GONE);
                amb.inptTelCel.setText("");
            }
        });

        //Tratamento spinner
        amb.inptFormacao.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                formacao = (i == 0)? "Fundamental" : (i == 1)? "Medio" : (i == 2)? "Graduacao" : (i == 3)? "Especializacao" :
                        (i == 4)? "Mestrado" : "Doutorado";

                if(i == 0 || i == 1){
                    amb.llgraducaoEspecializacao.setVisibility(View.GONE);
                    amb.llMestradoDoutorado.setVisibility(View.GONE);
                    amb.llFundamentalMedio.setVisibility(View.VISIBLE);
                }else if(i == 2 || i == 3){
                    amb.llFundamentalMedio.setVisibility(View.GONE);
                    amb.llMestradoDoutorado.setVisibility(View.GONE);
                    amb.llgraducaoEspecializacao.setVisibility(View.VISIBLE);
                }else{
                    amb.llgraducaoEspecializacao.setVisibility(View.GONE);
                    amb.llFundamentalMedio.setVisibility(View.GONE);
                    amb.llMestradoDoutorado.setVisibility(View.VISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        //Salvar
        amb.btnsalvar.setOnClickListener(view -> {

            nome = amb.inptNome.getText().toString();
            email = amb.inptEmail.getText().toString();
            receberEmails = amb.checkEmail.isChecked()? true : false;
            telefone = amb.inptTel.getText().toString();
            tipoTelefone = amb.radioTelComercial.isChecked()? "Comercial" : "Residencial";
            celular = amb.inptTelCel.getText().toString();
            sexo = amb.sexoMasc.isChecked()? "Masculino" : "Feminino";
            data = amb.inptDataNasc.getText().toString();
            vagasInteresse = amb.inptVagasInteresse.getText().toString();

            if(formacao.equals("Fundamental") || formacao.equals("Medio")){
                anoFormatura = amb.anoFormFundMedio.getText().toString();

                pessoa = new Pessoa(nome, email, receberEmails, telefone, tipoTelefone, celular, sexo, data, formacao, vagasInteresse, anoFormatura);
                Toast.makeText(MainActivity.this, pessoa.toStringFundMedio(), Toast.LENGTH_SHORT).show();

            }else if(formacao.equals("Graduacao") || formacao.equals("Especializacao")){
                anoConclusao = amb.inptAnoConclusaoGradEsp.getText().toString();
                instituicao = amb.inptInstituicaoGradEspec.getText().toString();

                pessoa = new Pessoa(nome, email, receberEmails, telefone, tipoTelefone, celular, sexo, data, formacao, vagasInteresse, anoConclusao, instituicao);
                Toast.makeText(this, pessoa.toStringGradEspec(), Toast.LENGTH_SHORT).show();
            }else{
                tituloMonografia = amb.tituloMonografia.getText().toString();
                orientador = amb.orientador.getText().toString();

                pessoa = new Pessoa(nome, email, receberEmails, telefone, tipoTelefone, celular, sexo, data, formacao, vagasInteresse, anoConclusao, instituicao, tituloMonografia, orientador);
                Toast.makeText(this, pessoa.toStringMestrDoutor(), Toast.LENGTH_SHORT).show();
            }
        });

        //Limpar
        amb.btnlimpar.setOnClickListener(view -> {
            amb.inptNome.setText("");
            amb.inptEmail.setText("");
            amb.checkEmail.setChecked(false);
            amb.inptTel.setText("");
            amb.radioTelComercial.setChecked(true);
            amb.inptTelCel.setText("");
            amb.sexoMasc.setChecked(true);
            amb.inptDataNasc.setText("");
            amb.anoFormFundMedio.setText("");
            amb.inptAnoConclusaoGradEsp.setText("");
            amb.anoConclusaoMestrDout.setText("");
            amb.inptInstituicaoMestrDout.setText("");
            amb.inptInstituicaoGradEspec.setText("");
            amb.tituloMonografia.setText("");
            amb.orientador.setText("");
            amb.checkTelCel.setChecked(false);
            amb.inptVagasInteresse.setText("");
            amb.inptTelCel.setVisibility(View.GONE);

            amb.checkTelCel.setOnClickListener(view1 -> {
                if(amb.checkTelCel.isChecked()){
                    amb.inptTelCel.setVisibility(View.VISIBLE);
                }else{
                    amb.inptTelCel.setVisibility(View.GONE);
                }
            });
        });

    }
}