package br.edu.ceub.desenvolvimentosistemas.pratica02;

public class Alunos {
    private String nome;
    private int semestre;
    private String curso;

    public Alunos(String nome, int semestre, String curso) {
        this.nome = nome;
        this.semestre = semestre;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public String getCurso() {
        return curso;
    }

    public String gerarResumo() {
        return nome + " - " + curso + " - " + semestre + "º semestre";
    }
}