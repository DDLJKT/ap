document.addEventListener("DOMContentLoaded", onDeviceReady, false);

function onDeviceReady() {
  var button = document.getElementById("myButton");
  button.addEventListener("click", function () {
    alert("Button clicked");
  });
}
