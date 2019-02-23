CREATE TABLE categoria (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO vendasapi.categoria (nome) values ('Livros');
INSERT INTO vendasapi.categoria (nome) values ('Celulares e Telefonia fixa');
INSERT INTO vendasapi.categoria (nome) values ('Eletrodomésticos');
INSERT INTO vendasapi.categoria (nome) values ('Games e PC Gaming');
INSERT INTO vendasapi.categoria (nome) values ('Informática e Tablets');
INSERT INTO vendasapi.categoria (nome) values ('Filmes, séries e Música');
INSERT INTO vendasapi.categoria (nome) values ('Moda, Beleza e perfumaria');

INSERT INTO vendasapi.categoria (nome) values ('Viagens');
INSERT INTO vendasapi.categoria (nome) values ('TV, Áudio e Home Theater');
INSERT INTO vendasapi.categoria (nome) values ('Móveis e Decoração');
INSERT INTO vendasapi.categoria (nome) values ('Outros');