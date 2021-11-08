const alunos = require("../027")
const Aluno = require("./mod-aluno")

const curso = {
    nome: 'Certified Tech Developer',
    aprovacaoMedia: 7,
    faltasMax: 5,
    listaEstudantes: [],
    addAluno: function (x, y, z) {
        (this.listaEstudantes).push(new Aluno(x, y, z))
    },
    aprovacao: function (aluno) {
        for(i = 0; i < (this.listaEstudantes).length; i++) {
            if(this.listaEstudantes[i].nome == aluno) {
                if(this.listaEstudantes[i].calcularMedia() >= this.aprovacaoMedia && this.listaEstudantes[i].faltas < this.faltasMax || (this.listaEstudantes[i].calcularMedia() >= ((this.aprovacaoMedia)*1.1).toFixed(2)) && (this.listaEstudantes[i].faltas == this.faltasMax)) {
                    return `O aluno ${this.listaEstudantes[i].nome} foi aprovado com média ${this.listaEstudantes[i].calcularMedia()}.`
                } else {
                    return `O aluno ${this.listaEstudantes[i].nome} foi reprovado.`
                }
                             
            }
        }
    },
    listaAprovacao: function () {
        for(i = 0; i < (this.listaEstudantes).length; i++) {
            if(this.listaEstudantes[i].calcularMedia() >= this.aprovacaoMedia && this.listaEstudantes[i].faltas < this.faltasMax || this.listaEstudantes[i].calcularMedia() >= (this.aprovacaoMedia)*1.1 && this.listaEstudantes[i].faltas == this.faltasMax) {
                console.log(`O aluno ${this.listaEstudantes[i].nome} foi aprovado com média ${this.listaEstudantes[i].calcularMedia()}.`)
            } else {
                console.log(`O aluno ${this.listaEstudantes[i].nome} foi reprovado.`)
            }
        }
    }
} 
module.exports = curso