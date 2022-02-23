const { getObject, sendObject } = require('./bot');

module.exports.opcaoAudio = sendObject(context,
  `
    Escolha uma opção de áudio:
    1 - Dublado;
    2 - Legendado
  `,
  'respsotaUsuario_opcao1')

