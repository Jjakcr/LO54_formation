/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jean- Jacques
 */

/*correction bug datepicker */
function datePickBug() {
    var datepick = document.getElementsByClassName('datepicker-orient-bottom');

    var top = datepick[0].offsetTop + 20;
    datepick[0].style.top = top + 'px';
}

function returnValue(link){
   var id = link.value;
   document.getElementById('idSess').value=id;
   var text = document.getElementById('title'+id).innerHTML;
   document.getElementById('myModalLabel').innerHTML = "Subcribe to "+ text;
}
