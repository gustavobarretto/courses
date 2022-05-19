USE dhtube;

SELECT usuario.nome as user_name,
COUNT(video.usuario_idUsuario) as total_videos,
canal.nome as canal_name
FROM usuario 
LEFT JOIN canal 
ON usuario.idUsuario = canal.usuario_idUsuario
LEFT JOIN video
ON usuario.idUsuario = video.usuario_idUsuario
GROUP BY usuario.nome;

SELECT usuario.nome as user_name,
COUNT(video.usuario_idUsuario) as total_videos,
SUM(video.qtdLikes) as total_likes
FROM usuario
INNER JOIN video
ON usuario.idUsuario = video.usuario_idUsuario
GROUP BY usuario.nome
ORDER BY total_videos DESC;

SELECT usuario.nome as user_name,
SUM(video.qtdDislikes) as total_dislikes
FROM usuario
INNER JOIN video
ON usuario.idUsuario = video.usuario_idUsuario
GROUP BY usuario.nome
ORDER BY total_dislikes DESC;

SELECT hashtag.nome as hashtag,
COUNT(video_hashtag.hashtag_idHashtag) as total_used
FROM hashtag
INNER JOIN video_hashtag
ON hashtag.idHashtag = video_hashtag.hashtag_idHashtag
GROUP BY hashtag.nome
ORDER BY total_used DESC;

SELECT video.titulo as video_title,
video.qtdReproducoes as most_popular
FROM video
ORDER BY most_popular DESC
LIMIT 5;



