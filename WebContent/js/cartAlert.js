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
			var itemsPrice = remove_anchor.parent().children(".items-price-area").children(".items-price").text();
			
			var itemsPrice = parseFloat(itemsPrice.split(",").join(""));
			var totalPrice = parseFloat($("#total-price").text().split(",").join(""));
			console.log(itemsPrice);
			console.log(totalPrice);
			remove_anchor.parent().remove();
			$('#cartSize').text(parseInt($('#cartSize').text()) - parseInt(responseData));
			if(totalPrice - itemsPrice === 0){
				$('#checkoutArea').remove();
			}
			else{
				$("#total-price").text((totalPrice - itemsPrice).toFixed(2));
			}
			var parent = $(".alertArea");
			parent.children().fadeOut(500, function(){
				parent.empty();
				parent.append(`
						<div class='alert alert-dismissible alert-success'>
	  						<button type='button' class='close' data-dismiss='alert'>&times;</button>
	  						One item was successfully removed form your cart!
						</div>
	  						`);
			});
		})
		.fail(function(){
			var parent = $(".alertArea");
			parent.children().fadeOut(500, function(){
				parent.empty();
				parent.append(`
						<div class='alert alert-dismissible alert-danger'>
	  						<button type='button' class='close' data-dismiss='alert'>&times;</button>
	  						Something went wrong, please try again!
						</div>
	  						`);
			});
		});
	});

	$(document).on("click",".update_item",function(event){
		event.preventDefault();
		console.log("update anchor clicked");
		var link = $(this).attr("href");
		console.log(link);
		var update_anchor = $(this);

		var updatedAmount = update_anchor.parent().find(".item-amount").val();
		console.log("updatedAmount " + updatedAmount);
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
			
			var totalPrice = parseFloat($("#total-price").text());
			var prePrice = parseFloat(update_anchor.parent().find(".items-price-area").find(".items-price").text().split(",").join(""));
			console.log("totalPrice: " + totalPrice);
			console.log("prePrice: " + prePrice);
			console.log("responseData: " + responseData);
			update_anchor.parent().find(".items-price-area").find(".items-price").text(parseFloat(responseData).toFixed(2));
			var floatResponseData = parseFloat(responseData);
			var result = totalPrice - prePrice;
			result = result + floatResponseData;
			$("#total-price").text(result.toFixed(2));
			update_anchor.parent().find(".update_item").hide();
			var parent = $(".alertArea");
			parent.children().fadeOut(500, function(){
				parent.empty();
				parent.append(`
						<div class='alert alert-dismissible alert-success'>
	  						<button type='button' class='close' data-dismiss='alert'>&times;</button>
	  						One item was successfully updated from your cart!
						</div>
	  						`);
			});
		})
		.fail(function(){
			var parent = $(".alertArea");
			parent.children().fadeOut(500, function(){
				parent.empty();
				parent.append(`
						<div class='alert alert-dismissible alert-danger'>
	  						<button type='button' class='close' data-dismiss='alert'>&times;</button>
	  						Something went wrong, please try again!
						</div>
	  						`);
			});

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
			parent.children().fadeOut(500, function(){
				parent.empty();
				parent.append(`
						<div class='alert alert-dismissible alert-success'>
	  						<button type='button' class='close' data-dismiss='alert'>&times;</button>
	  						Order is placed successfully!
						</div>
	  						`);
			});
		})
		.fail(function(){
			var parent = $(".alertArea");
			parent.children().fadeOut(500, function(){
				parent.empty();
				parent.append(`
						<div class='alert alert-dismissible alert-danger'>
	  						<button type='button' class='close' data-dismiss='alert'>&times;</button>
	  						Checkout failed! Please check the cart and try again!
						</div>
	  						`);
			});

		});
	});
});