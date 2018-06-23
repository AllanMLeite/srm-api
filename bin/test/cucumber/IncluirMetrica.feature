# language: pt

Funcionalidade: Incuir Metrica
  
  Cenario: Deve exibir mensagem de obrigatoriedade quando nome nao preenchido
    Dado que informei o nome ""
    Quando incluir
    Entao exibe "Informe o nome."