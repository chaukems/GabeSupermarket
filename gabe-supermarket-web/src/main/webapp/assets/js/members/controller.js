gfpApp.controller('GFPMembersController', function ($scope, $log, $http, $compile, $timeout, $uibModal) {

    var $ctrl = this;

    $ctrl.members = [
        {
            fullName: "Sydney",
            lastName: "Chauke",
            telephone: "0728565946",
            idNo: "8303305920088",
            age: 34,
            address: {
                addressLine1: "1 Nthlamu Street",
                addressLine2: "Xitasini",
                suburb: "Xigalo",
                postalCode: "1000"
            },
            beneficiaries: [
                {
                    fullName: "Ronald",
                    lastName: "Chauke",
                    telephone: "0824538541",
                    idNo: "8004285920088",
                    age: 38
                }
            ]
        },
        {
            fullName: "Tlangelani",
            lastName: "Maphali",
            telephone: "0835112345",
            idNo: "8502205920088",
            age: 32,
            address: {
                addressLine1: "1 Maphali street",
                addressLine2: "Nthlamu",
                suburb: "Xigalo ",
                postalCode: "1000"
            },
            beneficiaries: [
                {
                    fullName: "Hlulani",
                    lastName: "Maphali",
                    telephone: "0712345678",
                    idNo: "8801205920088",
                    age: 30
                }
            ]
        }
    ];

  
    $ctrl.address = {};

    $ctrl.addBeneficiaryPatient = function () {

    };

    $ctrl.addviewPatient = function (member) {
        $ctrl.memberDetails = member;
    };

    /*Modal buttons*/
    $ctrl.modalOk = function () {

        console.log("Modal ok clicked");

    };

    /*Modal buttons*/
});

