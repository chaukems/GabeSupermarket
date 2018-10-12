hmsApp.controller('ProductsController', function ($scope, $log, $http, $compile, $timeout, $uibModal) {

    var $ctrl = this;
    //  params: {fromDate: fromDate, endDate: endDate},

    $http({
        method: 'GET',
        transformRequest: angular.identity,
        url: "product/findAllProducts"
    }).then(function successCallback(response) {
        $ctrl.products = response.data;
    }, function errorCallback(error) {
        showError(getErrorMessage(error));
    });

    $ctrl.address = {};

    $ctrl.addBeneficiaryPatient = function () {

    };

    $ctrl.addViewProduct = function (product) {
        $ctrl.productDetails = product;
    };

    /*Modal buttons*/
    $ctrl.modalOk = function () {
        console.log("Modal ok clicked");
    };
    /*Modal buttons*/
});

