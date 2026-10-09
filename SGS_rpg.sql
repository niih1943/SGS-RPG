CREATE DATABASE IF NOT EXISTS SGS_rpg;
USE SGS_rpg;

CREATE TABLE agente(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    codinome VARCHAR(25),
    classe ENUM('Combatente', 'Especialista', 'Ocultista'),
    nivel INT,
    vida INT,
    sanidade INT,
    origem VARCHAR(50),
    status ENUM('Ativo', 'Morto', 'Incosciente', 'Desaparecido')
);

CREATE TABLE equipe(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(20),
    descricao VARCHAR(100)
);

CREATE TABLE missao(
	id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(45),
    equipe_id INT,
    local VARCHAR(45),
    grau_risco ENUM('Baixo', 'Médio', 'Alto', 'Extremo'),
    status ENUM('Planejada', 'Em andamento', 'Concluida'),
    inicio DATE,
    fim DATE,
    FOREIGN KEY (equipe_id) REFERENCES equipe(id)
);

CREATE TABLE ameaca(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(30),
    tipo VARCHAR(30),
    elemento VARCHAR(25),
    nivel_ameaca INT,
    status_aparicao ENUM('Planejada', 'Apareceu', 'Derrotada')
);

CREATE TABLE ocorrencia(
	id INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(200),
    impacto_narrativo VARCHAR(100),
    impacto_sanidade VARCHAR(75),
    missao_id INT,
    ameaca_id INT,
    FOREIGN KEY (missao_id) REFERENCES missao(id),
    FOREIGN KEY (ameaca_id) REFERENCES ameaca(id)
);

CREATE TABLE itens(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(45),
    categoria VARCHAR(45),
    efeito VARCHAR(45),
    nivel_perigo INT,
    status ENUM('Oculto', 'Descoberto', 'Em uso', 'Perdido'),
    agente_id INT,
    FOREIGN KEY (agente_id) REFERENCES agente(id)
);

CREATE TABLE agente_missao(
	agente_id INT,
    missao_id INT,
    resultado ENUM('Ileso', 'Ferido', 'Traumatizado', 'Morto'),
    
    PRIMARY KEY (agente_id, missao_id),
    
    CONSTRAINT fk_agente
		FOREIGN KEY (agente_id) REFERENCES agente(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	
    CONSTRAINT fk_missao
		FOREIGN KEY (missao_id) REFERENCES missao(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE agente_equipe(
	agente_id INT,
    equipe_id INT,
    funcao_na_equipe VARCHAR(45),
    
    PRIMARY KEY (agente_id, equipe_id),
    
    CONSTRAINT fk_ae_agente
		FOREIGN KEY (agente_id) REFERENCES agente(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
	
    CONSTRAINT fk_equipe
		FOREIGN KEY (equipe_id) REFERENCES equipe(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

USE SGS_rpg;

SELECT * FROM agente;