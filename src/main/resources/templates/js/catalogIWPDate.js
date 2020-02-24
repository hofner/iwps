angular.module('ui.bootstrap.demo', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);

angular.module('ui.bootstrap').controller('catalogIWPController', function($scope, catalogIWPService, $http) {
	var data = [];
  $scope.format = 'yyyy/MM/dd hh:mm:ss';
  $scope.date = new Date();
    var self = this;
   // self.user={id:null,date:''};
    //self.users=[];

    self.submit = submit;



   // fetchAllUsers();

    function getDate(){
    	catalogIWPService.getDate()
            .then(
            function(d) {
               // self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }

    function createCatalogIWP(){
    	catalogIWPService.createIWP()
            .then(
            		function(d) {
            			console.log('la fecha es '+new Date(d));
            			console.log($scope.date);
            			$scope.date=new Date(d)
            			var loading = $('.ebLoader');
            			loading.show();
                        // self.date = d;
                     },
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

  

  

    function edit(id){
        console.log('id to be edited', id);
//        for(var i = 0; i < self.users.length; i++){
//            if(self.users[i].id === id) {
//                self.user = angular.copy(self.users[i]);
//                break;
//            }
//        }
    }
    
    function submit() {
    	alert("a")
    	createCatalogIWP();    
    	alert("ab");
        
    }

    function remove(id){
        console.log('id to be deleted', id);
//        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
//            reset();
//        }
//        deleteUser(id);
    }


    function reset(){
      //  self.user={id:null,data:''};
        $scope.myForm.$setPristine(); //reset Form
    }
  
    alert("init")
});