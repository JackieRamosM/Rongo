/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function init() {
    $(".outterButton").click(function(){
        $(".nuevo-supervisor").fadeIn();
    });
    $(".hEdit").click(function(){
        $("#edit-" + $(this).attr('id')).fadeIn();
    });
}

window.onload = init;