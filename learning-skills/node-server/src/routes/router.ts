import { Router } from "express";

// Cep Router
import CepRouter from "./CepRouter";

const router = Router();

router.use('/cep', CepRouter);
router.use('/palindrome');
router.use('/vehicles');
router.use('/exchange')

export { router } 
