var routerApp = angular.module('routerApp', ['ui.router']);

routerApp.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/home');
    
    $stateProvider
        
        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home',
            templateUrl: 'partial-home.html'
        })
        
        // nested list with custom controller
        .state('home.list', {
            url: '/list',
            templateUrl: 'partial-home-list.html',
            controller: function($scope) {
                $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
            }
        })
        
        // nested list with just some random string data
        .state('home.paragraph', {
            url: '/paragraph',
            template: 'I could sure use a drink right now.'
        })
        
        // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
        .state('about', {
            url: '/about',
            views: {
                '': { templateUrl: 'partial-about.html' },
                'columnOne@about': { template: 'Look I am a column!' },
                'columnTwo@about': { 
                    templateUrl: 'table-data.html',
                    controller: 'scotchController'
                }
            }
            
        });
        
});

routerApp.controller('scotchController', function($scope, $http) {
    
    $scope.message = 'test';
    
     $http.get("/mota/resturants/all").success(function(response){
    	 $scope.resturants = response.data;
    }).error(function (data, status, header, config) {
        $scope.ResponseDetails = "Data: " + data +
        "<br />status: " + status +
        "<br />headers: " + jsonFilter(header) +
        "<br />config: " + jsonFilter(config);
    });
    
//    $scope.scotches = [
//        {
//            name: 'Macallan 12',
//            price: 50
//        },
//        {
//            name: 'Chivas Regal Royal Salute',
//            price: 10000
//        },
//        {
//            name: 'Glenfiddich 1937',
//            price: 20000
//        }
//    ];
    
});