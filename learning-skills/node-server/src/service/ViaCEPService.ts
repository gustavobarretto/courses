import axios from "axios";

class ViaCEPService {
  
  async getCEP(numbers: string) {
    const { data } = await axios.get(`https://viacep.com.br/ws/${numbers}/json/`);

    return data;
  }
}

export default new ViaCEPService();