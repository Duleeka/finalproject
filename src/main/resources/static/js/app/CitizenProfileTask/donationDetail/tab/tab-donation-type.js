var DonationDetailTab=function () {




    var runDonationTypeSelect=function () {
        $("#donation_type").select2({
            placeholder : "Select A Donation Type",
            allowClear : true,
        });
    }
    var selectDonationType=function () {
        $('#donation_type').on("select2:select", function(e) {
            var value = e.currentTarget.value;
            var text = e.currentTarget.textContent;
            addDataTotable(value,text)
        });
    }
 var addDataTotable=function (value,text) {
     var obj={
         id:"",
         version:"",
         index:donationTypeList.length-1,
         donationRegisterId:value,
         donationType:text
     }
     donationTypeList.push(obj)
     populateTable()
 }
 var populateTable=function () {
     if(donationTypeList.length>0){
         var donationType,row;
         for(row=0;row<donationTypeList.length;row++){
             donationType=donationTypeList[row];
             var html="<tr>"+
                 "<input type='hidden' name='donationRegisterDTOS["+row+"].id' value='"+donationType.id+"'>"+
                 "<input type='hidden' name='donationRegisterDTOS["+row+"].version' value='"+donationType.version+"'>"+
                 "<input type='hidden' name='donationRegisterDTOS["+row+"].donationRegisterId' value='"+donationType.donationRegisterId+"'>"+
                 "<td>"+(row+1)+"</td>"+
                 "<td>"+donationType.donationType+"</td>"+
                 "<td></td>"+
                 "</tr>";
             $("#tbl_donation_tab > tbody:last-child").append(html);

         }
     }
 }



    return {
        init: function () {
            runDonationTypeSelect();
            selectDonationType();
        }
    };
}();
