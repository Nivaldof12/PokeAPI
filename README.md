## <img width="30" height="30" src="https://img.icons8.com/color/96/youtube-play.png" alt="youtube-play"/> [Vídeo explicando um pouco do projeto](https://drive.google.com/file/d/1ZXAV-stzNiJR39Ybtutu1d96YiIDTmNo/view?usp=sharing).

## :clipboard: Diagrama

## :package: Stack

- **Java 17**
- **Spring Boot** para o framework
- **Gradle** para gerenciamento de dependências
- Criar um **MICROSSERVIÇO**

## :file_folder: Requisitos funcionais

- Consuma os dados da [PokéAPI](https://pokeapi.co/docs/v2).
- Crie e exponha 2 endpoints:

## :round_pushpin: **1. GET /pokemons**
A ideia por trás desse endpoint é poder pesquisar por pokémons pelo seu nome - o usuário enviará uma parte (qualquer parte) do nome do pokémon como o parâmetro para esse endpoint, e o serviço deve responder com uma lista dos pokémons. A pesquisa deve diferenciar maiúsculas de minúsculas.

- **Consulta null**: Se a consulta estiver vazia: `GET /pokemons`, a lista exibe todos os pokemons da PokeAPI.

- **Consulta not null**: Se a consulta não for vazia, exemplo: `GET /pokemons?consulta=pidge`, a lista exibe os pokemons por nome ou iniciais. Nesse caso:
  - Entrada: `GET /pokemons?consulta=pidge`
  - Saída: ```{"result" : ["pidgey", "pidgeotto", "pidgeot, "pidgeot-mega"]}```

**Ordenar**
    
  - **Consulta null**: Se não passar a consulta: `GET /pokemons?ordenar=true`, a lista exibe todos os pokemons da PokeAPI em ordem alfabética em ordem crescente.

  - **Consulta not null**: Se a consulta não for vazia, exemplo: `GET /pokemons?consulta=pidge&ordenar=true`, a lista exibe os pokemons por nome ou iniciais, ordem alfabética e em ordem crescente. Nesse Exemplo:
    - Entrada: `GET /pokemons?consulta=pidge&ordenar=true`
    - Saída: ```{"result" : ["pidgeot", "pidgeot-mega", "pidgeotto", "pidgey"]}```
   
**Comprimento**

  - **Consulta null**: Se não passar a consulta: `GET /pokemons?comprimento=true`, a lista exibe todos os pokemons da PokeAPI ordenados por comprimento do menor nome para o maior.

  - **Consulta not null**: Se a consulta não estiver vazia, exemplo: `GET /pokemons?consulta=pidge&comprimento=true`, a lista exibe os pokemons por nome ou iniciais, por comprimento e em ordem crescente. Nesse Exemplo:
    - Entrada: `GET /pokemons?consulta=pidge&comprimento=true`
    - Saída: ```{"result" : ["pidgey", "pidgeot", "pidgeotto", "pidgeot-mega"]}```
   
## :round_pushpin: **2. GET /pokemons/highlight**

Este endpoint tem, em sua maioria, os mesmos requisitos que o primeiro (deve receber os mesmos parâmetros da mesma maneira), a única diferença é o requisito de resposta: ao lado do nome do pokémon, a resposta também deve destacar a substring que correspondeu ao nome do pokémon. A maneira como você deve fazer isso é cercando a substring com `<pre> </pre>`. Se a consulta estiver vazia, ela deve considerar todos os pokemons listados na PokeAPI.

- **Consulta null**: Se a consulta estiver vazia: `GET /pokemons/highlight`, a lista exibe todos os pokemons da PokeAPI.

- **Consulta not null**: Se a consulta não for vazia, exemplo: `GET /pokemons/highlight?consulta=pidge`, a lista exibe os pokemons por nome ou iniciais. Nesse caso:
  - Entrada: `GET /pokemons/highlight?consulta=pidge`
  - Saída:

```JSON
{
    "result": [
        {
            "name": "pidgey",
            "highlight": "<pre>pidge</pre>y"
        },
        {
            "name": "pidgeotto",
            "highlight": "<pre>pidge</pre>otto"
        },
        {
            "name": "pidgeot",
            "highlight": "<pre>pidge</pre>ot"
        },
        {
            "name": "pidgeot-mega",
            "highlight": "<pre>pidge</pre>ot-mega"
        }
    ]
}
```

**Ordenar**
    
  - **Consulta null**: Se não passar a consulta: `GET /pokemons/highlight?ordenar=true`, a lista exibe todos os pokemons da PokeAPI em ordem alfabética em ordem crescente.

  - **Consulta not null**: Se a consulta não for vazia, exemplo: `GET /pokemons/highlight?consulta=pidge&ordenar=true`, a lista exibe os pokemons por nome ou iniciais, ordem alfabética e em ordem crescente. Nesse Exemplo:
    - Entrada: `GET /pokemons/highlight?consulta=pidge&ordenar=true`
    - Saída:
  
  ```JSON
{
    "result": [
        {
            "name": "pidgeot",
            "highlight": "<pre>pidge</pre>ot"
        },
        {
            "name": "pidgeot-mega",
            "highlight": "<pre>pidge</pre>ot-mega"
        },
        {
            "name": "pidgeotto",
            "highlight": "<pre>pidge</pre>otto"
        },
        {
            "name": "pidgey",
            "highlight": "<pre>pidge</pre>y"
        }
    ]
}
```
   
**Comprimento**

  - **Consulta null**: Se não passar a consulta: `GET /pokemons/highlight?comprimento=true`, a lista exibe todos os pokemons da PokeAPI ordenados por comprimento do menor nome para o maior.

  - **Consulta not null**: Se a consulta não estiver vazia, exemplo: `GET /pokemons/highlight?consulta=pidge&comprimento=true`, a lista exibe os pokemons por nome ou iniciais, por comprimento e em ordem crescente. Nesse Exemplo:
    - Entrada: `GET /pokemons/highlight?consulta=pidge&comprimento=true`
    - Saída:

   ```JSON
{
    "result": [
        {
            "name": "pidgey",
            "highlight": "<pre>pidge</pre>y"
        },
        {
            "name": "pidgeot",
            "highlight": "<pre>pidge</pre>ot"
        },
        {
            "name": "pidgeotto",
            "highlight": "<pre>pidge</pre>otto"
        },
        {
            "name": "pidgeot-mega",
            "highlight": "<pre>pidge</pre>ot-mega"
        }
    ]
}
```   
## :closed_book: Fora do escopo:

- [Java Records](https://www.baeldung.com/java-record-keyword)
- Qualquer biblioteca de classificação, nem qualquer coisa relacionada à classificação da Biblioteca Padrão Java/Kotlin, isso inclui: `Collections.sort`, `Collections.swap`, `Comparators`, etc.
- Qualquer biblioteca de cache (se você deseja implementar o cache, você deve implementá-lo manualmente).
- Qualquer biblioteca do agendador automático de tarefas (para tarefas recorrentes). Se você deseja implementar um recurso que usa agendamento automático de tarefas, você deve usar apenas Java/Kotlin Standard Library ou suas próprias classes e métodos.
- AQualquer coisa que gere código automaticamente ou gere implementações automáticas para interfaces/classes abstratas, como: [Lombok](https://projectlombok.org/features/all), [Feign Client](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html), [Retrofit2](https://square.github.io/retrofit), [Spring Repositories](https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html) (não confunda com [Spring Stereotypes](http://blog.triadworks.com.br/entendendo-os-stereotypes-do-spring)), etc

## :green_book: Requisitos não funcionais

- Você precisa **explicar** sua lógica implementada do algoritmo de classificação usado (por exemplo, você pode usar comentários embutidos no código-fonte).
- Explique o **Big-Ω** de seus algoritmos de classificação.
- O projeto deve consumir e expor TODOS os pokémons existentes da **PokéAPI**.
- Desenhe um **diagrama** explicando sua arquitetura.
- Sua API deve ser criada com desempenho e capacidade de manutenção em mente.
