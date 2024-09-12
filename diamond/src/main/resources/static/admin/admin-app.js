const app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/addProduct", {
            templateUrl: "/admin/product/addProduct.html",
            controller: "product-ctrl"
        })
        .when("/listProduct", {
            templateUrl: "/admin/product/productList.html",
            controller: "product-ctrl"
        })
        .when("/addCategory", {
            templateUrl: "/admin/category/addCategory.html",
            controller: "category-ctrl"
        })
        .when("/listCategory", {
            templateUrl: "/admin/category/categoryList.html",
            controller: "category-ctrl"
        })
        .when("/addUser", {
            templateUrl: "/admin/user/newUser.html",
            controller: "user-ctrl"
        })
        .when("/listUser", {
            templateUrl: "/admin/user/userList.html",
            controller: "user-ctrl"
        })
        .otherwise({
            templateUrl: "/admin/index.html",
            // template: "<h1 class='text-center'>Administration</h1>"
        });
});
