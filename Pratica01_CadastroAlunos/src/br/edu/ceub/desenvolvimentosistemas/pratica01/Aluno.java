package br.edu.ceub.desenvolvimentosistemas.pratica01;

public class Aluno {
	
 private String nome;
 private int semestre;
 
 public Aluno(String nome, int semestre) {

 this.nome = nome;
 this.semestre = semestre;
 }
 
 public String getNome() {
 return nome;
 }
 
 public int getSemestre() {
 return semestre;
 }
 
 public String resumo() {
 return nome + " - " + semestre + "º semestre";
 }
}