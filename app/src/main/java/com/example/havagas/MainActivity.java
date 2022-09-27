package com.example.havagas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.havagas.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding amb;
    private final String TAG_CICLO_PDM = "TAG_CLICLO_PDM";

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

        //visibilidade do campo celular
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

            //visibilidade do campo celular
            amb.checkTelCel.setOnClickListener(view1 -> {
                if(amb.checkTelCel.isChecked()){
                    amb.inptTelCel.setVisibility(View.VISIBLE);
                }else{
                    amb.inptTelCel.setVisibility(View.GONE);
                }
            });
        });

    }

    @SuppressLint("LongLogTag")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("nome", amb.inptNome.getText().toString());
        outState.putString("email", amb.inptEmail.getText().toString());
        outState.putString("telefone", amb.inptTel.getText().toString());
        //outState.putString("tipoTelefone", tipoTelefone);
        outState.putString("celular", amb.inptTelCel.getText().toString());
        //outState.putString("sexo", sexo);
        outState.putString("data", amb.inptDataNasc.getText().toString());
        //outState.putString("formacao", formacao);
        outState.putString("vagasInteresse", amb.inptVagasInteresse.getText().toString());
        outState.putString("anoFormatura", amb.anoFormFundMedio.getText().toString());
        //outState.putString("anoConclusao", anoConclusao);
        //outState.putString("instituicao", instituicao);
        outState.putString("tituloMonografia", amb.tituloMonografia.getText().toString());
        outState.putString("orientador", amb.orientador.getText().toString());
        //outState.putBoolean("receberEmails", receberEmails);

        Log.v("Recuperação no onSaveInstanceState", "Dados salvos no Bundle outState");
    }

    //etapas do ciclo para visualização no console
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG_CICLO_PDM, "onStart: iniciando cliclo visivel");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG_CICLO_PDM, "onResume: iniciando cliclo foreground");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.v(TAG_CICLO_PDM, "onPause: finalizando ciclo foreground");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG_CICLO_PDM, "onStop: finalizando ciclo visivel");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.v(TAG_CICLO_PDM, "onRestar: iniciando chamada para ciclo visivel");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.v(TAG_CICLO_PDM, "onDestroy: finalizando ciclo/aplicacao");
    }



}