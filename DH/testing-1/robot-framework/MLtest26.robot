*** settings ***
library  SeleniumLibrary

*** variables ***

*** test case ***
Mercado Livre
  Acessar o site do Mercado Livre
  Fazer uma busca por iPhone 12
  Clicar no primeiro resultado da busca

*** keywords ***
Acessar o site do Mercado Livre
  Open Browser   https://www.mercadolivre.com.br/  chrome 

Fazer uma busca por iPhone 12
  Input Text  css=body > header > div > form > input  iPhone 12
  Click Element  css=body > header > div > form > button > div

Clicar no primeiro resultado da busca
  Click Element  css=#root-app > div > div > section > ol > li:nth-child(1) > div > div > div.ui-search-result__content-wrapper > div.ui-search-item__group.ui-search-item__group--title > a.ui-search-item__group__element.ui-search-link > h2
  Close Browser