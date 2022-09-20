## Testes Api RestFul TDD BDD JUnit5 Mockito.

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

![](https://raw.githubusercontent.com/mockito/mockito/main/src/javadoc/org/mockito/logo.png)

- O Mockito é um framework de testes unitários e o seu principal objetivo é instanciar classes 
e controlar o comportamento dos métodos. Isso é chamado de mock, na tradução livre quer dizer zombar, 
e talvez seja mesmo o termo que melhor o define. Pois ao mockar a dependencia de uma classe, faz 
com que a classe que eteja sendo testada pense estar invocando o metodo realmente, mas de fato não está. 
Conforme o desenho abaixo tenta explicar.
- 
![](https://miro.medium.com/max/1050/1*Y5OEPlXdLblECPh3jRjoTw.png)
* Fluxo de trabalho Mockito.

# Apis Restfull.
### Representation State Transfer.
#### O que é rest?
- Designer de arquitetura construida para servir aplicações em rede.
- Não é um padrão e sim um guia.
- Ele possui uma arquiterua onde não se guarda stados (Stateless).
- É uma interface uniforme: cada recurso(resource) tem uma URL específica, 
e os resources são representados por HTML, XML, txt, dentre outros
- Funciona no Modelo REQUEST -> RESPONSE, onde troca-se mensagens e retorna-se 
códigos de status, dependendo do que aconteceu no processamento da rquisição http.

![](https://www.smarti.blog.br/wp-content/uploads/2018/08/Rest_Overview_Diagram.jpg)

* Fluxo de trabalho API Rest.

# Verbos HTTP.

#### Post
- Cria um recurso no servidor
- Envia-se o recurso a ser criado.
- Sua resposta possui o código 201(CREATED), significa que algum recurso foi criado no servidor.

#### Get
- Obtém um recurso do servidor. 
- Poderá enviar parametros com critérios de buscas.
- Sua resposta possui o código 200(OK - recurso encontrado) ou 404(NOT FOUND - recurso não encontrado) 
quando o recurso não for encontrado no servidor.
- 
#### Put
- Há uma semelhança com Post, porém no Put o recurso já existirá no servidor para ser altualizado.
- Envia-se o recurso através da URL, envia-se o indentificador do recurso que irá receber a atualização.
- Sua resposta possui o código 200(OK) quando ocorre tudo com sucesso.

#### Delete
- Ddeletará um recurso no servidor.
- Envia-se um indentificador do recurso que deseja-se deletar atravé da URL.
- Sua resposta possui o código 204(NO CONTENT) quando ocorre a deleção com sucesso.

# Modelagem de Recurso.

###### - Não recomendado.
|Verbo HTTP| URL | Ação |
|-------|-------|-------|
|POST/PUT| /cadastrarCliente | salvar |
|GET| /buscarCliente/1 | visualizar |
|DELETE/GET| /deletarCliente/1 | remover |
|POST| /alterarCliente/1 | atualizar |

###### * Observação *: 
- ###### Sua URL não deve utilizar verbos como "cadastarCliente", e sim substantivo, utilizar "cadastrar" 
    ###### por exemplo, denvendo utilizar apenas o Post para salvar um recurso no servidor, já o Put 
    ###### apenas quando se quer atualizar algum recurso.
- ###### Get não se é utilizado para deletar e sim o DELETE para obter recuros do servidor para excluir.
- ###### Get não se é utilizado para deletar e sim para obter recursos do servidor, neste caso para deletar é recomendado utilizar apropriadamente o DELETE para se excluir(Também não se deve utilizaar verbos na UL).

# Identificação de Recursos.

###### - Abordagem RestFul
|Verbo HTTP| URL | Ação |
|-------|-------|-------|
|POST| /clientes | salvar |
|GET| /clientes/1 | visualizar |
|DELETE| /clientes/1 | remover |
|PUT| /clientes/1 | atualizar |
###### * Observação *:
- ######Abordagen utiliza substantivos, onde a raiz para visualizar, remover e atualizar,
- ###### e identificadores na requisição da URL;

# Identificação de Sub Recursos.

|Verbo HTTP| URL | Ação |
|-------|-------|-------|
|POST| /clientes/1/enderecos | salvar |
|GET| /clientes/1/enderecos/1 | visualizar |
|DELETE| /clientes/1/enderecos/1 | remover |
|PUT| /clientes/1/enderecos/1 | atualizar |

***Observação:** 
Abordagem utiliza sub endereços, onde se tem a identificação dos endereços, uma url apenas do 
endereço, poderá ser utilizada também passando apenas URL "/enderecos" para o Get, e assim visualizar 
todos os endereços. 

##### **Códigos HTTP Status.*
| Consulte os status de respostas HTTP aqui: **[MDN Web Docs](https://developer.mozilla.org/pt-BR/docs/Web/HTTP/Status)** |
|----------------------------------------------------------------------------------------------------------------|

##### **Código de Status Sucesso e Erro.*

|Verbo HTTP| Sucesso | Erro |
|-------|-------|-------|
|POST| 201(created) | 400(Bad Request) |
|GET| 200(ok) | 404(Not found) |
|DELETE| 204(No Content) | 400(Bad Request)/404(Not Found) |
|PUT| 200(ok) | 400/404(Not Found) |

# Representação de recursos.

### JSON

- Javascript Object Notation.
- Leitura mais simples. Qualquer linguagem de programação poderá utilizar o JSON.
- Analisador(parsing) mais fácil.
- Suporte para Objetos.
- É um recurso tipado.
- Velocidade maior de execução e transporte de dados.
- Arquivo com tamanho reduzido.

### XML

- Comparação de estrutura do arquivo JSON com XML utilizado utilizado em protocolo SOAP.

- **Exemplo XML SOAP**:
```
<clientes>
    <cliente id="1">
        <nome>Gustavo</nome>
        <cpf>12345875487</cpf>
        <endereco>
            <logradouro>
                Rua W Y Z
            </logradouro>
            <numero>10</numero>
        </endereco>
    </cliente>
</clientes>
```

- **Exemplo JSON**:
```
[
    {
        nome: "Gustavo",
        cpf: "12345875487",
        endereco: {
            endereco: "Rua W Y Z",
            numero: 10
        }
    }
]
```