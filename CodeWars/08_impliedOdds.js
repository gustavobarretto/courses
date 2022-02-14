// Betting odds are a great way to find out how likely an event is to happen, 
// and most betting websites will offer you odds for sporting events as well 
// as major political elections, or even who might be likely to win a reality show!

// FRACTIONAL ODDS AND YOUR STAKE

// There are many kinds of odds, including decimal and American, 
// but the most popular in the UK is fractional odds. 
// Let's say an event has odds of 1/5 to win. Well, this means that if you 
// bet £1 (British Pound Sterling) and you win, you get back £1.20, meaning
//  a 20 pence profit, i.e. you win back (1 / 5) * your stake. Simple enough right? 
//  But that only tells you how much money you'll win, we still need to work out how likely this event is to happen!

// FRACTIONAL ODDS AND IMPLIED PROBABILITY

// What we really want to know for this kata is, what is the implied probability of an array of fractional betting odds?

// Many might look at odds of 1/5 and think the event is 20% likely to happen. 
// But actually, it would be 83.3% likely to happen. So how did we get here? The standard formula is:

// denominator / (denominator + numerator) * 100

// In this case, that would be: 5 / (1 + 5) * 100.

// For this challenge, you will be given some fractional odds, represented 
// as an array of strings. Find out which odds have the highest implied probability, 
// and return that probability as a percentage to 1 decimal place, e.g. "83.3%" for 1/5.

// The result must be a string, and there should be no spaces between the number and the percentage sign. 
// When rounding, 5 should be rounded up. Good luck!

function oddsConverter(odds) {
    let prob
    let oddsList = []
    for (let i = 0; i < odds.length; i++) {
      var numeros = '';
      var denominator = '';
      var numerator = '';
      let probAnalized = odds[i]
      for(let c = 0; c < probAnalized.length; c++) {
        if(probAnalized[c] == '/') {
          denominator = numeros;
          numeros = 0;
          probAnalized[c+1] != undefined ? numerator += probAnalized[c+1] : '';
        } else {
          numeros += probAnalized[c]
      }}
      
      prob = ((parseFloat(numerator) / ((parseFloat(numerator)+parseFloat(denominator))*100)) * 10000).toFixed(1);
      if(prob[3] == 0) {
        prob = Math.floor(prob)
      }
      oddsList.push(prob)
    }
    oddsList.sort(function(a, b) {return b-a})
    return oddsList[0] + '%'
  };