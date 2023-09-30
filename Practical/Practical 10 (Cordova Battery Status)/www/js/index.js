document.addEventListener("DOMContentLoaded", onDeviceReady, false);

function onDeviceReady() {
  // Add battery status event listeners
  window.addEventListener("batterystatus", onBatteryStatus, false);
  window.addEventListener("batterylow", onBatteryLow, false);
  window.addEventListener("batterycritical", onBatteryCritical, false);
}

function onBatteryStatus(status) {
  document.getElementById("status").innerHTML = status.isPlugged
    ? "Charging"
    : "Not Charging";
  document.getElementById("level").innerHTML = status.level;
}

function onBatteryLow(status) {
  alert("Battery level is low: " + status.level);
}

function onBatteryCritical(status) {
  alert("Battery is critically low: " + status.level);
}
