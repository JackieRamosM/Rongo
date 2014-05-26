/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function validate(){
    var wrong = [];
    var user = document.getElementById('user').value;
    if (user===null || user==="") {
        wrong[wrong.length] = "user";
    }
    var password = document.getElementById('password').value;
    if (password===null || password==="") {
        wrong[wrong.length] = "password";
    }
    if(wrong.length > 0) {
        wrong.forEach(function(entry) {
            document.getElementById(entry).style.backgroundColor = "rgb(255,113,113)";
        });
    }
    return false;
}

