CREATE TABLE fornecedor (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	razao_social VARCHAR(100) NOT NULL,
	nome_fantasia VARCHAR(100) NOT NULL, 
	cnpj BIGINT(20) NOT NULL,
	logradouro VARCHAR(30),
	numero VARCHAR(30),
	complemento VARCHAR(30),
	bairro VARCHAR(30),
	cep VARCHAR(30),
	cidade VARCHAR(30),
	estado VARCHAR(30),
	ativo BOOLEAN NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE fornecedor DROP COLUMN cidade;
ALTER TABLE fornecedor DROP COLUMN estado;
ALTER TABLE fornecedor ADD COLUMN codigo_cidade BIGINT(20);
ALTER TABLE fornecedor ADD CONSTRAINT fk_fornecedor_cidade FOREIGN KEY (codigo_cidade) REFERENCES cidade(codigo);


INSERT INTO vendasapi.fornecedor
(razao_social,
nome_fantasia, 
cnpj,
logradouro,
numero,
complemento,
bairro,
cep,
ativo,
codigo_cidade) values 
('Caelum ltda',
'Alura', 
1234546500001,
'Rua Europa',
'99',
'Conj 1, APT 81',
'Vila Mariana',
'04830477',
true,
4);

