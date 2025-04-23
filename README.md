# Projeto de Testes AgiBank

## Descrição
Este projeto contém casos de teste para validação da interface do usuário do AgiBank, incluindo testes manuais e automatizados.

 *Cenários de Teste Manual*

*### *1. Validação da Página Inicial*
- Acessar o site do AgiBank
- Verificar se todos os elementos da página inicial estão visíveis
- Validar os links do menu principal
- Verificar responsividade em diferentes resoluções

*2. Fluxo de Navegação*
- Navegar pelos menus principais
- Validar redirecionamentos
- Verificar breadcrumbs
- Testar botões de voltar/avançar do navegador

*3. Formulários*
- Testar campos obrigatórios
- Validar máscaras de entrada
- Verificar mensagens de erro
- Testar envio de formulários

*4. Testes de Compatibilidade*
- Chrome (última versão)
- Firefox (última versão)
- Edge (última versão)
- Dispositivos móveis

*Execução dos Testes Manuais*
1. Acessar o ambiente de teste
2. Seguir o roteiro de testes definido
3. Registrar os resultados em planilha/ferramenta de gestão
4. Reportar bugs encontrados
5. Validar correções

*Suporte à Automação*

*Pré-requisitos*
- Java JDK 11
- Maven 3.9.x ou superior
- Google Chrome
- ChromeDriver (compatível com a versão do Chrome)

*Executar Testes Automatizados*
1. Configurar ambiente Java e Maven
2. Na pasta do projeto, executar:
```bash
mvn clean test
```

*Estrutura do Projeto*
```
├── docs/
│   └── casos-de-teste/
│       └── planilha-testes-manuais.xlsx
├── src/
│   └── test/
│       └── java/
│           └── agibank_pesquisa/
├── drivers/
└── README.md
```

*Relatórios*
- Resultados dos testes manuais: pasta `docs/casos-de-teste`
- Relatórios de automação: pasta `target/cucumber-reports`



