export default function sendOpcaoDublado (context) {
  return {
    context,
    string: `
     Escolha uma opção de áudio:
     1 - Dublado;
     2 - Legendado
   `,
   stage: 'respostaUsuario_opcao1'
  }
}
export default function getOpcaoDublado (context) {
  return {
    context,
    string: `
     Escolha uma opção de áudio:
     1 - Dublado;
     2 - Legendado
   `,
   stage: 'respostaUsuario_opcao1'
  }
}



console.log(opcaoDublado('context'))