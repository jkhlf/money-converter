## Conversor de Moedas - Alura Challenges 

![Badge-Conversor.png](src\main\resources\badge\Badge-Conversor.png)

Este projeto é um conversor de moedas desenvolvido em Java, utilizando a API pública de taxas de câmbio ExchangeRate-API. O conversor permite que os usuários façam conversões entre diferentes moedas e exibe um histórico de conversões realizadas.

### Funcionalidades
Conversão de Moedas: Permite converter entre várias moedas, como Dólar, Real Brasileiro, Peso Argentino e Peso Colombiano.
Histórico de Conversões: Exibe um histórico das últimas conversões realizadas.
Registro de Logs: Utiliza a biblioteca java.time para registrar data e hora das conversões realizadas.
Suporte para Mais Moedas: Fácil de expandir para novas moedas, utilizando a ExchangeRate-API.
Pré-requisitos
Antes de executar o projeto, certifique-se de ter o seguinte:

### Java 11 ou superior instalado.
Maven (caso use Maven para gerenciamento de dependências).
Chave da API ExchangeRate-API (gratuita ou paga) disponível em ExchangeRate-API.


## Como Funciona
O ConversorService se conecta à ExchangeRate-API usando a chave de API fornecida no arquivo .env para buscar a taxa de conversão entre duas moedas.
O sistema permite conversões entre Dólar, Real Brasileiro, Peso Argentino e Peso Colombiano, além de qualquer outra moeda que você deseje adicionar.
As conversões são registradas com a data e hora usando java.time e armazenadas em um histórico.
O histórico de conversões pode ser exibido ao final de cada operação.


## Licença

[MIT](https://choosealicense.com/licenses/mit/)