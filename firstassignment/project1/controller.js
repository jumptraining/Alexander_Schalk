var Controller = (function() {

	var addButtonClickEvent = function(textTrigger, event) {

		var key = event.which || event.keyCode;
		var mouseEvent = null;
		
		//key 13 for Enter Button
		if (key === 13 || null) {

			var model = this;
			var value = textTrigger.value.trim();

			//test
			//var keyCode = event;
			//	debugger;						
			//added if statement
			//if (keyCode === 13) {
		//		//debugger;
	//			model.Add(value);
	//			textTrigger.value = null;
			//}

			if (value.length) {
				if (model.notDuplicate(value)) {
					//debugger;	
					model.Add(value);
					textTrigger.value = null;
				} else {
					alert("Duplicate Value");
				}
			}
		};
	};
	
	
    var deleteButtonClickEvent = function(event) {
        var model = this;
        if (event.target.type == "button") {
            model.Delete(event.target.value);
        }
    }
	
	var constructor = function() {
        var scopeEl;
        var model;
        var view;
        this.init = function(el, m, v) {
            scopeEl = el;
            model = m;
            view = v;
            model.setScope(el);
            model.setView(view);
            model.registerWidget(view.listView());
            model.registerWidget(view.summaryView());
            model.refreshWidgets(view, model);
            
			
			var addButton = view.triggerField().getButtonInstance(el);
          
			var textTrigger = view.triggerField().getTextInstance(el);
            addButton.addEventListener("click", addButtonClickEvent.bind(model, textTrigger));
 			//added lines
			//added lines of code:
			//commented lines were previously tested
			//var enter = view.triggerField().getKeyCode();
			//var enter = document.getElementById("myInput");
			//var addButton = view.triggerField().getButtonInstance(el);
            
			textTrigger.addEventListener("keyup", addButtonClickEvent.bind(model, textTrigger));
			//end          
			
			
            var listViewEl = scopeEl.getElementsByClassName('listWrapper')[0];
            listViewEl.addEventListener("click", deleteButtonClickEvent.bind(model));
			
			

        };
    };
    return new constructor();
})