# define a imagem base
FROM debian:latest
# define o mantenedor da imagem
LABEL maintainer="gustavobarretto"
# Atualiza a imagem com os pacotes
RUN apt-get update && apt-get upgrade -y
# Instala o NGINX para testar
RUN apt-get install nginx -y
# Expoe a porta 80
EXPOSE 80
# Comando para iniciar o NGINX no Container
CMD ["nginx", "-g", "daemon off;"]

