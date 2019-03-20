function statusChange(cb) {
  /*  display("Clicked, new value = " + cb.checked);*/
   // document.getElementById("place").setAttribute("disabled", !cb.value);

   /* if(cb.value){
        $("#place").prop("disabled",false );
    }else{
        $("#place").prop("disabled",true );
    }
    console.log(cb.value)*/
}
$('#status2').change(function () {
     if(this){
      $("#place").prop("disabled",false );
  }else{
      $("#place").prop("disabled",true );
  }
  console.log(this)
});
