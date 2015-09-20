/**
 * 
 */
function Afterhours($scope, $http) {
    $http.get('http://52.11.19.84:8080/Loftro/rest/resthandler').
        success(function(data) {
            $scope.resthandler = data;
        });
}