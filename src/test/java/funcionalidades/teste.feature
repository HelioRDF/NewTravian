# language: pt
Funcionalidade: Login Travian
  Como: Jogador 
  Quero: Realizar login
  Para: Acessar minha conta travian

  Cenario: Login
    Dado Que estou na pagina de login
    E Digitei o usuario
    E Digitei a senha
    E Cliquei em entrar
    E Rejeito termos
    Entao Acesso a pagina Principal

  Esquema do Cenario: Clicar no campo
    Dado loguei na conta
    E cliquei no campo <aldeia>
    Entao valido

    Exemplos: 
      | aldeia |
      |      1 |
      |      2 |
      |      3 |
      |      4 |
      |      5 |
      |      6 |
      |      7 |
      |      8 |
      |      9 |
      |      10 |
      |      11 |
      |      12 |
      |      13 |
      |      14 |
      |      15 |
      |      16 |
      |      17 |
      |      18 |
