import './style.css'

const form = document.forms.car_registration;

const { img, brand_model, year, plate, color } = form;
const registration = document.querySelector("[type='submit']");

const creatingTable = (img, brand_model, year, plate, color) => {
  const row = document.createElement('tr');
  row.innerHTML =
  `

    <th><img src="${img}" alt="" style="width:200px;height:100px"></th>
    <th>${brand_model}</th>
    <th>${year}</th>
    <th>${plate}</th>
    <th>${color}</th>
  `
  return row;
}

registration.addEventListener('click', (e) => {
  e.preventDefault();
  const cars_table = document.querySelector("[data-js='cars_table'");
  cars_table.appendChild(creatingTable(
    img.value,
    brand_model.value,
    year.value,
    plate.value,
    color.value));

})
