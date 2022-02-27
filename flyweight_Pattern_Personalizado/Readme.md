# Enunciado

Fazer um exemplo e aplicar o padrão flyweight:

Fiz uma pequena simulação de uma pokedex, do sistema nesse caso. Quando um pokemon é adicionado a um sistema irá sempre retorna uma unica instância dos dados daquele pokemon, caso for informado um que não tem registrado, irá criar um novo objeto do tipo **Pokemon** e guardar em cache essa instância, para poder ter apenas uma instância de cada objeto. 

Com isso economizamos o uso de memória reaproveitando uma instância já existente no sistema.