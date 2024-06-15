<?php
	$path='./';
	$page = 'Pizza Order';
	include $path.'assets/inc/header.php';
?>
	<div id="container">
		<h2>Order a Delicious Pizza!</h2>
	
		<form name="OrderForm" action="orderprocess.php"  onsubmit="return validateForm();" method="post">
			<p>Name:  <input type="text" name="customerName" <?php if(isset($_GET['name'])){echo 'value="'.$_GET['name'].'"';}?>  /></p>
			<p>ID:  <input type="text"  name="customerID" style="<?php if(isset($_GET['name'])){echo 'background-color:pink';} ?>" /></p>
			<p> Check the size of Pizza you would like to order:<br />
				<!-- Note the <label> tags below that allow the user to click on the text! -->
				<input type="radio" name ="pizzaSize" value = "P" id="personal"/><label for="personal">Personal<label><br/>
				<input type="radio" name ="pizzaSize" value = "S" id="small"/><label for="small">Small<label><br/>
				<input type="radio" name ="pizzaSize" value = "M"  id="medium" checked="true"/><label for="medium">Medium<label><br/>
				<input type="radio" name ="pizzaSize" value = "L"  id="large"/><label for="large">Large<label>
			</p>
			<!-- new code added for toppings -->
			<p> Select the number of toppings you want on your pizza:<br />
				<input type="radio" name ="toppingsCount" value = "0" id="none"/><label for="none">No Extra Toppings<label><br/>
				<input type="radio" name ="toppingsCount" value = "1" id="one"/><label for="one">One Topping<label><br/>
				<input type="radio" name ="toppingsCount" value = "2"  id="two"/><label for="two">Two Toppings<label><br/>
				<input type="radio" name ="toppingsCount" value = "3"  id="three"/><label for="three">Three Toppings<label>
			</p>
			<p>
				<input type="submit"  name="Submit"  value=" Send Form"  />
			</p>
		</form>
	</div> 
<?php
	include $path.'assets/inc/footer.php';
?>