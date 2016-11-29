var list = new Vue({
    el: '#peopleList',
    data: {
        resultVO:resultJson
    },
    methods: {
        getPage: function (n) {
            sendAjax(n);
        },
        specialJump: function (action) {
//            switch action:
//                case 'first':
//                    this.resultVO.pageNo sendAjax();
        }
    },
    computed: {
        fst: function () {
            return this.resultVO.pageNo != 1;
        },
        pre: function () {
            return this.resultVO.pageNo > 1;
        },
        nex: function () {
            return this.resultVO.pageNo < this.resultVO.pageCount;
        },
        Lst: function () {
            return this.resultVO.pageNo != this.resultVO.pageCount;
        },
        pages: function () {
           var totalPage = this.resultVO.pageCount;
           var pageNo = this.resultVO.pageNo;
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