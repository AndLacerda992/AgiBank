#language:pt
#encoding:UTF-8
#Autor: Anderson-Lacerda

Funcionalidade: Validar função de pesquisa


  Cenário: Devo não receber resultado ao pesquisar por várias números
    Dado que estou na tela principal do AgiBank
    E clico na lupa
    Quando insiro no campo "312321323123"
    E clico em pesquisar
    Então visualizo mensagem de não há resultado para a pesquisa

  Cenário: Devo receber o resultado de acordo com a pesquisa
    Dado que estou na tela principal do AgiBank
    E clico na lupa
    Quando insiro no campo "instagram"
    E clico em pesquisar
    Então visualizo somente postagens que contém o texto pesquisado

     Cenário: Devo receber default quando pesquisar sem inserir termo
    Dado que estou na tela principal do AgiBank
    E clico na lupa
    Quando não insiro valor
    E clico em pesquisar
    Então recebo um resultado default
