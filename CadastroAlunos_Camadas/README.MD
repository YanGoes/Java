# Aula 4 - Cadastro de Alunos em Camadas

Projeto Java Desktop desenvolvido para a disciplina **Desenvolvimento de Sistemas (CEUB)** utilizando **Java Swing**, organização em camadas e versionamento com Git.

## Objetivo

Desenvolver um sistema de cadastro de alunos aplicando conceitos de Programação Orientada a Objetos, separação de responsabilidades e controle de versões.

## Funcionalidades

- Cadastro de alunos.
- Validação do nome (aceita apenas letras e espaços).
- Cadastro da instituição de ensino.
- Validação do semestre (1º ao 10º).
- Listagem dos alunos cadastrados.
- Busca por nome.
- Busca por curso.
- Busca por instituição.
- Contagem do total de alunos cadastrados.

## Como executar

1. Abra o projeto no Eclipse ou IntelliJ IDEA.
2. Execute a classe `br.edu.ceub.ds.aula04.app.Principal`.
3. Utilize a interface para cadastrar, listar, buscar e contar alunos.

## Estrutura do projeto

```text
src/
└── br/
    └── edu/
        └── ceub/
            └── ds/
                └── aula04/
                    ├── model/
                    │   └── Aluno.java
                    ├── service/
                    │   └── CadastroAlunos.java
                    ├── view/
                    │   └── TelaCadastroAluno.java
                    └── app/
                        └── Principal.java
```

## Organização das camadas

| Pacote | Responsabilidade |
|---------|------------------|
| `model` | Representa a entidade `Aluno` e seus atributos. |
| `service` | Contém as regras de negócio e operações sobre os alunos. |
| `view` | Interface gráfica desenvolvida em Java Swing. |
| `app` | Classe responsável por iniciar a aplicação. |

## Tecnologias utilizadas

- Java
- Java Swing
- Git
- GitHub
- Eclipse / IntelliJ IDEA

## Melhorias implementadas

Durante o desenvolvimento foram adicionadas as seguintes melhorias:

- Organização do projeto em camadas (`model`, `service`, `view` e `app`).
- Campo obrigatório **Instituição** no cadastro.
- Nova coluna **Instituição** na tabela de alunos.
- Busca de alunos por instituição.
- Validação do nome para impedir números.
- Atualização automática da tabela e do contador de alunos.

## Autor

**Yan Henrique Rios Goes Santos**

Projeto desenvolvido para a disciplina **Desenvolvimento de Sistemas (CEUB)**.