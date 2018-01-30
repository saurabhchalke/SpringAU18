var inputData = document.getElementById("input");
inputData.addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode === 13) {
        document.getElementById("button").click();
    }
});

function valueChanged()
{
    if($('.coupon_question').is(":checked")) {
      $(".radioButtons").show();
      $(".displayTable").hide();
      $(".displayMessage").hide();
    }
         
        //$(".displayTable").hide();
    else {
      $(".radioButtons").hide();
      $(".displayTable").hide();
      $(".displayMessage").hide();
    }

}

//Function to find the output for the given requirement
function setOutput() {
  var input = document.getElementById('input').value;
  var output = document.getElementById("output");
  //Check if the input is empty
  if(input == "")
    return;
  //Checking if the input is not a number
  if($('.coupon_question').is(":checked")) {
    if(isNaN(input)) 
      processText(input);
    //If the input is the number
    else 
      output.innerHTML = "Invalid name";
      return;
  }
  else {
    if(isNaN(input)){
      $(".displayMessage").show();
      output.innerHTML = "Invalid number";
    }
    else
      processNumber(input);
  }
}

function processText(input) {
  var output = document.getElementById("output");
  var tableName = document.getElementById("output");
  var radios = document.getElementsByName("optradio");
  var ifRadioChecked = false;

  for (var i = 0, length = radios.length; i < length; i++)
  {
   if (radios[i].checked)
   {
    // do whatever you want with the checked radio
    gender = radios[i].value;
    ifRadioChecked = true;
    // only one radio can be logically checked, don't check the rest
    break;
   }
  }

  if(ifRadioChecked == false) {
    output.innerHTML = "Please select your gender";
    return;
  }

  document.getElementById("tableName").innerHTML = input;
  document.getElementById("tableGender").innerHTML = gender;
  if(gender = "male")
    document.getElementById("tableComment").innerHTML = "Hi there Mr. " + input;
  else if(gender == "female")
    document.getElementById("tableComment").innerHTML = "Hi there Ms. " + input;
  else
    document.getElementById("tableComment").innerHTML = "Hi there " + input;
  output.innerHTML = input;
  $(".displayTable").show();
  $(".displayMessage").show();

}

function processNumber(input) {
  $(".displayMessage").show();
  var output = document.getElementById("output");
  if (input >= 0 && input < 50)
      output.innerHTML = "Number is less than 50";
    else if (input >= 50 && input < 100)
      output.innerHTML = "Number is greater than 50 and less than 100";
    else if (input >= 100 && input < 1000)
      output.innerHTML = "Number is greater than 100";
    else
      output.innerHTML = "Number is invalid";
}