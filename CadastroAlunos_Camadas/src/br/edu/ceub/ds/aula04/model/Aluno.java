package br.edu.ceub.ds.aula04.model;

public class Aluno {
    private String nome;
    private String curso;
    private int semestre;

    public Aluno(String nome, String curso, int semestre) {
        this.nome = nome;
        this.curso = curso;
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

    public String gerarResumo() {
        return "Nome: " + nome + " | Curso: " + curso + " | Semestre: " + semestre + "º";
    }
}