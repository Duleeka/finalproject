var CitizenServiceTab = function () {


    var runServiceTypeSelect=function () {
        $("#service_type").select2({
            placeholder : "Select Specific Service Type",
            allowClear : true,
        });
    }
    var selectServiceType = function () {
        $('#service_type').on("select2:select", function (e) {
            var value = e.currentTarget.value;
            var text = e.currentTarget.textContent;
            addDataTotable(value, text)
        });
    };
    var addDataTotable = function (value, text) {
        var obj = {
            id: "",
            version: "",
            index: serviceTypeList.length - 1,
            serviceRegisterId: value,
            serviceType: text
        }
        serviceTypeList.push(obj)
        populateTable()
    }



    var populateTable = function () {
        if (serviceTypeList.length > 0) {
            var serviceType, row;
            for (row = 0; row < serviceTypeList.length; row++) {
                serviceType = serviceTypeList[row];
                var html = "<tr>" +
                    "<input type='hidden' name='serviceRegisterDTOS[" + row + "].id' value='" + serviceType.id + "'>" +
                    "<input type='hidden' name='serviceRegisterDTOS[" + row + "].version' value='" + serviceType.version + "'>" +
                    "<input type='hidden' name='serviceRegisterDTOS[" + row + "].serviceRegisterId' value='" + serviceType.serviceRegisterId + "'>" +
                    "<td>" + (row + 1) + "</td>" +
                    "<td>" + serviceType.serviceType + "</td>" +
                    "<td></td>" +
                    "<td><button type='button' onclick='CitizenServiceTab.deleteServices()'>Remove</button> </td>" +

                    "</tr>";
                $("#tbl_service_tab > tbody:last-child").append(html);

            }
        }
    };

    var deleteServiceType = function () {
        console.log(serviceTypeList);
        serviceTypeList.splice(0, 1);
        console.log(serviceTypeList)

    };


    return {
        init: function () {
            runServiceTypeSelect();
            selectServiceType();
        },
        deleteServices: function () {
            deleteServiceType();
        }



    };
}();
