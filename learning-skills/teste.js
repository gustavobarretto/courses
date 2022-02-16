const arr = [ [5, -3], [1, -3], [3, 10] ];
const sln = [ 0, 0, 0 ];
let x = 0;

for(let i = 0; i <= 2; i++) {
    for(let j = 0; j <= 1; j++) {
        sln[i] = sln[i] + arr[i][j];
    }
    x = x + sln[i];
}

console.log(x);


function permutacao(n) {
    if(n>1) {
        return permutacao(n - 1) * n;
    } else {
        return 1;
    }
}

console.log(permutacao(4));

function troca(a, b) {
    let copia = a;
    a = b;
    b = copia
    return { a, b }
}

console.log(troca(1, 2));
