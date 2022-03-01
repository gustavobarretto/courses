const Api = require('./abstractApi');

const auth = await Api.auth();

const response = await Api.get('/gepaci/tipos');

Api.auth();

Api.get('/')