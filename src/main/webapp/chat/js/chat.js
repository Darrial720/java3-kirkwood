let wsProtocol = window.location.protocol === "https:" ? "wss://" : "ws://";

const wsUri = wsProtocol + document.location.host + document.location.pathname + "endpoint";
const websocket = new WebSocket(wsUri);

websocket.onopen = function(){
    console.log("open websocket: " + wsUri);
}

websocket.onclose= function(){

}

websocket.onmessage= function(){

}

websocket.onerror= function(){
    const errorText = document.getElementById("errorText")
    errorText.innerHTML("Error: " + event.data);
}