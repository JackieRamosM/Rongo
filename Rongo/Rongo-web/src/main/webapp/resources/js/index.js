/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(function() {
    var msie6 = $.browser == 'msie' && $.browser.version < 7;
    if (!msie6) {
        var top = $('nav').offset().top - parseFloat($('nav').css('margin-top').replace(/auto/, 0));
        $(window).scroll(function(event) {
            var y = $(this).scrollTop();
            if (y >= top) {
                $('nav').addClass('fixed');
            } else {
                $('nav').removeClass('fixed');
            }
        });
    }
});

function init() {
    $(".message h4").click(function() {
        $(this).parent().fadeOut(function() {
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
function getUrlParams() {
    var params = [], hash;
    var d = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for (var i = 0; i < d.length; i++)
    {
        hash = d[i].split('=');
        params.push(hash[0]);
        params[hash[0]] = hash[1];
    }
    return params;
}

window.onload = init;