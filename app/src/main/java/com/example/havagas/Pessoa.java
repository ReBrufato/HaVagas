package com.example.havagas;

public class Pessoa {
    private String nome;
    private  String email;
    private Boolean receberEmails = false;
    private String telefone;
    private String tipoTelefone;
    private String celular;
    private String sexo;
    private String data;
    private String formacao;

    //fundamental e médio
    private String anoFormatura;

    //graduação e especialização
    private String anoConclusao;
    private String instituicao;

    //mestrado e doutorado
    //anoConclusao
    //instituicao
    private String tituloMonografia;
    private String orientador;

    //fundamental e médio
    public Pessoa(String nome, String email, Boolean receberEmails, String telefone, String tipoTelefone, String celular, String sexo, String data, String formacao,
                  String anoForatura) {
        this.nome = nome;
        this.email = email;
        this.receberEmails = receberEmails;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.celular = celular;
        this.sexo = sexo;
        this.data = data;
        this.formacao = formacao;
        this.anoFormatura = anoForatura;
    }

    //graduação e especialização
    public Pessoa(String nome, String email, Boolean receberEmails, String telefone, String tipoTelefone, String celular, String sexo, String data, String formacao,
                  String anoConclusao, String instituicao) {
        this.nome = nome;
        this.email = email;
        this.receberEmails = receberEmails;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.celular = celular;
        this.sexo = sexo;
        this.data = data;
        this.formacao = formacao;
        this.anoConclusao = anoConclusao;
        this.instituicao = instituicao;
    }

    //mestrado e doutorado

    public Pessoa(String nome, String email, Boolean receberEmails, String telefone, String tipoTelefone, String celular, String sexo, String data, String formacao,
                  String anoConclusao, String instituicao, String tituloMonografia, String orientador) {
        this.nome = nome;
        this.email = email;
        this.receberEmails = receberEmails;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.celular = celular;
        this.sexo = sexo;
        this.data = data;
        this.formacao = formacao;
        this.anoConclusao = anoConclusao;
        this.instituicao = instituicao;
        this.tituloMonografia = tituloMonografia;
        this.orientador = orientador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getReceberEmails() {
        return receberEmails;
    }

    public void setReceberEmails(Boolean receberEmails) {
        this.receberEmails = receberEmails;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getAnoForatura() {
        return anoFormatura;
    }

    public void setAnoForatura(String anoForatura) {
        this.anoFormatura = anoForatura;
    }

    public String getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(String anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTituloMonografia() {
        return tituloMonografia;
    }

    public void setTituloMonografia(String tituloMonografia) {
        this.tituloMonografia = tituloMonografia;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String toStringFundMedio() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", receberEmails=" + receberEmails +
                ", telefone='" + telefone + '\'' +
                ", tipoTelefone='" + tipoTelefone + '\'' +
                ", celular='" + celular + '\'' +
                ", sexo='" + sexo + '\'' +
                ", data='" + data + '\'' +
                ", formacao='" + formacao + '\'' +
                ", anoForatura='" + anoFormatura + '\'' +
                '}';
    }

    public String toStringGradEspec() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", receberEmails=" + receberEmails +
                ", telefone='" + telefone + '\'' +
                ", tipoTelefone='" + tipoTelefone + '\'' +
                ", celular='" + celular + '\'' +
                ", sexo='" + sexo + '\'' +
                ", data='" + data + '\'' +
                ", formacao='" + formacao + '\'' +
                ", anoConclusao='" + anoConclusao + '\'' +
                ", instituicao='" + instituicao + '\'' +
                '}';
    }

    public String toStringMestrDoutor() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", receberEmails=" + receberEmails +
                ", telefone='" + telefone + '\'' +
                ", tipoTelefone='" + tipoTelefone + '\'' +
                ", celular='" + celular + '\'' +
                ", sexo='" + sexo + '\'' +
                ", data='" + data + '\'' +
                ", formacao='" + formacao + '\'' +
                ", anoConclusao='" + anoConclusao + '\'' +
                ", instituicao='" + instituicao + '\'' +
                ", tituloMonografia='" + tituloMonografia + '\'' +
                ", orientador='" + orientador + '\'' +
                '}';
    }
}
