## Enunciado
Estamos desenvolvendo um aplicativo de streaming, estilo Netflix, com o objetivo de ser utilizado por usuários de todo o mundo. No momento, estamos recebendo filmes apenas para Argentina, Brasil e Colômbia. Nesse caso, precisamos desenvolver uma funcionalidade específica:

Como cliente, queremos que o aplicativo nos permita fazer um pedido com o nome do filme e nos envie o objeto filme que contém o link de reprodução. Os diferentes filmes estão disponíveis em apenas um dos países e permitem-nos vê-los se estivermos no país correspondente.


Para saber em que país se encontra o cliente, ocorreu-nos utilizar o endereço IP do pedido que nos enviou. Como os endereços IP têm um formato definido por 4 números (de 0 a 255) separados por pontos, ficando como: 255.255.255.255, podemos pegar o primeiro número do endereço para descobrir de qual país ele vem:

0 a 49 -> Argentina

50 a 99 -> Brasil

100 a 149 -> Colombia

###Vamos criar:

Uma Interface IGradeDeFilmes que define um método getFilme que recebe o nome, devolvendo um objeto filme.

Uma classe GradeDeFilmes que implementa a interface IGradeDeFilmes e devolve um filme.

Uma classe GradeDeFilmesProxy que possui um atributo IP e pede um filme à GradeDeFilmes - com getFilme e "filtra" de acordo com o país. Recordar como se encontra o país pelo IP, se não for possível enviar para aquele país, lança uma exceção do tipo FilmeNaoHabilitadoException criado para esse fim.

### As classes utilizarão:
Filme que possui um nome, um país e um link de reprodução — todos String.

IP que possui quatro inteiros (números de 0 a 255).

No método principal (main), realizar pedidos de filmes com o nome e o IP fazendo com exemplos dos 3 países. Mostrar o link do filme se estiver habilitado. Se não, exiba “Filme não disponível no seu país”.

Bons estudos!

