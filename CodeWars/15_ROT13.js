function rot13(str) {
    const firstLine = [ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m" ];
    const scndLine =  [ 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' ];
    
    function letterLine (letter) {
        if(firstLine.indexOf(letter.toLowerCase()) !== -1) {
            return letter.toUpperCase() === letter ? 
                scndLine[firstLine.indexOf(letter.toLowerCase())].toUpperCase() :
                scndLine[firstLine.indexOf(letter.toLowerCase())];
            
        } else if(scndLine.indexOf(letter.toLowerCase()) !== -1) {
            return letter.toUpperCase() === letter ? 
                firstLine[scndLine.indexOf(letter.toLowerCase())].toUpperCase() :
                firstLine[scndLine.indexOf(letter.toLowerCase())];
        } else {
            return "NaW";
        }
    }

    return str.split('').map( word => {
        if(letterLine(word) === 'NaW') {
            return word;
        }
        return letterLine(word);
    }).join('')
}

function rot13(str) {
    return str.replace(/[a-z]/ig, function(x){
      return String.fromCharCode(x.charCodeAt(0) + (x.toLowerCase() <= 'm' ? 13: -13));
    });
  }

  function rot13(str) {
    return str.split('').map(function(e) {
      return /[A-Ma-m]/.test(e) ? String.fromCharCode(e.charCodeAt(0) + 13) :
             /[N-Zn-z]/.test(e) ? String.fromCharCode(e.charCodeAt(0) - 13) : e;
    }).join('');
  }

  function rot13(str) {
    var a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
     var b = "nopqrstuvwxyzabcdefghijklmNOPQRSTUVWXYZABCDEFGHIJKLM"
     return str.replace(/[a-z]/gi, c => a[b.indexOf(c)])
   }




