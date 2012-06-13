/**
* 支持多选项标签
**/
;(function($) {
	function _1bf(_1c0, tab) {
		var w = 0;
		var b = true;
		$(">div.tabs-header ul.tabs li", _1c0).each(function() {
					if (this == tab) {
						b = false;
					}
					if (b == true) {
						w += $(this).outerWidth(true);
					}
				});
		return w;
	};
	function _1c1(_1c2) {
		var _1c3 = $(">div.tabs-header", _1c2);
		var _1c4 = 0;
		$("ul.tabs li", _1c3).each(function() {
					_1c4 += $(this).outerWidth(true);
				});
		var _1c5 = $(".tabs-wrap", _1c3).width();
		var _1c6 = parseInt($(".tabs", _1c3).css("padding-left"));
		return _1c4 - _1c5 + _1c6;
	};
	function _1c7(_1c8) {
		var _1c9 = $(">div.tabs-header", _1c8);
		var _1ca = 0;
		$("ul.tabs li", _1c9).each(function() {
					_1ca += $(this).outerWidth(true);
				});
		if (_1ca > _1c9.width()) {
			$(".tabs-scroller-left", _1c9).css("display", "block");
			$(".tabs-scroller-right", _1c9).css("display", "block");
			$(".tabs-wrap", _1c9).addClass("tabs-scrolling");
			if ($.boxModel == true) {
				$(".tabs-wrap", _1c9).css("left", 2);
			} else {
				$(".tabs-wrap", _1c9).css("left", 0);
			}
			var _1cb = _1c9.width()
					- $(".tabs-scroller-left", _1c9).outerWidth()
					- $(".tabs-scroller-right", _1c9).outerWidth();
			$(".tabs-wrap", _1c9).width(_1cb);
		} else {
			$(".tabs-scroller-left", _1c9).css("display", "none");
			$(".tabs-scroller-right", _1c9).css("display", "none");
			$(".tabs-wrap", _1c9).removeClass("tabs-scrolling").scrollLeft(0);
			$(".tabs-wrap", _1c9).width(_1c9.width());
			$(".tabs-wrap", _1c9).css("left", 0);
		}
	};
	function _1cc(_1cd) {
		var opts = $.data(_1cd, "tabs").options;
		var cc = $(_1cd);
		if (opts.fit == true) {
			var p = cc.parent();
			opts.width = p.width();
			opts.height = p.height();
		}
		cc.width(opts.width).height(opts.height);
		var _1ce = $(">div.tabs-header", _1cd);
		if ($.boxModel == true) {
			var _1cf = _1ce.outerWidth(true) - _1ce.width();
			_1ce.width(cc.width() - _1cf);
		} else {
			_1ce.width(cc.width());
		}
		_1c7(_1cd);
		var _1d0 = $(">div.tabs-panels", _1cd);
		var _1d1 = opts.height;
		if (!isNaN(_1d1)) {
			if ($.boxModel == true) {
				var _1cf = _1d0.outerHeight(true) - _1d0.height();
				_1d0
						.css("height", (_1d1 - _1ce.outerHeight() - _1cf)
										|| "auto");
			} else {
				_1d0.css("height", _1d1 - _1ce.outerHeight());
			}
		} else {
			_1d0.height("auto");
		}
		var _1d2 = opts.width;
		if (!isNaN(_1d2)) {
			if ($.boxModel == true) {
				var _1cf = _1d0.outerWidth(true) - _1d0.width();
				_1d0.width(_1d2 - _1cf);
			} else {
				_1d0.width(_1d2);
			}
		} else {
			_1d0.width("auto");
		}
		if ($.parser) {
			$.parser.parse(_1cd);
		}
	};
	function _1d3(_1d4) {
		var tab = $(">div.tabs-header ul.tabs li.tabs-selected", _1d4);
		if (tab.length) {
			var _1d5 = $.data(tab[0], "tabs.tab").id;
			var _1d6 = $("#" + _1d5);
			var _1d7 = $(">div.tabs-panels", _1d4);
			if (_1d7.css("height").toLowerCase() != "auto") {
				if ($.boxModel == true) {
					_1d6.height(_1d7.height()
							- (_1d6.outerHeight() - _1d6.height()));
					_1d6.width(_1d7.width()
							- (_1d6.outerWidth() - _1d6.width()));
				} else {
					_1d6.height(_1d7.height());
					_1d6.width(_1d7.width());
				}
			}
			$(">div", _1d6).triggerHandler("_resize");
		}
	};
	function _1d8(_1d9) {
		$(_1d9).addClass("tabs-container");
		$(_1d9).wrapInner("<div class=\"tabs-panels\"/>");
		$("<div class=\"tabs-header\">"
				+ "<div class=\"tabs-scroller-left\"></div>"
				+ "<div class=\"tabs-scroller-right\"></div>"
				+ "<div class=\"tabs-wrap\">" + "<ul class=\"tabs\"></ul>"
				+ "</div>" + "</div>").prependTo(_1d9);
		var _1da = $(">div.tabs-header", _1d9);
		$(">div.tabs-panels>div", _1d9).each(function() {
			if (!$(this).attr("id")) {
				$(this).attr("id",
						"gen-tabs-panel" + $.fn.tabs.defaults.idSeed++);
			}
			var _1db = {
				id : $(this).attr("id"),
				title : $(this).attr("title"),
				content : null,
				href : $(this).attr("href"),
				closable : $(this).attr("closable") == "true",
				icon : $(this).attr("icon"),
				selected : $(this).attr("selected") == "true",
				cache : $(this).attr("cache") == "false" ? false : true
			};
			$(this).attr("title", "");
			_1dc(_1d9, _1db);
		});
		$(".tabs-scroller-left, .tabs-scroller-right", _1da).hover(function() {
					$(this).addClass("tabs-scroller-over");
				}, function() {
					$(this).removeClass("tabs-scroller-over");
				});
		$(_1d9).bind("_resize", function() {
					var opts = $.data(_1d9, "tabs").options;
					if (opts.fit == true) {
						_1cc(_1d9);
						_1d3(_1d9);
					}
					return false;
				});
	};
	function _1dc(_1dd, _1de) {
		var _1df = $(">div.tabs-header", _1dd);
		var tabs = $("ul.tabs", _1df);
		var tab = $("<li></li>");
		var _1e0 = $("<span></span>").html(_1de.title);
		var _1e1 = $("<a class=\"tabs-inner\"></a>").attr("href",
				"javascript:void(0)").append(_1e0);
		tab.append(_1e1).appendTo(tabs);
		if (_1de.closable) {
			_1e0.addClass("tabs-closable");
			_1e1
					.after("<a href=\"javascript:void(0)\" class=\"tabs-close\"></a>");
		}
		if (_1de.icon) {
			_1e0.addClass("tabs-with-icon");
			_1e0.after($("<span/>").addClass("tabs-icon").addClass(_1de.icon));
		}
		if (_1de.selected) {
			tab.addClass("tabs-selected");
		}
		if (_1de.content) {
			$("#" + _1de.id).html(_1de.content);
		}
		$.data(tab[0], "tabs.tab", {
					id : _1de.id,
					title : _1de.title,
					href : _1de.href,
					loaded : false,
					cache : _1de.cache
				});
	};
	function _1e2(_1e3, _1e4) {
		_1e4 = $.extend({
					id : null,
					title : "",
					content : "",
					href : null,
					cache : true,
					icon : null,
					closable : false,
					selected : true,
					height : "auto",
					width : "auto"
				}, _1e4 || {});
		if (_1e4.selected) {
			$(".tabs-header .tabs-wrap .tabs li", _1e3)
					.removeClass("tabs-selected");
		}
		_1e4.id = "gen-tabs-panel" + $.fn.tabs.defaults.idSeed++;
		$("<div></div>").attr("id", _1e4.id).attr("title", _1e4.title)
				.height(_1e4.height).width(_1e4.width).appendTo($(
						">div.tabs-panels", _1e3));
		_1dc(_1e3, _1e4);
	};
	function _1e5(_1e6, _1e7) {
		var opts = $.data(_1e6, "tabs").options;
		var elem = $(">div.tabs-header li:has(a span:contains(\"" + _1e7
						+ "\"))", _1e6)[0];
		if (!elem) {
			return;
		}
		var _1e8 = $.data(elem, "tabs.tab");
		var _1e9 = $("#" + _1e8.id);
		if (opts.onClose.call(_1e9, _1e8.title) == false) {
			return;
		}
		var _1ea = $(elem).hasClass("tabs-selected");
		$.removeData(elem, "tabs.tab");
		$(elem).remove();
		_1e9.remove();
		_1cc(_1e6);
		if (_1ea) {
			_1eb(_1e6);
		} else {
			var wrap = $(">div.tabs-header .tabs-wrap", _1e6);
			var pos = Math.min(wrap.scrollLeft(), _1c1(_1e6));
			wrap.animate({
						scrollLeft : pos
					}, opts.scrollDuration);
		}
	};
	function _1eb(_1ec, _1ed) {
		if (_1ed) {
			var elem = $(">div.tabs-header li:has(a span:contains(\"" + _1ed
							+ "\"))", _1ec)[0];
			if (elem) {
				$(elem).trigger("click");
			}
		} else {
			var tabs = $(">div.tabs-header ul.tabs", _1ec);
			if ($(".tabs-selected", tabs).length == 0) {
				$("li:first", tabs).trigger("click");
			} else {
				$(".tabs-selected", tabs).trigger("click");
			}
		}
	};
	function _1ee(_1ef, _1f0) {
		return $(">div.tabs-header li:has(a span:contains(\"" + _1f0 + "\"))",
				_1ef).length > 0;
	};
	$.fn.tabs = function(_1f1, _1f2) {
		if (typeof _1f1 == "string") {
			switch (_1f1) {
				case "resize" :
					return this.each(function() {
								_1cc(this);
							});
				case "add" :
					return this.each(function() {
								_1e2(this, _1f2);
								$(this).tabs();
							});
				case "close" :
					return this.each(function() {
								_1e5(this, _1f2);
							});
				case "select" :
					return this.each(function() {
								_1eb(this, _1f2);
							});
				case "exists" :
					return _1ee(this[0], _1f2);
			}
		}
		_1f1 = _1f1 || {};
		return this.each(function() {
			var _1f3 = $.data(this, "tabs");
			var opts;
			if (_1f3) {
				opts = $.extend(_1f3.options, _1f1);
				_1f3.options = opts;
			} else {
				opts = $.extend({}, $.fn.tabs.defaults, {
					width : (parseInt($(this).css("width")) || "auto"),
					height : (parseInt($(this).css("height")) || "auto"),
					fit : ($(this).attr("fit") == "true"),
					border : ($(this).attr("border") == "false" ? false : true),
					plain : ($(this).attr("plain") == "true")
				}, _1f1);
				_1d8(this);
				$.data(this, "tabs", {
							options : opts
						});
			}
			var _1f4 = this;
			var _1f5 = $(">div.tabs-header", _1f4);
			var _1f6 = $(">div.tabs-panels", _1f4);
			var tabs = $("ul.tabs", _1f5);
			if (opts.plain == true) {
				_1f5.addClass("tabs-header-plain");
			} else {
				_1f5.removeClass("tabs-header-plain");
			}
			if (opts.border == true) {
				_1f5.removeClass("tabs-header-noborder");
				_1f6.removeClass("tabs-panels-noborder");
			} else {
				_1f5.addClass("tabs-header-noborder");
				_1f6.addClass("tabs-panels-noborder");
			}
			if (_1f3) {
				$("li", tabs).unbind(".tabs");
				$("a.tabs-close", tabs).unbind(".tabs");
				$(".tabs-scroller-left", _1f5).unbind(".tabs");
				$(".tabs-scroller-right", _1f5).unbind(".tabs");
			}
			$("li", tabs).bind("click.tabs", _1f7);
			$("a.tabs-close", tabs).bind("click.tabs", _1f8);
			$(".tabs-scroller-left", _1f5).bind("click.tabs", _1f9);
			$(".tabs-scroller-right", _1f5).bind("click.tabs", _1fa);
			_1cc(_1f4);
			_1eb(_1f4);
			function _1f8() {
				var elem = $(this).parent()[0];
				var _1fb = $.data(elem, "tabs.tab");
				_1e5(_1f4, _1fb.title);
			};
			function _1f7() {
				$(".tabs-selected", tabs).removeClass("tabs-selected");
				$(this).addClass("tabs-selected");
				$(">div.tabs-panels>div", _1f4).css("display", "none");
				var wrap = $(".tabs-wrap", _1f5);
				var _1fc = _1bf(_1f4, this);
				var left = _1fc - wrap.scrollLeft();
				var _1fd = left + $(this).outerWidth();
				if (left < 0 || _1fd > wrap.innerWidth()) {
					var pos = Math.min(_1fc - (wrap.width() - $(this).width())
									/ 2, _1c1(_1f4));
					wrap.animate({
								scrollLeft : pos
							}, opts.scrollDuration);
				}
				var _1fe = $.data(this, "tabs.tab");
				var _1ff = $("#" + _1fe.id);
				var _2ff = $("#" + _1fe.id + ">iframe");
				_1ff.css("display", "block").focus();
				if(_2ff.attr("src")=="about:blank")
					_2ff.attr("src",_2ff.attr("url"));
				if (_1fe.href && (!_1fe.loaded || !_1fe.cache)) {
					_1ff.load(_1fe.href, null, function() {
								if ($.parser) {
									$.parser.parse(_1ff);
								}
								opts.onLoad.apply(this, arguments);
								_1fe.loaded = true;
							});
				}
				_1d3(_1f4);
				opts.onSelect.call(_1ff, _1fe.title);
			};
			function _1f9() {
				var wrap = $(".tabs-wrap", _1f5);
				var pos = wrap.scrollLeft() - opts.scrollIncrement;
				wrap.animate({
							scrollLeft : pos
						}, opts.scrollDuration);
			};
			function _1fa() {
				var wrap = $(".tabs-wrap", _1f5);
				var pos = Math.min(wrap.scrollLeft() + opts.scrollIncrement,
						_1c1(_1f4));
				wrap.animate({
							scrollLeft : pos
						}, opts.scrollDuration);
			};
		});
	};
	$.fn.tabs.defaults = {
		width : "auto",
		height : "auto",
		idSeed : 0,
		plain : false,
		fit : false,
		border : true,
		scrollIncrement : 100,
		scrollDuration : 400,
		onLoad : function() {
		},
		onSelect : function(_200) {
		},
		onClose : function(_201) {
		}
	};
})(jQuery);