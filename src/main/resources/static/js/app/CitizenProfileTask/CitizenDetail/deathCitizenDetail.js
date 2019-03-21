var DeathCitizenDetails=function () {

    var runDeathSwitch=function () {
        $('#dead_status').bootstrapToggle();
    }
    var runDeathSwitchToggleWithDeathTab=function () {
        $('#dead_status').change(function() {
            $("#place").prop("disabled",$(this).prop('checked') );

        })
    }
    var runRelationSelect=function () {
        $("#relationship").select2({
            placeholder : "Select a Relationship",
            allowClear : true,
        });
    }

    var runValidator=runDeathSwitch = function () {
        var form = $('#assetCategoryAddForm');
        var errorHandler = $('.errorHandler', form);
        var successHandler = $('.successHandler', form);

        $('#frm_citizendetail').validate(
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
                rules : {
                    citizenInitials : {
                        minlength : 2,
                        required : true
                    }
                },
                messages : {
                    citizenInitials :{
                        minlength:"Min Length is 2",
                        required:"Please Specify a Initials"
                    }
                },
                invalidHandler : function(event, validator) { //display error alert on form submit
                    successHandler.hide();
                    errorHandler.show();
                },
                highlight : function(element) {
                    $(element).closest('.help-block').removeClass('valid');
                    // display OK icon
                    $(element).closest('.form-group').removeClass('has-success').addClass('has-error').find('.symbol').removeClass('ok').addClass('required');
                    // add the Bootstrap error class to the control group
                },
                unhighlight : function(element) { // revert the change done by hightlight
                    $(element).closest('.form-group').removeClass('has-error');
                    // set error class to the control group
                },
                success : function(label, element) {
                    label.addClass('help-block valid');
                    // mark the current input as valid and display OK icon
                    $(element).closest('.form-group').removeClass('has-error').addClass('has-success').find('.symbol').removeClass('required').addClass('ok');
                },

                submitHandler : function(form) {
                    successHandler.show();
                    errorHandler.hide();
                    // submit form
                    return true;
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

    }
    return {
        init: function () {
            runDeathSwitch();
            runDeathSwitchToggleWithDeathTab();
            runRelationSelect();
            runValidator()
        }
    };
}();
