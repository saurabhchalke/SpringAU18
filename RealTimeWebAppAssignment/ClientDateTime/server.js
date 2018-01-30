var express = require('express'),
app = express(),
server = require('http').createServer(app),
io = require('socket.io').listen(server),
nicknames = [];
 
server.listen(3001);
 

app.get('/', function(req, res){
res.sendFile(__dirname + '/chat.html');
});
 
var timer =new Date();  
setInterval(function() {  
  	timer.setSeconds(timer.getSeconds() + 1);
  io.sockets.emit('timer', timer);
}, 1000);

io.sockets.on('connection', function (socket) {
	
  socket.on('reset', function (data) {
    timer = new Date();
    io.sockets.emit('timer', timer);
  });
  socket.on('changeTime', function (data) {
    timer = new Date(data);
  });
  
});