var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.pagination' , 'ui.grid.cellNav', 'ui.grid.edit', 'ui.grid.resizeColumns', 'ui.grid.pinning', 'ui.grid.selection', 'ui.grid.moveColumns', 'ui.grid.exporter', 'ui.grid.importer', 'ui.grid.grouping','ngMaterial',
    'ngMessages',
    'material.svgAssetsCache']);
var REST_SERVICE_URI = '';
/**http://localhost:8091/catalog/*/
app.controller('MainCtrl',  ['$scope', '$http', '$timeout', '$interval', 'uiGridConstants', 'uiGridGroupingConstants',
 function ($scope, $http, $timeout, $interval,uiGridConstants, uiGridGroupingConstants) {
	 $scope.format = 'yyyy/MM/dd hh:mm:ss';
	  $scope.date = new Date();
  $scope.gridOptions = {
		    enableGridMenu: true, 
	         data: 'data', 
	         enableRowSelection : true,
	         multiSelect : true,
	         enablePaginationControls: false,
	         paginationPageSize: 25,
	        importerDataAddCallback: function ( grid, newObjects ) { 
	           $scope.data = $scope.data.concat( newObjects ); 
	         }, 
	         onRegisterApi: function(gridApi){ 
	           $scope.gridApi = gridApi; 
			}
		  
  };
  $scope.gridOptions.data = 'myData';
  $scope.gridOptions.enableColumnResizing = true;
  $scope.gridOptions.enableFiltering = true;
  $scope.gridOptions.enableGridMenu = true;
  $scope.gridOptions.showGridFooter = true;
  $scope.gridOptions.showColumnFooter = true;
  $scope.gridOptions.fastWatch = true;
 
  $scope.gridOptions.rowIdentity = function(row) {
    return row.id;
  };
  $scope.gridOptions.getRowIdentity = function(row) {
    return row.id;
  };
 	 
  $scope.gridOptions.columnDefs = [
 
    { name: 'iwp', field: uiGridConstants.ENTITY_BINDING  ,enableCellEdit: false  , enableColumnResizing: true }

  ];
 
  
  var i = 0;
  $scope.updateData=function(){
	  var selected =$scope.gridApi.selection.getSelectedRows();
	  if(selected==''){
		  selected=null
	  }
	  $http.get(REST_SERVICE_URI+'updateIwp', {
	        params:  {page: 1, limit: 100, sort: 'name', direction: 'desc' ,data : selected}
	      //  headers: {'Authorization': 'Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ=='}
	    }
	)
	.then(function(response) {
		alert("exito")
	    // Request completed successfully
	}, function(x) {
		alert("no exito")
	    // Request error
	});
	  alert(selected)
  } 
  
  
  $scope.refreshData = function(){
    $scope.myData = [];
 
    var start = new Date();
    //var sec = $interval(function () {
      $scope.callsPending++;
 
      $http.get(REST_SERVICE_URI+'getIwp')
        .success(function(data) {
        	alert(data.length)
          $scope.callsPending--;
 
          data.forEach(function(row){
            row.id = i;
            i++;
            row.registered = new Date(row.registered)
            $scope.myData.push(row);
          });
        })
        .error(function() {
          $scope.callsPending--
        });
   // }, 200, 10);
 
 
    var timeout = $timeout(function() {
       $interval.cancel(sec);
       $scope.left = '';
    }, 2000);
 
    $scope.$on('$destroy', function(){
      $timeout.cancel(timeout);
      $interval.cancel(sec);
    });
 
  };
  $scope.callsPending = 0;

 
}]);

app.directive('offCanvasMenu', function () {
    return {
        restrict: 'A',
        replace: false,
        link: function (scope, element) {
            scope.isMenuOpen = false;
            scope.toggleMenu = function () {
                scope.isMenuOpen = !scope.isMenuOpen;
            };
        }
    };
});
 app.filter('keyboardShortcut', function($window) {
    return function(str) {
      if (!str) return;
      var keys = str.split('-');
      var isOSX = /Mac OS X/.test($window.navigator.userAgent);

      var seperator = (!isOSX || keys.length > 2) ? '+' : '';

      var abbreviations = {
        M: isOSX ? '' : 'Ctrl',
        A: isOSX ? 'Option' : 'Alt',
        S: 'Shift'
      };

      return keys.map(function(key, index) {
        var last = index == keys.length - 1;
        return last ? key : abbreviations[key];
      }).join(seperator);
    };
  })
  app.controller('DemoBasicCtrl', function DemoCtrl($mdDialog) {
    this.settings = {
      printLayout: true,
      showRuler: true,
      showSpellingSuggestions: true,
      presentationMode: 'edit'
    };
	

    this.sampleAction = function(name, ev) {
      $mdDialog.show($mdDialog.alert()
        .title(name)
        .textContent('You triggered the "' + name + '" action')
        .ok('Great')
        .targetEvent(ev)
      );
    };
	

  });
   app.controller('AppCtrl',  function ($scope, $timeout, $mdSidenav) {
    $scope.toggleLeft = buildToggler('left');
    $scope.toggleRight = buildToggler('right');

    function buildToggler(componentId) {
      return function() {
        $mdSidenav(componentId).toggle();
      }
    }
  });


