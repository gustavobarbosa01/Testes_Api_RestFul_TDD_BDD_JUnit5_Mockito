## Testes_Api_RestFul_TDD_BDD_JUnit5_Mockito.

# Objetivos do Projeto.

- Objetivo ao se realizar os testes
- Tipos de Testes
- Conhecimento da estrutura e implementação de Testes
- Aplicação de Testes com TDD e BDD
- Utilização de Mockito para os testes
- Utilização do JUnit5 para os testes

# Porque Testar o seu código?

- Diminuir ao máximo as chances de obter bugs.
- Teste de regressão após fazer alguma alteração de códigos existentes ou novas funcionalidades, implementar testes automatizados.
- Para evitar desenvolver e deixar passar os erros mais óbvios.
- Os testes proporcionam uma escrita de códigos de alta qualidade.
- Para se fazer uma refatoração de código e upgrade de dependências de forma segura.
- Atender as necessidades das empresas que exigem que os desenvolvedores testem seus códigos.

# Tipos de testes abordados no Projeto.

1. Teste Unitário.
- Teste da menor parte testável de um programa. No teste unitário os módulos serão testados separadamente. 
A implementação terá as classes que serão testadas isoladas para a simulação dos comportamentos das dependências
2. Teste de Integração
- Testar a integração entre duas pastes do sistema. Testes que irão verificar se suas classes 
comunica-se bem com os serviços web, escreve arquivos de texto,
mandam mensagens via socket e se são considerados testes de integração. 

# TDD Test Driven Developement

- Desenvolvimento Orientado por testes. 
Desenvolvimento de software baseado em testes que serão escritos antes do nosso código de produção.
- Primeiro se escreve um testes, deve obter um erro, depois do test passar, se refatora para que o 
- mesmo seja implementado até atendender todos osqrequisitos do sistema.

![](https://miro.medium.com/max/1400/1*7dua_4_yXKc_IKHK01VZ2A.jpeg)
* Fluxo de trabalho do TDD.

# BDD Behavior Driven Developement

- Desenvolvimento de testes de fácil entendimento.
O teste BDD não traz somente um estilo de escrever cenários de testes amigáveis, mas também a 
importante ideia do que deve ser feito antes de escrever o código que implementa a sua 
funcionalidade.

#### Given - When - Then
- Em cada testes desenvolvido no BDD segue-se basicamente tres passos, "Dado que" especificamente 
os se encontra o cenário, "Quando" onde se executa suas operações e "Então" um resultado é obtido. 
Por exemplo dado dois numeros quando somados o resultado será o obtido ou esperado.

![](https://www.primecontrol.com.br/en/wp-content/uploads/2020/02/bdd.png)
* Fluxo de trabalho do BDD.

# Mockito

![](../../../AppData/Local/Temp/1_3NDVbzYlOTLyRSrpay9uYw.png)

- O Mockito é um framework de testes unitários e o seu principal objetivo é instanciar classes 
e controlar o comportamento dos métodos. Isso é chamado de mock, na tradução livre quer dizer zombar, 
e talvez seja mesmo o termo que melhor o define. Pois ao mockar a dependencia de uma classe, faz 
com que a classe que eteja sendo testada pense estar invocando o metodo realmente, mas de fato não está. 
Conforme o desenho abaixo tenta explicar.
- 
![](../../../AppData/Local/Temp/1_Y5OEPlXdLblECPh3jRjoTw.png)
* Fluxo de trabalho Mockito.

# Apis Restfull
### Representation State Transfer
#### O que é rest?
- Designer de arquitetura construida para servir aplicações em rede.
- Não é um padrão e sim um guia.
- Ele possui uma arquiterua onde não se guarda stados (Stateless).
- É uma interface uniforme: cada recurso(resource) tem uma URL específica, 
e os resources são representados por HTML, XML, txt, dentre outros
- Funciona no Modelo REQUEST -> RESPONSE, onde troca-se mensagens e retorna-se 
códigos de status, dependendo do que aconteceu no processamento da rquisição http.

![](../../../AppData/Local/Temp/img-1.png)

* Fluxo de trabalho API Rest.