$(document).ready(function(){
	
	$(".update_item").hide();
	
	$(".item-amount").change(function(event){
		$(event.target).closest("div").find(".update_item").show();
	});
	$(document).on("click",".rm_item",function(event){
		event.preventDefault();
		var link = $(this).attr("href");
		var remove_anchor = $(this);
		$.ajax({
			url:link,
			type:"DELETE"
		})
		.done(function(responseData){
			var itemsPrice = remove_anchor.parent().children(".items-price-area").children(".items-price").text().trim();			
			itemsPrice = itemsPrice.substring(1);
			itemsPrice = parseFloat(itemsPrice.split(",").join(""));
			console.log(itemsPrice);
			
			var totalPrice = $("#total-price").text().trim();
			totalPrice = totalPrice.substring(1);
			totalPrice = parseFloat(totalPrice.split(",").join(""));

			remove_anchor.parent().remove();
			$('#cartSize').text(parseInt($('#cartSize').text()) - parseInt(responseData));
			if(totalPrice - itemsPrice === 0){
				$('#checkoutArea').remove();
			}
			else{
				let newTotalPrice = totalPrice - itemsPrice;
				
				$("#total-price").text(newTotalPrice.toLocaleString('en-US', { style: 'currency', currency: 'USD' }));
			}
			alert("Item removed successfully");
		})
		.fail(function(){
			alert("Something went wrong, please check and try again!");
		});
	});

	$(document).on("click",".update_item",function(event){
		event.preventDefault();
		var link = $(this).attr("href");
		var update_anchor = $(this);

		var updatedAmount = update_anchor.parent().find(".item-amount").val();
		var amount = JSON.stringify({"quantity": updatedAmount});
		alert(amount);
		$.ajax({
			url:link,
			method:"PUT",
			data:amount,
			dataType:'json'
		})
		.done(function(responseData){
			var newCartSize = 0;
			$(".item-amount").each(function(){
				newCartSize += parseInt($(this).val());
			});
			$("#cartSize").text(newCartSize);
			
			var totalPrice = $("#total-price").text().trim();
			totalPrice = totalPrice.substring(1);
			totalPrice = totalPrice.split(",").join("");
			totalPrice = parseFloat(totalPrice);
			
			var prePrice = update_anchor.parent().find(".items-price-area").find(".items-price").text().trim();
			prePrice = prePrice.substring(1);
			prePrice = prePrice.split(",").join("");
			console.log("raw: " + prePrice);
			prePrice = parseFloat(prePrice);
			
			console.log("totalPrice: " + totalPrice);
			console.log("prePrice: " + prePrice);
			console.log("responseData: " + responseData);
			
			update_anchor.parent()
			.find(".items-price-area")
			.find(".items-price")
			.text(parseFloat(responseData).toLocaleString('en-US', { style: 'currency', currency: 'USD' }));
			
			var floatResponseData = parseFloat(responseData);
			var result = totalPrice - prePrice;
			result = result + floatResponseData;
			$("#total-price").text(result.toLocaleString('en-US', { style: 'currency', currency: 'USD' }));
			
			update_anchor.parent().find(".update_item").hide();
			alert("Item quantity is upadted successfully!");
		})
		.fail(function(){
			alert("Quantity updation failed, please check and try again!");
		});
	});
	
	$("#checkout").click(function(event){
		event.preventDefault();
		var link = $(this).attr("href");
		$.ajax({
			url:link,
			method:"DELETE"
		})
		.done(function(){
			$(".cart-body").empty();
			var parent = $(".alertArea");
			$("#cartSize").text(0);
			alert("Order is placed successfully");
		})
		.fail(function(){
			alert("Failed to place the order, please check and try again!");
		});
	});
});