package br.edu.ceub.desenvolvimentosistemas.pratica02;

import java.util.ArrayList;

public class CadastroAlunos {
    private ArrayList<Alunos> alunos = new ArrayList<>();

    public void adicionar(Alunos aluno) {
        alunos.add(aluno);
    }

    public int quantidade() {
        return alunos.size();
    }

    public ArrayList<Alunos> getAlunos() {
        return alunos;
    }

    public Alunos buscarPorNome(String nome) {
        for (Alunos aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }
}