package br.edu.ceub.ds.aula04.model;

public class Aluno {
    private String nome;
    private String curso;
    private int semestre;
    private String instituicao;

    public Aluno(String nome, String curso, String instituicao, int semestre) {
        this.nome = nome;
        this.curso = curso;
        this.instituicao = instituicao;
        this.semestre = semestre;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String gerarResumo() {
        return "Nome: " + nome +
                "\nCurso: " + curso +
                "\nInstituição: " + instituicao +
                "\nSemestre: " + semestre;
    }
}