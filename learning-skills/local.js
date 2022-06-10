class CardNumberAnalyzer {
  constructor(cardNumber) {
      if(!!cardNumber == false) {
        throw new Error("Not a valid card number")
      }
    this.cardNumber = this.cardValidation(cardNumber);
  }
  
    hasValidCardNumberLength(cardNumber) {
      const lengthValidator = {
        '15': true,
        '16': true
      }
      return !!lengthValidator[String(cardNumber?.length)]
    }
  
  cardValidation(cardNumber) {
    cardNumber = cardNumber.split(" ").join("")
    if(cardNumber.match(/\D+/)) {
      throw new Error("Not a valid card number")
    }
    if(!cardNumber.split(" ").join("").match(/^[3|4|5]\d+/g)) {
      throw new Error("Unknown card brand")
    };
    if(!!cardNumber == false){
      throw new Error("Not a valid card number")
    }
    return cardNumber;
  }
  
     checkBrand(firstDigit) {
      const brand = {
        '3': 'american_express',
        '4': 'visa',
        '5': 'master_card'
      }
      return brand[firstDigit]
    }
  
      securityLocation(brand) {
      const secLoc = {
        'american_express': {
          location: 'front',
          expectedLength: 4
        }, 
        'visa': {
          location: 'back',
          expectedLength: 3
        },
        'master_card': {
          location: 'back',
          expectedLength: 3
        }
      }
      return secLoc[brand]
    }
  
  
    getCardDetails() {
      return {
        card: {
          number: this.cardNumber,
          bin: String(this.cardNumber).split("").slice(0,6).join(""),
          brand: this.checkBrand(this.cardNumber[0]),
          expectedLength: this.cardNumber.length,
          isValid: this.hasValidCardNumberLength(this.cardNumber)
        },
        securityCode: this.securityLocation(this.checkBrand(this.cardNumber[0]))
      }
    }
  }

function main() {
  try {
    const creditCard = new CardNumberAnalyzer('9123456799990000');
    const { card, securityCode } = creditCard.getCardDetails();
    const isValid = creditCard.hasValidCardNumberLength();
    
  } catch (e) {
    console.log(e);
  }
}

main()



