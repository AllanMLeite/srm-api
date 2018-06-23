# language: pt
Funcionalidade: Incuir Usuario

Contexto:
Dado que estou incluindo um novo usuario

  Esquema do Cenario: Deve exibir mensagem de obrigatoriedade quando nome nao preenchido
    Dado que informei "" no campo "<campo>"
    Quando incluir
    Entao exibe "Informe o nome."

    Exemplos: 
      | campo | mensagem        |
      | nome  | Informe o nome. |
