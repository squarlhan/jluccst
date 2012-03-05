(function (jQuery){
/*
 * jQuery Plugin - Messager
 * Author: corrie	Mail: corrie@sina.com	Homepage: www.corrie.net.cn
 * Copyright (c) 2008 corrie.net.cn
 * @license http://www.gnu.org/licenses/gpl.html [GNU General Public License]
 *
 * $Date: 2008-08-30 
 * $Vesion: 1.1
 @ how to use and example: Please Open demo.html
 */
	this.version = '@1.1';
	this.layer = {'width' : 200, 'height': 100};
	this.title = '信息提示';
	this.time = 4000;
	this.anims = {'type' : 'slide', 'speed' : 600};
	
	this.inits = function(title, text){
		if($("#message").is("div")){ return; }
		$(document.body).prepend('<div id="message" class="messager" style="width:'+this.layer.width+'px;height:'+this.layer.height+'px;"><div class="messager-title-area"><span id="message_close" class="messager-close">×</span><div class="messager-title">'+title+'</div><div style="clear:both;"></div></div><div class="message-content-area"><div id="message_content" class="message-content" style="width:'+(this.layer.width-17)+'px;height:'+(this.layer.height-50)+'px;">'+text+'</div></div></div>');
	};
	this.show = function(title, text, time){
		if($("#message").is("div")){ return; }
		if(title==0 || !title)title = this.title;
		this.inits(title, text);
		if(time)this.time = time;
		switch(this.anims.type){
			case 'slide':$("#message").slideDown(this.anims.speed);break;
			case 'fade':$("#message").fadeIn(this.anims.speed);break;
			case 'show':$("#message").show(this.anims.speed);break;
			default:$("#message").slideDown(this.anims.speed);break;
		}
		$("#message_close").click(function(){		
			setTimeout('this.close()', 1);
		});
		//$("#message").slideDown('slow');
		this.rmmessage(this.time);
	};
	this.lays = function(width, height){
		if($("#message").is("div")){ return; }
		if(width!=0 && width)this.layer.width = width;
		if(height!=0 && height)this.layer.height = height;
	}
	this.anim = function(type,speed){
		if($("#message").is("div")){ return; }
		if(type!=0 && type)this.anims.type = type;
		if(speed!=0 && speed){
			switch(speed){
				case 'slow' : ;break;
				case 'fast' : this.anims.speed = 200; break;
				case 'normal' : this.anims.speed = 400; break;
				default:					
					this.anims.speed = speed;
			}			
		}
	}
	this.rmmessage = function(time){
		setTimeout('this.close()', time);
		//setTimeout('$("#message").remove()', time+1000);
	};
	this.close = function(){
		switch(this.anims.type){
			case 'slide':$("#message").slideUp(this.anims.speed);break;
			case 'fade':$("#message").fadeOut(this.anims.speed);break;
			case 'show':$("#message").hide(this.anims.speed);break;
			default:$("#message").slideUp(this.anims.speed);break;
		};
		setTimeout('$("#message").remove();', this.anims.speed);
		this.original();
	};
	this.original = function(){	
		this.layer = {'width' : 200, 'height': 100};
		this.title = '信息提示';
		this.time = 4000;
		this.anims = {'type' : 'slide', 'speed' : 600};
	};
    jQuery.messager = this;
    return jQuery;
})(jQuery);