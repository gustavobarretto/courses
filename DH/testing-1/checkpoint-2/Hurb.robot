*** settings ***

Library  SeleniumLibrary
Resource  ./hurb.resource

*** test cases ***
Processo de reserva de pacote de viagens
  Abrir Browser
  Clicar em "Permitir todos os cookies"
  Selecionar a opção "Pacotes"
  Buscar por alguma cidade turística (Ex: Buenos Aires, Florença, Orlando) e clicar em "Pesquisar"
  Selecionar um pacote de viagem
  Clicar em "ESCOLHER OPÇÃO"
  Escolher uma opção de viagem e clicar em "COMPRAR"
  Selecionar a opção "Boleto parcelado"
  Marcar o checkbox "Li e aceito as condições de termos de uso e política de privacidade"


  

