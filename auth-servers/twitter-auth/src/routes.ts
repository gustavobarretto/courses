import { Router } from 'express';
import DocusignController from './DocusignController';

const routes = Router();

routes.get('/auth/docusign', DocusignController.call)
routes.get('/auth/docusign/callback')


export default routes;