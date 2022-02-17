import opcaoDublado from "./opcaoDublado";

class Interaction {
  
  async sendResponse({ context, string, stage }) {
    if(this.flow.respostaUsuario) return

    await context.sendActivity(string);
    this.flow.passoAtual = stage;
    this.flow.RespostaUsuario = false;
    this.flow.tentativs = 0;
  }

  async getResponse({ context, options }) {
    if(!this.flow.RespostaUsuario) return

    function callbackFilter(opcao) {
      return opcao.op === context.activity.text 
    }
    
    const optionChoosed = options.filter(callbackFilter);

    this.flow.passoAtual = optionChoosed.stage;
    this.flow.tentativs = 0
    this.flow.respostaUsuario = false;  

  }
}

class Opcao1 extends Interaction {
  constructor() {
    super();
  }
}

// Interaction.sendResponse({
//   context,
//   string: `
//     Escolha uma opção de áudio:
//     1 - Dublado;
//     2 - Legendado
//   `,
//   stage: 'respsotaUsuario_opcao1'
// })

Interaction.sendResponse(opcaoDublado(this.context));

// Interaction.getResponse({
//   context,
//   options: [
//     {
//       op: '1',
//       stage: 'menu_opcao1_horario_dublado'
//     },
//     {
//       op: '2',
//       stage: 'menu_opcao1_horario_legendado'
//     }
//   ] 
// })


