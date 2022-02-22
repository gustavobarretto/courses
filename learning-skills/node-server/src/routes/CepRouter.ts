import { Router } from 'express';
import ViaCEPController from '../controller/ViaCEPController';
import ViaCEPService from '../service/ViaCEPService';

const router = Router();

router.get('/:numbers', ViaCEPController.query)
router.post('/body', async (request, response) => {
  const { cep } = request.body;

  return response.send(await ViaCEPService.getCEP(cep));

})

export default router;


