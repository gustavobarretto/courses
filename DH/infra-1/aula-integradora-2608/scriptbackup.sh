#!/bin/bash
####################################
#
# Backup to NFS mount script.
#
####################################

# What to backup. 
backup_files="./teste/"

checkbackup="./backup"
# openssl sha1 <nome do arquivo> cria um hash específico
# sha1sum <nome do arquivo> verifica se o hash é o mesmo


if [ -e $checkbackup ]; then
	rm $checkbackup -rf
	echo "Já existe uma pasta backup. Excluindo para substituí-la"
	mkdir $checkbackup
else
	mkdir $checkbackup
	echo "Não existe nenhum backup. Criando uma pasta backup para prosseguir"
fi

# Where to backup to.
dest="./backup"

# Create archive filename.
day=$(date +"%d-%m-%Y-%T")
hostname="gustavo" 
archive_file="$hostname-$day.tgz"

# Print start status message.
echo "Backing up $backup_files to $dest/$archive_file"
date
echo

# Backup the files using tar.
tar czf $dest/$archive_file $backup_files

# Print end status message.
echo
echo "Backup finished"
date

# Long listing of files in $dest to check file sizes.
ls -lh $dest
