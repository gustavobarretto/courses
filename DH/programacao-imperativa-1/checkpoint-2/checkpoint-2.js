let menu = {
    pratos: ['Pipoca', 'Macarrão', 'Carne', 'Feijão', 'Brigadeiro'],
    tempo: [10, 8, 15, 12, 8],
    cozinhando: function(prato, segundos) {
        let mensagem = 'Prato pronto. Tenha um bom apetite!'
        if(segundos <= this.tempo[prato-1]*2 && segundos >= this.tempo[prato-1]) {
            console.log(`A/O ${this.pratos[prato-1]} ficou pronto em ${segundos} segundos! ` + mensagem)
        } else if(segundos > this.tempo[prato-1]*2 && segundos <= this.tempo[prato-1]*3) {
            console.log(`A/O ${this.pratos[prato-1]} queimou em ${segundos} segundos de cozimento. `)
        } else if(segundos > this.tempo[prato-1]*3) {
            console.log(`KABUM!!!`)
        } else if(segundos < this.tempo[prato-1]) {
            console.log(`O tempo de ${segundos} segundos é insuficiente. O/A ${this.pratos[prato-1]} ainda não está pronto.`)
        } else {
            console.log('Opção incorreta. Prato inexistente.')
        }
    }
}; menu.cozinhando(1, 23)
