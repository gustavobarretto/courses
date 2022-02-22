import axios from "axios";
import { Request, Response } from 'express';
import { PerformanceNodeTiming } from "perf_hooks";
import ViaCEPService from "../service/ViaCEPService";

class ViaCEPController {

  async query(request: Request, response: Response)  {
    const { numbers } = request.params;

    response.send(await ViaCEPService.getCEP(numbers));
  }

}

export default new ViaCEPController();




const arr = [1, 2, 3, 4 ,5]

npm i bluebird