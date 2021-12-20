const { Router } = require('express');

const ContactController = require('./app/controllers/ContactController');
const CategoryController = require('./app/controllers/CategoryController');

const router = Router();

router.get(
  '/contacts',
  /*   (request, response, next) => {
    // Middleware é executado de cima para baixo e serve para fazer
    // verificação antes de dar continuidade para o middleware principal
    request.appId = 'MeuAppID';
    next();
  }, */
  ContactController.index,
);
router.get('/contacts/:id', ContactController.show);
router.delete('/contacts/:id', ContactController.delete);
router.post('/contacts', ContactController.store);
router.put('/contacts/:id', ContactController.update);

router.get('/categories', CategoryController.index);
router.post('/categories', CategoryController.store);

module.exports = router;
