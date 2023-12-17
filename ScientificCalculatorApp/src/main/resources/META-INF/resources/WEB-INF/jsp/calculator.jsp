<!DOCTYPE html>
<html>
	<head>
		<title>Simple Calculator</title>
  		<script>
			let displayValue = '';
			function appendToDisplay(value) {
				if (document.getElementById('display').value == 0){
					displayValue = value;
				}
				else{
					displayValue += value;
				}
				document.getElementById('display').value = displayValue;
			}
			
			function calculate() {
				const expression = document.getElementById('display').value;
				fetch('/calculate', {
					method: 'POST',
					headers: {
						'Content-Type': 'application/json',
						},
					body: JSON.stringify({ expression: expression })
					})
				.then(response => response.json()) // Parse response as JSON
				.then(data => {
					const result = data.result; // Extract the 'result' property from the response
					document.getElementById('display').value = result; // Update the display with the result
					displayValue = result;
					})
				.catch(error => {
					console.error('Error:', error);
					});
			}
			
			function clearDisplay() {
				displayValue = '';
				document.getElementById('display').value = displayValue;
			}
  	
  			function backButton() {
  				displayValue = displayValue.slice(0,-1);
  				document.getElementById('display').value = displayValue;
  			}
  	
		</script>
    	<style>
			.calculator {
			width: 418px;
			margin: 50px auto;
			padding: 10px;
			border: 1px solid #ccc;
			border-radius: 5px;
			font-family: Broadway;
			background-color: #949494;
			}
			
			input[type="text"] {
			width: 100%;
			padding: 10px;
			margin-bottom: 15px;
			border: 1px solid #ccc;
			border-radius: 5px;
			font-size: 20px;
			width: 94%;
			margin-bottom: 10px;
			padding: 10px;
			outline: none;
			border-color: #007bff; /* Changing border color on focus */
			box-shadow: 0 0 5px rgba(0, 123, 255, 0.5); /* Adding a subtle box shadow on focus */
			font-family: Arial Rounded MT Bold;
			background-color: #ffff9f;
			}
						
			.buttons button {
			width: 70px;
			height: 50px;
			margin: 5px;
			font-size: 18px;
			}
							
			button {
			padding: 10px;
			border: none;
			border-radius: 5px;
			background-color: #D3D3D3;
			color: #000;
			cursor: pointer;
			transition: background-color 0.3s ease;
			}
							
			button:hover {
			background-color: #0056b3;
			color: #fff;
			}
				
			.heading{
			text-align:center;
			font-family: Arial Rounded MT Bold;
			font-size: 45px;
			}
					
			.logout-button{
			text-align:right;
			}
						
			.calculator-container {
			width: 500px;
			padding: 20px;
			background-color: #fff;
			border-radius: 8px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
			}
						
			body {
			margin: 0;
			font-family: Arial, sans-serif;
			display: flex;
			justify-content: center;
			align-items: center;
			height: 100vh;
			background-color: #f5f5f5;
			}
		</style>
	</head>
	<body>
		<div class="calculator-container">
			<h1 class="heading">CALCULATOR</h1>
			<h3>Welcome ${name}
				<p class="logout-button"><a href="./login">LOGOUT</a></p>
			</h3>
			<div class="calculator">
				<input type="text" id="display" disabled>
				<div class="buttons">
					<button onclick="appendToDisplay('sin(')">sin</button>
					<button onclick="appendToDisplay('cos(')">cos</button>
					<button onclick="appendToDisplay('tan(')">tan</button>
					<button onclick="appendToDisplay('!')">n!</button>
					<button onclick="backButton()">&#171</button>
					<button onclick="appendToDisplay('^')">^</button>
					<button onclick="appendToDisplay('(')">(</button>
					<button onclick="appendToDisplay(')')">)</button>
					<button onclick="clearDisplay()">C</button>
					<button onclick="appendToDisplay('/')">/</button>			
					<button onclick="appendToDisplay('sqrt(')">&#8730</button>
					<button onclick="appendToDisplay('7')">7</button>
					<button onclick="appendToDisplay('8')">8</button>
					<button onclick="appendToDisplay('9')">9</button>
					<button onclick="appendToDisplay('*')">*</button>
					<button onclick="appendToDisplay('log(')">log</button>
					<button onclick="appendToDisplay('4')">4</button>
					<button onclick="appendToDisplay('5')">5</button>
					<button onclick="appendToDisplay('6')">6</button>
					<button onclick="appendToDisplay('-')">-</button>
					<button onclick="appendToDisplay('ln(')">ln</button>
					<button onclick="appendToDisplay('1')">1</button>
					<button onclick="appendToDisplay('2')">2</button>
					<button onclick="appendToDisplay('3')">3</button>
					<button onclick="appendToDisplay('+')">+</button>
					<button onclick="appendToDisplay('pi')">&#960</button>
					<button onclick="appendToDisplay('e')">e</button>
					<button onclick="appendToDisplay('0')">0</button>
					<button onclick="appendToDisplay('.')">.</button>
					<button onclick="calculate()">=</button>
				</div>
			</div>
		</div>
	</body>
</html>
