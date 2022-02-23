import opcaoDublado from "./opcaoDublado";
import { opcaoAudio } from "./opcaoAudio";

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

  async getData({ context,  object, attribute, stage}) {
    if (!this.flow.respostaUsuario) return;
    Object.defineProperty(object, attribute, context.activity.text)
    this.flow.tentativas = 0;
    this.flow.respostaUsuario = false;
    this.passoAtual = stage;
  
  }
}

function sendObject(context, string, stage) {
  return {
    context,
    string,
    stage
  }
};

function getObject(context, options) {
  return {
    context,
    options
  }

}

module.exports = { sendObject, getObject }
Interaction.sendResponse(opcaoAudio);


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


