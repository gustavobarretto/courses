import express from 'express';
import cors from 'cors';
import helmet from 'helmet';
import { router } from './routes/router';

const app = express();

app.use(express.json());
app.use(cors());
app.use(helmet());
app.use(router);

export { app }

