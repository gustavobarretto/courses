// Variável de contagem de produtos que levam brinquedos ao sul.
let toyAndSouth = 0;

// Lista de produtos
const arr = [
  "288355555123888",
  "335333555584333",
  "223343555124001",
  "002111555874555",
  "111188555654777",
  "111333555123333",
  "432055555123888",
  "079333555584333",
  "155333555124001",
  "333188555584333",
  "555288555123001",
  "111388555123555",
  "288000555367333",
  "066311555874001",
  "110333555123555",
  "333488555584333",
  "455448555123001",
  "022388555123555",
  "432044555845333",
  "034311555874001",
  "150150555875888",
  "201222555875001"
];

// Variável de contagem de códigos válidos e inválidos
const codesCount = {
  valid: 0,
  invalid: {
    count: 0,
    codes: []
  },
}

// Variável de contagem da região dos pacotes de destino
const regionCounterDestiny = {
  "Sudeste": 0,
  "Sul": 0,
  "Centro-Oeste": 0,
  "Nordeste": 0,
  "Norte": 0
}

// Variável de organização de pacotes em grupos por destino
const dataGroupByDestiny = {
  "Sudeste": [],
  "Sul": [],
  "Centro-Oeste": [],
  "Nordeste": [],
  "Norte": []
}

// Variável de organização de pacotes em grupos por produto
const dataGroupByProduct = {
  "Jóias": [],
  "Livros": [],
  "Eletrônicos": [],
  "Bebidas": [],
  "Brinquedos": []
}

// Variável de contagem do número de vendedores
const sellers = []

// Variável de contagem do número de pacotes destinados ao Norte e Centro-Oeste no mesmo caminhão 
const sameTruckToNorth = []

// O código faz duas tarefas: 
// - Identifica a região de destino e origem;
// - Identifica o produto do pacote
function checker(str, property) {
  const numbers = Number(str);
  const regions = { // Dicionário de regiões
    100: "Sudeste",
    200: "Sul",
    300: "Centro-Oeste",
    400: "Nordeste",
    500: "Norte",
  };
  const products = { // Dicionário de produtos
    001: "Jóias",
    111: "Livros",
    333: "Eletrônicos",
    555: "Bebidas",
    888: "Brinquedos",
  };
  if (property === "origin" || property === "destiny") {
    const result = Object.entries(regions).find((region) => numbers < Number(region[0]))
    if(result) {
      return result[1]
    }
    throw new Error("Código de origem ou destino inválido.")
  } else if (property === "products") {
    const result = Object.entries(products).find((product) => numbers === Number(product[0]))
    if(result) {
      return result[1]
    }
    throw new Error("Código de produto inválido.")
  } else if (property === "loggi") {
    if(numbers === 555) {
      return str;
    }
    throw new Error("Código Loggi inválido.")
  } else {
    return str;
  }
}

// A função valida completamente o código de barras, incluindo os vendedores válidos.
function validation(barCode) {
  if(barCode.length != 15) {
    console.log("O código deve ter exatamente quinze dígitos.")
    return
  }
  try {
    // Verificação de cada parte
    const origin = 'Cidade ' + barCode.slice(0, 3) + ', região ' + checker(barCode.slice(0, 3), 'origin'); 
    const destiny = 'Cidade ' + barCode.slice(3,6) + ', região ' + checker(barCode.slice(3, 6), 'destiny');
    const loggi = checker(barCode.slice(6, 9), 'loggi');
    const seller = barCode.slice(9, 12)
    const product = checker(barCode.slice(12, 15), 'products');

    // Contagem de vendedores
    const filterSeller = sellers.find(s => Number(s?.sellerCode) === Number(seller))
    if(!filterSeller) {
      sellers.push({
        sellerCode: seller,
        count: 1
      })
    } else {
      filterSeller.count++;
    }

    // Erro de vendedor não autorizado
    if(seller === '357') { 
      throw new Error("O código do vendedor 357 não está autorizado a realizar envios.")
    }

    codesCount.valid++; // Contagem do código válido
    return { // Retorno do conteúdo do pacote e informações
      'Código': barCode,
      'Região de Origem': origin,
      'Região de Destino': destiny,
      'Código Loggi': loggi,
      'Código do Vendedor': seller,
      'Tipo do Produto': product 
    }
  } catch (error) {
    codesCount.invalid.count++; // Contagem do código inválido
    codesCount.invalid.codes.push(barCode); // Reserva do código que foi declarado inválido
    return error.message + " Código: " + barCode;
  }
}

// Filtro para extrair produtos por região, seja de destino ou de origem.
function filterRegion(str, content) {
  return content[str].match(/Sudeste|Sul|Centro-Oeste|Nordeste|Norte/g);
} 

// Verificação da lista de exemplos do desafio
arr.forEach((codes, index) => {
  const content = validation(codes);
  console.log(content);
  if(Object.prototype.isPrototypeOf(content)) {

    // Group by Destiny
    const regionDestiny = filterRegion('Região de Destino', content);
    regionCounterDestiny[regionDestiny]++
    dataGroupByDestiny[regionDestiny].push(content);

    //Group by Truck
    if(regionDestiny[0] === "Norte" || regionDestiny[0] === "Centro-Oeste") {
      sameTruckToNorth.push(content);
    }

    // Group by product
    const product = content['Tipo do Produto'].match(/Jóias|Livros|Eletrônicos|Bebidas|Brinquedos/g);
    dataGroupByProduct[product].push(content);

    // Group by South origin and Toy
    const south = content['Região de Origem'].match(/Sul/g);
    if(south) {
      content['Tipo do Produto'] === 'Brinquedos' ? toyAndSouth++ : '';
    }
  }
})

// Verificação dos resultados
console.log({regionCounterDestiny})
console.log({codesCount})
console.log({toyAndSouth})
console.log({dataGroupByDestiny})
console.log({dataGroupByDestiny})
console.log({sellers})
console.log(codesCount.invalid.codes)
console.log({sameTruckToNorth})
