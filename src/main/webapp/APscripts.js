function addPlayer() {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "http://localhost:8181/MultiplayerELO/access/Players/add", false);
		xmlHttp.setRequestHeader('Content-Type', 'application/json');
		xmlHttp.send(JSON.getJSONForObject({
			name: getName(),
			ELO: getELO(),
		}));
}

function getName() {
		return document.getElementById("newName").value;
}

function getELO() {
		return document.getElementById("initELO").value;
}