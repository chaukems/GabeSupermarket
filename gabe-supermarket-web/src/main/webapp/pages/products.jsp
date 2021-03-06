<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Gabe Supermarket | Products</title>

        <link rel="apple-touch-icon" href="apple-icon.png">
        <link rel="shortcut icon" href="favicon.ico">

        <link rel="stylesheet" href="<c:url value='/assets/css/normalize.css'/> ">
        <link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/> "> 
        <link rel="stylesheet" href="<c:url value='/assets/css/font-awesome.min.css'/> ">
        <link rel="stylesheet" href="<c:url value='/assets/css/themify-icons.css'/> ">
        <link rel="stylesheet" href="<c:url value='/assets/css/flag-icon.min.css'/> ">
        <link rel="stylesheet" href="<c:url value='/assets/css/cs-skin-elastic.css'/> ">
        <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
        <link rel="stylesheet" href="<c:url value='/assets/scss/style.css'/> ">

        <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
        <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
        <link rel="stylesheet" href="assets/scss/style.css">

        <link href="<c:url value='/assets/css/lib/vector-map/jqvmap.min.css'/> " rel="stylesheet">
        <link href='<c:url value='/assets/css/fonts-google.css'/>' rel='stylesheet' type='text/css'>
    </head>
    <body>

        <!-- Left Panel -->

        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">

                <div class="navbar-header">
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand" href="./">Gabe Supermarket</a>
                    <a class="navbar-brand hidden" href="./">G</a>
                </div>

                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="home"> <i class="menu-icon fa fa-dashboard"></i>Dashboard </a>
                        </li>
                        <li>
                            <a href="billing"> <i class="menu-icon fa fa-money"></i>Billing</a>
                        </li>
                        <li class="active">
                            <a href="products"> <i class="menu-icon fa fa-address-book-o"></i>Products</a>
                        </li>                  
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>
        </aside><!-- /#left-panel -->

        <!-- Left Panel -->

        <!-- Right Panel -->

        <div id="right-panel" class="right-panel" ng-app = "hmsApp" ng-controller="ProductsController as $ctrl">

            <!-- Header-->
            <header id="header" class="header">

                <div class="header-menu">

                    <div class="col-sm-7">
                        <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    </div>

                    <div class="col-sm-5">
                        <div class="user-area dropdown float-right">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <img class="user-avatar rounded-circle" src="assets/images/admin.jpg" alt="User Avatar">
                            </a>

                            <div class="user-menu dropdown-menu">
                                <a class="nav-link" href="#"><i class="fa fa- user"></i>My Profile</a>
                                <a class="nav-link" href="#"><i class="fa fa -cog"></i>Settings</a>
                                <a class="nav-link" href="#"><i class="fa fa-power -off"></i>Logout</a>
                            </div>
                        </div>

                        <div class="float-right" style="margin-top:8px; margin-right:10px">
                            <span> Welcome Admin </span>                      
                        </div>
                    </div>
                </div>

            </header><!-- /header -->
            <!-- Header-->

            <div class="breadcrumbs">
                <div class="col-sm-4">
                    <div class="page-header float-left">
                        <div class="page-title">
                            <h1>Products Management</h1>
                        </div>
                    </div>
                </div>               
            </div>

            <div class="content mt-3">
                <div class="animated fadeIn">
                    <div class="row">

                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <strong class="card-title">All Products</strong>
                                </div>
                                <div class="card-body">
                                    <table id="bootstrap-data-table" class="table table-striped table-bordered">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Description</th>
                                                <th>Bar Code</th>                                              
                                                <th>Units</th>
                                                <th>Amount</th>
                                                <th>Image</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr ng-repeat="product in $ctrl.products track by $index">
                                                <td></td>
                                                <td>{{product.productName}}</td>
                                                <td>{{product.description}}</td>
                                                <td>{{product.barCode}}</td>
                                                <td>{{product.units}}</td>  
                                                <td>{{product.amount}}</td>  
                                                <td>{{product.image}}</td> 
                                                <td width="10%">                                                    
                                                    <button type="button" class="btn btn-danger btn-sm" ng-click="$ctrl.addViewProduct(product)" data-toggle="modal" data-target="#largeModal">
                                                        <i class="fa fa-ban"></i> View/Edit
                                                    </button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- .animated -->

                <!-- start modal -->
                <div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="largeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="largeModalLabel">Product details</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="col-lg-12">
                                    <div class="card">
                                        <div class="card-body">
                                            <!-- Credit Card -->
                                            <div id="pay-invoice">
                                                <div class="card-body">   
                                                    <div class="col-lg-6">
                                                        <div class="card">
                                                            <div class="card-header">
                                                                <strong class="card-title mb-3">Product Image</strong>
                                                            </div>
                                                            <div class="card-body">
                                                                <div class="mx-auto d-block">
                                                                    <img class="rounded-circle mx-auto d-block" src="{{$ctrl.productDetails.image}}" alt="Card image cap">
                                                                    <!--<h5 class="text-sm-center mt-2 mb-1">{{$ctrl.productDetails.fullName}} {{$ctrl.productDetails.lastName}}</h5>
                                                                <div class="location text-sm-center"><i class="fa fa-map-marker"></i>
                                                                      {{$ctrl.productDetails.address.addressLine1}},{{$ctrl.productDetails.address.addressLine2}},
                                                                      {{$ctrl.productDetails.address.suburb}},{{$ctrl.memberDetails.address.postalCode}},</div>>-->
                                                                </div>
                                                                <hr>
                                                            </div
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-lg-6">
                                                    <form action="" method="post" novalidate="novalidate">                                                       
                                                        <div class="form-group">
                                                            <label for="cc-payment" class="control-label mb-1">Product Name</label>
                                                            <input ng-model="$ctrl.productDetails.productName" type="text" class="form-control" aria-required="true" aria-invalid="false">
                                                        </div>
                                                        <div class="form-group has-success">
                                                            <label for="cc-name" class="control-label mb-1">Description</label>
                                                            <input ng-model="$ctrl.productDetails.description" type="text" class="form-control" aria-required="true" aria-invalid="false">
                                                            <span class="help-block field-validation-valid" data-valmsg-for="cc-name" data-valmsg-replace="true"></span>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="cc-number" class="control-label mb-1">Bar Code</label>
                                                            <input  ng-model="$ctrl.productDetails.barCode" type="tel" class="form-control">
                                                            <span class="help-block" data-valmsg-for="cc-number" data-valmsg-replace="true"></span>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-6">
                                                                <div class="form-group">
                                                                    <label for="cc-exp" class="control-label mb-1">Units</label>
                                                                    <input  ng-model="$ctrl.productDetails.units" type="text" class="form-control" autocomplete="off">
                                                                    <span class="help-block" data-valmsg-for="cc-exp" data-valmsg-replace="true"></span>
                                                                </div>
                                                            </div>
                                                            <div class="col-6">
                                                                <label for="x_card_code" class="control-label mb-1">Amount</label>
                                                                <div class="input-group">
                                                                    <input ng-model="$ctrl.productDetails.amount" type="number" class="form-control cc-cvc" value="" autocomplete="off">
                                                                </div>
                                                            </div>
                                                        </div>                                                       
                                                    </form>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div> <!-- .member details -->
                            </div><!--/.col-->

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" ng-click="$ctrl.modalOk()">Save</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- end modal -->
        </div><!-- .content -->
        <!-- .content -->
    </div><!-- /#right-panel -->

    <!-- Right Panel -->
    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>

    <script src="assets/js/lib/data-table/datatables.min.js"></script>
    <script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
    <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
    <script src="assets/js/lib/data-table/jszip.min.js"></script>
    <script src="assets/js/lib/data-table/pdfmake.min.js"></script>
    <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
    <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
    <script src="assets/js/lib/data-table/datatables-init.js"></script>

    <!-- Angular -->
    <script src="<c:url value='/assets/js/angular.js'/>"></script>
    <script src="<c:url value='/assets/js/angular-animate.min.js'/>"></script>
    <script src="<c:url value='/assets/js/ui-bootstrap-tpls-2.5.0.min.js'/>"></script>

    <script src="<c:url value='/assets/js/app.js'/>"></script>
    <script src="<c:url value='/assets/js/controller/products-controller.js'/>"></script>

    <script type="text/javascript">
                                $(document).ready(function () {
                                    $('#bootstrap-data-table-export').DataTable();
                                });
    </script>

</body>
</html>
