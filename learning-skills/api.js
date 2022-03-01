const axios = require('axios');

async function main(cep) {

  const { data } = await axios.post(`http://viacep.com.br/ws/${cep}/json/`, {
    username: "mutant",
    passowrd: "890SAHJDNKJ21893"
  });

  console.log(data);
  axios.create()
  
}


const { data } = await;
const { accessToken } = data;

accessToken








main('41830380');
