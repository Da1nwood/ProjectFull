var s = require('net').Socket();
s.connect(1488, 'localhost');
var array = [];
    s.on('data', function (d) {
        array.push(d.toString())
        foo()
    });
    function foo(){
setTimeout(function () {
    console.log(array)
},2000);
}
// s.write('GET http://www.google.com/ HTTP/1.1\n\n');
// var WebSocket = require('ws')
// var socket = new WebSocket("ws://localhost/1449");
// socket.onopen = function() {
//     console.log(1);
// };
//
// socket.onclose = function(event) {
//     if (event.wasClean) {
//         console.log('Соединение закрыто чисто');
//     } else {
//         console.log('Обрыв соединения'); // например, "убит" процесс сервера
//     }
//     console.log('Код: ' + event.code + ' причина: ' + event.reason);
// };
//
// socket.onmessage = function(event) {
//     console.log("Получены данные " + event.data);
// };
//
// socket.onerror = function(error) {
//     console.log("Ошибка " + error.message);
// };