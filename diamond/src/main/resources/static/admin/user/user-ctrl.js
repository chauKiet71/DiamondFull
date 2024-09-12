app.controller("user-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.form = {}
    $scope.loadUser = function () {
        $http.get("/rest/account").then(resp => {
            $scope.items = resp.data;
        })
    }
    $scope.loadUser()

    //reset
    $scope.reset = function () {
        $scope.form = {}
    }

    //edit
    $scope.edit = function (item) {
        $scope.form = angular.copy(item)
    }

    //create
    $scope.create = function () {
        var item = angular.copy($scope.form)
        $http.post(`/rest/account`, item).then(resp => {
            $scope.items.push(resp.data)
            $scope.reset();
            alert("Add user success")
        }).catch(error => {
            console.log("Error: " + error)
            alert("Add error")
        })
    }

    //delete
    $scope.delete = function (item) {
        $http.delete(`/rest/account/${item.username}`).then(resp => {
            var index = $scope.items.findIndex(acc => acc.username === item.username)
            if (index !== -1) {
                $scope.items.splice(index, 1);
            }
            alert("Delete success")
        }).catch(error => {
            alert("Delete error")
            console.log("Error: " +error)
        })
    }

    // Upload hình
    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
            alert("Upload hình ảnh thành công");
            console.log($scope.form.image)
        }).catch(error => {
            alert("Lỗi upload hình ảnh");
            console.log("Error", error);
        })
    }
})