package br.edu.ceub.ds.aula04.view;

import br.edu.ceub.ds.aula04.model.Aluno;
import br.edu.ceub.ds.aula04.service.CadastroAlunos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaCadastroAluno extends JDialog {

    private JTextField txtNome;
    private JTextField txtCurso;
    private JTextField txtSemestre;
    private JTextField txtInstituicao;

    private JButton btnCadastrar;
    private JButton btnListar;
    private JButton btnBuscarNome;
    private JButton btnBuscarCurso;
    private JButton btnBuscarInstituicao;
    private JButton btnContar;
    private JButton btnLimparFiltros;

    private JTable tabelaAlunos;
    private DefaultTableModel tableModel;
    private JLabel lblTotal;

    private CadastroAlunos service;

    public TelaCadastroAluno(CadastroAlunos service) {
        this.service = service;

        setTitle("Cadastro de Alunos");
        setSize(580, 480);
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Painel Superior (Título, Formulário e Botões)
        JPanel panelTop = new JPanel(new BorderLayout(5, 5));

        JLabel lblTitulo = new JLabel("Cadastro de Alunos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        panelTop.add(lblTitulo, BorderLayout.NORTH);

        // Formulário
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 8, 8));
        panelForm.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        panelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        panelForm.add(txtNome);

        panelForm.add(new JLabel("Curso:"));
        txtCurso = new JTextField();
        panelForm.add(txtCurso);

        panelForm.add(new JLabel("Instituição:"));
        txtInstituicao = new JTextField();
        panelForm.add(txtInstituicao);

        panelForm.add(new JLabel("Semestre:"));
        txtSemestre = new JTextField();
        panelForm.add(txtSemestre);

        panelTop.add(panelForm, BorderLayout.CENTER);

        // Painel de Botões de Ação
        JPanel panelBotoes = new JPanel(new BorderLayout(8, 8));
        panelBotoes.setBorder(BorderFactory.createEmptyBorder(5, 20, 10, 20));

        JPanel panelGrid = new JPanel(new GridLayout(2, 3, 8, 8));

        btnCadastrar = new JButton("Cadastrar");
        btnListar = new JButton("Listar Todos");
        btnBuscarNome = new JButton("Buscar p/ Nome");
        btnBuscarCurso = new JButton("Buscar p/ Curso");
        btnBuscarInstituicao = new JButton("Buscar p/ Instituição");
        btnContar = new JButton("Contar Alunos");
        btnLimparFiltros = new JButton("Limpar Filtros");

// Os 6 botões ficam na grade 2x3
        panelGrid.add(btnCadastrar);
        panelGrid.add(btnListar);
        panelGrid.add(btnBuscarNome);

        panelGrid.add(btnBuscarCurso);
        panelGrid.add(btnBuscarInstituicao);
        panelGrid.add(btnContar);

// A grade fica no centro
        panelBotoes.add(panelGrid, BorderLayout.CENTER);

// O botão Limpar Filtros fica sozinho embaixo
        panelBotoes.add(btnLimparFiltros, BorderLayout.SOUTH);

        panelTop.add(panelBotoes, BorderLayout.SOUTH);

        add(panelTop, BorderLayout.NORTH);

        // Painel Inferior (Tabela de Listagem)
        String[] colunas = {"Nome", "Curso", "Instituição", "Semestre"};
        tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Impede a edição direta das células na tabela
            }
        };

        tabelaAlunos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabelaAlunos);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Alunos Cadastrados"));

        add(scrollPane, BorderLayout.CENTER);

        // Rodapé de Status
        lblTotal = new JLabel("Total de alunos cadastrados: 0", SwingConstants.LEFT);
        lblTotal.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        add(lblTotal, BorderLayout.SOUTH);

        // Eventos dos Botões
        btnCadastrar.addActionListener(e -> cadastrarAluno());
        btnListar.addActionListener(e -> listarAlunos());
        btnBuscarNome.addActionListener(e -> buscarPorNome());
        btnBuscarCurso.addActionListener(e -> buscarPorCurso());
        btnBuscarInstituicao.addActionListener(e -> buscarPorInstituicao());
        btnContar.addActionListener(e -> contarAlunos());
        btnLimparFiltros.addActionListener(e -> listarAlunos());


        // Carrega os dados na tabela ao abrir
        listarAlunos();
    }

    private void cadastrarAluno() {
        String instituicao = txtInstituicao.getText().trim();
        String nome = txtNome.getText().trim();
        String curso = txtCurso.getText().trim();
        String textoSemestre = txtSemestre.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo 'Nome'.", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocus();
            return;
        }

        if (!nome.matches("^[\\p{L}\\s]+$")) {
            JOptionPane.showMessageDialog(this, "O nome deve conter apenas letras e espaços.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            txtNome.requestFocus();
            return;
        }

        if (curso.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo 'Curso'.", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtCurso.requestFocus();
            return;
        }

        if (instituicao.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, preencha o campo 'Instituição'.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            txtInstituicao.requestFocus();
            return;
        }

        if (textoSemestre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha o campo 'Semestre'.", "Aviso", JOptionPane.WARNING_MESSAGE);
            txtSemestre.requestFocus();
            return;
        }

        int semestre;
        try {
            semestre = Integer.parseInt(textoSemestre);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O semestre deve ser um número válido.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            txtSemestre.requestFocus();
            return;
        }

        if (semestre < 1 || semestre > 10) {
            JOptionPane.showMessageDialog(this, "Informe um semestre válido entre 1 e 10.", "Erro de Validação", JOptionPane.WARNING_MESSAGE);
            txtSemestre.requestFocus();
            return;
        }

        Aluno novoAluno = new Aluno(nome, curso, instituicao, semestre);
        service.adicionar(novoAluno);

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
        listarAlunos(); // Atualiza a tabela automaticamente
    }

    private void listarAlunos() {
        atualizarTabela(service.getAlunos());
    }

    private void buscarPorNome() {
        String nomeBusca = JOptionPane.showInputDialog(this, "Digite o nome do aluno que deseja buscar:", "Buscar por Nome", JOptionPane.QUESTION_MESSAGE);

        if (nomeBusca != null && !nomeBusca.trim().isEmpty()) {
            Aluno encontrado = service.buscarPorNome(nomeBusca);
            if (encontrado != null) {
                atualizarTabela(List.of(encontrado));
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum aluno encontrado com este nome.", "Resultado", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void buscarPorCurso() {
        String cursoBusca = JOptionPane.showInputDialog(this, "Digite o nome do curso que deseja buscar:", "Buscar por Curso", JOptionPane.QUESTION_MESSAGE);

        if (cursoBusca != null && !cursoBusca.trim().isEmpty()) {
            List<Aluno> resultados = service.buscarPorCurso(cursoBusca);
            if (!resultados.isEmpty()) {
                atualizarTabela(resultados);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum aluno encontrado para o curso informado.", "Resultado", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void buscarPorInstituicao() {
        String instituicaoBusca = JOptionPane.showInputDialog(
                this,
                "Digite o nome da instituição:",
                "Buscar por Instituição",
                JOptionPane.QUESTION_MESSAGE);

        if (instituicaoBusca != null && !instituicaoBusca.trim().isEmpty()) {

            List<Aluno> resultados =
                    service.buscarPorInstituicao(instituicaoBusca);

            if (!resultados.isEmpty()) {
                atualizarTabela(resultados);
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Nenhum aluno encontrado para a instituição informada.",
                        "Resultado",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void contarAlunos() {
        int quantidade = service.quantidade();
        JOptionPane.showMessageDialog(this, "Atualmente existem " + quantidade + " aluno(s) cadastrado(s).", "Total de Alunos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void atualizarTabela(List<Aluno> lista) {
        tableModel.setRowCount(0); // Limpa as linhas anteriores
        for (Aluno a : lista) {
            tableModel.addRow(new Object[]{
                    a.getNome(),
                    a.getCurso(),
                    a.getInstituicao(),
                    a.getSemestre() + "º"
            });
        }
        lblTotal.setText("Total de alunos cadastrados: " + service.quantidade());
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCurso.setText("");
        txtInstituicao.setText("");
        txtSemestre.setText("");
        txtNome.requestFocus();
    }
}