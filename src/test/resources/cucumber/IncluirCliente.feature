# language: pt
Funcionalidade: Incuir cliente

  Contexto: 
    Dado que estou incluindo um novo cliente

  Esquema do Cenario: Deve exibir mensagem de obrigatoriedade quando nome nao preenchido
    Dado que informei "" no campo "<campo>"
    Quando incluir
    Entao exibe "<mensagem>"

    Exemplos: 
      | campo | mensagem         |
      | nome  | Informe o nome.  |
      | risco | Informe o risco. |
