// Cooper Gadd, ISTE-240, 2228
// 7/14/2023
// ISTE240 Exercise 4 – JavaScript Part 1

// a
function jsStyle()
{
    document.getElementById('text').style.color="darkblue";
    document.getElementById('text').style.fontSize="20px";
}

// b
function getFormValues()
{
    window.alert(
        "First name: " +
        document.getElementById('fname').value +
        " Last name: " +
        document.getElementById('lname').value
    );
}

// c
function getOptions()
{
	window.alert(
		document.getElementById('mySelect').length
	);
}

// d
function turnRed()
{
    document.getElementById('rb').style.color="red";
}
function turnBlack()
{
    document.getElementById('rb').style.color="black";
}

// e
function divide()
{
    document.getElementById('result').innerHTML = (
        (parseInt(document.getElementById('firstoperand').value))
        /
        (parseInt(document.getElementById('secondoperand').value))
    );
}
function multiply()
{
    document.getElementById('result').innerHTML = (
        (parseInt(document.getElementById('firstoperand').value))
        *
        (parseInt(document.getElementById('secondoperand').value))
    );
}