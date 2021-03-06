;angular.module('miaomiao.shop').
    controller('FindShopCtrl', function ($scope, $http, $state,$location, $ionicLoading,$ionicScrollDelegate, localStorageService, httpClient,ShopService, MMUtils, $timeout) {

        $scope.shop_data = {};
        $scope.shop_items = [];
        $scope.shop_info = {};

        $scope.shop_info.locationReady = localStorageService.get('MMMETA_location_pos_ready');
        if (!$scope.shop_info.locationReady) {
            $scope.shop_info.locationMessage = "定位失败,您可以搜索所在的小区"
        } else {
            if(localStorageService.get('MMMETA_location_pos_addr')){
                $scope.shop_info.locationMessage = localStorageService.get('MMMETA_location_pos_addr');
            }else{
                $scope.shop_info.locationMessage = "点击重新定位";
            }
        }

        $scope.searchButtonText = "搜索";

        $scope.shop_history = localStorageService.get('MMMETA_shop_history') || [];

        $scope.clearSearch = function () {
            $scope.shop_data.searchQuery = '';
            hideSearchSuggestions();
        };

        function showSearchSuggestions() {
            $scope.shop_info.showAddressSuggestion = true;
        }

        function hideSearchSuggestions() {
            $scope.shop_info.showAddressSuggestion = false;
        }

        $scope.startSearch = function () {

            if($scope.shop_data.searchQuery && $scope.shop_data.searchQuery.length > 0){
                $scope.searchButtonText = "搜索";
            }else{
                $scope.searchButtonText = "取消";
            }

            showSearchSuggestions();
        };

        $scope.goToShop = function (shop) {

            //TODO: check shop status
            if (shop.status != undefined && shop.status != 0) {
                MMUtils.showAlert('您选择的小区店铺已经打烊了');
                return;
            }

            var shopExist = false;
            for (var i = 0; i < $scope.shop_history.length; i++) {
                if (shop.id == $scope.shop_history[i].id) {
                    shopExist = true;
                    break;
                }
            }
            if (!shopExist) {
                $scope.shop_history.push(shop);
            }

            localStorageService.set('MMMETA_shop_history', $scope.shop_history);
            ShopService.setDefaultShopAndSync(shop);

            if ($scope.modal) {
                $scope.modal.hide();
            } else {
                $state.go('productList',null,{reload: true});
            }
        };

        $scope.clickAddressSuggestions = function($event){

            $event.stopPropagation();

            resetFindShopView();

        };

        $scope.clickCommunity = function(community,$event){

            $event.stopPropagation();

            if(!community.shops || community.shops.length == 0){

                community.showShopNotReadyMessage = true;
                $timeout(function(){
                    community.showShopNotReadyMessage = false;
                },1000);

                return;

            }

            if(community.shops && community.shops.length == 1){
                $scope.goToShop(community.shops[0]);
                return;
            }

            if(community.shops && community.shops.length > 1){
                community.showShopsInCommunity = !community.showShopsInCommunity;
                return;
            }
        };

        $scope.toggleShopsInCommunity = function($event,item){
            $event.stopPropagation();
        };

        // for shop star
        $scope.readonly = true;

        $scope.getSuggestions = function (key, $event) {

            if($scope.shop_data.searchQuery && $scope.shop_data.searchQuery.length > 0){
                $scope.searchButtonText = "搜索";
            }else{
                $scope.searchButtonText = "取消";
            }

            // get suggestion from server
            httpClient.getCommunitySuggestions(key,function(data, status){

                var code = data.code, dataDetail = data.data;

                if (code == 0 &&
                    !MMUtils.isEmptyObject(dataDetail) &&
                    dataDetail.communitys &&
                    dataDetail.communitys.length) {

                    $timeout(function () {
                        $scope.shop_info.address_suggestions = dataDetail.communitys;
                    });

                }else{
                    $scope.shop_info.address_suggestions = [];
                }
            },function(data, status){
            })

        };

        $scope.performSearch = function (key, $event) {

            if ($event)$event.target.blur();

            if($scope.searchButtonText == "取消"){
                $scope.searchButtonText = "搜索";
                hideSearchSuggestions();
                return;
            }

            var KEY = key || $scope.shop_data.searchQuery;
            if(!KEY)return;

            $timeout(function () {
                $scope.shop_info.locationMessage = KEY;
            });

            MMUtils.showLoadingIndicator('正在搜索' + KEY + '...',$scope);

            // search by keywords
            httpClient.getCommunityByName(key, function (data, status) {
                $ionicLoading.hide();
                var code = data.code, dataDetail = data.data;

                if (code == 0 && !MMUtils.isEmptyObject(dataDetail)) {
                    $scope.community_items = _updateShopStatusForCommunity(dataDetail.communitys);
                }else{
                    $scope.community_items = [];
                }
                $scope.shop_info.commmunityListTitle = "为您找到的小区";

                hideSearchSuggestions();

            }, function (data, status) {

                $ionicLoading.hide();
                $scope.community_items = [];
                $scope.shop_info.commmunityListTitle = "为您找到的小区";

                hideSearchSuggestions();
            });
        };


        // $scope.shop_info.locationMessage = localStorageService.get('MMMETA_location_pos_addr') || "切换地址";

        $scope.relocation = function () {

            function showPosition(position) {

                $ionicLoading.hide();

                if (position) {

                    $timeout(function () {
                        $scope.shop_info.locationReady = true;
                        $scope.shop_info.locationMessage = "定位成功,正在获取地址...";
                    });

                    localStorageService.set('MMMETA_location_pos_ready', 1);
                    localStorageService.set('MMMETA_location_pos_data',
                        {'lat': position.coords.latitude, 'lng': position.coords.longitude});

                    updateUIWhenPositionDataReady();

                } else {
                    $timeout(function () {
                        $scope.shop_info.locationReady = false;
                        $scope.shop_info.locationMessage = "定位失败！";
                    });
                }
            }

            function showError() {
                $ionicLoading.hide();
                $timeout(function () {
                    $scope.shop_info.locationMessage = "定位失败！";
                });
            }

            if (navigator.geolocation) {
                var position_option = {
                    enableHighAccuracy: true,
                    timeout: 10000,
                    maximumAge:0
                };

                MMUtils.showLoadingIndicator('正在重新定位',$scope);

                navigator.geolocation.getCurrentPosition(showPosition, showError, position_option);
            } else {
                $scope.shop_info.locationMessage = "浏览器不支持定位";
            }
        };

        function updateRealGEOAddressByGEOData(lng, lat,cb) {

            var gpsPoint = new BMap.Point(lng, lat);

            BMap.Convertor.translate(gpsPoint, 0, function(point){ //百度官方发布的接口
                var myGeo = new BMap.Geocoder();
                // 根据坐标得到地址描述
                myGeo.getLocation(point, function (result) {
                    if (result) {
                        localStorageService.set('MMMETA_location_pos_addr', result.address);
                        $timeout(function () {
                            $scope.shop_info.locationMessage = result.address;
                        });
                    }
                });

                if(cb){
                    cb(point);
                }
            });
        }

        function _updateShopStatusForCommunity(comm_items){
            for(var i=0; i<  comm_items.length;i++){
                var hasOpenShop = false;
                if(comm_items[i].shops){
                    for(var j=0;j< comm_items[i].shops.length;j++){
                        if(comm_items[i].shops[j].status == 0){
                            hasOpenShop = true;
                        }
                    }
                }
                comm_items[i].hasOpenShop = hasOpenShop;
            }
            return comm_items;
        }

        function updateUIWhenPositionDataReady() {

            $scope.shop_info.locationReady = localStorageService.get('MMMETA_location_pos_ready');

            if ($scope.shop_info.locationReady) {

                $scope.shop_info.locationData = localStorageService.get('MMMETA_location_pos_data');

                function onBMAPPointReady(point){

                    $scope.shop_info.loadingCoummnityItems = true;
                    $scope.community_items = null;

                    httpClient.getNearCommunityList(point.lat, point.lng, function (data, status) {

                        var code = data.code, dataDetail = data.data;

                        if (code == 0 || !MMUtils.isEmptyObject(dataDetail)) {

                            $timeout(function () {
                                $scope.community_items = _updateShopStatusForCommunity(dataDetail.communitys);
                            });
                        }else{
                            $scope.community_items = [];
                        }

                        $scope.shop_info.loadingCoummnityItems = false;

                    }, function (data, status) {

                        // still show it and with no item hint
                        $timeout(function () {
                            $scope.shop_info.loadingCoummnityItems = false;
                            $scope.community_items = [];
                            $scope.shop_info.commmunityListTitle = "附近的小区";
                        });
                    });
                }

                updateRealGEOAddressByGEOData($scope.shop_info.locationData.lng, $scope.shop_info.locationData.lat,onBMAPPointReady);

            }
        }

        function resetFindShopView(){
            $scope.shop_info.showAddressSuggestion = false;
            $scope.shop_info.commmunityListTitle = "附近的小区";
        }

        $scope.$on("$ionicView.enter", function () {

            $scope.shop_info.commmunityListTitle = "附近的小区";
            $scope.searchButtonText = "搜索";
            $timeout(function () {
                updateUIWhenPositionDataReady();
            });
        });
    });