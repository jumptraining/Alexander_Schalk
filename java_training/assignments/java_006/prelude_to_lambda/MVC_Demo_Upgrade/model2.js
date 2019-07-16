var Model = (function() {	//not modified

	var data = [];
	var widgets = [];
	var scope;
	var view;

	var constructor = function() {	//not modified
		this.Add = (item) => {	//removed 'function', arrow added
			data.push(item);
			this.refreshWidgets(view, this);
		};
		
		this.Delete = (val) => {	//removed 'function', arrow added
			var itemIdx = data.indexOf(val);
			data.splice(itemIdx, 1);
			this.refreshWidgets(view, this);
		
		};

		this.notDuplicate = (val) => {	//removed 'function', arrow added
			result = false;
			if(this.getData().indexOf(val) == -1) {
				result = true;
			}
			return result;
		}

		this.getData = () => data;	//removed 'function' and {} and return, arrow added
		
		this.getCount = () => data.length;	//removed 'function' and {} and return, arrow added
		
		this.setScope = (s) => scope = s;	//removed 'function' and {} and return, arrow added
		
		this.setView = (v) => view = v;	//removed 'function' and {} and return, arrow added
		
		// expect view to have it's refresh method
		this.registerWidget = (widget) => widgets.push(widget);	//removed 'function', arrow added
		
		this.refreshWidgets = (mainview, model) => {	//removed 'function', arrow added
			// will loop if any views are around and invoke their refresh method
			var x; l = widgets.length;
			if(l) {
				for(x = 0; x < l; x++) {
					widgets[x].refresh.apply(widgets[x], [mainview, scope, model]);
				}
			}		
		};
		
		// for testing content in console.log();
		this.toString = () => data.split(",");	//removed 'function' and {} and return, arrow added
		
	};
	
	return new constructor();
	
});