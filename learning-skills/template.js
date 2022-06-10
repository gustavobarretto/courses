function hasValidCardNumberLength(cardNumber) {
  const lengthValidator = {
    '15': true,
    '16': true
  }
  return !!lengthValidator[String(cardNumber?.length)]
}

console.log(hasValidCardNumberLength('000000000000000000'))