# Aula 4 - Cadastro de Alunos Em Camadas (CEUB)

Projeto Java Desktop desenvolvido para a disciplina **Desenvolvimento de Sistemas (CEUB)** utilizando **Java Swing**, organização em camadas e versionamento com Git.

## Objetivo

Aplicar os conceitos de Programação Orientada a Objetos, separação de responsabilidades e controle de versões por meio de um sistema de cadastro de alunos.

## Funcionalidades

- Cadastro de alunos;
- Listagem dos alunos cadastrados;
- Busca por nome;
- Busca por curso;
- Exibição do total de alunos cadastrados.

## Estrutura do projeto

```text
src/
└── br/
    └── edu/
        └── ceub/
            └── ds/
                └── aula04/
                    ├── br.edu.ceub.ds.aula04.model/
                    │   └── Aluno.java
                    ├── br.edu.ceub.ds.aula04.service/
                    │   └── CadastroAlunos.java
                    ├── br.edu.ceub.ds.aula04.view/
                    │   └── TelaCadastroAluno.java
                    └── br.edu.ceub.ds.aula04.app/
                        └── Principal.java
```

### Organização das camadas

| Pacote | Responsabilidade |
|---------|------------------|
| `model` | Entidade `Aluno` e seus atributos. |
| `service` | Regras de negócio e gerenciamento dos alunos. |
| `view` | Interface gráfica desenvolvida em Java Swing. |
| `app` | Classe responsável por iniciar a aplicação. |

## Como executar

1. Abra o projeto no Eclipse ou IntelliJ IDEA.
2. Execute a classe `br.edu.ceub.ds.aula04.app.Principal`.
3. Utilize a interface para cadastrar, buscar, listar e contar alunos.

## Tecnologias utilizadas

- Java
- Java Swing
- Git
- GitHub
- Eclipse / IntelliJ IDEA

## Autor

**Yan Henrique Rios Goes Santos**

Projeto desenvolvido para fins acadêmicos na disciplina **Desenvolvimento de Sistemas**.