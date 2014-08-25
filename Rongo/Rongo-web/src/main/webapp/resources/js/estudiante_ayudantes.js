

var params = "";

function getUrlVars(){
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}

function init(){
    params = getUrlVars();
    $("#ayudantia").html(decodeURI(params["ayudantia"]).replace(/\+/g,' '));
    $("#ayudante-de").html(decodeURI(params["ayudantia"]).replace(/\+/g,' '));
}

window.onload = init();


