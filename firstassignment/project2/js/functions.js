window.onload = init;

//these variables are used to count correctly matched terms
var b = 0;
b++;
	
//inside the init function are functions that control a timer
//and allow it be displayed in a hh:mm:ss format
//the timer displays correct up until the count reaches 600 (10 minutes)
//there is a four state button that controls the timer as well as displays the appropriate score message when clicked
function init() {

    var btn = document.getElementById("timerControl");
    var state = "start";
    var display = document.getElementById("timerDisplay");
    var timerId;
    var timeShown;
	
    function timer() {

        function start() {

            var count = 0;

            function showTime() {
                count++;
				if(count > 59) {
					if(count%60 > 9) {
						timeShown = "00:0" + Math.floor(count/60) + ":" + count%60;
					} else {
						timeShown = "00:0"  + Math.floor(count/60) + ":0" + count%60;
					}
				} else if (count > 9) {
					timeShown = "00:00:" + count;
				} else {
					timeShown = "00:00:0" + count;
				}
                display.innerHTML = timeShown;
            }

            timerId = setInterval(showTime, 1000);

        }

        function end() {

            display.innerHTML = "Timer stopped!";
            clearInterval(timerId);

        }


        if (state == "start") {
            state = "end";
            btn.innerHTML = "End";
            start();
        } else if (state == "end") {
            state = "showscore";
            btn.innerHTML = "Show Score";
            end();
        } else if (state == "showscore") {
            state = "playAgain";
			btn.innerHTML = "Play Again";
        } else if (state == "playAgain"){
			state == "end";
			btn.innerHTML = "End";
			start();
		}

    }

    btn.addEventListener("click", timer, false);
    btn.addEventListener("click", submit001, false);	
	
	    function submit001() {
        if (state == "playAgain") {
			if (b === 6) {
				message001.innerHTML = "Perfect score!";
			} else if (b > 0) {
                message001.innerHTML = ((b - 1) === 1) ? "You got " + (b - 1) + " answer correct!" : "You got " + (b - 1) + " answers correct!";
            }
        }
    }
}

//various drag and drop functions determine which terms are allowed to be dropped
//and the text of each term replaces 'Drag and Drop Here' when dragged over the correct space
//functions drop002 - drop005 and allowDrop001 - allowDrop005 were redundant and removed
//attempts to create a dragStart999 and drop999 function for all the terms to enable dragging and dropping over any space were not successful 
    function drop001(event) {
        event.preventDefault();
    }
	
    function allowDrop001(event) {
        event.preventDefault();
    }
	
    function dragStart001(event) {
        event.dataTransfer.setData("choice001", event.target.id);
    }

    function dragStart002(event) {
        event.dataTransfer.setData("choice002", event.target.id);
    }

    function dragStart003(event) {
        event.dataTransfer.setData("choice003", event.target.id);
    }

    function dragStart004(event) {
        event.dataTransfer.setData("choice004", event.target.id);
    }

    function dragStart005(event) {
        event.dataTransfer.setData("choice005", event.target.id);
    }
/*
	function dragStart999(event) {
        event.dataTransfer.setData("choice999", event.target.id);
    }

	function drop999(event) {
		//event.preventDefault();
		var data = event.dataTransfer.getData("choice999");
		event.target.appendChild(document.getElementById(data));
		score001.innerHTML = b++;
		
		var term = document.getElementById(id).innerHTML;
		document.getElementById(id).innerHTML = term;
	}
*/
    function drop006(event) {
        var data = event.dataTransfer.getData("choice001");
        event.target.appendChild(document.getElementById(data));
        score001.innerHTML = b++;
        //place001.innerHTML = "FIRST TERM";
		
		var term = document.getElementById("target001").innerHTML;
		document.getElementById("place001").innerHTML = term;
    }

    function drop007(event) {
        var data = event.dataTransfer.getData("choice002");
        event.target.appendChild(document.getElementById(data));
        score001.innerHTML = b++;
        //place002.innerHTML = "SECOND TERM";
		
		var term = document.getElementById("target002").innerHTML;
		document.getElementById("place002").innerHTML = term;
    }

    function drop008(event) {
        var data = event.dataTransfer.getData("choice003");
        event.target.appendChild(document.getElementById(data));
        score001.innerHTML = b++;
        //place003.innerHTML = "THIRD TERM";
		
		var term = document.getElementById("target003").innerHTML;
		document.getElementById("place003").innerHTML = term;
    }

    function drop009(event) {
        var data = event.dataTransfer.getData("choice004");
        event.target.appendChild(document.getElementById(data));
        score001.innerHTML = b++;
        //place004.innerHTML = "FOURTH TERM";
    
		var term = document.getElementById("target004").innerHTML;
		document.getElementById("place004").innerHTML = term;
	}

    function drop010(event) {
        var data = event.dataTransfer.getData("choice005");
        event.target.appendChild(document.getElementById(data));
        score001.innerHTML = b++;
        //place005.innerHTML = "FIFTH TERM";
		
		var term = document.getElementById("target005").innerHTML;
		document.getElementById("place005").innerHTML = term;
    }