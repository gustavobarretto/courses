// Your job is to write a function which increments a string, to create a new string.

// If the string already ends with a number, the number should be incremented by 1.
// If the string does not end with a number. the number 1 should be appended to the new string.
// Examples:

// foo -> foo1

// foobar23 -> foobar24

// foo0042 -> foo0043

// foo9 -> foo10

// foo099 -> foo100

// Attention: If the number has leading zeros the amount of digits should be considered.


function incrementString (strng) {
    // return incrementedString
    let number = []
      let letter = []
      strng.split('').map(string => {
          const NaN = parseInt(string)
          return isNaN(NaN) ? letter.push(string) : NaN == 0 ? letter.push(string) : number.push(NaN) 
      })
      number.lastIndexOf(9) == number.length - 1 || number.length == 0 ? letter.lastIndexOf('0') > -1 ? letter.pop() : '' : ''
      number.length == 0 ? letter.push(1) : ''
      return number.join('') == '' ? letter.join('') : letter.join('') + `${parseInt(number.join('')) + 1}`
  }

console.log(incrementString('foo'))
console.log(incrementString('foo000'))
console.log(incrementString('foo001'))
console.log(incrementString('foo0001'))
console.log(incrementString('foo99'))
console.log(incrementString('foo099'))

