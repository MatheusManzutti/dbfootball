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

-- Supondo que os IDs dos registros das tabelas tb_campeonato, tb_clube e tb_estadio estejam corretos
INSERT INTO tb_partida (campeonato, estadio, clube1, clube2, data_Hora)
VALUES (1, 1, 1, 2, TIMESTAMP '2023-03-19T19:00:00Z');
INSERT INTO tb_partida (campeonato, estadio, clube1, clube2, data_Hora)
VALUES (2, 4, 4, 5, TIMESTAMP '2023-03-22T00:00:00Z');
INSERT INTO tb_partida (campeonato, estadio, clube1, clube2, data_Hora)
VALUES (1, 3, 1, 3, TIMESTAMP '2023-03-26T19:00:00Z');
INSERT INTO tb_partida (campeonato, estadio, clube1, clube2, data_Hora)
VALUES (2, 4, 4, 6, TIMESTAMP '2023-04-05T00:00:00Z');

