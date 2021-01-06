#language: pt
# encoding: utf8

Funcionalidade: Efetuar Login
  Como um cliente eventual, gostaria de efetuar Login no site Petz

  Esquema do Cenario: Efetuar Login de Usuario com sucesso
    Dado que acesso o site da Petz
    Quando preciono Cadastre-se
    E seleciono Entrar
    Quando preencho o <email> e a <senha> e clico em entrar
    Entao efetuo o login com sucesso
  Exemplos:
    | email                              | senha        |
    | "rodrigootavioaugusto@maildrop.cc" | "DzIcMCckzh" |
    | "rosangelataniaana@maildrop.cc"    | "9RpAbQ2UEZ" |
    | "cristianeemilly@maildrop.cc"      | "GHHWc3X1ap" |


    Cenario: Efetuar Login de Usuario com email invalido
      Dado que acesso o site da Petz cenario
      Quando aperto Cadastre-se
      E clico Entrar
      Quando preencho o Email com o endereco "roodrigootavioaugusto@maildrop.cc" e a Senha com "DzIcMCckzh" e clico em entrar
      Entao aparece a mensagem que os dados estao incorrentos

