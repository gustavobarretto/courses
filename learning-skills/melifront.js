function func (a, b, c) {
  if(checkStrings(arguments)) return "There is some string" 
  if(c < a || c > b) return "Number out of range."
  const x = c - a;
  const y = b - c;
  if(x === y) return "Both difference are identical"
  return x > y ? b : a; 
}

function checkStrings(object) {
  return Object.values(object).findIndex( n => typeof n === "string") != -1;
}

console.log(func(10, 20, 15))

