var calculo = {
    'fatorial': function fatorial(n){
        if (n <= 1) return 1;
        return n * fatorial(n - 1);
    }
};

console.log(calculo.fatorial(5)); 