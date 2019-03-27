var CitizenAsset = function () {

    var runWaterFacilitySwitch = function () {
        $('#water_facility').bootstrapToggle();
    }

    var runElectricitySwitch = function () {
        $('#electricity').bootstrapToggle();
    }

    var runToiletFacilitySwitch = function () {
        $('#toilet_facility').bootstrapToggle();
    }

    /*START SELECT2*/
    var runHouseholderIdSelect=function () {
        $("#hh_no").select2({
            placeholder : "Select a Householder No",
            allowClear : true,
        });
    }

    var runLandNameSelect = function () {
        $("#land_name").select2({
            placeholder: "Select Specific Land Name",
            allowClear: true,
        });
    }

    var runLandTypeSelect = function () {
        $("#land_type").select2({
            placeholder: "Select Specific Land type ",
            allowClear: true,
        });
    }
    var runHouseOwnershipSelect = function () {
        $("#house_own").select2({
            placeholder: "Select Specific Ownership Type ",
            allowClear: true,
        });
    }
    var runHouseTypeSelect = function () {
        $("#house_type").select2({
            placeholder: "Select Specific House Type ",
            allowClear: true,
        });
    }
    var runRoofTypeSelect = function () {
        $("#roof_type").select2({
            placeholder: "Select Specific Roof Type ",
            allowClear: true,
        });
    }
    var runWallTypeSelect = function () {
        $("#wall_type").select2({
            placeholder: "Select Specific Wall Type ",
            allowClear: true,
        });
    }


    /*END SELECT2*/

    var runValidator = function () {
        var form = $('#assetCategoryAddForm');
        var errorHandler = $('.errorHandler', form);
        var successHandler = $('.successHandler', form);

        $('#frm_citizenasset').validate(
            {
                errorElement: "span", // contain the error msg in a span tag
                errorClass: 'help-block',
                errorPlacement: function (error, element) { // render error placement for each input type
                    if (element.attr("type") == "radio" || element.attr("type") == "checkbox") { // for chosen elements, need to insert the error after the chosen container
                        error.insertAfter($(element).closest('.form-group').children('div').children().last());
                    } else if (element.attr("name") == "dd" || element.attr("name") == "mm" || element.attr("name") == "yyyy" || element.closest('.input-group').has('.input-group-btn').length || element.closest('.form-group').has('.input-group-addon').length) {
                        error.insertAfter($(element).closest('.form-group').children('div'));
                    } else if (element.closest('.form-group').has('.select2').length) {
                        error.insertAfter($(element).closest('.form-group').children('span'));
                    } else {
                        error.insertAfter(element);
                        // for other inputs, just perform default behavior
                    }
                },
                ignore: "",

                rules:
                    {
                        householderId: {
                            required: true
                        },
                        landAssetType: {
                            required: true
                        },
                        assetStatus: {
                            minlength: 2
                        },

                        houseOwnership: {
                            required: true

                        },
                        /*houseType: {
                            required: true
                    },*/
                        assetDescription: {
                            minlength: 2
                        },
                        /*mainCultivation: {
                            required: true
                        },*/
                messages: {
                    householderId: {
                        required: "Please Select Householder Id"
                    },
                    landAssetType: {
                        required: "Please Specify a Land Type"
                    },
                    assetStatus: {
                        minlength: "Min Length is 2"
                    },
                    houseOwnership: {
                        required: "Please Specify a Ownership Type"
                    },
                    /*houseType: {
                        required: "Please Specify a Ownership Type"
                    },*/
                    assetDescription: {
                        minlength: "Min Length is 2"
                    },
                    /*mainCultivation: {
                        required: "Please Specify a Main Cultivation"
                    },*/
                },

                    invalidHandler: function (event, validator) { //display error alert on form submit
                        successHandler.hide();
                        errorHandler.show();
                    },
                    highlight: function (element) {
                        $(element).closest('.help-block').removeClass('valid');
                        // display OK icon
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error').find('.symbol').removeClass('ok').addClass('required');
                        // add the Bootstrap error class to the control group
                    },
                    unhighlight: function (element) { // revert the change done by hightlight
                        $(element).closest('.form-group').removeClass('has-error');
                        // set error class to the control group
                    },
                    success: function (label, element) {
                        label.addClass('help-block valid');
                        // mark the current input as valid and display OK icon
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success').find('.symbol').removeClass('required').addClass('ok');
                    },

                    submitHandler: function (form) {
                        successHandler.show();
                        errorHandler.hide();
                        // submit form
                        return true;
                    }
                }
                    });

        /*     jQuery.validator.setDefaults({
                 debug: true,
                 success: "valid"
             });
             $( "#frm_citizendetail" ).validate({
                 rules: {
                     citizenInitials: {
                         required: true
                     }
                 }
             });*/

    };
    return {
        init: function () {
            runHouseholderIdSelect();
            runLandNameSelect();
            runLandTypeSelect();
            runHouseOwnershipSelect();
            runHouseTypeSelect();
            runWallTypeSelect();
            runRoofTypeSelect();
            runValidator();
            runWaterFacilitySwitch();
            runElectricitySwitch();
            runToiletFacilitySwitch();
        }
    };
}();
