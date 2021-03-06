if('undefined' == typeof window.Util) {
		window.Util =  {
				/**
                     * Send the ajax request
                     * 
                     * @param {Object} oConfig 
                     * @return
                     * 
                     * e.g.
                     * Util.request({
                     *     type: string,      			 //MUST, GET/PUT/DELETE...
                     *     url: string,         		 //MUST
                     *     onsuccess: function() {},     //OPTIONAL, successful callback
                     *     onfail: function() {}         //OPTIONAL, unsuccessful callback
                     *     onerror: function() {}        //OPTIONAL, errorHandler, when exception thrown
                     *	   elementId: string			 //OPTIONAL, the control to change to loading state
                     *     loading: false                //OPTIONAL, default is true. if set to false, not to show loading
                     * });
                     */
				request: function(oConfig) {
					var oDeferred = $.Deferred();
					var showLoading = req.loading === false ? false : true;
					$.Ajax({
						type: oConfig.type,
						url: oConfig.url,
						data: oConfig.data,
						success: function(response){
							showLoading && showLoader(oConfig.ele, false);
							oDeferred.resolve(response);
						},
						fail: function(msg, error){
							showLoading && showLoader(oConfig.ele, false);
							oDeferred.reject(response);
						}
					})
					showLoading && showLoader(oConfig.ele, true);
					return oDeferred.promise();
				},

				showLoader:  function(ele, isShow){
					if($(ele)){
						isShow ? $(ele).showLoading() : $(ele).hideLoading();
					}
				},

				/**
                     * Show message toast
                     * 
                     * @param {Object} options
                     * @return
                     * 
                     * e.g.
                     * Util.msgToast({
                     *     message: string,   //MUST, the message to show
                     *     duration: number,  //OPTIONAL
                     *     mode: Util.MSGTYPE,      //OPTIONAL
                     * });
                     */
				msgToast: function(options){
					var defaults = {
            			message: 'This is a toast notification!',
            			duration: 2000,
            			mode: 'INFO'
        			};
					var settings = $.extend({}, defaults, options);

        			var spanClass = 'alert ';
					switch(settings.mode) {
						case 'SUCCESS':
            				spanClass += 'alert-success';
            				break;
						case 'ERROR':
							spanClass += 'alert-danger';
							break;
						default:
							spanClass += 'alert-info';
					}

                    //var _toastBox = document.createElement('div'); //div should have style text-align:center
                    //_toastBox.className = "toastBox";
                    var _toastBox=$('<div></div>').attr('id', 'msgToast').addClass('toastBox');
                    jQuery('<span/>',{text: settings.message}).addClass(spanClass).appendTo(_toastBox);
                    document.body.appendChild(_toastBox[0]);

                    var fadeTime = 500;
        			$('#msgToast').fadeIn(fadeTime);
        			setTimeout(function () {
            			$('#msgToast').fadeOut(fadeTime);
                        setTimeout(function(){$('#msgToast').remove()},fadeTime);
                    }, settings.duration);
				}
			}
}

Util.MSGTYPE = {
    INFO: 'INFO',
    SUCCESS: 'SUCCESS',
    ERROR: 'ERROR'
}
