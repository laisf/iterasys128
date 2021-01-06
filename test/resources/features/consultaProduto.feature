#language: pt
#encodind: utf-8

  Funcionalidade:Consultar Produto
    Como um cliente eventual, gostaria de consultar disponibilidade
    e preço de alguns produtos que tenho interesse em adquirir

  Esquema do Cenario: Consultar Produto Fixo
    Dado que acesso o site da Cobasi
    E procuro por <produto> e aperto Enter
    Quando exibe a lista de produtos relacionados ao <produto>
    E seleciono o <produtoDescricao> da lista
    Entao  verifico o <preco> e o <produtoDescricao>
    Exemplos:
      | id  | produto   |                  produtoDescricao                                           | preco       |
      | "1" | "Ração"   | "Ração Golden Special para Cães Adultos Frango e Carne"                     | "R$ 115,90" |
      | "2" | "Petisco" | "Petisco Pedigree Dentastix Cuidado Oral Para Cães Adultos Raças Pequenas"  | "R$ 7,19"   |