$(document).ready(function() 
		{  
	if ($("#alertSuccess").text().trim() == "")  
    {   
		$("#alertSuccess").hide();  
     }  
	     $("#alertError").hide(); 
	  
});



$(document).on("click", "#btnSave", function(event) 
{ 
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 
 
 // Form validation-------------------
var status = validateUserForm(); 
	if (status != true) 
		 { 
		 $("#alertError").text(status); 
		 $("#alertError").show(); 
		 return; 
		 } 
 
 // If valid------------------------
var type = ($("#hidUserIDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
	 url : "UserAPI", 
	 type : type, 
	 data : $("#formUser").serialize(), 
	 dataType : "text", 
	 complete : function(response, status) 
	 { 
	 	onUserSaveComplete(response.responseText, status); 
	 } 
	 }); 
});

function onUserSaveComplete(response, status) 
{ 
			if (status == "success") 
		 { 
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") 
		 { 
		 $("#alertSuccess").text("Successfully saved."); 
		 $("#alertSuccess").show(); 
		 
		 $("#divUserGrid").html(resultSet.data); 
		 } else if (resultSet.status.trim() == "error") 
		 { 
		 $("#alertError").text(resultSet.data); 
		 $("#alertError").show(); 
		 } 
		 } else if (status == "error") 
		 { 
		 $("#alertError").text("Error while saving."); 
		 $("#alertError").show(); 
		 } else
		 { 
		 $("#alertError").text("Unknown error while saving.."); 
		 $("#alertError").show(); 
		 }
		 
		 $("#hidUserIDSave").val(""); 
		 $("#formUser")[0].reset(); 

}


$(document).on("click", ".btnRemove", function(event) 
{ 
	 $.ajax( 
	 { 
	 url : "UserAPI", 
	 type : "DELETE", 
	 data : "uID=" + $(this).data("uid"),
	 dataType : "text", 
	 complete : function(response, status) 
	 { 
	 	onUserDeleteComplete(response.responseText, status); 
	 } 
	 }); 
});

function onUserDeleteComplete(response, status) 
{ 
	if (status == "success") 
	 { 
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") 
		 { 
		 $("#alertSuccess").text("Successfully deleted."); 
		 $("#alertSuccess").show(); 
	 
		 $("#divUserGrid").html(resultSet.data); 
		 } else if (resultSet.status.trim() == "error") 
			 { 
			 $("#alertError").text(resultSet.data); 
			 $("#alertError").show(); 
			 } 
	 
		 } else if (status == "error") 
		 { 
		 $("#alertError").text("Error while deleting."); 
		 $("#alertError").show(); 
		 } else
			 { 
			 $("#alertError").text("Unknown error while deleting.."); 
			 $("#alertError").show(); 
			 } 
}


$(document).on("click", ".btnUpdate", function(event) 
{ 

	$("#hidUserIDSave").val($(this).closest("tr").find('#hidUserIDUpdate').val());     
	 $("#name").val($(this).closest("tr").find('td:eq(0)').text()); 
	 $("#uAddress").val($(this).closest("tr").find('td:eq(1)').text()); 
	 $("#uEmail").val($(this).closest("tr").find('td:eq(2)').text()); 
	 $("#nic").val($(this).closest("tr").find('td:eq(3)').text()); 
	 $("#pno").val($(this).closest("tr").find('td:eq(4)').text()); 
});

  // CLIENT-MODEL================================================================
function validateUserForm() 
{ 
	// name
	if ($("#name").val().trim() == "") 
	 { 
	 	return "Insert name."; 
	 } 
	 
	// uAddress
	if ($("#uAddress").val().trim() == "") 
	 { 
		 return "Insert Address."; 
	 } 
	 
	 // uEmail
	if ($("#uEmail").val().trim() == "") 
	 { 
	 	return "Insert Email."; 
	 } 
	 
	 // nic
	if ($("#nic").val().trim() == "") 
	 { 
	 	return "Insert nic."; 
	 } 
	 
	 // pno
	if ($("#pno").val().trim() == "") 
	 { 
	 	return "Insert pnone Number."; 
	 } 


	return true; 
}





