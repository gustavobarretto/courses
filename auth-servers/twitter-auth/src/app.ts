import express from 'express';
import helmet from 'helmet';
import cors from 'cors';
import routes from './routes';

const app = express();

app.use(helmet());
app.use(cors());
app.use(routes);

export default app;

