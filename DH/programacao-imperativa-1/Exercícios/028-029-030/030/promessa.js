function promessa () {
    return new Promise(function(resolve, reject) {
        console.log('lendo arquivo...');
        setTimeout(resolve, 3000);
    })
}

module.exports = promessa