DROP TABLE IF EXISTS filial;

CREATE TABLE IF NOT EXISTS filial(

   id INT AUTO_INCREMENT PRIMARY KEY,
   nomeFilial VARCHAR(62),
   rua VARCHAR(62),
   numero VARCHAR(20),
   cidade VARCHAR(40),
   estado VARCHAR(20),
   e5Estrelas BIT
);