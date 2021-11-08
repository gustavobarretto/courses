const fs = require('fs');
const promessa = require('./030/promessa')

const emPromessa = (arq) => new Promise(function (resolve, rejected) {
    fs.readFile(arq, (err, content) => {
        resolve(JSON.parse(content))
        rejected(err)
    })
});
promessa().then( _ => {
    emPromessa('file.json')
    .then(content => {
        console.log(content)
    })
})



