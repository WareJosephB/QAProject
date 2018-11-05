function generatePlayers() {
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8181/MultiplayerELO/access/player/getAll", false);
	xmlHttp.send(null);
	
	var players = eval(xmlHttp.response);
	var totalPlayers = array.length;

	var gamePlayers = document.getElementById("numberOfPlayers").value;
	
	for(var j = 0; j< gamePlayers; j++){
		field = "<select  id=\"player" + j + "\" name= \"Placed" + j + "\">";
	
		for (var i = 0; i < totalPlayers; i++) {
			var player = players[i];
			field += "<option value=\"" + player.id + "\">" + player.name + "</option>";
		}
	
		field+="</select>";

	document.getElementById("playerfields").innerHTML += field; 
	}
	
}

function addGame() {
	
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8181/MultiplayerELO/access/player/getAll", false);
	xmlHttp.send(null);
	var players = eval(xmlHttp.response);
	var totalPlayers = array.length;


	var game = CREATE GAME HERE

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("POST", "http://localhost:8181/MultiplayerELO/access/game/add", false);
	xmlHttp.setRequestHeader('Content-Type', 'application/json');
	xmlHttp.send(JSON.stringify(game));
}
	
	
	
	