const app = angular.module("profile-app", ["ngRoute"]);

app.controller("profile-ctrl", function ($scope, $http, $location) {

    // Chuyển đổi ngày từ định dạng ISO sang MM/DD/YYYY
    function formatDateToMMDDYYYY(dateString) {
        var date = new Date(dateString);
        var month = ('0' + (date.getMonth() + 1)).slice(-2); // Tháng từ 0-11
        var day = ('0' + date.getDate()).slice(-2); // Ngày từ 1-31
        var year = date.getFullYear();
        return `${month}/${day}/${year}`; // Định dạng MM/DD/YYYY
    }

    $scope.form = {}; // Form lưu dữ liệu của account
    var path = $location.absUrl(); // Lấy URL đầy đủ
    var id = path.split("/").pop();  // Lấy 'id' từ URL, phần cuối cùng của URL là 'a1'

    // Load thông tin user từ server và đưa vào form
    $scope.loadUser = function () {
        $http.get("/rest/account/" + id).then(resp => {
            $scope.form = resp.data; // Đưa dữ liệu vào form
            // Chuyển đổi ngày từ server thành định dạng mm/dd/yyyy
            if (resp.data.birthday) {
                $scope.form.birthday = formatDateToMMDDYYYY(String(resp.data.birthday));
                $scope.form.birthday = new Date($scope.form.birthday);// Chuyển thành định dạng mm/dd/yyyy
            } else {
                $scope.form.birthday = "";
            }
        }).catch(error => {
            console.log("Error: ", error);
        });
    };

    // Gọi loadUser khi controller khởi động
    $scope.loadUser();

    // Tạo hoặc cập nhật user
    $scope.update = function () {
        var item = angular.copy($scope.form); // Copy dữ liệu từ form
        $http.put(`/rest/account/${id}`, item).then(resp => {
            alert("Cập nhật thành công");
        }).catch(error => {
            console.log("Error: " + error);
            alert("Cập nhật thất bại");
        });
    };

    // Upload hình ảnh
    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.photo = resp.data.name; // Cập nhật tên ảnh trong form
            alert("Upload hình ảnh thành công");
        }).catch(error => {
            alert("Lỗi upload hình ảnh");
            console.log("Error", error);
        });
    };
});
