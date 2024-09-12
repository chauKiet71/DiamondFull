app.controller("category-ctrl", function ($http, $scope) {
    $scope.items = [];
    $scope.form = {};
    $scope.loadCategoris = function () {
        $http.get("/rest/categories").then(resp => {
            $scope.items = resp.data;
            console.log($scope.items)
        })
    }
    $scope.loadCategoris()

    //edit
    $scope.edit = function (item) {
        $scope.form = angular.copy(item)
    }

    $scope.reset = function () {
        $scope.form = {}
    }

    //create category
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/categories`, item).then(resp => {
            $scope.items.push(resp.data)
            $scope.reset()
            alert("Add success")
        }).catch(error => {
            alert("Add error")
            console.log("Error: " + error)
        })
    }

    //delete category
    $scope.delete = function (item) {
        $http.delete(`/rest/categories/${item.category_id}`).then(resp => {
            var index = $scope.items.findIndex(c => c.category_id === item.category_id); // Sửa dấu '=' thành '==='
            if (index !== -1) {
                $scope.items.splice(index, 1);
            }
            alert("Delete success");
        }).catch(error => {
            alert("Delete error");
            console.log("Error: " + error);
        });
    }

})
