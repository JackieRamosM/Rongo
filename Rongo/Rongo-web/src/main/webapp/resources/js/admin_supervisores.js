/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function init() {
    $(".outterButton").click(function(){
        $(".nuevo-supervisor").fadeIn();
    });
    $("#cancelarAdd").click(function(){
        $(".nuevo-supervisor").fadeOut();
    });
    $(".hEdit").click(function(){
        $("#edit-" + $(this).attr('id')).fadeIn();
    });
    $("#cancelarEdit").click(function(){
        $("#edit-" + $('.hEdit').attr('id')).fadeOut();
    });
}

window.onload = init;