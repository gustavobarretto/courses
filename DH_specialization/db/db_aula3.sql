USE DHtube;

-- Listar todos os países que contêm a letra A, ordenados alfabeticamente.
SELECT pais.nome as country FROM pais WHERE pais.nome LIKE "A%" ORDER BY pais.nome ASC;

-- Gere uma lista de usuários, com detalhes de todos os seus dados, o avatar que possuem e a qual país pertencem.
SELECT usuario.nome as username, usuario.email as user_email, usuario.dataNascimento as user_birthday,
usuario.codigoPostal as zipcode, pais.nome as country, avatar.nome as avatar
FROM usuario
INNER JOIN pais
ON usuario.Pais_idPais = pais.idPais
INNER JOIN avatar
ON usuario.Avatar_idAvatar = avatar.idAvatar;


-- Faça uma lista com os usuários que possuem playlists, mostrando a quantidade que possuem.
SELECT usuario.nome as username, COUNT(playlist.usuario_idUsuario) as total_playlist
FROM usuario
INNER JOIN playlist
ON usuario.idUsuario = playlist.usuario_idUsuario
GROUP BY usuario.nome;

-- Mostrar todos os canais criados entre 01/04/2021 e 01/06/2021.
SELECT canal.nome as channel_name, canal.dataCriacao as creation_date
FROM canal
WHERE dataCriacao BETWEEN '2021-04-01' AND '2021-06-01';

-- Mostre os 5 vídeos com a menor duração, listando o título do vídeo, a tag ou tags que possuem,
-- o nome de usuário e o país ao qual correspondem.
SELECT
video.titulo as video_title,
video.duracao as video_duration,
usuario.nome as username,
pais.nome as country,
GROUP_CONCAT(DISTINCT Hashtag.nome) as hashtag_title
FROM video
INNER JOIN video_hashtag
ON video.idVideo = video_hashtag.video_idVideo
INNER JOIN Hashtag
ON video_hashtag.hashtag_idHashtag = Hashtag.idHashtag
INNER JOIN usuario
ON video.usuario_idUsuario = usuario.idUsuario
INNER JOIN pais
ON usuario.Pais_idPais = pais.idPais
GROUP BY pais.nome, usuario.nome, video.titulo
ORDER BY video.duracao
LIMIT 5;


-- Liste todas as playlists que possuem menos de 3 vídeos, mostrando o nome de usuário e avatar que possuem.
SELECT
playlist.nome as playlist_name,
usuario.nome as username,
avatar.nome as user_avatar,
COUNT(playlist_video.video_idVideo) as qnt_videos_by_playlist
FROM playlist
INNER JOIN usuario
ON playlist.usuario_idUsuario = usuario.idUsuario
INNER JOIN avatar
ON usuario.idUsuario = avatar.idAvatar
INNER JOIN playlist_video
ON playlist_video.Playlist_idPlaylist = playlist.idPlaylist
INNER JOIN video
ON video.idVideo = playlist_video.video_idVideo
GROUP BY playlist.nome, usuario.nome, avatar.nome
HAVING qnt_videos_by_playlist > 3;


-- Insira um novo avatar e atribua-o a um usuário.
INSERT INTO avatar VALUE(86, "Avatar Novo", "fake url");
UPDATE usuario SET Avatar_idAvatar = 86 WHERE usuario.idUsuario = 1; 

-- Gere um relatório de estilo de classificação de avatares usados ​​por país.
SELECT avatar.nome as avatar_name, pais.nome as avatar_country, COUNT(usuario.Avatar_idAvatar) as total_used
FROM avatar
INNER JOIN usuario
ON avatar.idAvatar = usuario.Avatar_idAvatar
INNER JOIN pais
ON usuario.Pais_idPais = pais.idPais
GROUP BY pais.nome;

-- Insira um usuário com os seguintes dados:
-- Nome: Roberto Rodriguez
-- E-mail: rrodriguez@dhtube.com
-- Password: rr1254
-- Data de nascimento: 01 de novembro de 1975
-- Código postal: 1429
-- País: Argentino
-- Avatar: carita feliz 
INSERT INTO
usuario (nome, email, senha, dataNascimento, codigoPostal, Pais_idPais, Avatar_idAvatar)
VALUES
("Roberto Rodriguez", "rrodriguez@dhtube.com", "rr1254", "1975-11-01", 1429, 9, 85);

-- Gere um relatório de todos os vídeos e suas hashtags,
-- mas apenas aqueles cujos nomes de hashtags contêm menos
-- de 10 caracteres, classificados em ordem crescente pelo número de caracteres na hashtag.
SELECT * FROM video
INNER JOIN video_hashtag
ON video.idVideo = video_hashtag.Video_idVideo
INNER JOIN hashtag
ON hashtag.idHashtag = video_hashtag.hashtag_idHashtag
WHERE length(hashtag.nome) < 10
GROUP BY video.titulo;
