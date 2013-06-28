/**
 * @fileoverview Giant Interective Group, Inc. Javascript Library v#version.
 * 该Javascript UI库是基于jQuery的扩展。
 * <pre>
 * Copyright (C) 2004-2009 Giant Interective Group, Inc. All rights reserved.
 * 版权所有 2004-2009 上海巨人网络科技有限公司
 * </pre>
 *
 * @version #version, #date
 * @author  Zhangkai
 * Depend on jQuery 1.3.x
 */
if(typeof giant === 'undefined') var giant = window.giant = {};
if(typeof giant.ui === 'undefined') giant.ui = {};
(function($) {
     giant.ui.friendsuggest = function(options) {
        this.opts = $.extend({}, giant.ui.friendsuggest.defaults, options);
        this.currentPage = 1;
        this.totalPage =1;
        this.resultArr = [];
        this.isAllFriendShow = false;   //是否已经显示所有好友
        this.isDropDownListShow = false; //下拉选项是否已显示
        this.activeIndex = 0;
        this.typeId = -1;
        this._init();
    };
    giant.ui.friendsuggest.prototype = {
        _init:function() {
            this._formartSelect();
            this._getRecordCound();
            this._clickBind();
            this._focusBind();
            this._blurBind();
            this._keyUpBind();
            this._selectChangeBind();
        },
        _formartSelect:function(){
            var $this= this;
             $($this.opts.frinedNumberContainer).text($this.opts.selectType == 'multiple' ? $this.opts.totalSelectNum : 1);
             $.ajax({
                url:$this.opts.ajaxGetFriendTypeUrl,
                cache:false,
                success:function(msg) {
                	msg = $this.ajaxFriendsTypeOperate(msg);
                    var myData = eval(msg);
                    var arr=[];
                    $.each(myData,function(i,n){
                        arr.push("<option value='"+n.id+"'>"+n.name+"</option>");                        
                    });
                    $($this.opts.selectFriendType).append(arr.join(''));
                }
            });
        },
        _selectChangeBind:function(){
            var $this = this;
             $(this.opts.selectFriendType).bind("change",function(){
                $this.typeId = $(this).val();
                $this.currentPage = 1;
                $this._getRecordCound($this._formartAllFriend);
             });
        },
        _clickBind:function() {
            var $this = this;
            $($this.opts.inputContainer).bind('click',function(){
                $($this.opts.input).focus();
            });
            //右侧查看所有小图标
            $($this.opts.btnAll).bind("click", function(e) {
                 if (!$this.isAllFriendShow) {
                     $this._formartAllFriend();
                } else {
                    $this.setAllFriendHide();
                }
                e.stopPropagation();
            });
            //查看所有中的关闭按钮
            $($this.opts.btnCloseAllFriend).bind("click", function(e) {
                $this.setAllFriendHide();
                e.stopPropagation();
            });
            //点击添加好友
            $($this.opts.allFriendListContainer).find("a").live("click", function(e) {
                //$(this).toggleClass('selected');
                $this.addUser($(this).attr("name"), $(this).text(), $(this).find("img").attr("src"),$(this));
                e.stopPropagation();
            });
            //点击删除好友
            $($this.opts.resultContainer).find("span").live("click", function(e) {
                $this.deleteUser($(this).parents("a"));
                e.stopPropagation();
            });
            //下一页
            $($this.opts.btnNextPage).bind("click", function(e) {
                if ($this.currentPage < $this.totalPage) {
                    $this.currentPage++;
                    $this._getData($this._getPar(), $($this.opts.allFriendListContainer), null, "all");
                    if ($this.currentPage == $this.totalPage) {
                        $($this.opts.btnNextPage).addClass("disable");
                    }
                    if ($this.currentPage > 1) {
                        $($this.opts.btnPrevPage).removeClass("disable");
                    }
                }
                e.stopPropagation();
            });
            //上一页
            $($this.opts.btnPrevPage).bind("click", function(e) {
                if ($this.currentPage > 1) {
                    $this.currentPage--;
                    $this._getData($this._getPar(), $($this.opts.allFriendListContainer), null, "all");
                    if ($this.currentPage < $this.totalPage) {
                        $($this.opts.btnNextPage).removeClass("disable");
                    }
                    if ($this.currentPage == 1) {
                        $($this.opts.btnPrevPage).addClass("disable");
                    }
                }
                e.stopPropagation();
            });
            /*
            $(document).bind('click',function(){
                $this.setAllFriendHide();
            });
            $($this.opt.allFriendContainer).bind('click',function(e){
                e.stopPropagation();
            });
            */
        },
        _focusBind:function() {
            var $this = this;
            $($this.opts.input).bind("focus", function() {
            	if ($($this.opts.input).val().length == 0){
                    $this._formartAllFriend();//如果输入为空则显示列表
                }else{
	                $(this).val("");
	                $this.setAllFriendHide();
	                $($this.opts.inputContainer).css("border-color", "#7f9db9");
                }
            });
        },
        _blurBind:function() {
            var $this = this;
            $($this.opts.input).bind("blur", function() {
                $($this.opts.inputContainer).css("border-color", "#999");
                setTimeout(function() {
                    $this.setDropDownListHide();
                    $($this.opts.input).val("");
                    $this._formartAllFriend();//如果输入为空则显示列表
                }, 200);
            });
        },
        _keyUpBind:function() {
            var $this = this;
            //$(this.opts.input).bind("change", function(event) {
            $(this.opts.input).bind("keyup", function(event) {
                if (event.keyCode != "40" && event.keyCode != "38" && event.keyCode != "39" && event.keyCode != "37" && event.keyCode != "13") {
                    if ($($this.opts.input).val().length > 0) {
                        $this.setDropDownListShow();
                        //alert($this.typeId);
                        var data = {name:$(this).val(),typeId:$this.typeId};
                        $this._getData(data, $($this.opts.dropDownListContainer), function() {
                            $($this.opts.dropDownListContainer).find("a").eq(0).addClass("active");
                            $($this.opts.dropDownListContainer).find("a").each(function(index) {
                                $(this).bind("mouseover", function() {
                                    $this.activeIndex = index;
                                    $($this.opts.dropDownListContainer).find("a").removeClass("active");
                                    $($this.opts.dropDownListContainer).find("a").eq($this.activeIndex).addClass("active");
                                });
                                $(this).bind("click", function() {
                                    var $obj = $($this.opts.dropDownListContainer).find("a.active");
                                    $this.addUser($obj.attr("name"), $obj.text(), $obj.find("img").attr("src"));
                                    $this.setDropDownListHide();
                                    $($this.opts.input).focus();
                                });
                            });
                        },"normal");
                    }
                    else {       //输入为空
                        $($this.opts.dropDownListContainer).html($this.opts.inputDefaultTip);
                        $this._formartAllFriend();//如果输入为空则显示列表
                    }
                }
                if ($this.isDropDownListShow) {
                    var totalCount = $($this.opts.dropDownListContainer).find("a").size();
                    if (totalCount > 0) {
                        //down 键
                        if (event.keyCode == "40") {
                            if ($this.activeIndex < totalCount - 1) $this.activeIndex++;
                            else  $this.activeIndex = 0;
                        }
                        //up 键
                        else if (event.keyCode == "38") {
                            if ($this.activeIndex > 0)  $this.activeIndex--;
                            else  $this.activeIndex = totalCount - 1;
                        }
                        //回车键  加入
                        else if (event.keyCode == "13") {
                                var $obj = $($this.opts.dropDownListContainer).find("a.active");
                                $this.addUser($obj.attr("name"), $obj.text(), $obj.find("img").attr("src"));
                                $this.setDropDownListHide();
                                $($this.opts.input).val("");
                                $($this.opts.input).focus();
                            }
                        $($this.opts.dropDownListContainer).find("a").removeClass("active");
                        $($this.opts.dropDownListContainer).find("a").eq($this.activeIndex).addClass("active");
                    }
                }
            });
        },
        _formartAllFriend:function() {
            var $this = this;
            $this.setAllFriendShow();
            $this._getData($this._getPar(), $($this.opts.allFriendListContainer), null, "all");
            //上一页下一页判断
            if ($this.currentPage == 1) {
                $($this.opts.btnPrevPage).addClass("disable");
            }
            if ($this.currentPage == $this.totalPage || $this.totalPage == 0) {
                $($this.opts.btnNextPage).addClass("disable");
            }
        },
        _getData:function(data, $container, callBack, type) {
            var callBack = callBack || null;
            var type=type || "normal";
            var ajaxUrl="";
            if(type=="normal"){
                ajaxUrl = this.opts.ajaxUrl;
            }
            else{
                ajaxUrl=this.opts.ajaxLoadAllUrl;
            }
            var $this = this;
            if ($this.xmlHttpObj) {
                $this.xmlHttpObj.abort();
                $this.xmlHttpObj = null;
            }
            this.xmlHttpObj = $.ajax({
                url:ajaxUrl,
                data:data,
                type: "POST",
                cache:false,
                before:function() {
                    if ($.isFunction($this.opts.ajaxBefore)) {
                        $this.opts.ajaxBefore.call($this);
                    }
                },
                success:function(msg) {
                	msg = $this.ajaxFriendsDataOperate(msg);
                    var myData = eval(msg);
                    if(myData!=null){
	                    if (myData.length > 0) {
	                        var arr = [];
	                        $.each(myData, function(i, n) {
	                            if ($this.opts.selectType == 'multiple') {
	                            //arr.push("<a href='javascript:void(0)' title='" + n.friendUserName + "' class='checkbox" + (($.inArray(n.fUid + '', $this.resultArr) > -1) ? " checked" : "") + "' name='" + n.fUid+ "'><img src='" + n.friendHeadPic + "' title='" + n.fUid + "' alt='' />" + n.friendUserName + "</a>");
	                            arr.push("<a href='javascript:void(0)' title='" + n.friendUserName + "' class='checkbox" + (($.inArray(n.fUid + '', $this.resultArr) > -1) ? " checked" : "") + "' name='" + n.fUid+ "'><img src='" + n.friendHeadPic + "' alt='' />" + n.friendUserName + "</a>");
	                            } else {
	                            //arr.push("<a href='javascript:void(0)' title='" + n.friendUserName + "' class='radio" + (($.inArray(n.fUid + '', $this.resultArr) > -1) ? " checked" : "") + "' name='" + n.fUid + "'><img src='" + n.friendHeadPic + "' title='" + n.fUid + "' alt='' />" + n.friendUserName + "</a>");
	                            arr.push("<a href='javascript:void(0)' title='" + n.friendUserName + "' class='radio" + (($.inArray(n.fUid + '', $this.resultArr) > -1) ? " checked" : "") + "' name='" + n.fUid + "'><img src='" + n.friendHeadPic + "' alt='' />" + n.friendUserName + "</a>");
	                            }
	                        });
	                        $container.html(arr.join(''));
	                    } else {
	                        $container.html($this.opts.noDataTip);
	                    }
                    }
                    if ($.isFunction(callBack)) {
                        callBack();
                    }
                },
                error:function() {
                    if ($.isFunction($this.opts.ajaxError)) {
                        $this.opts.ajaxError.call($this);
                    }
                }
            });
        },
        _getRecordCound:function(callBack){
            var $this =this;
            var data ="";
            if(this.typeId!=-1){
               data="typeId="+this.typeId; 
            }
             $.ajax({
                url:$this.opts.ajaxGetCountUrl,
                data:data,
                cache:false,
                success:function(msg) {
                	msg = $this.ajaxFriendsCountOperate(msg);
                    var myData = eval(msg);
                    if(!window.isNaN(myData)){
                        $this.totalPage = Math.ceil(myData/50.0);
                    }
                    if($.isFunction(callBack)){
                        callBack.call($this);
                    }
                }
            });
        },
        _getPar:function() {
            var data = "pageSize=50&p=" + this.currentPage;
            if (this.typeId != -1) {
                data += "&typeId=" + this.typeId;
            }
            return data;
        },
        /**
         * 添加用户
         * @param{Number} uid 好友的id
         * @name {String} name 好友的名字
         * @image{String} name 图片路径
         * */
        addUser:function(uid, name, image,aObj) {
            var $this = this;
            //如果当前用户不存在
            if ($this.opts.selectType == "multiple") {
                if ($.inArray(uid, $this.resultArr) == -1) {
                    if (parseInt($($this.opts.frinedNumberContainer).text()) > 0)
                    {
                        $this.resultArr.push(uid);
                        if ($this.opts.resultInput)
                            $($this.opts.resultInput).val($this.resultArr.join())
                        $($this.opts.input).before("<a href='javascript:void(0)' name='" + uid + "'><img src='" + image + "' title='" + uid + "' alt='' />" + name + "<span title='移除该好友'>移除该好友</span></a>")
                        $($this.opts.frinedNumberContainer).text($this.opts.totalSelectNum - $this.resultArr.length);
                        if (aObj) aObj.addClass('checked');
                    } else {
                        if ($.isFunction($this.opts.limitCallBack)) {
                            $this.opts.limitCallBack.call();
                        } else {
                            alert('抱歉，可选好友数量已经达到上限');
                        }
                    }
                } else {
                    var $obj = $($this.opts.resultContainer).find("[name='" + uid + "']");
                    $this.deleteUser($obj); return;
                }
            } else {
                if ($.inArray(uid, $this.resultArr) == -1) {
                    var $obj = $($this.opts.resultContainer).find("[name='" + $this.resultArr[0] + "']");
                    $this.deleteUser($obj);
                    $this.resultArr.push(uid);
                    if ($this.opts.resultInput)
                        $($this.opts.resultInput).val($this.resultArr.join())
                    $($this.opts.input).before("<a href='javascript:void(0)' name='" + uid + "'><img src='" + image + "' title='" + uid + "' alt='' />" + name + "<span title='移除该好友'>移除该好友</span></a>")
                    $($this.opts.frinedNumberContainer).text(1 - $this.resultArr.length);
                    if (aObj) aObj.addClass('checked');
                }
            }
        },
        deleteUser:function($obj) {
            var $this = this;
            var name = $obj.attr('name');
            $this.resultArr = [];
            $obj.siblings("a").each(function() {
                $this.resultArr.push($(this).attr("name"));
            });

            if ($this.opts.resultInput)
                $($this.opts.resultInput).val($this.resultArr.join())
            $obj.remove();
            $($this.opts.allFriendListContainer).find('[name="' + name+ '"]').removeClass('checked');
            $($this.opts.frinedNumberContainer).text($this.opts.totalSelectNum - $this.resultArr.length);
        },
        /**
         * 显示好友提示下拉层
         * */
        setDropDownListShow:function() {
            this.isDropDownListShow = true;
            this.setAllFriendHide();
            $(this.opts.dropDownListContainer).show();
        },
         /**
         * 隐藏好友提示下拉层
         * */
        setDropDownListHide:function() {
            this.isDropDownListShow = false;
            this.activeIndex = 0;
            $(this.opts.dropDownListContainer).hide();
            //$(this.opts.input).val("");
            //$(this.opts.dropDownListContainer).html("");
            //$(this.opts.dropDownListContainer).html("数据加载中....");
            $(this.opts.dropDownListContainer).html("<div style='height:350px;background: #e0ebf2;'>数据加载中....</div>");
        },
         /**
         * 显示所有好友选择框
         * */
        setAllFriendShow:function() {
            this.isAllFriendShow = true;
            this.setDropDownListHide();
            $(this.opts.allFriendContainer).show();
            $(this.opts.btnAll).addClass("active");
        },
         /**
         * 隐藏所有好友选择框
         * */
        setAllFriendHide:function() {
            this.isAllFriendShow = false;
            $(this.opts.allFriendContainer).hide();
            $(this.opts.btnAll).removeClass("active");
        },
        /**
         * 获取选中的好友结果集
         * @return {Array} 返回存放选中的好友id的数组
         * */
        getResult:function() {
            return this.resultArr;
        },
        /**
         * 处理ajax返回的好友结果集，如果需要非默认操作可以重写这个方法
         * @return {json} 返回好友信息的json字符串
         * */
        ajaxFriendsDataOperate:function(data) {
           return data;
        },
        /**
         * 处理ajax返回的好友类型结果集，如果需要非默认操作可以重写这个方法
         * @return {json} 返回好友类型信息的json字符串
         * */
        ajaxFriendsTypeOperate:function(data) {
        	return data;
        },
        /**
         * 处理ajax返回的好友数，如果需要非默认操作可以重写这个方法
         * @return {json} 返回好友数的json字符串
         * */
        ajaxFriendsCountOperate:function(data) {
        	return data;
        }
    }
    /**
     * 默认参数
     * <pre>
     * totalSelectNum 多选模式下，最多选取人数，默认为30
     * selectType 选择模式，默认为多选"multiple",若为单选，则用single
     * selectCallBack 单选模式下，选中之后的回调函数。 
     * </pre>
     * */
    giant.ui.friendsuggest.defaults = {
        btnAll:"#ui-fs .ui-fs-icon",
        btnCloseAllFriend:"#ui-fs .ui-fs-all .close",
        btnNextPage:"#ui-fs .ui-fs-all .next",
        btnPrevPage:"#ui-fs .ui-fs-all .prev",
        selectFriendType:"#ui-fs-friendtype",
        allFriendContainer:"#ui-fs .ui-fs-all" ,
        allFriendListContainer:"#ui-fs .ui-fs-all .ui-fs-allinner div.list",
        frinedNumberContainer:"#ui-fs .ui-fs-allinner .page b",
        resultContainer:"#ui-fs .ui-fs-result",
        input:"#ui-fs .ui-fs-input input",
        inputContainer:"#ui-fs .ui-fs-input",
        dropDownListContainer:"#ui-fs .ui-fs-list",
        resultInput : "#ui-fs .ui-fs-result-box",
        inputDefaultTip:"输入人员姓名(支持全拼输入)",
        noDataTip:"您的通讯录不存在该人员",
        ajaxUrl:"ajax2.jsp",
        ajaxLoadAllUrl:"ajax2.jsp",
        ajaxGetCountUrl:"ajaxcount2.jsp",
        ajaxGetFriendTypeUrl:"ajaxfriendtype2.jsp",
        totalSelectNum:5,
        ajaxBefore:null,
        ajaxError:null,
        selectType:"multiple",
        limitCallBack:null
    };
})(jQuery);
