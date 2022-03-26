## Vamos praticar!

Exercício: Filmes

O objetivo desta atividade é consolidar o conhecimento adquirido sobre DTO e ResponseEntity, e revisar as anotações mais utilizadas.

---
## Desafio:

Dado a entidade Filme composto por:

- Título (String);

- Categoria (String);

- Prêmios (Integer);

- Id (Integer).

Desenvolva uma API que nos permita:

Buscar todos os filmes que salvamos. Queremos visualizar uma lista com apenas o título e a categoria, para isso precisamos usar um DTO.

Caminho: /Filmes

Método: GET

Excluir um filme pelo id. Caso o filme exista e tenha sido eliminado com sucesso, retorne com o código de status 200 usando o ResponseEntity, se o filme não for encontrado retornar o status 404.

Caminho: /{id}

Método: DELETE

👉 Para este exercício, você não precisa usar um banco de dados, você pode fazer as operações em uma lista.

Bons estudos!
