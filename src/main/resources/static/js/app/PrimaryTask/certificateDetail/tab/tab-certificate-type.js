var CertificateDetailTab = function () {


    var runCertificateTypeSelect = function () {
        $("#certificate_type").select2({
            placeholder: "Select A Certificate Type",
            allowClear: true
        });
    };
    var selectCertificateType = function () {
        $('#certificate_type').on("select2:select", function (e) {
            var value = e.currentTarget.value;
            var text = e.currentTarget.textContent;
            addDataTotable(value, text)
        });
    };
    var addDataTotable = function (value, text) {
        var obj = {
            id: "",
            version: "",
            index: certificateTypeList.length -1 ,
            certificateRegisterId: value,
            certificateType: text
        }
        certificateTypeList.push(obj)
        populateTable()
    }



    var populateTable = function () {
        if (certificateTypeList.length > 0) {
            var certificateType, row;
            for (row = 0; row < certificateTypeList.length; row++) {
                certificateType = certificateTypeList[row];
                var html = "<tr>" +
                    "<input type='hidden' name='certificateDetailRegisterDTOS[" + row + "].id' value='" + certificateType.id + "'>"+
                    "<input type='hidden' name='certificateDetailRegisterDTOS[" + row + "].version' value='" + certificateType.version + "'>" +
                    "<input type='hidden' name='certificateDetailRegisterDTOS[" + row + "].certificateRegisterId' value='" + certificateType.donationRegisterId + "'>" +
                    "<td>" + (row + 1) + "</td>" +
                    "<td>" + certificateType.certificateType + "</td>" +
                    /*"<td></td>" +*/
                    "<td><button type='button' onclick='CertificateDetailTab.deleteCertificates()'>Remove</button> </td>" +

                    "</tr>";
                $("#tbl_certificate_tab > tbody:last-child").append(html);

            }
        }
    }


    var deleteCertificateType = function () {
        console.log(certificateTypeList)
        certificateTypeList.splice(0, 1);
        console.log(certificateTypeList)

    }


    return {
        init: function () {
            runCertificateTypeSelect();
            selectCertificateType();
        },
        deleteCertificates: function () {
            deleteCertificateType();
        },



    };
}();
