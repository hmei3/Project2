$(document).ready(function(){
	$("#login").click(function(event){
		event.preventDefault();
		
		var email = $("#email").val();
		var password = $("#password").val();
		
		var emailPattern = /^(?=.{2,8}@)[a-zA-Z][a-zA-Z0-9]+@[a-z0-9]+(.[a-z]+){1,2}$/;;
		
		var passwordPattern = /^[a-zA-Z0-9]{5,10}$/;
		
		var emailTest = emailPattern.test(email);
		var passwordTest = passwordPattern.test(password);
		if(emailTest && passwordTest){
			$("#loginForm").submit();
		}
		else{
			$("#msgArea").empty();
			if(emailTest === false){
				$("#msgArea").append("<p style='color: red; text-align: center;'>Invalid email!</p>");
			}
			if(passwordTest === false){
				$("#msgArea").append("<p style='color: red; text-align: center;'>Invalid password!</p>");
			}
		}
	});
})