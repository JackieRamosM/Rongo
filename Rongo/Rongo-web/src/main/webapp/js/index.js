/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function init(){
    $(".message h4").click(function(){
        $(this).parent().fadeOut(function(){
            $(this).remove();
        });
    });
    var params = getUrlParams();
    var ticket = params["ticket"];
    console.log(ticket);
    console.log(document.cookie.split(";"));
}


/*
* How to Get Url Parameters & Values using jQuery
* @source http://w3lessons.info/2013/02/25/how-to-get-url-parameters-values-using-jquery/
* @returns {getUrlParams.vars|Array}
*/
function getUrlParams(){
    var params = [], hash;
    var d = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < d.length; i++)
    {
        hash = d[i].split('=');
        params.push(hash[0]);
        params[hash[0]] = hash[1];
    }
    return params;
}

window.onload = init;