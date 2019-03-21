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

    return {
        init: function () {
            runDeathSwitch();
            runDeathSwitchToggleWithDeathTab();
            runRelationSelect();
        }
    };
}();
