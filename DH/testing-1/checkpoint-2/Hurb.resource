# ALUNO: GUSTAVO TELES BARRETTO
# OBS: CONSIDERANDO O QUE FOI FALADO COM A PROFESSORA BEATRIZ, NÃO PREENCHEMOS INFORMAÇÕES NEM DADOS PESSOAIS PARA EMISSSÃO DE BOLETO.
# ENCERREI O CLICANDO EM ESCOLHER BOLETO, SELECIONANDO OS TERMOS E CONDIÇÕES E FECHANDO O BROWSER.

*** settings ***
Library  SeleniumLibrary

*** variables ***
${SITE}  https://www.hurb.com/br
${BROWSER}  chrome
${PERMITIR_COOKIES}  css=#CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll
${SELECIONAR_PACOTES}  css=#__next > div.Header_Header__1jiZz > div.hrc-2LOsj > div > div > div.h-91nvuq > div > button:nth-child(2) > span
${SELECIONAR_CIDADE}  css=#downshift-1-input
${CLICAR_PESQUISAR}  css=#__next > div.Header_Header__1jiZz > div.hrc-2LOsj > div > div > div.hrc-2_yd0.hrc-SLIuR > button > span
${SELECIONAR_PACOTE}  css=#__next > div > main > div.ResultsCardsContainer_ResultsCardContainer__1jtiB > a:nth-child(1) > div.hrc-3-0W1 > img
${SITE_PACOTE}  Get Window Handles
${ESCOLHER_OPCAO}  css=body > div:nth-child(4) > section > div.box-offer-top.box-nopadding.col-sm-6.col-md-6 > div > section.box-offer-main.pull-left > div:nth-child(5) > div.pull-left.first-box > button
${CLICAR_COMPRAR}  css=#offer-options > div.offer-options--items > div:nth-child(4) > div.row.flex > div.col-xs-12.col-sm-4.col-md-4.offer-options--box-right.main-package > div > div.col-xs-12.col-sm-7.col-md-7.offer-options--box.offer-options--box-price.flex > div:nth-child(2) > div:nth-child(4) > a
${CLICAR_BOLETO}  css=#ui-id-1
${CLICAR_POLITICA_PRIVACIDADE}  css=#cancellation-policy


*** keywords ***
Abrir Browser
  Open Browser  ${SITE}  ${BROWSER}
  Sleep  5s

Clicar em "Permitir todos os cookies"
  Click Element  ${PERMITIR_COOKIES}

Selecionar a opção "Pacotes"
  Click Element  ${SELECIONAR_PACOTES}

Buscar por alguma cidade turística (Ex: Buenos Aires, Florença, Orlando) e clicar em "Pesquisar"
  Input Text  ${SELECIONAR_CIDADE}  Buenos Aires
  Click Element  ${CLICAR_PESQUISAR}

Selecionar um pacote de viagem
  Click Element  ${SELECIONAR_PACOTE}

Clicar em "ESCOLHER OPÇÃO"
  Switch Window  NEW

Escolher uma opção de viagem e clicar em "COMPRAR" 
  Click Element  ${CLICAR_COMPRAR}

#As vezes aparece novamente clicar novamente o clicar COOKIES e dá erro.
#Entretanto, desconheço a sintaxe do IF. Tentei pesquisar mas não tive tempo útil para finalizar.

Selecionar a opção "Boleto parcelado"
  Click Element  ${CLICAR_BOLETO}
  
Marcar o checkbox "Li e aceito as condições de termos de uso e política de privacidade"
  Select Checkbox  ${CLICAR_POLITICA_PRIVACIDADE}
  Close Browser
  


