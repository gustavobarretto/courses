// function isPrime(num) {
   // let cont = 0;
   // for (i = 0; i <= num; i++) { num % i == 0 ? cont > 2 ? i = num : cont++ : ''}
   // return cont == 2;

   // let cont = 0;
   // if (num > 100) {
   //    const n = num.toString().split('')[num.toString().split('').length - 1]
   //    n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0 ? cont = 3 : '';
   // } else if (cont == 0) {
   //    for (i = 0; i <= num; i++) { num % i == 0 ? cont > 2 ? i = num : cont++ : ''} 
   // }
   // return cont == 2;

//    let cont = 0;
//    if (num > 1000 ) {
//       for(i = 2; i < (num/2); i++) { num % i == 0 ? cont = 3 : cont = 2 } 
//    } else if (num <= 1000) {
//       for (i = 0; i <= num; i++) { num % i == 0 ? cont > 2 ? i = num : cont++ : ''}
// }
//    return cont == 2;

function isPrime(num) {
   //TODO
   if(num <= 1) {
       return false
    }
   for(i = 2; i*i <= num; i++) {
      if(num % i == 0) {
         return false
      }
    }
    return true
 }

console.log(isPrime(960111615))

console.log(isPrime(50794129))