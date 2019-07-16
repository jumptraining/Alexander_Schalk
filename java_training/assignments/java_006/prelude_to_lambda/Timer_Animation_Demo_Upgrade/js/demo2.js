/**
 * @param {string} title -	JavaScript Demo (DMJS)
 * @param {string} author - Claude Gauthier
 * @param {string} email -	claude_r_gauthier@hotmail.com
 * @param {string} date -	2013-12-10
 * 
 */
(function(window) { //not modified
	var	document = window.document,
		core_version = "0.1",
		isReady = false,
		launchFn,
		calcXY = (anchor, obj, container) => {	//removed 'function', arrow added
			var getEnd = (cont, obj) => cont - obj;	//removed 'function' and {} and return, arrow added
			var objW = obj.clientWidth,
				objH = obj.clientHeight,
				contW = container.clientWidth,
				contH = container.clientHeight,
				x, y;
				
			switch(anchor) {
				case "tl":
					x = 0;
					y = 0;
				break;
				
				case "br":
				default:
					x = getEnd(contW, objW);
					y = getEnd(contH, objH);
				break;								
			}
			return {
				x: x,
				y: y
			}
		},
		calcAnimPath = (start, end) => {	//removed 'function', arrow added
			// based on Bresenham's line drawing algorithm
			var x0 = start.x, y0 = start.y,
				x1 = end.x, y1 = end.y,
				path = [], coord = {},
				dy = y1 - y0, dx = x1 - x0,
				d = 2 * dy - dx,
				x = x0, y = y0;
				
			while(x <= x1) {
				coord.x = x;
				coord.y = y;
				path.push($.cloneObject(coord));
				x++;
				if(d < 0) {
					d += dy + dy;
				} else {
					d += 2 * (dy - dx);
					y++;
				}
			}

			return path;
		},
		DMJS = {
			// info
			getVersion: () => core_version, //removed 'function' and {} and return, arrow added
			// ready
			ready: (fn) => launchFn = fn,	//removed 'function' and {} and return, arrow added
			getReadyState: () => isReady,	//removed 'function' and {} and return, arrow added
			// get will be set using NormalizeAPI()
			get: null,
			getBody: () => document.getElementsByTagName('body')[0],	//removed 'function' and {} and return, arrow added
			// addEvent and removeEvent will be set using normalizeAPI()
			addEvent: null,
			removeEvent: null,
			// various object inspection functions
			getConstructorName: (obj) => {	//removed 'function', arrow added
				if(obj == undefined || obj == null) {
					return null;
				}
				if(obj.constructor) {
					if(obj.constructor.name) {
						return obj.constructor.name.toLowerCase();
					} else {
						var temp = obj.constructor.toString().toLowerCase(),
							st = temp.indexOf('function ') + 9,
							en = temp.indexOf('(');
						return temp.substr(st, en - st);
					}
				}
			},
			isEmptyObject: (obj) => {	//removed 'function', arrow added
				for(var key in obj) {
					return false;
				}
				return true;
			},			
			isObjectType: (obj, type) => {	//removed 'function', arrow added
				var val = false;
				if(obj == undefined || obj == null) {
					return val;
				}				
				if($.getConstructorName(obj) == type) {
					val = true;
				}
				return val;				
			},
			// object type inspection		
			isArray: (obj) => $.isObjectType(obj, "array"),	//removed 'function' and {} and return, arrow added
			isString: (obj) => $.isObjectType(obj, "string"),	//removed 'function' and {} and return, arrow added
			isObject: (obj) => $.isObjectType(obj, "object"),	//removed 'function' and {} and return, arrow added		
			// clone Object
			cloneObject: function(obj) { //not modified
				if(obj == null || $.isObject(obj) == false) {
					return obj;
				}
				var returnObj = obj.constructor();
				for(key in obj) {
					returnObj[key] = this.cloneObject(obj[key]);
				}
				return returnObj;
			},
			// animation function returning an animation object with an interface		
			setAnimation: (obj) => { // removed 'function', arrow added
				if($.isEmptyObject(obj) || !obj.target || !obj.start || !obj.end) {
					return null;
				}
				var target = obj.target,
					container = $.getBody(),
					container = obj.container ? obj.container : container,
					start = obj.start,
					end = obj.end,
					startPos,
					endPos,
					path = [];
					
				if($.isArray(start)) {
					startPos = {
						x: start[0],
						y: start[1]
					};
				} else {
					if($.isString(start)) {
						startPos = calcXY(start, target, container);
					}
				}
				
				if($.isArray(end)) {
					endPos = {
						x: end[0],
						y: end[1]
					};
				} else {
					if($.isString(end)) {
						endPos = calcXY(end, target, container);
					}
				}				
				path = calcAnimPath(startPos, endPos);
				return (
					(animObj, animPath) => {	//removed 'function', arrow added

						var target = animObj,
							path = animPath,
							index = 0,
							timer,
							l = animPath.length,
							dir = l;
						
						var setPixelVal = (coord) => coord + "px";	//removed 'function' and {} and return, arrow added
						
						var setCoord = (path) => {	//removed 'function', arrow added
							target.style.left = setPixelVal(path.x);
							target.style.top = setPixelVal(path.y);
						};

						var show = () => {	//removed 'function', arrow added
							target.style.visibility = "visible";	
						};
						
						var anim = (index) => {	//removed 'function', arrow added
							setCoord(path[index]);
						};
						
						return {
							start: function() {	//not modified
								anim(index);
								show();
								this.resume();
							},
							resume: function() {	//not modified
								timer = setInterval(() => {	//removed 'function', arrow added
									if(index >= dir - 1) {
										dir = 0;
									}
									if(index <= 0) {
										dir = l;
									}
									if(dir == l) {
 										index = index + 1;
									} 
									if(dir == 0) {
										index = index - 1;
									}
									anim(index);
								}, 1); 
							},	
							pause: function() {	//not modified
								clearInterval(timer);
							}
						}
					}
				)(target, path)				
			},
			string: {
				format: () => {	//removed 'function', arrow added
					var l = arguments.length,
						str;
					if(l < 2) {
						return null;
					}
					str = arguments[0];
					for(x = l-1; x >= 1; x--) {
						str = str.replace(new RegExp('\\{' + (x - 1) + '\\}', 'gm'), arguments[x]);
					}
					return str;
				}
			}
		},
		initDMJS = function() { //not modified
			$.isReady = true;
			launchFn.call(DMJS);
		},
		/** in order to deal with cross browser issues
			i'm using feature detection in order to 
			assign proper functionality to the methods */
		normalizeAPI = () => {  //removed 'function', arrow added
			// set GET method
			// todo - normalize the element obj
			var getFn,
				addEventFn,
				removeEventFn;
				
			// giving precedence to document.all for Windows CE IE browsers
			if(document.getElementById) {
				getFn = (id) => document.getElementById(id);	//removed 'function' and {} and return, arrow added
			} else {
				if(document.all) {
					getFn = (id) => document.all[id];	//removed 'function' and {} and return, arrow added
				}				
			}
			DMJS.get = getFn;
			if(document.addEventListener) {
				addEventFn = (el, type, fn) => {	//removed 'function', arrow added
					el.addEventListener(type, fn, false);
					return fn;
				}
				
				removeEventFn = (el, type, fn) => {	//removed 'function', arrow added
					el.removeEventListener(type, fn, false);
				}
				
			} else {
				if(document.attachEvent) {
					addEventFn = (el, type, fn) => {	//removed 'function', arrow added
						var temp = () => fn.apply(el, arguments);	//removed 'function' and {} and return, arrow added
						el.attachEvent("on" + type, temp);
						return temp;
					}
					
					removeEventFn = (el, type, fn) => {	//removed 'function', arrow added
						el.detachEvent("on" + type, fn);
					}
				}
			}
			DMJS.addEvent = addEventFn;
			DMJS.removeEvent = removeEventFn;
		};
	
	normalizeAPI();
	
	if ( typeof window === "object" && typeof window.document === "object" ) {
		window.DMJS = window.$ = DMJS;
	}
	
	window.onload = initDMJS;
	
})(window);