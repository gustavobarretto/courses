const inputName = document.querySelector("[data-js='name_input']");

inputName.addEventListener('input', (e) => {
  const dontChange = ["da", "das", "de", "do", "dos"];
  const valueAsArray = e.target.value.split(" ");
  e.target.value = valueAsArray
    .map((word) => {
      return dontChange.includes(word.toLowerCase())
        ? word.toLowerCase()
        : capitalize(word);
    })
    .join(" ");

  function capitalize(word) {
    return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
  }
})

const colorFont = document.createElement('div');
colorFont.setAttribute('data-js', 'form-color');
inputName.insertAdjacentElement('afterend', colorFont);
const colorForm = document.querySelector("[data-js='form-color']");
colorForm.innerHTML =
`
<select data-js="colors" multiple>
  <option>#0000FF</option>
  <option>#000000</option>
  <option>#00FF00</option>
  <option>#FF0000</option>
  <option>#FFFF00</option>
</select>
<div data-js="colors-box"></div>
`

const colorsChosed = document.querySelector('[data-js="colors"]');
const colorsBox = document.querySelector('[data-js="colors-box"]');

const creationBox = (selected, color) => {
  if(selected) {
    return colorsBox.innerHTML +=
    `
      <div style="width:100px; height:100px; background-color: ${color}"></div>
    `
  } else {

  }

}

colorsChosed.addEventListener('change', (e) => {

  const divArray = [...e.target.options].map(option => {
    return {value: option.value,
            selected: option.selected
            }
  })

  divArray.map(boxColors => {
    console.log(boxColors)
    creationBox(boxColors.selected, boxColors.value)
  })
})








