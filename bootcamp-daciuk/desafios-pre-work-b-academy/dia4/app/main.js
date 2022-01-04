const form = document.forms.car_registration;

const { img, brand_model, car_year, plate_license, car_color } = form;

const registration = document.querySelector("[type='submit']");
const cars_table = document.querySelector("[data-js='cars_table']");

const creatingTable = (
  img,
  brand_model,
  car_year,
  plate_license,
  car_color
) => {
  const row = document.createElement("tr");
  row.innerHTML = `
    <th><img src="${img}" alt="" style="width:200px;height:100px"></th>
    <th>${brand_model}</th>
    <th>${car_year}</th>
    <th>${plate_license}</th>
    <th>${car_color}</th>
    <th><button data-js="delete-button">Delete</button></th>
  `;
  return row;
};

const urlAPI = "http://localhost:3333/cars";

const reqCarRegistration = async (url, methodParam, data) => {
  const response = await fetch(url, {
    method: methodParam,
    mode: "cors",
    cache: "no-cache",
    credentials: "same-origin",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    referrerPolicy: "no-referrer",
    body: JSON.stringify(data),
  });
  return response.json();
};

const attCarsData = async (urlAPI) => {
  return await reqCarRegistration(urlAPI, "GET").then((data) => {
    data.map((car) => {
      cars_table.appendChild(
        creatingTable(car.image, car.brandModel, car.year, car.plate, car.color)
      );
    });
  });
};

registration.addEventListener("click", (e) => {
  e.preventDefault();

  cars_table.innerHTML = `
    <tr data-js="cars_table_columns">
    <th>Image</th>
    <th>Brand/Model</th>
    <th>Year</th>
    <th>Plate</th>
    <th>Color</th>
    </tr>
  `;

    reqCarRegistration(urlAPI, "POST", {
      image: img.value,
      brandModel: brand_model.value,
      year: car_year.value,
      plate: plate_license.value,
      color: car_color.value,
    }).then((data) => {
      console.log(data);
    });

  attCarsData(urlAPI);
});



attCarsData(urlAPI);

document.addEventListener('click', (e) => {
  if (!!e.target?.parentNode?.parentNode?.childNodes[7]?.innerText) {
    const plate_license = e.target.parentNode.parentNode.childNodes[7].innerText;
    cars_table.innerHTML = `
      <tr data-js="cars_table_columns">
      <th>Image</th>
      <th>Brand/Model</th>
      <th>Year</th>
      <th>Plate</th>
      <th>Color</th>
      </tr>
    `;

    reqCarRegistration(urlAPI, "DELETE", {
      plate: plate_license
    }).then( (data) => {
      console.log(data)
    })

    attCarsData(urlAPI);
  }
})
