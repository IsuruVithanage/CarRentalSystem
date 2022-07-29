function Customer(custID, name, address, email, nic, contact, userID) {
    var __custID=custID;
    var __name=name;
    var __address=address;
    var __email=email;
    var __nic=nic;
    var __contact=contact;
    var __userID=userID;

    this.getCustID = function () {
        return __custID;
    }

    this.getCustName = function () {
        return __name;
    }

    this.getCustAddress = function () {
        return __address;
    }

    this.getCustEmail = function () {
        return __email;
    }

    this.getCustNIC = function () {
        return __nic;
    }

    this.getCustContact = function () {
        return __contact;
    }

    this.getUserID = function () {
        return __userID;
    }

    this.setCustID = function (v) {
        __custID=v;
    }

    this.setCustName = function (v) {
        __name=v;
    }

    this.setCustAddress = function (v) {
        __address=v;
    }

    this.setCustEmail = function (v) {
        __email=v;
    }

    this.setNic = function (v) {
        __nic=v;
    }

    this.setContact = function (v) {
        __contact=v;
    }

    this.setUserID = function (v) {
        __userID=v;
    }


}