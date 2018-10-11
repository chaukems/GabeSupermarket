<%@page session="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <c:url var="home" value="/" scope="request" />
        <title>Gabe's Supermarket | Home</title>

        <link href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"> 
        <link href="<c:url value='/static/css/font-awesome.css'/>" rel="stylesheet"> 

        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>-->

        <script src="<c:url value='/static/js/jquery-2.1.3.js'/>"></script>
        <script src="<c:url value='/static/js/bootstrap.min.js'/>"></script>

        <!-- DataTables CSS -->
        <link href="<c:url value='/static/css/dataTables.bootstrap.css'/>" rel="stylesheet">
        <link href="<c:url value='/static/css/dataTables.responsive.css'/>" rel="stylesheet">


        <%@include file="init.jsp" %>
    </head>

    <div class="loading">Loading&#8230;
        <br/>
        <span id="loadingMessage"></span>
    </div>

    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Gabe's Supermarket &trade;</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="home">Product Management</a></li>
                <li class="active"><a href="reorder">Reorder point Products List</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">              
                <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </ul>
        </div>
    </nav>

    <div class="container" style="min-height: 500px"> 
        <div class="starter-template"> 
            <div id="tablesDiv">
                <h1>Reorder Point Products List (Reorder point <= 10 units)</h1> <br>             
                <table class="table table-bordered table-striped table-condensed cf" id="productsTable">
                    <thead class="cf" >
                        <tr>                   
                            <th>Barcode</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Measurement units</th>
                            <th>Measurement Value</th> 
                            <th>Image</th> 
                            <th>Barcode Image</th> 
                            <th></th> 
                        </tr>
                    </thead>
                    <tbody>                      
                    </tbody>
                </table>                 

                <h1>Selected products to be reordered</h1> <br>
                <button type="button" class="btn btn-info btnOrderProduct" ><i class="fa fa-plus"></i> Order</button>
                <table class="table table-bordered table-striped table-condensed cf" id="selectedProductsTable">
                    <thead class="cf" >
                        <tr>   
                            <th>Product Id</th>
                            <th>Barcode</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Measurement units</th>
                            <th>Measurement Value</th> 
                        </tr>
                    </thead>
                    <tbody>                      
                    </tbody>
                </table> 
            </div>
        </div>
    </div>

    <!-- DataTables JavaScript -->
    <script src="<c:url value='/static/js/jquery.dataTables.min.js'/>"></script>
    <script src="<c:url value='/static/js/dataTables.bootstrap.min.js'/>"></script>
    <script src="<c:url value='/static/js/dataTables.responsive.js'/>"></script>

    <script>
        $(document).ready(function () {

            showOverlay();

            $.ajax({
                url: "products/reorder",
                type: 'GET',
                success: function (result) {

                    var data = "";

                    $.each(result, function (key, obj) {
                        data += '<tr id="' + obj.productId + '">'
                                + '<td>' + obj.barcode + '</td>'
                                + '<td>' + obj.name + '</td>'
                                + '<td>' + obj.description + '</td>'
                                + '<td>' + obj.measurementUnits + '</td>'
                                + '<td>' + obj.measurementValue + '</td>'
                                + '<td><img width="120px" src="' + obj.image + '"/></td>'
                                + '<td><img width="120px" src="' + obj.barcodeImage + '"/></td>'
                                + '<td><input class="form-control" type="checkbox" name="reorderproducts" value = "' + obj.productId + '"/></td>'
                                // + '<td><button id = "' + obj.productId + '"  class="btn btn-info btn-sm" data-toggle="modal" data-target="#updateModal">Order</button></td>'
                                + '</tr>';
                    });

                    $('#productsTable tbody').html(data);

                    $('#productsTable').DataTable({
                        responsive: true
                    });

                    $('input[type="checkbox"]').change(function () {
                        var val = $(this).val();
                        if ($(this).is(':checked')) {

                            var $row = $(this).closest("tr");
                            var $tr = $('<tr />').attr('data-val', val);
                            var $td = $('<td>' + val + '</td>'
                                    + '<td>' + $.trim($row.find("td").eq(0).html()) + '</td>'
                                    + '<td>' + $.trim($row.find("td").eq(1).html()) + '</td>'
                                    + '<td>' + $.trim($row.find("td").eq(2).html()) + '</td>'
                                    + '<td><input class="form-control" type="text" value="' + $.trim($row.find("td").eq(3).html()) + '"/></td>'
                                    + '<td><input class="form-control" type="text" value="' + $.trim($row.find("td").eq(04).html()) + '"/></td>');

                            $tr.append($td);
                            $('#selectedProductsTable tbody').append($tr);
                        }
                        else {
                            $('#selectedProductsTable tbody').find("[data-val='" + val + "']").remove();
                        }
                    });

                    closeOverlay();
                },
                error: function (jqXHR, exception) {
                    closeOverlay();
                    var msg = '';
                    if (jqXHR.status === 0) {
                        msg = 'Not connect.\n Verify Network.';
                    } else if (jqXHR.status == 404) {
                        msg = 'Requested page not found. [404]';
                    } else if (jqXHR.status == 500) {
                        msg = 'Internal Server Error [500].';
                    } else if (exception === 'parsererror') {
                        msg = 'Requested JSON parse failed.';
                    } else if (exception === 'timeout') {
                        msg = 'Time out error.';
                    } else if (exception === 'abort') {
                        msg = 'Ajax request aborted.';
                    } else {
                        msg = 'Uncaught Error.\n' + jqXHR.responseText;
                    }
                    alert(msg);
                }
            });

            $('.btnOrderProduct').on('click', function (e) {
                showOverlay();
                //
                var data = [];

                $("#selectedProductsTable > tbody tr").each(function (i) {
                    var productId = $.trim($(this).find("td").eq(0).html());                    
                    var units = $.trim($(this).find("td").eq(4).find("input").val());
                    var value = $.trim($(this).find("td").eq(5).find("input").val());

                    data.push({productId: productId, totalPurchased: units, units: units, measurementValue: value});
                });

                $.ajax({
                    url: "products/purchase",
                    type: 'POST',
                    contentType: "application/json; charset=utf-8",
                    dataType: "JSON",
                    data: angular.toJson(data),
                    success: function (result) {
                        alert(result.message);
                        closeOverlay();
                    },
                    error: function (jqXHR, exception) {
                        closeOverlay();
                        var msg = '';
                        if (jqXHR.status === 0) {
                            msg = 'Not connect.\n Verify Network.';
                        } else if (jqXHR.status == 404) {
                            msg = 'Requested page not found. [404]';
                        } else if (jqXHR.status == 500) {
                            msg = 'Internal Server Error [500].';
                        } else if (exception === 'parsererror') {
                            msg = 'Requested JSON parse failed.';
                        } else if (exception === 'timeout') {
                            msg = 'Time out error.';
                        } else if (exception === 'abort') {
                            msg = 'Ajax request aborted.';
                        } else {
                            msg = 'Uncaught Error.\n' + jqXHR.responseText;
                        }
                        alert(msg);
                    }
                });
            });
        });
    </script>

</body>
</html>