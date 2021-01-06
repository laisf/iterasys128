#language: pt
# encoding: utf8

Funcionalidade: Efetuar Cadastro
  Como um cliente eventual, gostaria de efetuar cadastro no site Petz

  Esquema do Cenario: Efetuar Cadastro de Usuario
    Dado que entro na pagina da Petz
    Quando clico em Cadastre-se
    E seleciono Criar conta
    Quando exibe a pagina de cadastro e preencho <nomeCompleto> e <email> e <ddd> e <celular> e <sexo> e <dataNascimento> e <cpf> e <senha> e <confSenha>
    E clico em Criar Conta
    Entao crio a conta de usuario
    Exemplos:
      | nomeCompleto                          | email                                | ddd  |  celular    | sexo | cpf           | dataNascimento | senha        | confSenha    |
      | "Cristiane Emilly Castro"             | "cristianeemilly@maildrop.cc"        | "98" | "995515812" | "F"  | "08237045211" | "07/03/1942"   | "GHHWc3X1ap" | "GHHWc3X1ap" |
      | "Rosangela Tania Analu Peixoto"       | "rosangelataniaana@maildrop.cc"      | "83" | "989397072" | "F"  | "54015888529" | "08/09/1953"   | "9RpAbQ2UEZ" | "9RpAbQ2UEZ" |
      | "Rodrigo Otavio Augusto da Conceicao" | "rodrigootavioaugusto@maildrop.cc"   | "96" | "991518726" | "M"  | "08264438008" | "01/05/1943"   | "DzIcMCckzh" | "DzIcMCckzh" |



