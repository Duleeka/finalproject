
var UserRegister=function () {

    var runUserRoleSelect = function () {
        $("#userRole").select2({
            placeholder: "Select Specific User Role",
            allowClear: true,
        });
    }

    var runValidator = function () {
        var form = $('#assetCategoryAddForm');
        var errorHandler = $('.errorHandler', form);
        var successHandler = $('.successHandler', form);

        $('#frm_userregister').validate(
            {
                errorElement : "span", // contain the error msg in a span tag
                errorClass : 'help-block',
                errorPlacement : function(error, element) { // render error placement for each input type
                    if (element.attr("type") == "radio" || element.attr("type") == "checkbox" ) { // for chosen elements, need to insert the error after the chosen container
                        error.insertAfter($(element).closest('.form-group').children('div').children().last());
                    } else if (element.attr("name") == "dd" || element.attr("name") == "mm" || element.attr("name") == "yyyy" || element.closest('.input-group').has('.input-group-btn').length || element.closest('.form-group').has('.input-group-addon').length) {
                        error.insertAfter($(element).closest('.form-group').children('div'));
                    } else if (element.closest('.form-group').has('.select2').length ){
                        error.insertAfter($(element).closest('.form-group').children('span'));
                    } else {
                        error.insertAfter(element);
                        // for other inputs, just perform default behavior
                    }
                },
                ignore : "",

                rules :
                    {
                        username: {
                            required: true,
                            minlength: 2
                        },
                        role: {
                            required: true,
                        },
                        password : {
                            required : true,
                            minlength: 8
                        },
                        password: {
                            required: true,
                            minlength: 8
                        },
                        email :{
                            minlength: 2
                        },
                        messages : {
                            username: {
                                required: "Please Specify User Name",
                                minlength: "Min Length is 2"

                            },
                            role: {
                                required: "Please Specify Uer Role"

                            },
                            password : {
                                required: "Please Enter Valid Password",
                                minlength: "Min Length is 8"
                            },
                            password: {
                                required: "Confirm Password",
                                minlength: "Min Length is 8"
                            },
                            email :{
                                minlength: 2,
                                email : "Enter Valid Email"
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

    };
    return {
        init: function () {
            runValidator();
            runUserRoleSelect();
        }
    };
}();
