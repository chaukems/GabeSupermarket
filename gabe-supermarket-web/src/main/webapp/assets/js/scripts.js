jQuery(document).ready(function () {
  
    /*
     Fullscreen background
     */
    $.backstretch("assets/img/backgrounds/1.jpg");

    $('#password').keypress(function (e) {
        if (e.which === 13) {
            login();
            return false;    //<---- Add this line
        }
    });

    $('.loginBtn').click(function () {
        if ($("#username").val() == "" || $("#password").val() == "") {
            // $("#errorBox").html();
            //$(".error").show();

            showError('Please enter username and password.');
        } else {
            closeError();
            login();
        }
    });


    function login() {

        $.ajax({
            url: "login",
            type: "post",
            data: {username: $("#username").val(), password: $("#password").val()},
            success: function (data) {
                console.log(data.authenticated);
               if(typeof data.authenticated !== "undefined"){
                   window.location= "home";
               }else{
                   showError("Wrong username and password.");
               }
            }, error: function (jqXHR, textStatus, errorThrown) {
                var options = angular.toJson(eval("(" + jqXHR.responseText + ")"));
                var json = JSON.parse(options);

                var errorT = "";
                if (errorThrown.length == "") {
                    errorT = +", " + errorThrown;
                }

                errorMessage = json.message + errorT + " , Reason: " + json.error.message;
                showError(errorMessage);

            }
        });

        /*$.ajax({
         url: "login",
         type: "POST",
         async: false,
         data: {username: $("#username").val(), password: $("#password").val()},
         success: function (data, textStatus, jqXHR) {
         
         window.location = "home";
         
         }, error: function (jqXHR, textStatus, errorThrown) {
         var options = angular.toJson(eval("(" + jqXHR.responseText + ")"));
         var json = JSON.parse(options);
         
         var errorT = "";
         if (errorThrown.length = "") {
         errorT = +", " + errorThrown;
         }
         
         errorMessage = json.message + errorT + " , Reason: " + json.error.message;
         
         },
         complete: function () {
         showError(errorMessage);
         }
         });*/

    }

    function showError(message) {
        $("#message").html(message);
        $(".error").fadeIn(500);
    }

    function closeError() {
        $(".error").fadeOut(500);
    }

});