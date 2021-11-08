let pratos= ['Pipoca', 'Macarrão', 'Carne', 'Feijão', 'Brigadeiro'];
    let tempo= [10, 8, 15, 12, 8];
    let cozinhando = (prato, segundos) => {
        const mensagem = 'Prato pronto. Tenha um bom apetite!'
        if(segundos < tempo[prato-1]*2 && segundos >= tempo[prato-1]) {
            console.log(`A/O ${pratos[prato-1]} ficou pronto em ${segundos} segundos! ` + mensagem)
        } else if(segundos >= tempo[prato-1]*2 && segundos < tempo[prato-1]*3) {
            console.log(`A/O ${pratos[prato-1]} queimou em ${segundos} segundos de cozimento. ` + mensagem)
        } else if(segundos >= tempo[prato-1]*3) {
            console.log(`KABUM!!! ` + mensagem)
        } else if(segundos < tempo[prato-1]) {
            console.log(`O tempo de ${segundos} segundos é insuficiente. O/A ${pratos[prato-1]} ainda não está pronto. ` + mensagem)
        } else {
            console.log('Opção incorreta. Prato inexistente.')
        }
    }; cozinhando(1, 12); cozinhando(1, 5); cozinhando(3, 34); cozinhando(2, 5); cozinhando(11, 21); cozinhando(4, 25);cozinhando(4, 78);
