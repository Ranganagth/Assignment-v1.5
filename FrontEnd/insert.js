let device_id1 = document.getElementById("device_id");
let device_name1 = document.getElementById("device_name");
let device_serial_no1 = document.getElementById("device_serial_no");
let device_type_id1 = document.getElementById("device_type_id");
let status1 = document.getElementById("status");
let prototype_id1 = document.getElementById("prototype_id");
let location_Id1 = document.getElementById("location_Id");
let created_by1 = document.getElementById("created_by");
let created_timestamp1 = document.getElementById("created_timestamp");
let updated_timestamp1 = document.getElementById("updated_timestamp");
let device_state1 = document.getElementById("device_state");
let user_device_type1 = document.getElementById("user_device_type");
let tcu_serial_number1 = document.getElementById("tcu_serial_number");
let imei1 = document.getElementById("imei");
let iccid1 = document.getElementById("iccid");
let account_id1 = document.getElementById("account_id");


function checking() {
  let data = {
     device_id: device_id1.value,
     device_name: device_name1.value,
     device_serial_no: device_serial_no1.value,   
     device_type_id : device_type_id1.value,
     status: status1.value,
     prototype_id: prototype_id1.value,
     location_Id: location_Id1.value,
     created_by: created_by1.value,
     created_timestamp: created_timestamp1.value,
     updated_timestamp: updated_timestamp1.value,
     device_state: device_state1.value,
     user_device_type : user_device_type1.value ,
     tcu_serial_number : tcu_serial_number1.value,
     imei : imei1.value,
     iccid : iccid1.value,
     account_id : account_id1.value,

  };

//   console.log(data);
//   let vinNoCheck = vinNo.value;
//   let speedCheck = speed.value;
//   let sp = +speed.value;
//   if (device_id.value == "" || device_id.value == "") {
//     alert("empty");
//     return "Data is empty";
//   }

//   console.log(sp);
//   if (vin.value.length != 17 || speed.value.length != 3 || sp < 0) {
//     alert("not appropriate");
//     return "Data is not of appropriate";
//   }
  let options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Accept: "application/json",
      //Authorization: `Bearer ${localStorage.getItem("AccessToken")}`,
    },
    body: JSON.stringify(data),
  };
  fetch("http://localhost:8080/login", options)
    .then(function (response) {
      console.log(response);
      return response.status;
    })
    .then(function (status) {
      console.log(status);
      if (status === 200) {
        alert("success");
        window.location.replace("ApplicationV1.html");
        console.log("success");
      //} else if (status === 401) {
       //window.location.replace("login.html");
      } else {
        console.log("unsuccess");
      }
    });
}
// const logout = () => {
//   localStorage.removeItem("AccessToken");
//   window.location.replace("login.html");
// };
