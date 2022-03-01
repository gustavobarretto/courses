const axios = require('axios')

class Api {
  async auth() {

    const { data } = await axios.post('', {
      user
      password
    })

    return 'Bear '.concat(data)
  }

  async get(auth, url) {
    const customizedAxios = axios.create({
      baseUrl: '',
      headers: {
        'Authorization': auth 
      }
    })

    const { data } = await customizedAxios.get(url)
    return data;
  }

}

module.exports = new Api(); // single pattern





