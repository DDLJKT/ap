document.addEventListener("DOMContentLoaded", function () {
  var button = document.getElementById("myButton");
  var fruitDropdown = document.getElementById("fruitDropdown");

  button.addEventListener("click", function () {
    var selectedFruit = fruitDropdown.value;
    alert("Fruit selected is " + selectedFruit);
  });
});
