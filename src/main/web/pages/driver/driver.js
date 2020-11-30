function addInputLine() {
    var inputLine = $($(".baseInfo")[0]).html();
    //console.log(inputLine);
    $($(".inputLineContainer")[0]).append(inputLine);
}
function displayTable(tableId) {
    // let table = $("#memberMeetingId");
    let table = $("#"+tableId);
    if(table.css('display')==='none')
        table.fadeIn("slow");
    else
        table.fadeOut("slow");
}