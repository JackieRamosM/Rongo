PrimeFaces.widget.Panel=PrimeFaces.widget.BaseWidget.extend({init:function(a){this._super(a);this.header=this.jq.children("div.ui-panel-titlebar");this.title=this.header.children("span.ui-panel-title");this.content=$(this.jqId+"_content");this.onshowHandlers=this.onshowHandlers||{};this.bindEvents()},bindEvents:function(){if(this.cfg.toggleable){this.bindToggler()}if(this.cfg.closable){this.bindCloser()}this.header.find(".ui-panel-titlebar-icon").on("mouseover.panel",function(){$(this).addClass("ui-state-hover")}).on("mouseout.panel",function(){$(this).removeClass("ui-state-hover")})},toggle:function(){if(this.cfg.collapsed){this.expand();this.invokeOnshowHandlers()}else{this.collapse()}},expand:function(){this.toggleState(false,"ui-icon-plusthick","ui-icon-minusthick");if(this.cfg.toggleOrientation==="vertical"){this.slideDown()}else{if(this.cfg.toggleOrientation==="horizontal"){this.slideRight()}}},collapse:function(){this.toggleState(true,"ui-icon-minusthick","ui-icon-plusthick");if(this.cfg.toggleOrientation==="vertical"){this.slideUp()}else{if(this.cfg.toggleOrientation==="horizontal"){this.slideLeft()}}},slideUp:function(){this.content.slideUp(this.cfg.toggleSpeed,"easeInOutCirc")},slideDown:function(){this.content.slideDown(this.cfg.toggleSpeed,"easeInOutCirc")},slideLeft:function(){var a=this;this.originalWidth=this.jq.width();this.title.hide();this.toggler.hide();this.content.hide();this.jq.animate({width:"42px"},this.cfg.toggleSpeed,"easeInOutCirc",function(){a.toggler.show();a.jq.addClass("ui-panel-collapsed-h")})},slideRight:function(){var a=this,b=this.originalWidth||"100%";this.toggler.hide();this.jq.animate({width:b},this.cfg.toggleSpeed,"easeInOutCirc",function(){a.jq.removeClass("ui-panel-collapsed-h");a.title.show();a.toggler.show();a.content.css({visibility:"visible",display:"block",height:"auto"})})},toggleState:function(c,b,a){this.toggler.children("span.ui-icon").removeClass(b).addClass(a);this.cfg.collapsed=c;this.toggleStateHolder.val(c);this.fireToggleEvent()},fireToggleEvent:function(){if(this.cfg.behaviors){var a=this.cfg.behaviors.toggle;if(a){a.call(this)}}},close:function(){if(this.visibleStateHolder){this.visibleStateHolder.val(false)}var a=this;this.jq.fadeOut(this.cfg.closeSpeed,function(c){if(a.cfg.behaviors){var b=a.cfg.behaviors.close;if(b){b.call(a)}}})},show:function(){var a=this;$(this.jqId).fadeIn(this.cfg.closeSpeed,function(){a.invokeOnshowHandlers()});this.visibleStateHolder.val(true)},bindToggler:function(){var a=this;this.toggler=$(this.jqId+"_toggler");this.toggleStateHolder=$(this.jqId+"_collapsed");this.toggler.click(function(){a.toggle()})},bindCloser:function(){var a=this;this.closer=$(this.jqId+"_closer");this.visibleStateHolder=$(this.jqId+"_visible");this.closer.click(function(){a.close()})},addOnshowHandler:function(b,a){this.onshowHandlers[b]=a},invokeOnshowHandlers:function(){for(var b in this.onshowHandlers){if(this.onshowHandlers.hasOwnProperty(b)){var a=this.onshowHandlers[b];if(a.call()){delete this.onshowHandlers[b]}}}}});