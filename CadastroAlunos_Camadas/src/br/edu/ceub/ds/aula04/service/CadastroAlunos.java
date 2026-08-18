package br.edu.ceub.ds.aula04.service;

import br.edu.ceub.ds.aula04.model.Aluno;
import java.util.ArrayList;
import java.util.List;


public class CadastroAlunos {
    private List<Aluno> alunos = new ArrayList<>();


    public void adicionar(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public int quantidade() {
        return alunos.size();
    }

    public Aluno buscarPorNome(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(nome.trim())) {
                return a;
            }
        }
        return null;
    }

    // Método novo para buscar por curso
    public List<Aluno> buscarPorCurso(String curso) {
        List<Aluno> resultado = new ArrayList<>();
        for (Aluno a : alunos) {
            if (a.getCurso().equalsIgnoreCase(curso.trim())) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public List<Aluno> buscarPorInstituicao(String instituicao) {
        List<Aluno> resultado = new ArrayList<>();

        for (Aluno a : alunos) {
            if (a.getInstituicao().equalsIgnoreCase(instituicao.trim())) {
                resultado.add(a);
            }
        }

        return resultado;
    }
}