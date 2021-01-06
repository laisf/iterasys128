#language: pt
#encoding: utf8
Funcionalidade: Consultar Produto PO
  Como um cliente eventual, gostaria de consultar a disponibilidade
  e preço de alguns produtos que tenho interesse em adquirir

Esquema do Cenário: Consulta Produto Fixo com Enter - PO
  Dado que acesso o site da Petz <id> PO
  Quando procuro por <produto> e pressiono Enter PO
  Entao exibe a lista de produtos relacionados a <produto> PO
  Quando seleciono o produto <produtoDescricao> da lista PO
  Entao verifico o preco <preco> e o nome como <produtoDescricao> PO
  Exemplos:
    | id  | produto   |                  produtoDescricao                                           | preco                  |
    | "1" | "Ração"   | "Ração Golden Special para Cães Adultos Frango e Carne"                     | "Por: R$ 115,90à vista" |
    | "2" | "Petisco" | "Petisco Pedigree Dentastix Cuidado Oral Para Cães Adultos Raças Pequenas"  | "Por: R$ 7,19à vista"   |