hmsApp.controller('BillingController', function ($scope, $log, $http, $compile, $timeout, $uibModal) {

    var $ctrl = this;
    //  params: {fromDate: fromDate, endDate: endDate},

    $http({
        method: 'GET',
        transformRequest: angular.identity,
        url: "billing/findAllInvoices"
    }).then(function successCallback(response) {
        $ctrl.invoices = response.data;
        console.log(response.data);
    }, function errorCallback(error) {
        showError(getErrorMessage(error));
    });

    $ctrl.addBeneficiaryPatient = function () {

    };

    $ctrl.addViewInvoice = function (invoice) {
        $ctrl.invoiceDetail = invoice;
    };

    /*Modal buttons*/
    $ctrl.modalOk = function () {
        console.log("Modal ok clicked");
    };
    /*Modal buttons*/
});

