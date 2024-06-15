// Cooper Gadd, ISTE-240, 2228
// 7/22/2023
// ISTE240 Exercise 5 – JavaScript Part 2

// a
function jsMove()
{
    document.getElementById('text').style.left = parseInt(document.getElementById('text').style.left) + 10 + 'px';
}

// b
function howmany()
{
    let inputTextCount = 0;

    for(let i=0; i < document.getElementById('regForm').getElementsByTagName('input').length; i++)
    {
        if(document.getElementById('regForm').getElementsByTagName('input')[i].type === 'text')
        {
            inputTextCount++;
        }
    }

    window.alert(
        "Total input elements in the form: " +
        document.getElementById('regForm').getElementsByTagName('input').length + 
        "\nTotal type 'text' in the form: " +
        inputTextCount
    );
}

// c
function colorchanger()
{
	document.getElementById('colorChanger').style.backgroundColor = document.getElementById('mySelect').value;
}

// d
function turnColor()
{
    document.getElementById('rb').style.color=document.getElementById('mySelect').value;
}
function turnBlack()
{
    document.getElementById('rb').style.color="black";
}

// e
function divide()
{
    while(document.getElementById('result').firstChild)
    {
        document.getElementById('result').removeChild(document.getElementById('result').firstChild);
    }

    document.getElementById('result').append(
        document.createTextNode(
            (parseInt(document.getElementById('firstoperand').value))
            /
            (parseInt(document.getElementById('secondoperand').value))
        )
    );
}
function multiply()
{
    while(document.getElementById('result').firstChild)
    {
        document.getElementById('result').removeChild(document.getElementById('result').firstChild);
    }

    document.getElementById('result').append(
        document.createTextNode(
            (parseInt(document.getElementById('firstoperand').value))
            *
            (parseInt(document.getElementById('secondoperand').value))
        )
    );
}