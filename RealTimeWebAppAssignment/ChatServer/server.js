var express = require('express'),
app = express(),
server = require('http').createServer(app),
io = require('socket.io').listen(server),
nicknames = [];
userSockets = {};

server.listen(3001);
 
app.get('/', function(req, res){
res.sendFile(__dirname + '/chat.html');
});
 
io.sockets.on('connection', function(socket){
socket.on('new user', function(data, callback){
if(nicknames.indexOf(data) != -1){
callback(false);
} else{
socket.nickname = data;
nicknames.push(socket.nickname);
userSockets[socket.nickname] = socket;
io.sockets.emit('usernames', nicknames);
callback(true);
updateNicknames();
}
});
 
function updateNicknames(){
io.sockets.emit('usernames', nicknames);
}
 
socket.on('send message', function(data){
    
let nick = data.to;
data.from = socket.nickname;
console.log(data);
//io.sockets.emit('new message', {msg: data.msg, nick: socket.nickname});

if(userSockets[nick]!=undefined){
    let s = userSockets[nick];
    console.log(data);
    s.emit('new message',data);
}
});
 
socket.on('disconnect', function(data){
if(!socket.nickname) return;
nicknames.splice(nicknames.indexOf(socket.nickname), 1);
updateNicknames();
});
})