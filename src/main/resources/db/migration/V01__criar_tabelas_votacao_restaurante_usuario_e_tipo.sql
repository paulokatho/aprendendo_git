
CREATE TABLE IF NOT EXISTS tipo (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	tipo_restaurante VARCHAR(50) NOT NULL	
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS usuario (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(80) NOT NULL,
	telefone VARCHAR(14) NOT NULL,
	email VARCHAR(50) NOT NULL,
	setor VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS restaurante (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	rua_numero VARCHAR(80) NOT NULL,
	bairro VARCHAR(50) NOT NULL,
	telefone VARCHAR(14) NOT NULL,
	valor_refeicao DECIMAL(10, 2) NOT NULL,
	codigo_tipo BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_tipo) REFERENCES tipo(codigo)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS votar (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_restaurante BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_restaurante) REFERENCES restaurante(codigo)
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
INSERT INTO tipo VALUES (0, 'Churrascaria');
INSERT INTO tipo VALUES (0, 'Massas');

INSERT INTO restaurante VALUES (0, 'Boi na Brasa', 'Rua do lado 435', 'centro', '3664-0214', 22, 1);
INSERT INTO restaurante VALUES (0, 'Comida da Mama', 'Rua da frente 1150', 'centro', '3664-5813', 18, 2);

INSERT INTO usuario VALUES (0, 'Paulo André', '99999-9999', 'pkatho@gmail.com', 'DEV');
INSERT INTO usuario VALUES (0, 'Antonia Cardoso', '91111-1111', 'antonia@gmail.com', 'RH');
INSERT INTO usuario VALUES (0, 'Mara Melão', '92222-2222', 'm.melao@gmail.com', 'RH');
	