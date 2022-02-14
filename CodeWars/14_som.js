function parseInt(string) {
  const dictionary = [
    { 'one': 1 },
    { 'tw': 2 },
    { 'thr': 3 },
    { 'thi': 3 },
    { 'fo': 4 },
    { 'fi': 5 },
    { 'six': 6 },
    { 'sev': 7 },
    { 'eigh': 8 },
    { 'nin': 9 },
    { 'zer': 0 },
    { 'ten': 10 },
    { 'eleven': 11 },
  ]

  if(string.includes('teen')) {
    const number = dictionary.filter( value => {
      return string.includes((Object.keys(value))[0])
    })
    return `1${(Object.values(number[0]))[0]}`;
  } else if {
    
  }
  

  

  return;
}

console.log(parseInt('fifteen'))

