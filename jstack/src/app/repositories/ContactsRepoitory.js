const { v4 } = require('uuid');

const db = require('../../database');

let contacts = [
  {
    // uuid -> Universal Unique ID - Gera uma HASH
    id: v4(),
    name: 'Mateus',
    email: 'mateus@mail.com',
    phone: '123414141',
    category_id: v4(),

  },
  {

    id: v4(),
    name: 'Jose',
    email: 'jose@mail.com',
    phone: '12131414',
    category_id: v4(),

  },
  {

    id: v4(),
    name: 'Maria',
    email: 'maria@mail.com',
    phone: '3131313155',
    category_id: v4(),

  },
];

class ContactsRepository {
  findAll() {
    return new Promise((resolve) => resolve(contacts));
  }

  findById(id) {
    return new Promise((resolve) => resolve(
      contacts.find(((contact) => contact.id === id)),
    ));
  }

  findByEmail(email) {
    return new Promise((resolve) => resolve(
      contacts.find(((contact) => contact.email === email)),
    ));
  }

  delete(id) {
    return new Promise((resolve) => {
      contacts = contacts.filter((contact) => contact.id !== id);
      resolve();
    });
  }

  async create({
    name, email, phone, category_id,
  }) {
    const row = await db.query();
  }

  update(id, {
    name, email, phone, category_id,
  }) {
    return new Promise((resolve) => {
      const updatedContact = {
        id,
        name,
        email,
        phone,
        category_id,
      };

      contacts = contacts.map((contact) => (
        contact.id === id ? updatedContact : contact));

      resolve(updatedContact);
    });
  }
}

module.exports = new ContactsRepository();
