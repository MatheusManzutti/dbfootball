INSERT INTO tb_campeonato (campeonato) VALUES ('Paulista');
INSERT INTO tb_campeonato (campeonato) VALUES ('Carioca');

INSERT INTO tb_clube (clube) VALUES ('Palmeiras');
INSERT INTO tb_clube (clube) VALUES ('Corinthians');
INSERT INTO tb_clube (clube) VALUES ('São Paulo');
INSERT INTO tb_clube (clube) VALUES ('Flamengo');
INSERT INTO tb_clube (clube) VALUES ('Fluminense');
INSERT INTO tb_clube (clube) VALUES ('Botafogo');

INSERT INTO tb_estadio (estadio) VALUES ('Allianz Parque');
INSERT INTO tb_estadio (estadio) VALUES ('Neo Quimica Arena');
INSERT INTO tb_estadio (estadio) VALUES ('Morumbi');
INSERT INTO tb_estadio (estadio) VALUES ('Maracana');

INSERT INTO tb_partida (id_Campeonato, id_Estadio, id_clube1, id_clube2, data_Hora) VALUES (1, 1, 1, 2, TIMESTAMP WITH TIME ZONE '2023-03-19T19:00:00Z');
INSERT INTO tb_partida (id_Campeonato, id_Estadio, id_clube1, id_clube2, data_Hora) VALUES (2, 4, 4, 5, TIMESTAMP WITH TIME ZONE '2023-03-22T00:00:00Z');
INSERT INTO tb_partida (id_Campeonato, id_Estadio, id_clube1, id_clube2, data_Hora) VALUES (1, 3, 1, 3, TIMESTAMP WITH TIME ZONE '2023-03-26T19:00:00Z');
INSERT INTO tb_partida (id_Campeonato, id_Estadio, id_clube1, id_clube2, data_Hora) VALUES (2, 4, 4, 6, TIMESTAMP WITH TIME ZONE '2023-04-05T00:00:00Z');