/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

// Wait for the deviceready event before using any of Cordova's device APIs.
// See https://cordova.apache.org/docs/en/latest/cordova/events/events.html#deviceready
document.addEventListener("click", onDeviceReady, false);

function onDeviceReady() {
  var num1 = document.getElementById("num1");
  var num2 = document.getElementById("num2");
  num1 = parseFloat(num1.value);
  num2 = parseFloat(num2.value);
  var add = document.getElementById("add");
  var sub = document.getElementById("sub");
  var mul = document.getElementById("mul");
  var div = document.getElementById("div");
  var displayText = document.getElementById("displayText");
  add.addEventListener("click", function () {
    var total = num1 + num2;
    displayText.textContent = "Sum: " + total;
  });
  sub.addEventListener("click", function () {
    var total = num1 - num2;
    displayText.textContent = "Difference: " + total;
  });
  mul.addEventListener("click", function () {
    var total = num1 * num2;
    displayText.textContent = "Product: " + total;
  });
  div.addEventListener("click", function () {
    var total = num1 / num2;
    displayText.textContent = "Division: " + total;
  });
}
