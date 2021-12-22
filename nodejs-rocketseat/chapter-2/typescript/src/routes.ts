import { Request, Response } from 'express'
import CreateCourseService from './CreateCourseService';

export function createCourse(request: Request, response: Response) {

    CreateCourseService.execute({
        educator: "Gustavo",
        duration: 10,
        name: "NodeJS"
    });

    CreateCourseService.execute({
        educator: "Diego",
        name: "ReactJS"
    });

    return response.send();
}