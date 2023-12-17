<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
		body {
		    margin: 0;
		    font-family: Arial, sans-serif;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    height: 100vh;
		    background-color: #f5f5f5;
		}
		.registration-container {
		    width: 320px;
		    padding: 20px;
		    background-color: #fff;
		    border-radius: 8px;
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}
		.registration-form {
		    display: flex;
		    flex-direction: column;
		}
		
		h2 {
		    text-align: center;
		    margin-bottom: 20px;
		}
		
		.input-group {
		    margin-bottom: 15px;
		}
		
		label {
		    display: block;
		    margin-bottom: 5px;
		    color: #333;
		}

		input[type="text"],
		input[type="password"] {
		    width: 94%;
		    padding: 8px;
		    border-radius: 5px;
		    border: 1px solid #ccc;
		}

		button {
		    padding: 10px;
		    border: none;
		    border-radius: 5px;
		    background-color: #007bff;
		    color: #fff;
		    cursor: pointer;
		    transition: background-color 0.3s ease;
		}
		
		button:hover {
		    background-color: #0056b3;
		}
		
		pre{
			color: red;
		}
    </style>
</head>

<body>
    <div class="registration-container">
    	
        <form class="registration-form" method="post">
            <h2>New User Registration</h2>
            <div class="input-group">
                <label for="fullname">Full Name</label>
                <input type="text" id="fullname" name="fullname" required>
            </div>
            <div class="input-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Register</button>
        </form>
        <br>
        <a href="./login">back to Login</a>
        <pre class="pre">
    		${message}
    	</pre>
    </div>
   
</body>

</html>
