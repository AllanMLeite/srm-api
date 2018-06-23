# language: pt
Funcionalidade: Incluir cliente

  Contexto: 
    Dado que estou incluindo um novo cliente

  Esquema do Cenario: Deve exibir mensagem de obrigatoriedade quando nome nao preenchido
    Dado que informei "" no campo "<campo>"
    Quando incluir
    Entao exibe "<mensagem>"

    Exemplos: 
      | campo  | mensagem          |
      | nome   | Informe o nome.   |
      | risco  | Informe o risco.  |
      | limite | Informe o limite. |

  Cenario: Deve salvar o cliente
    Dado que informei "Mauricio" no campo "nome"
    E que informei "B" no campo "risco"
    Quando incluir
    Entao salva o cliente
    E nao exibe mensagem
