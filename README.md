## Stack

- **Java 17**
- **Spring Boot** para o framework
- **Gradle** para gerenciamento de dependências
- Criar um **MICROSSERVIÇO**

## Apresentação

- Crie um repositório público com seu código.
- Envie o link para a equipe de RH para avaliação.

## Requisitos funcionais

- Consuma os dados da [PokéAPI](https://pokeapi.co/docs/v2).
- Crie e exponha 2 endpoints:

## **1. GET /pokemons**

- **Consulta null**: Se a consulta estiver vazia: `GET /pokemons`, a lista exibe todos os pokemons da PokeAPI.

- **Consulta not null**: Se a consulta não for vazia, exemplo: `GET /pokemons?name=pidge`, a lista exibe os pokemons por nome ou iniciais. Nesse caso:
  - Entrada: `GET /pokemons?name=pidge`
  - Saída: ```{"result" : ["pidgey", "pidgeotto", "pidgeot, "pidgeot-mega"]}```

**Ordenar**
    
  - **Consulta null**: Se não passar a consulta: `GET /pokemon?ordenar`, a lista exibe todos os pokemons da PokeAPI em ordem alfabética em ordem crescente.

  - **Consulta not null**: Se a consulta não for vazia, exemplo: `GET /pokemon?consulta=pidge&ordenar=true`, a lista exibe os pokemons por nome ou iniciais, ordem alfabética e em ordem crescente. Nesse Exemplo:
    - Entrada: `GET /pokemon?consulta=pidge&ordenar=true`
    - Saída: ```{"result" : ["pidgeot", "pidgeot-mega", "pidgeotto", "pidgey"]}```
   
**Comprimento**

  - **Consulta null**: Se não passar a consulta: `GET /pokemon?comprimento`, a lista exibe todos os pokemons da PokeAPI ordenados por comprimento do menor nome para o maior.

  - **Consulta not null**: Se a consulta não estiver vazia, exemplo: `GET /pokemon?consulta=pidge&comprimento=true`, a lista exibe os pokemons por nome ou iniciais, por comprimento e em ordem crescente. Nesse Exemplo:
    - Entrada: `GET /pokemon?consulta=pidge&comprimento=true`
    - Saída: ```{"result" : ["pidgey", "pidgeot", "pidgeotto", "pidgeot-mega"]}```
   
## **2. GET /pokemons/highlight**

Este endpoint tem, em sua maioria, os mesmos requisitos que o primeiro (deve receber os mesmos parâmetros da mesma maneira), a única diferença é o requisito de resposta: ao lado do nome do pokémon, a resposta também deve destacar a substring que correspondeu ao nome do pokémon. A maneira como você deve fazer isso é cercando a substring com `<pre> </pre>`. Se a consulta estiver vazia, ela deve considerar todos os pokemons listados na PokeAPI.
