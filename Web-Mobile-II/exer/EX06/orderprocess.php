<?php
	$path='./';
	$page = 'Order Reciept';
	include $path.'assets/inc/header.php';
?>
	<h2>Your Pizza Order</h2>
<?php
    $cName = $_POST['customerName'];
    $cID = $_POST['customerID'];
    $pSize = $_POST['pizzaSize'];
    $tCount = $_POST['toppingsCount'];

    if (empty($cID)){
        header('Location: orderform.php?name='.$cName);
    }else{
        if (!is_numeric($cID)){
            echo '<p>Customer ID '.$cID .' is not valid ID becuase it contains a non-numeric character.</p>';
            echo '<p><form action="orderform.php"><input type="hidden" name="name" value="'.$cName.'"/><input type="submit" value="ok"/></form></p>';
        }else {
            switch($pSize){
            case 'P':
                $pizzaCost = 7.99;
                $pizzaType = "Personal";
                break;
            case 'S':
                $pizzaCost = 10.99;
                $pizzaType = "Small";
                break;
            case 'M':
                $pizzaCost = 13.99;
                $pizzaType = "Medium";
                break;
            case 'L':
                $pizzaCost = 16.99;
                $pizzaType = "Large";
                break;
            default:
                $pizzaCost = 13.99;
                $pizzaType = "Medium";
            }
            // new code added for toppings amount
            switch($tCount){
                case '0':
                    $toppingsCost = 0;
                    break;
                case '1':
                    $toppingsCost = 2.00;
                    break;
                case '2':
                    $toppingsCost = 3.00;
                    break;
                case '3':
                    $toppingsCost = 3.75;
                    break;
                }

            // new code added for math
            $totalPizzaCost = $pizzaCost + $toppingsCost;
            $taxAmount = $totalPizzaCost * 0.08;
            $totalCost = $totalPizzaCost + $taxAmount;

            $fmt = numfmt_create('en_US', NumberFormatter::CURRENCY );
            ?>
                <div id='receipt'>
                    <br/>Your Delicious Pizza Order!!
                    <br/>
                    <br/>Pizza Price:
            <?php
                echo numfmt_format_currency($fmt, $pizzaCost, "USD");
                // new code added for displaying toppings cost
                echo "<br>Topping Price: ".numfmt_format_currency($fmt, $toppingsCost, "USD");
                echo "<br>Tax Amount: ".numfmt_format_currency($fmt, $taxAmount, "USD");
                echo "<br>Total Cost of your order is: ".numfmt_format_currency($fmt, $totalCost, "USD");
                echo "<br><br>Thank you for your order.";
                echo ($cName == '')? '.': ", $cName.";
                echo"</div>";
        }
    }

?>
<?php
	include $path.'assets/inc/footer.php';
?>