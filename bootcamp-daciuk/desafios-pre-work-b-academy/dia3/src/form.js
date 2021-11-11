const inputName = document.querySelector("[data-js='name_input']");

inputName.addEventListener('input', (e) => {
  const dontChange = ["da", "das", "de", "do", "dos"];
  const valueAsArray = e.target.value.split(" ");
  console.log(valueAsArray)

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
