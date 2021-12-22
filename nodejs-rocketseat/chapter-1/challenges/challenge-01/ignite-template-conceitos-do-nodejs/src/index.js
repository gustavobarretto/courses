const express = require('express');
const cors = require('cors');
const { v4: uuidv4 } = require('uuid');

const app = express();

app.use(cors());
app.use(express.json());

const users = [];

function checksExistsUserAccount(request, response, next) {
  const { username } = request.headers;

  const user = users.find( userSearched => { 
    return userSearched.username === username 
  })
  
  if(!user) {
    return response.status(400).json({ error: "User not found!" })
  }
  request.user = user;

  return next();
}

function findUserTodo(user, id) {
  return todo = user.todos.find( todo => {
    return id === todo.id
  })
}

app.post('/users', (request, response) => {
  const { name, username } = request.body;

  users.push({
    id: uuidv4(),
    name,
    username,
    todos: []
  })
  
  return response.status(204).json({message: "Cadastro de usuário efetuado com sucesso"})
});

app.get('/todos', checksExistsUserAccount, (request, response) => {
  const { user } = request;
  return response.status(200).json(user.todos);
});

app.post('/todos', checksExistsUserAccount, (request, response) => {
  const { user } = request;

  const { title, deadline } = request.body;

  user.todos.push({
    id: uuidv4(),
    title,
    done: false,
    deadline,
    created_at: new Date()
  })

  return response.status(200).json(user)
});

app.put('/todos/:id', checksExistsUserAccount, (request, response) => {
  const { user } = request;

  const id = request.params.id;

  const todo = findUserTodo(user, id);

  todo.title = request.body.title,
  todo.deadline = request.body.deadline

  return response.status(200).json(todo);
});

app.patch('/todos/:id/done', checksExistsUserAccount, (request, response) => {
  const { user } = request;

  const id = request.params.id;

  const todo = findUserTodo(user, id);

  !!todo.done ? todo.done = false : todo.done = true;

  return response.status(200).json(todo);
});

app.delete('/todos/:id', checksExistsUserAccount, (request, response) => {
  const { user } = request;

  const id = request.params.id;

  todoIndex = user.todos.findIndex( todoToDelete => {
    return todoToDelete.id === id;
  })

  user.todos.splice(todoIndex, 1)

  return response.status(200).json(user.todos);
});

module.exports = app;