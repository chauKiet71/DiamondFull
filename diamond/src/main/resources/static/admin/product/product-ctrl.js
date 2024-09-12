app.controller("product-ctrl", function ($scope, $http, $location) {
    $scope.items = [];
    $scope.form = {};
    $scope.cates = [];
    $scope.initialize = function () {
        $http.get("/rest/product").then(resp => {
            $scope.items = resp.data;
            console.log($scope.form)
            $scope.items.forEach(item => {
                item.create_date = new Date(item.create_date)
            })
        });
// load categories
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        });
    }
// Khởi đầu
    $scope.initialize();
// Xóa form
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date()
        };
    }
// Hiển thị lên form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        // $location.path('/addProduct');
        console.log("Object edit: " + $scope.form)
    };
// Thêm sản phẩm mới
    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/product`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset();
            alert("Thêm mới sản phẩm thành công!");
        }).catch(error => {
            alert("Lỗi thêm mới sản phẩm!");
            console.log("Error", error);
        });
    }
// Cập nhật sản phẩm
    $scope.update = function () {
        var item = angular.copy($scope.form);  // Sao chép dữ liệu từ form vào biến item
        $http.put(`/rest/product/${item.id}`, item)  // Gửi yêu cầu PUT tới server
            .then(resp => {
                var index = $scope.items.findIndex(p => p.id == item.id);  // Tìm chỉ số của mục cần cập nhật trong mảng items
                if (index !== -1) {  // Nếu tìm thấy chỉ số
                    $scope.items[index] = item;  // Cập nhật mục trong mảng items
                }
                alert("Cập nhật sản phẩm thành công!");  // Thông báo thành công
            })
            .catch(error => {
                console.log("Error", error);  // Ghi log lỗi
            });
    };

// Xóa sản phẩm
    $scope.delete = function (item) {
        $http.delete(`/rest/product/${item.product_id}`).then(resp => {
            var index = $scope.items.findIndex(p => p.product_id == item.product_id);
            if (index !== -1) {
                $scope.items.splice(index, 1);
            }
            $scope.reset();
            alert("Xóa sản phẩm thành công!");
        }).catch(error => {
            console.log("Error", error); // Xem lỗi nếu có
            alert("Lỗi xóa sản phẩm!");
        });
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

    $scope.pager = {
        page: 0,
        size: 10,
        get items(){
            var start = this.page* this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        last() {
            this.page = this.count - 1
        },
        next() {
            this.page++;
            if(this.page >= this.count) {
                this.first();
            }
        },
        prev() {
            this.page--;
            if(this.page < 0){
                this.last();
            }
        }
    }
})