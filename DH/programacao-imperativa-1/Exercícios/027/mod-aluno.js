class Aluno {
    constructor(n, f, nts) {
        this.nome = n
        this.faltas = f
        this.notas = nts
    }
    calcularMedia () {
        let reducer = (a, cV) => a + cV;        
        let total = (this.notas).reduce(reducer) 
        return (total / (this.notas).length).toFixed(2)
    }
    get med() {
        return `A média de ${this.nome} é de ${this.calcularMedia()}.`
    }
    falta() {
        this.faltas++ 
    }    
}

module.exports = Aluno