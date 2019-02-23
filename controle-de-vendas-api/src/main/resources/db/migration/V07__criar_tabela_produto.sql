CREATE TABLE produto (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(300) NOT NULL,
	valor DECIMAL(10,2) NOT NULL,
	quantidade BIGINT(5) NOT NULL,
	status VARCHAR(100),
	img1 VARCHAR(200),
	img2 VARCHAR(200),
	img3 VARCHAR(200),
	img4 VARCHAR(200),
	img5 VARCHAR(200),
	codigo_categoria BIGINT(20) NOT NULL,
	codigo_fornecedor BIGINT(20) NOT NULL,
	ativo BOOLEAN NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo),
	FOREIGN KEY (codigo_fornecedor) REFERENCES fornecedor(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
