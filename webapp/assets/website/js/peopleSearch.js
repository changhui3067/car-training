var list = new Vue({
    el: '#peopleList',
    data: {
        pageCount:resultJson.pageCount,
        pageNo: resultJson.pageNo,
        peopleList:resultJson.list
    },
    methods: {
        getPage: function (n) {
            sendAjax(n);
        },
        specialJump: function (action) {
            if (!this[action] || !this[action]) {
                return;
            }
            switch (action) {
                case 'fst':
                    sendAjax(1);
                    break;
                case 'pre':
                    sendAjax(this.pageNo - 1);
                    break;
                case 'nex':
                    sendAjax(this.pageNo + 1);
                    break;
                case 'Lst':
                    sendAjax(this.pageCount);
                default:
                    return;
            }
        }
    },
    computed: {
        fst: function () {
            return this.pageNo != 1;
        },
        pre: function () {
            return this.pageNo > 1;
        },
        nex: function () {
            return this.pageNo < this.pageCount;
        },
        Lst: function () {
            return this.pageNo != this.pageCount;
        },
        pages: function () {
           var totalPage = this.pageCount;
           var pageNo = this.pageNo;
            var pages = [];
            if (totalPage >= 5) {
                if (pageNo < 3) {
                    pages = Array.apply(null, Array(5)).map(function (_, i) {
                        var page = {};
                        page.no = i + 1;
                        page.current = page.no == pageNo;
                        return page;
                    });
                } else if (totalPage - pageNo < 3) {
                    pages = Array.apply(null, Array(5)).map(function (_, i) {
                        var page = {};
                        page.no = totalPage - 4 + i;
                        page.current = page.no == pageNo;
                        return page;
                    });
                } else {
                    pages = Array.apply(null, Array(5)).map(function (_, i) {
                        var page = {};
                        page.no = pageNo - 2 + i;
                        page.current = page.no == pageNo;
                        return page;
                    });
                }
            } else {
                pages = Array.apply(null, Array(totalPage)).map(function (_, i) {
                    var page = {};
                    page.no = i + 1;
                    page.current = page.no == pageNo;
                    return page;
                });
            }
            return pages;
        }
    }
});
$(document).ready(function () {
    $("#peopleList").removeClass("hidden");
});