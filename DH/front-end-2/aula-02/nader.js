let maoUsuario, maoMaquina, pontosMaquina, pontosJogador, desejaJogar = confirm("Você deseja jogar pedra papel tesoura?");; 

const rodada =()=>{
    if (maoUsuario == maoMaquina){
        alert("Empate");
    } else if ((maoUsuario == 1 && maoMaquina==3) || (maoUsuario == 2 && maoMaquina == 1) || (maoUsuario == 3 && maoMaquina==2)){
        pontosJogador++;
        alert("Venceu");
    } else if ((maoUsuario == 1 && maoMaquina==2) || (maoUsuario == 2 && maoMaquina == 3) || (maoUsuario == 3 && maoMaquina==1)){
        alert("Perdeu");
        pontosMaquina++;
    } else {
        alert("Entrada inválida. A máquina venceu!");
        pontosMaquina++;
    }
}

while (desejaJogar){
        alert("Vamos começar, a partida terá 3 rodadas");
        pontosJogador = 0;
        pontosMaquina = 0;
        for (let i = 0; i < 3; i++) {
            maoMaquina = parseInt(Math.random()*2+1);
            maoUsuario = prompt('Digite (1) p/ pedra ou (2) p/ papel ou (3) p/ tersoura');
            rodada();
        }
        if (pontosJogador>pontosMaquina){
            alert("Parabéns! Você venceu a partida!!!")
            desejaJogar = confirm("Você deseja jogar novamente pedra papel tesoura?");
        } else if (pontosMaquina>pontosJogador){
            alert("Você perdeu a partida! Tente de novo!")
        } else alert("A partida deu empate!")   
            desejaJogar = confirm("Você deseja jogar novamente pedra papel tesoura?");
    }