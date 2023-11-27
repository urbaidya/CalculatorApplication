<!DOCTYPE html>
<html>
	<head>
		<title>Simple Calculator</title>
  		<script>
			let displayValue = '';
			function appendToDisplay(value) {
				displayValue += value;
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
				font-family: Arial, sans-serif;
				}
			input[type="text"] {
			    width: 100%;
			    padding: 10px;
			    margin-bottom: 15px;
			    border: 1px solid #ccc;
			    border-radius: 5px;
			    font-size: 16px;
			}
			input[type="text"] {
				width: 94%;
				margin-bottom: 10px;
				padding: 10px;
				outline: none;
			    border-color: #007bff; /* Changing border color on focus */
			    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5); /* Adding a subtle box shadow on focus */
				
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
				}
			</style>
	</head>
	<body>
		<h1 class="heading">CALCULATOR</h1>
		<div class="calculator">
		
			<input type="text" id="display" disabled>
			<div class="buttons">
				<button onclick="appendToDisplay('sin(')">sin</button>
				<button onclick="appendToDisplay('cos(')">cos</button>
				<button onclick="appendToDisplay('tan(')">tan</button>
				<button onclick="appendToDisplay('!')">n!</button>
				<button onclick="backButton()"><<=</button>
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
				<button onclick="appendToDisplay('3.14')">&#960</button>
				<button onclick="appendToDisplay('2.72')">e</button>
				<button onclick="appendToDisplay('0')">0</button>
				<button onclick="appendToDisplay('.')">.</button>
				<button onclick="calculate()">=</button>

			</div>
		</div>
	</body>
</html>
