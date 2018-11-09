function generatePlayerFields() {
	document.getElementById("playerFields").innerHTML = "";

	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8181/MultiplayerELO/access/Players/get", false);
	xmlHttp.send(null);
	var players = eval(xmlHttp.response);

	var totalPlayers = players.length;

	var field =  "";

	var places = ["1st", "2nd", "3rd", "4th", "5th"];

	var selectList = document.createElement("select");



	// for (var i = 0; i < totalPlayers; i++) {
	// 	var player = players[i];
	// 	field += "<option value="+player.id+">"+player.name+"</option>";
	// }
	// field += "</select>";

for (var j = 0; j < gamePlayers; j ++){
	document.getElementById("playerFields").innerHTML.appendChild(selectList);
	selectList.id = "player" + j;
	for (var i = 0; i < totalPlayers; i++) {
	    var playerOption = document.createElement("option");
	    playerOption.value = i;
	    playerOption.text = array[i].name;
	    selectList.appendChild(option);
	}
}
// 	var gamePlayers = document.getElementById("players").value;
//
// 	for (var m = 0; m < gamePlayers; m++){
// 		document.getElementById("playerFields").innerHTML += "<select id = player"+m+"> +field +"<br>";
// 	}
// }

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
