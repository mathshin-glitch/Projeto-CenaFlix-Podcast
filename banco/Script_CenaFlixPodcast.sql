CREATE DATABASE cenaflix_podcast;
USE cenaflix_podcast;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(150) NOT NULL,
    senha TEXT NOT NULL,
    tipo VARCHAR(100) NOT NULL
);

CREATE TABLE podcast (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produtor VARCHAR(100) NOT NULL,
    nomeEpisodio VARCHAR(150) NOT NULL,
    numeroEpisodio INT NOT NULL,
    duracao VARCHAR(100),
    urlRepositorio VARCHAR(200)
);


-- Inserir dados de teste na tabela de usuários
INSERT INTO usuario (login, senha, tipo) VALUES
('admin_master', 'admin123', 'ADMINISTRADOR'),
('joao_operador', 'op123', 'OPERADOR'),
('maria_usuario', 'user123', 'USUARIO');


-- Inserir dados de teste na tabela de podcasts
INSERT INTO podcast (produtor, nomeEpisodio, numeroEpisodio, duracao, urlRepositorio) VALUES
('Jovem Nerd', 'NerdCast 1000 – Especial', 1000, '2h30min', 'https://jovemnerd.com.br/nerdcast1000'),
('Mamilos', 'Fake News e Desinformação', 234, '1h10min', 'https://mamilos.com.br/ep234'),
('Café Brasil', 'A Educação que Queremos', 879, '50min', 'https://cafecombrasil.com/ep879'),
('Projeto Humanos', 'O Caso Evandro', 1, '1h15min', 'https://projetohumanos.com/casoevandro1'),
('História Preta', 'As Revoltas Negros', 45, '55min', 'https://historiapreta.com/ep45'),
('Autoconsciente', 'Como lidar com ansiedade', 12, '42min', 'https://autoconsciente.com/ep12'),
('Braincast', 'Tendências em tecnologia', 300, '1h05min', 'https://braincast.com.br/ep300'),
('AntiCast', 'A indústria do entretenimento', 120, '1h20min', 'https://anticast.com/ep120'),
('Geek & Nerd', 'O futuro da internet', 78, '48min', 'https://geeknerd.com/ep78'),
('Dragões de Garagem', 'Ciência e Curiosidades', 50, '53min', 'https://dragoesdegaragem.com/ep50');

select * from podcast;
select * from usuario;