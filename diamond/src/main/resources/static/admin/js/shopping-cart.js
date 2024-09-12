const app = angular.module("shopping-cart-app", [])
app.controller("shopping-cart-ctrl", function ($scope, $http) {

    $scope.cart = {
        items: [],
        add(id) {
            var item = this.items.find(item => item.id == id)
            if (item) {
                item.qty++;
                this.saveToLocalStorage()
            } else {
                $http.get(`/rest/product/${id}`).then(resp => {
                    resp.data.qty = 1
                    this.items.push(resp.data)
                    this.saveToLocalStorage()
                })
            }
        },
        //xoa san pham khoi gio hang
        remove(id) {
            var index = this.items.findIndex(item => item.id == id)
            this.items.splice(index, 1)
            this.saveToLocalStorage()
        },
        //xoa all gio hang
        clear() {
            this.items = []
            this.saveToLocalStorage()
        },
        // tinh tong so tien cac mat hang trong gio
        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total += qty, 0);
        },
        // tong thanh tien cac mat hang trong gio
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total += qty, 0)
        },
        //luu gio hang vao local storage
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items))
            localStorage.setItem("cart", json)
        },
        loadFromLocalStorege() {
            var json = localStorage.getItem("cart")
            this.items = json ? JSON.parse(json) : []
        }
    }
    $scope.cart.loadFromLocalStorege();
    var fullAddress = ""
    $scope.order = {
        create_date: new Date(),
        address: fullAddress,
        account: {username: $("#username").text()},

        get orderDetails() {
            return $scope.cart.items.map(item => {
                return {
                    product: {product_id: item.product_id},
                    price: item.price * item.qty,
                    quantity: item.qty

                };

            });
        },

        purchase() {
            const tinhSelect = document.getElementById('tinh');
            const quanSelect = document.getElementById('quan');
            const phuongSelect = document.getElementById('phuong');
            const addressInput = document.getElementById('address');

            const tinh = tinhSelect.options[tinhSelect.selectedIndex].text;
            const quan = quanSelect.options[quanSelect.selectedIndex].text;
            const phuong = phuongSelect.options[phuongSelect.selectedIndex].text;
            const detailedAddress = addressInput.value;

            // Kiểm tra nếu không phải là lựa chọn mặc định
            const tinhAddress = tinh !== "Tỉnh Thành" ? tinh : '';
            const quanAddress = quan !== "Quận Huyện" ? quan : '';
            const phuongAddress = phuong !== "Phường Xã" ? phuong : '';

            // Ghép địa chỉ
            fullAddress = [detailedAddress, phuongAddress, quanAddress, tinhAddress].filter(Boolean).join(', ');

            // Gán địa chỉ vào đối tượng order
            this.address = fullAddress;
            console.log("Địa chỉ: " + this.address)

            // Tạo một bản sao của đơn hàng
            var order = angular.copy(this);

            // Thực hiện đặt hàng qua API
            $http.post("/rest/orders", order).then(resp => {
                // console.log("Full response object:", resp);
                // console.log("Response data:", resp.data);
                console.log("Response status:", resp.status);
                console.log("Response headers:", resp.headers());
                console.log("Response config:", resp.config);

                alert("Đặt hàng thành công");
                $scope.cart.clear();
                // location.href = "/order/detail/" + resp.data.id;
            }).catch(error => {
                alert("Đặt hàng lỗi");
                console.error("Error occurred:", error);
                console.log("Order data:", order);
            });


            // Chỉ để test
            // alert("Đặt hàng");
        }
    };
})