(function () {
    'use strict';

    angular
        .module('app')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['UserService', '$rootScope','$http','$cookies'];
    function HomeController(UserService, $rootScope,$http,$cookies) {
        var vm = this;
        initController();
        vm.editProduct = editProduct;
        function initController(){
            var sid = $cookies.get('sessionid');
            console.log("session id"+sid);
            $http.get('/api/product?limit=10')
            .then(function (response) {
            	vm.tableData = response.data.data;
            },function (error){
            	console.log(error);
            });
            
        }

        function editProduct(id){
        		var i, len = vm.tableData.length;
        		vm.editData={};
        	    for (i = 0; i < len; i++) {
        	        if (vm.tableData[i] && vm.tableData[i].hasOwnProperty("id")) {
        	        	if( vm.tableData[i]["id"]==id){
        	        		vm.editData=vm.tableData[i];
        	        		 console.log(vm.editData);
        	        	}
        	           
        	        }
        	    }
        }
                
    }
    
})();