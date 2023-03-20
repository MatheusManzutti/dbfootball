INSERT INTO tb_campeonato (id_campeonato) VALUES ('Paulista');
INSERT INTO tb_campeonato (id_campeonato) VALUES ('Carioca');

INSERT INTO tb_clube (id_clube) VALUES ('Palmeiras');
INSERT INTO tb_clube (id_clube) VALUES ('Corinthians');
INSERT INTO tb_clube (id_clube) VALUES ('São Paulo');
INSERT INTO tb_clube (id_clube) VALUES ('Flamengo');
INSERT INTO tb_clube (id_clube) VALUES ('Fluminense');
INSERT INTO tb_clube (id_clube) VALUES ('Botafogo');

INSERT INTO tb_estadio (id_estadio) VALUES ('Allianz Parque');
INSERT INTO tb_estadio (id_estadio) VALUES ('Neo Quimica Arena');
INSERT INTO tb_estadio (id_estadio) VALUES ('Morumbi');
INSERT INTO tb_estadio (id_estadio) VALUES ('Maracana');

INSERT INTO tb_partida (id_campeonato, id_estadio, id_clube1, id_clube2, data_Hora) VALUES ('Paulista', 'Allianz Parque', 'Palmeiras', 'Corinthians', TIMESTAMP WITH TIME ZONE '2023-03-19T19:00:00Z');
INSERT INTO tb_partida (id_campeonato, id_estadio, id_clube1, id_clube2, data_Hora) VALUES ('Carioca', 'Maracana', 'Flamengo', 'Fluminense', TIMESTAMP WITH TIME ZONE '2023-03-22T00:00:00Z');
INSERT INTO tb_partida (id_campeonato, id_estadio, id_clube1, id_clube2, data_Hora) VALUES ('Paulista', 'Morumbi', 'Palmeiras', 'São Paulo', TIMESTAMP WITH TIME ZONE '2023-03-26T19:00:00Z');
INSERT INTO tb_partida (id_campeonato, id_estadio, id_clube1, id_clube2, data_Hora) VALUES ('Carioca', 'Maracana', 'Flamengo', 'Botafogo', TIMESTAMP WITH TIME ZONE '2023-04-05T00:00:00Z');