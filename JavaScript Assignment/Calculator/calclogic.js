var count = 0;

function insertNum(x) {
	document.getElementById('inputstring').value += x;
}

function clearInput() {
	document.getElementById('inputstring').value = "";
	document.getElementById('tempoutput').innerHTML = "";
}

function insertOp(x) {
	count++;
	document.getElementById('tempoutput').value = count;
	if(count == 2) {
		evalTempOutput();
		count--;
	}
	document.getElementById('inputstring').value += x;
}

function evalTempOutput() {
	try {
		result = eval(document.getElementById('inputstring').value);
	}
	catch(e) {
		document.getElementById('inputstring').value = document.getElementById('inputstring').value.slice(0, -1);
		alert(e);
	}
	document.getElementById('tempoutput').innerHTML = result;
}

function evalInput() {
	try {
		result = eval(document.getElementById('inputstring').value);
	}
	catch(e) {
		document.getElementById('inputstring').value = document.getElementById('inputstring').value.slice(0, -1);
		alert(e);
	}
	document.getElementById('inputstring').value = result;
	document.getElementById('tempoutput').innerHTML = "";
}
