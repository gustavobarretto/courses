let nomes = ['Drapala', 'Vitor', 'Galbier', 'João', 'Gustavo', 'Barretto']

function funcaoPrincipal() {
    let nomesAlterados = []
    console.log('Estes são os nomes ainda sem alteração: ')
    for(i = 0; i < nomes.length; i++) {
        console.log(nomes[i])
    }
    console.log('Agora vemos os nomes alterados: ')
    for(i = 0; i < nomes.length; i++) {
        nomesAlterados.push(nomes[i] + 'vksy')
        console.log(nomesAlterados[i])
    }
} funcaoPrincipal()

console.log(nomesAlterados)