#language: pt
# encoding: utf8

  Funcionalidade: Consultar Produto
    Como um cliente eventual, gostaria de consultar disponibilidade
    e preço de alguns produtos que tenho interesse em adquirir

  Cenario: Consulta Produto Fixo
    Dado que acesso o site da Petz "1"
    Quando procuro por "Ração" e pressiono Enter
    Entao exibe a lista de produtos relacionados a "Ração"
    Quando seleciono o primeiro produto da lista
    Entao verifico que a marca como "Royal Canin" com preco normal de "R$232,69" e "R$209,42" para assinantes


    Cenario: Consulta Produto Fixo com Clique na lupa
      Dado que acesso o site da Petz "2"
      Quando procuro por "Ração" e clico na lupa
      Entao exibe a lista de produtos relacionados a "Ração"
      Quando seleciono o primeiro produto da lista
      Entao verifico que a marca como "Royal Canin" com preco normal de "R$232,69" e "R$209,42" para assinantes

      Cenario: Consulta Produto Fixo que Nao Existe
        Dado que acesso o site da Petz "3"
        Quando procuro por "hnduijshfdi" e pressiono Enter
        Entao exibe uma lista de produtos aproximados e a mensagem de que encontrou "hnduijshfdi"

    Cenario: Consulta Produto Fixo com Menos de 3 Letras
      Dado que acesso o site da Petz "4"
      Quando procuro por "ab" e pressiono Enter
      Entao exibe uma caixa de alerta  dizendo que precisa preencher pelo menos tres letras no termo

    Esquema do Cenario:
      Dado que acesso o site da Petz <id>
      Quando procuro por <produto> e pressiono Enter
      Entao exibe a lista de produtos relacionados a <produto>
      Quando seleciono o <produtoDescricao> da lista
      Entao verifico a <marca> com o <precoNormal> e <precoAssinante>

      Exemplos:
        | id  | produto   | produtoDescricao                                     |  marca        | precoNormal | precoAssinante |
        | "5" | "Ração"   | "Ração Royal Canin Maxi - Cães Adultos - 15kg"       | "Royal Canin" | "R$ 232,69" | "R$ 209,42"    |
        | "6" | "Petisco" | "Snack Petz Cuidado Oral para Cães de Pequeno Porte" | "Petz"        | "R$ 3,99"   |   "R$ 3,59"    |












