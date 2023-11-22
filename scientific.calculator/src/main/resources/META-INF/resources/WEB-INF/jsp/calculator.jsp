<!DOCTYPE html>
<html>
<head>
  <title>Simple Calculator</title>
<!--   <link rel="stylesheet" type="css" href="../../../../static/css/styles.css"> -->
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
  	        body: JSON.stringify({ expression: expression }),
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
    </script>
    <style>
    .calculator {
  	  width: 335px;
  	  margin: 50px auto;
  	  padding: 10px;
  	  border: 1px solid #ccc;
  	  border-radius: 5px;
	}

	input[type="text"] {
	  width: 92%;
	  margin-bottom: 10px;
	  padding: 10px;
	}
	
	.buttons button {
	  width: 70px;
	  height: 50px;
	  margin: 5px;
	  font-size: 18px;
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
			<button onclick="appendToDisplay('1')">1</button>
			<button onclick="appendToDisplay('2')">2</button>
			<button onclick="appendToDisplay('3')">3</button>
			<button onclick="appendToDisplay('+')">+</button>
			<button onclick="appendToDisplay('4')">4</button>
			<button onclick="appendToDisplay('5')">5</button>
			<button onclick="appendToDisplay('6')">6</button>
			<button onclick="appendToDisplay('-')">-</button>
			<button onclick="appendToDisplay('7')">7</button>
			<button onclick="appendToDisplay('8')">8</button>
			<button onclick="appendToDisplay('9')">9</button>
			<button onclick="appendToDisplay('*')">*</button>
			<button onclick="appendToDisplay('.')">.</button>   
			<button onclick="appendToDisplay('0')">0</button>
			<button onclick="clearDisplay()">C</button>
			<button onclick="appendToDisplay('/')">/</button>
			<button onclick="appendToDisplay('^')">^</button>
			<button onclick="appendToDisplay('^0.5')">&#8730</button>
			<button onclick="calculate()">=</button>
		</div>
	</div>
</body>
</html>
