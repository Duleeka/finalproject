var DeathCitizenDetails = function () {

    var runDeathSwitch = function () {
        $('#dead_status').bootstrapToggle();
    }
    var runDeathSwitchToggleWithDeathTab = function () {
        $('#dead_status').change(function () {
            $("#place").prop("disabled", $(this).prop('checked'));
            $("#datetimepicker2").prop("disabled", $(this).prop('checked'));
            $("#death_reason").prop("disabled", $(this).prop('checked'));

        })
    }

/*START SELECT2*/

    var runRelationshipSelect = function () {
        $("#relationship").select2({
            placeholder: "Select a Relationship",
            allowClear: true,
        });
    }

    var runGenderSelect = function () {
        $("#gender").select2({
            placeholder: "Select",
            allowClear: true,
        });
    }

    var runMaritalStatusSelect = function () {
        $("#marital_status").select2({
            placeholder: "Select",
            allowClear: true,
        })
    }

    var runGnDivisionSelect = function () {
        $("#div_name").select2({
            placeholder: "Select a Gn Division",
            allowClear: true,
        })
    }

    var runBirthDistrictSelect = function () {
        $("#birth_place").select2({
            placeholder: "Select A Birth District",
            allowClear: true,
        })
    }

    var runPreviousResidentialAreaSelect = function () {
        $("#residence_area").select2({
            placeholder: "Select Previous Residential Area",
            allowClear: true,
        })
    }
    var runEducationLevelSelect = function () {
        $("#edu_level").select2({
            placeholder: "Select Highest Education Level",
            allowClear: true,
        })
    }

    var runNationalitySelect = function () {
        $("#nationality").select2({
            placeholder: "Select a Nationality Type",
            allowClear: true,
        })
    }

    var runReligionSelect = function () {
        $("#religion").select2({
            placeholder: "Select a Religion Type",
            allowClear: true,
        })
    }

 /*END SELECT2*/


    var runValidator = runDeathSwitch = function () {
        var form = $('#assetCategoryAddForm');
        var errorHandler = $('.errorHandler', form);
        var successHandler = $('.successHandler', form);

        $('#frm_citizendetail').validate(
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
/*START VALIDATION*/
                },
                ignore: "",

                rules:
                    {
                        citizenFamilyNo: {
                            minlength: 2,
                            required: true
                        },
                        citizenInitials: {
                            minlength: 2

                        },
                        citizenFirstName: {
                            minlength: 2
                        },
                        citizenMiddleName: {
                            minlength: 2

                        },
                        citizenLastName: {
                            minlength: 2

                        },
                        nic: {
                            minlength: 2,
                            required: true
                        },
                        citizenDateOfBirth: {
                            date: true,
                            required: true
                        },
                        citizenGender: {
                            required: true
                        },
                        maritalStatus: {
                            required: true
                        },
                        phoneNumber: {
                            minlength: 2,
                            required: true

                        },
                        citizenEmailAddress: {
                            minlength: 2,
                            required: true,
                            email: true
                        },
                        citizenGnDivision: {
                            required: true
                        },
                        citizenBirthDistrict: {
                            required: true
                        },
                        citizenAddress: {
                            required: true,
                            minlength: 2,
                            address: true
                        },
                        previousResidentialArea: {
                            minlength: 2
                        },
                        reasonToChangeResidentialArea: {
                            minlength: 2
                        },
                        nationalityId: {
                            required: true
                        },
                        religionId: {
                            required: true
                        },
                        citizenOccupation: {
                            minlength: 2,
                            occupation: true
                        },
                        citizenIncome: {
                            minlength: 2,
                            number: true
                        },
                        deathPlace: {
                            minlength: 2,
                            required: true
                        },
                        deathReason: {
                            minlength: 2,
                            required: true
                    },
                messages: {
                    citizenFamilyNo: {
                        minlength: "Min Length is 2",
                        required: "Please Specify Householder No"
                    },
                    citizenInitials: {
                        minlength: "Min Length is 2"

                    },
                    citizenFirstName: {
                        minlength: "Min Length is 2"

                    },
                    citizenMiddleName: {
                        minlength: "Min Length is 2"

                    },
                    citizenLastName: {
                        minlength: "Min Length is 2"

                    },
                    nic: {
                        minlength: "Min Length is 2",
                        required: "Please Specify Valid NIC No"
                    },
                    citizenDateOfBirth: {
                        required: "Please Specify Valid Data of Birth"
                    },
                    citizenGender: {
                        required: "Please Specify Citizen Gender"
                    },
                    maritalStatus: {
                        required: "Please Specify a Marital Status"
                    },
                    phoneNumber: {
                        minlength: "Min Length is 2",
                        required: "Please Specify a Phone Number"
                    },
                    citizenEmailAddress: {
                        required: "Please Enter Valid Email Address",
                        minlength: "Min Length is 2"
                    },
                    citizenGnDivision: {
                        required: "Please Select A Gn Division"
                    },
                    citizenBirthDistrict: {
                        required: "Please Select A Birth District"
                    },
                    citizenAddress: {
                        minlength: "Min Length is 2",
                        required: "Please Enter Citizen Address"
                    },
                    previousResidentialArea: {
                        minlength: "Min Length is 2"
                    },
                    reasonToChangeResidentialArea: {
                        minlength: "Min Length is 2"
                    },
                    nationalityId: {
                        required: "Please Select Nationality Type"
                    },
                    religionId: {
                        required: "Please Select Religion"
                    },
                    citizenOccupation: {
                        minlength: "Min Length is 2"
                    },
                    citizenIncome: {
                        minlength: "Min Length is 2"
                    },
                    deathPlace: {
                        minlength: "Min Length is 2",
                        required: "Please Enter Death Place"
                    },
                    deathReason: {
                        minlength: "Min Length is 2",
                        required: "Please Enter Reason"
                    }
                },
 /*START VALIDATION*/

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
            }});
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

    }
    return {
        init: function () {
            runDeathSwitch();
            runDeathSwitchToggleWithDeathTab();
            runRelationshipSelect();
            runGenderSelect();
            runMaritalStatusSelect();
            runGnDivisionSelect();
            runBirthDistrictSelect();
            runPreviousResidentialAreaSelect();
            runEducationLevelSelect();
            runNationalitySelect();
            runReligionSelect();
            runValidator()
        }
    };
}();
