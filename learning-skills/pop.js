function exchange(price, payment) {
  const change = payment - price;
  const arrChange = String(change).split('');
  const nota1 = arrChange.pop() || '0';
  const nota10 = arrChange.pop() || '0';
  
  return {
    nota100: arrChange.join('') || '0',
    nota10,
    nota1
  }
  
}

console.log(exchange(322, 4000));