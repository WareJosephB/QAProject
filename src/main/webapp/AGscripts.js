function generatePlayerFields() {
	document.getElementById("playerFields").innerHTML = "";
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8181/MultiplayerELO/access/Players/get", false);
	xmlHttp.send(null);
	var players = eval(xmlHttp.response);
	
	var totalPlayers = players.length;
	
	var field =  "";
	
	for (var i = 0; i < totalPlayers; i++) {
		var player = players[i];
		field += "<option value="+player.id+">"+player.name+"</option>";
	}
	field += "</select>";
	
	var gamePlayers = document.getElementById("players").value;
	
	for (var m = 0; m < gamePlayers; m++){
		document.getElementById("playerFields").innerHTML += "<select id = player"+m+"> +field +"<br>";
	}
}

function addGame(){
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8080/api-0.0.1-SNAPSHOT/api/movie/addMovie", false);
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.send(JSON.stringify({
		P: getPrelude(),
		C: getCorporate(),
		V: getVenus(),
		map: getMap(),
}));
	
}