/**
 * Created by hp on 3/21/2019.
 */
jQuery(document).ready(function() {


    $(function () {
        $(".date").datetimepicker({
            Default: true
        })
    });
    $(document).ready(function(){
        DiaryLog.init();

    });

});
