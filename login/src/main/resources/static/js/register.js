const regBtn = document.getElementById("regBtn");
const regInputs = document.querySelectorAll(".regInput");

//funktion för att säkerställa alla fält är ifyllda
function checkInputFields() {
  let allFilled = true;
  regInputs.forEach(input => {
    if (input.value === "") {
      allFilled = false;
    }
  });
  //om ett fält är tomt så blir regBtn disabled, .disabled och !allFilled rekommenderade chatGPT mig att använda.
  regBtn.disabled = !allFilled;
}

//lägg event listeners på alla regInputs (klass i register html)
regInputs.forEach(input => {
  input.addEventListener("input", checkInputFields); //checkInputFields rekommenderade chatGPT mig att använda.
});

//kör funktionen när sidan laddas
checkInputFields();
