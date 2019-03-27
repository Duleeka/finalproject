var CertificateDetail = function () {


    var runCertificateNoSelect = function () {
        $("#certificate_no").select2({
            placeholder: "Select Specific Certificate No",
            allowClear: true,
        });
    }

    var runCertificateTypeSelect = function () {
        $("#certificate_type").select2({
            placeholder: "Select Specific Certificate Type",
            allowClear: true,
        });
    }

    var runNICSelect = function () {
        $("#nic").select2({
            placeholder: "Select NIC",
            allowClear: true,
        });
    }


    var runValidator = function () {
        var form = $('#assetCategoryAddForm');
        var errorHandler = $('.errorHandler', form);
        var successHandler = $('.successHandler', form);

        $('#frm_certificatedetail').validate(
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
                        certificateId: {
                            required: true
                        },
                        certificateType: {
                            required: true
                        },
                        citizenId: {
                            required: true
                        },
                        certificateIssuedDate: {
                            required: true
                        },
                        cdDescription: {
                            minlength: 2
                    },
                messages: {
                    certificateId: {
                        required: "Please Select Certificate Id"
                    },
                    certificateType: {
                        required: "Please Specify a Certificate Type"
                    },
                    citizenId: {
                        required: "Please Specify a NIC"
                    },
                    certificateIssuedDate: {
                        required: "Please Specify a Issued Date"
                    },
                    cdDescription: {
                        minlength: "Min Length is 2"
                    }
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
            runCertificateNoSelect();
            runCertificateTypeSelect();
            runNICSelect();
            runValidator();
        }
    };
}();
