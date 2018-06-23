# language: pt
Funcionalidade: Listar cliente

  Contexto: 
    Dado desejo visualizar os clientes cadastrados
    E que existe um cliente cadastrado chamado "Ramon" com limite "10000", risco "A" e taxa "20"

  Cenario: Deve validar os dados dos clientes
    Quando listar
    Entao o sistema exibe "1" clientes
    E retorna o valor "Ramon" no campo "nome"
    E retorna o valor "10000" no campo "limite"
    E retorna o valor "A" no campo "risco"
    E retorna o valor "20" no campo "taxa"

  Cenario: Deve listar os clientes
    Dado que existe um cliente cadastrado chamado "Maicon" com limite "10000", risco "A" e taxa "20"
    E que existe um cliente cadastrado chamado "Mara" com limite "10000", risco "A" e taxa "20"
    Quando listar
    Entao o sistema exibe "3" clientes
