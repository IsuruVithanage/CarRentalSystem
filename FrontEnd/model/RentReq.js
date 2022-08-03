function RentReq(rentID, pickedDate, pickedTime, returnDate, returnTime, driverNeed, vehicle, driver, customer) {
    var __rentID=rentID;
    var __pickedDate=pickedDate;
    var __pickedTime=pickedTime;
    var __returnDate=returnDate;
    var __returnTime=returnTime;
    var __driverNeed=driverNeed;
    var __vehicle=vehicle;
    var __driver=driver;
    var __customer=customer;

    this.getrentID = function () {
        return __rentID;
    }

    this.getPickedDate = function () {
        return __pickedDate;
    }

    this.getPickedTime = function () {
        return __pickedTime;
    }

    this.getReturnDate = function () {
        return __returnDate;
    }

    this.getReturnTime = function () {
        return __returnTime;
    }

    this.getDriverNeed = function () {
        return __driverNeed;
    }

    this.getVehicle= function () {
        return __vehicle;
    }

    this.getDriver= function () {
        return __driver;
    }

    this.getCustomer= function () {
        return __customer;
    }

    this.setRentID = function (v) {
        __rentID=v;
    }

    this.setPickedDate = function (v) {
        __pickedDate=v;
    }

    this.setPickedTime = function (v) {
        __pickedTime=v;
    }

    this.setReturnDate = function (v) {
        __returnDate=v;
    }

    this.setReturnTimme = function (v) {
        __returnTime=v;
    }

    this.setDriverNeed = function (v) {
        __driverNeed=v;
    }

    this.setVehicle = function (v) {
        __vehicle=v;
    }

    this.setDriver = function (v) {
        __driver=v;
    }

    this.setCustomer = function (v) {
        __customer=v;
    }

    this.gettingDates = function (rID,cID,dneed,pdate,ptime,rdate,rtime) {
        __rentID=rID;
        __customer=cID;
        __pickedDate=pdate;
        __pickedTime=ptime;
        __returnDate=rdate;
        __returnTime=rtime;
        __driverNeed=dneed;
    }

}