'use strict';

angular.module('ui.bootstrap.demo').factory('catalogIWPService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8091/catalog/';

    var factory = {
        getDate: getDate,
        createIWP: createIWP      
    };

    return factory;

  

    function createIWP() {
        var deferred = $q.defer();
        $http.get("/spcgenerate")
            .then(
            function (response) {
            	//console.error(response.data);
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function getDate() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+"getDate")
            .then(
            function (response) {
            	 
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


}]);