const fs = require('fs');

const emPromessa1 = (arq) => new Promise(function (resolve, rejected) {
    fs.readFile(arq, (err, content) => {
        resolve(JSON.parse(content))
        rejected(err)
    })
});

Promise.all(
    [emPromessa1('file.json'), emPromessa1('file2.json'), emPromessa1('file3.json')]
).then(content => {
    console.log(content)
})
