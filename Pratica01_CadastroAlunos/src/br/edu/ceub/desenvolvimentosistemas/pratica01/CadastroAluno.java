package br.edu.ceub.desenvolvimentosistemas.pratica01;
import javax.swing.JOptionPane;

public class CadastroAluno {
 public static void main(String[] args) {
	 
 Aluno aluno1 = new Aluno("Pedro", 4);
 Aluno aluno2 = new Aluno("João", 3);
 Aluno aluno3 = new Aluno("Maria", 6);
 
 System.out.println(aluno1.resumo());
 
 System.out.println(aluno2.resumo());
 
 System.out.println(aluno3.resumo());
 
 String mensagem = aluno1.resumo()
		 + "\n" + aluno2.resumo()
		 + "\n" + aluno3.resumo();
		JOptionPane.showMessageDialog(
		 null,
		 mensagem,
		 "Cadastro de alunos",
		 JOptionPane.INFORMATION_MESSAGE
		);
 }
}