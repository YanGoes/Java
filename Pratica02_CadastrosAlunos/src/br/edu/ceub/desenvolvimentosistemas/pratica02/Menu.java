package br.edu.ceub.desenvolvimentosistemas.pratica02;

import javax.swing.JOptionPane;

public class Menu {

    public static void main(String[] args) {
        CadastroAlunos cadastro = new CadastroAlunos();
        int opcao = -1;

        String menuText = "--- CADASTRO DE ALUNOS ---\n\n"
                + "1 - Cadastrar aluno\n"
                + "2 - Listar alunos\n"
                + "3 - Buscar aluno por nome\n"
                + "0 - Sair\n\n"
                + "Escolha uma opção:";

        while (opcao != 0) {
            String entradaOpcao = JOptionPane.showInputDialog(null, menuText, "Menu Principal", JOptionPane.QUESTION_MESSAGE);

            if (entradaOpcao == null) {
                break;
            }

            try {
                opcao = Integer.parseInt(entradaOpcao);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida! Digite um número.", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog(null, "Digite o nome do aluno:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
                    if (nome == null || nome.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nome inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    String curso = JOptionPane.showInputDialog(null, "Digite o curso:", "Cadastro", JOptionPane.QUESTION_MESSAGE);
                    if (curso == null || curso.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Curso inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    String entradaSemestre = JOptionPane.showInputDialog(null, "Digite o semestre (1 a 10):", "Cadastro", JOptionPane.QUESTION_MESSAGE);
                    int semestre = 0;
                    try {
                        semestre = Integer.parseInt(entradaSemestre);
                        if (semestre < 1 || semestre > 10) {
                            JOptionPane.showMessageDialog(null, "Semestre deve ser entre 1 e 10!", "Erro", JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Semestre inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    Alunos novoAluno = new Alunos(nome, semestre, curso);
                    cadastro.adicionar(novoAluno);
                    JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    break;

                case 2:
                    if (cadastro.quantidade() == 0) {
                        JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado.", "Listagem", JOptionPane.WARNING_MESSAGE);
                    } else {
                        StringBuilder listaFormatada = new StringBuilder("--- LISTA DE ALUNOS ---\n\n");
                        for (Alunos a : cadastro.getAlunos()) {
                            listaFormatada.append(a.gerarResumo()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, listaFormatada.toString(), "Lista de Alunos", JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case 3:
                    String nomeBusca = JOptionPane.showInputDialog(null, "Digite o nome para buscar:", "Busca", JOptionPane.QUESTION_MESSAGE);
                    if (nomeBusca != null && !nomeBusca.trim().isEmpty()) {
                        Alunos encontrado = cadastro.buscarPorNome(nomeBusca);
                        if (encontrado != null) {
                            JOptionPane.showMessageDialog(null, "Aluno encontrado:\n\n" + encontrado.gerarResumo(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Aluno não encontrado!", "Resultado", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...", "Sair", JOptionPane.INFORMATION_MESSAGE);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}