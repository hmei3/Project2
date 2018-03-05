$(document).ready(function(){
	$("#register").click(function(event){
		event.preventDefault();
		
		var email = $("#email").val();
		var password = $("#password").val();
		var name = $("#name").val();
		
		var emailPattern = /^(?=.{2,8}@)[a-zA-Z][a-zA-Z0-9]+@[a-z0-9]+(.[a-z]+){1,2}$/;;
		var passwordPattern = /^[a-zA-Z0-9]{5,10}$/;
		var namePattern = /^[A-Z][a-z]{1,}(\s[A-Z][a-z]{1,}){1,}$/;
		
		var emailTest = emailPattern.test(email);
		var passwordTest = passwordPattern.test(password);
		var nameTest = namePattern.test(name);
		console.log(passwordTest === false);
		if(nameTest && emailTest && passwordTest){
			$("#registerForm").submit();
		}
		else{
			$("#msgArea").empty();
			if(nameTest === false){
				$("#msgArea").append("<p style='color: red; text-align: center;'>For each word, please ensure that only first character is <strong>captial!</strong></p>");
			}
			if(emailTest === false){
				$("#msgArea").append("<p style='color: red; text-align: center;'>Invalid email!</p>");
			}
			if(passwordTest === false){
				$("#msgArea").append("<p style='color: red; text-align: center;'>Only letters and numbers are allowed. Length 5 - 10!</p>");
			}
		}
	});
})