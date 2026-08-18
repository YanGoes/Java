package br.edu.ceub.ds.aula04.app;

import br.edu.ceub.ds.aula04.model.Aluno;
import br.edu.ceub.ds.aula04.service.CadastroAlunos;
import br.edu.ceub.ds.aula04.view.TelaCadastroAluno;

import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        CadastroAlunos service = new CadastroAlunos();

        String[] opcoesMenu = {"Cadastrar", "Listar", "Buscar", "Sair"};
        boolean executando = true;

        while (executando) {
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção no Menu Principal:",
                    "Menu Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoesMenu,
                    opcoesMenu[0]
            );

            switch (escolha) {
                case 0:
                    TelaCadastroAluno tela = new TelaCadastroAluno(service);
                    tela.setVisible(true);
                    break;

                case 1:
                    listarAlunos(service);
                    break;

                case 2:
                    buscarAluno(service);
                    break;

                case 3:
                case JOptionPane.CLOSED_OPTION:
                    executando = false;
                    break;
            }
        }
    }

    private static void listarAlunos(CadastroAlunos service) {
        if (service.quantidade() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado até o momento.", "Listagem", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("--- LISTA DE ALUNOS CADASTRADOS ---\n\n");
        for (Aluno a : service.getAlunos()) {
            sb.append(a.gerarResumo()).append("\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString(), "Alunos Cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void buscarAluno(CadastroAlunos service) {
        String nomeBusca = JOptionPane.showInputDialog(null, "Digite o nome do aluno que deseja buscar:", "Buscar Aluno", JOptionPane.QUESTION_MESSAGE);

        if (nomeBusca != null && !nomeBusca.trim().isEmpty()) {
            Aluno encontrado = service.buscarPorNome(nomeBusca);
            if (encontrado != null) {
                JOptionPane.showMessageDialog(null, "Aluno Encontrado:\n\n" + encontrado.gerarResumo(), "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum aluno foi encontrado com este nome.", "Resultado", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}