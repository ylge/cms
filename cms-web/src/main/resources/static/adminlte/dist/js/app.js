/*! AdminLTE app.js
* ================
* Main JS application file for AdminLTE v2. This file
* should be included in all pages. It controls some layout
* options and implements exclusive AdminLTE plugins.
*
* @Author  Almsaeed Studio
* @Support <https://www.almsaeedstudio.com>
* @Email   <abdullah@almsaeedstudio.com>
* @version 2.4.2
* @repository git://github.com/almasaeed2010/AdminLTE.git
* @license MIT <http://opensource.org/licenses/MIT>
*/

// Make sure jQuery has been loaded
if (typeof jQuery === 'undefined') {
    throw new Error('AdminLTE requires jQuery')
}

/* BoxRefresh()
 * =========
 * Adds AJAX content control to a box.
 *
 * @Usage: $('#my-box').boxRefresh(options)
 *         or add [data-widget="box-refresh"] to the box element
 *         Pass any option as data-option="value"
 */
+function ($) {
    'use strict';

    var DataKey = 'lte.boxrefresh';

    var Default = {
        source         : '',
        params         : {},
        trigger        : '.refresh-btn',
        content        : '.box-body',
        loadInContent  : true,
        responseType   : '',
        overlayTemplate: '<div class="overlay"><div class="fa fa-refresh fa-spin"></div></div>',
        onLoadStart    : function () {
        },
        onLoadDone     : function (response) {
            return response;
        }
    };

    var Selector = {
        data: '[data-widget="box-refresh"]'
    };

    // BoxRefresh Class Definition
    // =========================
    var BoxRefresh = function (element, options) {
        this.element  = element;
        this.options  = options;
        this.$overlay = $(options.overlay);

        if (options.source === '') {
            throw new Error('Source url was not defined. Please specify a url in your BoxRefresh source option.');
        }

        this._setUpListeners();
        this.load();
    };

    BoxRefresh.prototype.load = function () {
        this._addOverlay();
        this.options.onLoadStart.call($(this));

        $.get(this.options.source, this.options.params, function (response) {
            if (this.options.loadInContent) {
                $(this.options.content).html(response);
            }
            this.options.onLoadDone.call($(this), response);
            this._removeOverlay();
        }.bind(this), this.options.responseType !== '' && this.options.responseType);
    };

    // Private

    BoxRefresh.prototype._setUpListeners = function () {
        $(this.element).on('click', Selector.trigger, function (event) {
            if (event) event.preventDefault();
            this.load();
        }.bind(this));
    };

    BoxRefresh.prototype._addOverlay = function () {
        $(this.element).append(this.$overlay);
    };

    BoxRefresh.prototype._removeOverlay = function () {
        $(this.element).remove(this.$overlay);
    };

    // Plugin Definition
    // =================
    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data  = $this.data(DataKey);

            if (!data) {
                var options = $.extend({}, Default, $this.data(), typeof option == 'object' && option);
                $this.data(DataKey, (data = new BoxRefresh($this, options)));
            }

            if (typeof data == 'string') {
                if (typeof data[option] == 'undefined') {
                    throw new Error('No method named ' + option);
                }
                data[option]();
            }
        });
    }

    var old = $.fn.boxRefresh;

    $.fn.boxRefresh             = Plugin;
    $.fn.boxRefresh.Constructor = BoxRefresh;

    // No Conflict Mode
    // ================
    $.fn.boxRefresh.noConflict = function () {
        $.fn.boxRefresh = old;
        return this;
    };

    // BoxRefresh Data API
    // =================
    $(window).on('load', function () {
        $(Selector.data).each(function () {
            Plugin.call($(this));
        });
    });

}(jQuery);


/* BoxWidget()
 * ======
 * Adds box widget functions to boxes.
 *
 * @Usage: $('.my-box').boxWidget(options)
 *         This plugin auto activates on any element using the `.box` class
 *         Pass any option as data-option="value"
 */
+function ($) {
    'use strict';

    var DataKey = 'lte.boxwidget';

    var Default = {
        animationSpeed : 500,
        collapseTrigger: '[data-widget="collapse"]',
        removeTrigger  : '[data-widget="remove"]',
        collapseIcon   : 'fa-minus',
        expandIcon     : 'fa-plus',
        removeIcon     : 'fa-times'
    };

    var Selector = {
        data     : '.box',
        collapsed: '.collapsed-box',
        header   : '.box-header',
        body     : '.box-body',
        footer   : '.box-footer',
        tools    : '.box-tools'
    };

    var ClassName = {
        collapsed: 'collapsed-box'
    };

    var Event = {
        collapsed: 'collapsed.boxwidget',
        expanded : 'expanded.boxwidget',
        removed  : 'removed.boxwidget'
    };

    // BoxWidget Class Definition
    // =====================
    var BoxWidget = function (element, options) {
        this.element = element;
        this.options = options;

        this._setUpListeners();
    };

    BoxWidget.prototype.toggle = function () {
        var isOpen = !$(this.element).is(Selector.collapsed);

        if (isOpen) {
            this.collapse();
        } else {
            this.expand();
        }
    };

    BoxWidget.prototype.expand = function () {
        var expandedEvent = $.Event(Event.expanded);
        var collapseIcon  = this.options.collapseIcon;
        var expandIcon    = this.options.expandIcon;

        $(this.element).removeClass(ClassName.collapsed);

        $(this.element)
            .children(Selector.header + ', ' + Selector.body + ', ' + Selector.footer)
            .children(Selector.tools)
            .find('.' + expandIcon)
            .removeClass(expandIcon)
            .addClass(collapseIcon);

        $(this.element).children(Selector.body + ', ' + Selector.footer)
            .slideDown(this.options.animationSpeed, function () {
                $(this.element).trigger(expandedEvent);
            }.bind(this));
    };

    BoxWidget.prototype.collapse = function () {
        var collapsedEvent = $.Event(Event.collapsed);
        var collapseIcon   = this.options.collapseIcon;
        var expandIcon     = this.options.expandIcon;

        $(this.element)
            .children(Selector.header + ', ' + Selector.body + ', ' + Selector.footer)
            .children(Selector.tools)
            .find('.' + collapseIcon)
            .removeClass(collapseIcon)
            .addClass(expandIcon);

        $(this.element).children(Selector.body + ', ' + Selector.footer)
            .slideUp(this.options.animationSpeed, function () {
                $(this.element).addClass(ClassName.collapsed);
                $(this.element).trigger(collapsedEvent);
            }.bind(this));
    };

    BoxWidget.prototype.remove = function () {
        var removedEvent = $.Event(Event.removed);

        $(this.element).slideUp(this.options.animationSpeed, function () {
            $(this.element).trigger(removedEvent);
            $(this.element).remove();
        }.bind(this));
    };

    // Private

    BoxWidget.prototype._setUpListeners = function () {
        var that = this;

        $(this.element).on('click', this.options.collapseTrigger, function (event) {
            if (event) event.preventDefault();
            that.toggle($(this));
            return false;
        });

        $(this.element).on('click', this.options.removeTrigger, function (event) {
            if (event) event.preventDefault();
            that.remove($(this));
            return false;
        });
    };

    // Plugin Definition
    // =================
    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data  = $this.data(DataKey);

            if (!data) {
                var options = $.extend({}, Default, $this.data(), typeof option == 'object' && option);
                $this.data(DataKey, (data = new BoxWidget($this, options)));
            }

            if (typeof option == 'string') {
                if (typeof data[option] == 'undefined') {
                    throw new Error('No method named ' + option);
                }
                data[option]();
            }
        });
    }

    var old = $.fn.boxWidget;

    $.fn.boxWidget             = Plugin;
    $.fn.boxWidget.Constructor = BoxWidget;

    // No Conflict Mode
    // ================
    $.fn.boxWidget.noConflict = function () {
        $.fn.boxWidget = old;
        return this;
    };

    // BoxWidget Data API
    // ==================
    $(window).on('load', function () {
        $(Selector.data).each(function () {
            Plugin.call($(this));
        });
    });
}(jQuery);


/* ControlSidebar()
 * ===============
 * Toggles the state of the control sidebar
 *
 * @Usage: $('#control-sidebar-trigger').controlSidebar(options)
 *         or add [data-toggle="control-sidebar"] to the trigger
 *         Pass any option as data-option="value"
 */
+function ($) {
    'use strict';

    var DataKey = 'lte.controlsidebar';

    var Default = {
        slide: true
    };

    var Selector = {
        sidebar: '.control-sidebar',
        data   : '[data-toggle="control-sidebar"]',
        open   : '.control-sidebar-open',
        bg     : '.control-sidebar-bg',
        wrapper: '.wrapper',
        content: '.content-wrapper',
        boxed  : '.layout-boxed'
    };

    var ClassName = {
        open : 'control-sidebar-open',
        fixed: 'fixed'
    };

    var Event = {
        collapsed: 'collapsed.controlsidebar',
        expanded : 'expanded.controlsidebar'
    };

    // ControlSidebar Class Definition
    // ===============================
    var ControlSidebar = function (element, options) {
        this.element         = element;
        this.options         = options;
        this.hasBindedResize = false;

        this.init();
    };

    ControlSidebar.prototype.init = function () {
        // Add click listener if the element hasn't been
        // initialized using the data API
        if (!$(this.element).is(Selector.data)) {
            $(this).on('click', this.toggle);
        }

        this.fix();
        $(window).resize(function () {
            this.fix();
        }.bind(this));
    };

    ControlSidebar.prototype.toggle = function (event) {
        if (event) event.preventDefault();

        this.fix();

        if (!$(Selector.sidebar).is(Selector.open) && !$('body').is(Selector.open)) {
            this.expand();
        } else {
            this.collapse();
        }
    };

    ControlSidebar.prototype.expand = function () {
        if (!this.options.slide) {
            $('body').addClass(ClassName.open);
        } else {
            $(Selector.sidebar).addClass(ClassName.open);
        }

        $(this.element).trigger($.Event(Event.expanded));
    };

    ControlSidebar.prototype.collapse = function () {
        $('body, ' + Selector.sidebar).removeClass(ClassName.open);
        $(this.element).trigger($.Event(Event.collapsed));
    };

    ControlSidebar.prototype.fix = function () {
        if ($('body').is(Selector.boxed)) {
            this._fixForBoxed($(Selector.bg));
        }
    };

    // Private

    ControlSidebar.prototype._fixForBoxed = function (bg) {
        bg.css({
            position: 'absolute',
            height  : $(Selector.wrapper).height()
        });
    };

    // Plugin Definition
    // =================
    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data  = $this.data(DataKey);

            if (!data) {
                var options = $.extend({}, Default, $this.data(), typeof option == 'object' && option);
                $this.data(DataKey, (data = new ControlSidebar($this, options)));
            }

            if (typeof option == 'string') data.toggle();
        });
    }

    var old = $.fn.controlSidebar;

    $.fn.controlSidebar             = Plugin;
    $.fn.controlSidebar.Constructor = ControlSidebar;

    // No Conflict Mode
    // ================
    $.fn.controlSidebar.noConflict = function () {
        $.fn.controlSidebar = old;
        return this;
    };

    // ControlSidebar Data API
    // =======================
    $(document).on('click', Selector.data, function (event) {
        if (event) event.preventDefault();
        Plugin.call($(this), 'toggle');
    });

}(jQuery);


/* DirectChat()
 * ===============
 * Toggles the state of the control sidebar
 *
 * @Usage: $('#my-chat-box').directChat()
 *         or add [data-widget="direct-chat"] to the trigger
 */
+function ($) {
    'use strict';

    var DataKey = 'lte.directchat';

    var Selector = {
        data: '[data-widget="chat-pane-toggle"]',
        box : '.direct-chat'
    };

    var ClassName = {
        open: 'direct-chat-contacts-open'
    };

    // DirectChat Class Definition
    // ===========================
    var DirectChat = function (element) {
        this.element = element;
    };

    DirectChat.prototype.toggle = function ($trigger) {
        $trigger.parents(Selector.box).first().toggleClass(ClassName.open);
    };

    // Plugin Definition
    // =================
    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data  = $this.data(DataKey);

            if (!data) {
                $this.data(DataKey, (data = new DirectChat($this)));
            }

            if (typeof option == 'string') data.toggle($this);
        });
    }

    var old = $.fn.directChat;

    $.fn.directChat             = Plugin;
    $.fn.directChat.Constructor = DirectChat;

    // No Conflict Mode
    // ================
    $.fn.directChat.noConflict = function () {
        $.fn.directChat = old;
        return this;
    };

    // DirectChat Data API
    // ===================
    $(document).on('click', Selector.data, function (event) {
        if (event) event.preventDefault();
        Plugin.call($(this), 'toggle');
    });

}(jQuery);


/* Layout()
 * ========
 * Implements AdminLTE layout.
 * Fixes the layout height in case min-height fails.
 *
 * @usage activated automatically upon window load.
 *        Configure any options by passing data-option="value"
 *        to the body tag.
 */
+function ($) {
    'use strict';

    var DataKey = 'lte.layout';

    var Default = {
        slimscroll : true,
        resetHeight: true
    };

    var Selector = {
        wrapper       : '.wrapper',
        contentWrapper: '.content-wrapper',
        layoutBoxed   : '.layout-boxed',
        mainFooter    : '.main-footer',
        mainHeader    : '.main-header',
        sidebar       : '.sidebar',
        controlSidebar: '.control-sidebar',
        fixed         : '.fixed',
        sidebarMenu   : '.sidebar-menu',
        logo          : '.main-header .logo'
    };

    var ClassName = {
        fixed         : 'fixed',
        holdTransition: 'hold-transition'
    };

    var Layout = function (options) {
        this.options      = options;
        this.bindedResize = false;
        this.activate();
    };

    Layout.prototype.activate = function () {
        this.fix();
        this.fixSidebar();

        $('body').removeClass(ClassName.holdTransition);

        if (this.options.resetHeight) {
            $('body, html, ' + Selector.wrapper).css({
                'height'    : 'auto',
                'min-height': '100%'
            });
        }

        if (!this.bindedResize) {
            $(window).resize(function () {
                this.fix();
                this.fixSidebar();

                $(Selector.logo + ', ' + Selector.sidebar).one('webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend', function () {
                    this.fix();
                    this.fixSidebar();
                }.bind(this));
            }.bind(this));

            this.bindedResize = true;
        }

        $(Selector.sidebarMenu).on('expanded.tree', function () {
            this.fix();
            this.fixSidebar();
        }.bind(this));

        $(Selector.sidebarMenu).on('collapsed.tree', function () {
            this.fix();
            this.fixSidebar();
        }.bind(this));
    };

    Layout.prototype.fix = function () {
        // Remove overflow from .wrapper if layout-boxed exists
        $(Selector.layoutBoxed + ' > ' + Selector.wrapper).css('overflow', 'hidden');

        // Get window height and the wrapper height
        var footerHeight  = $(Selector.mainFooter).outerHeight() || 0;
        var neg           = $(Selector.mainHeader).outerHeight() + footerHeight;
        var windowHeight  = $(window).height();
        var sidebarHeight = $(Selector.sidebar).height() || 0;

        // Set the min-height of the content and sidebar based on
        // the height of the document.
        if ($('body').hasClass(ClassName.fixed)) {
            $(Selector.contentWrapper).css('min-height', windowHeight - footerHeight);
        } else {
            var postSetHeight;

            if (windowHeight >= sidebarHeight) {
                $(Selector.contentWrapper).css('min-height', windowHeight - neg);
                postSetHeight = windowHeight - neg;
            } else {
                $(Selector.contentWrapper).css('min-height', sidebarHeight);
                postSetHeight = sidebarHeight;
            }

            // Fix for the control sidebar height
            var $controlSidebar = $(Selector.controlSidebar);
            if (typeof $controlSidebar !== 'undefined') {
                if ($controlSidebar.height() > postSetHeight)
                    $(Selector.contentWrapper).css('min-height', $controlSidebar.height());
            }
        }
    };

    Layout.prototype.fixSidebar = function () {
        // Make sure the body tag has the .fixed class
        if (!$('body').hasClass(ClassName.fixed)) {
            if (typeof $.fn.slimScroll !== 'undefined') {
                $(Selector.sidebar).slimScroll({ destroy: true }).height('auto');
            }
            return;
        }

        // Enable slimscroll for fixed layout
        if (this.options.slimscroll) {
            if (typeof $.fn.slimScroll !== 'undefined') {
                // Destroy if it exists
                // $(Selector.sidebar).slimScroll({ destroy: true }).height('auto')

                // Add slimscroll
                $(Selector.sidebar).slimScroll({
                    height: ($(window).height() - $(Selector.mainHeader).height()) + 'px'
                });
            }
        }
    };

    // Plugin Definition
    // =================
    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data  = $this.data(DataKey);

            if (!data) {
                var options = $.extend({}, Default, $this.data(), typeof option === 'object' && option);
                $this.data(DataKey, (data = new Layout(options)));
            }

            if (typeof option === 'string') {
                if (typeof data[option] === 'undefined') {
                    throw new Error('No method named ' + option);
                }
                data[option]();
            }
        });
    }

    var old = $.fn.layout;

    $.fn.layout            = Plugin;
    $.fn.layout.Constuctor = Layout;

    // No conflict mode
    // ================
    $.fn.layout.noConflict = function () {
        $.fn.layout = old;
        return this;
    };

    // Layout DATA-API
    // ===============
    $(window).on('load', function () {
        Plugin.call($('body'));
    });
}(jQuery);


/* PushMenu()
 * ==========
 * Adds the push menu functionality to the sidebar.
 *
 * @usage: $('.btn').pushMenu(options)
 *          or add [data-toggle="push-menu"] to any button
 *          Pass any option as data-option="value"
 */
+function ($) {
    'use strict';

    var DataKey = 'lte.pushmenu';

    var Default = {
        collapseScreenSize   : 767,
        expandOnHover        : false,
        expandTransitionDelay: 200
    };

    var Selector = {
        collapsed     : '.sidebar-collapse',
        open          : '.sidebar-open',
        mainSidebar   : '.main-sidebar',
        contentWrapper: '.content-wrapper',
        searchInput   : '.sidebar-form .form-control',
        button        : '[data-toggle="push-menu"]',
        mini          : '.sidebar-mini',
        expanded      : '.sidebar-expanded-on-hover',
        layoutFixed   : '.fixed'
    };

    var ClassName = {
        collapsed    : 'sidebar-collapse',
        open         : 'sidebar-open',
        mini         : 'sidebar-mini',
        expanded     : 'sidebar-expanded-on-hover',
        expandFeature: 'sidebar-mini-expand-feature',
        layoutFixed  : 'fixed'
    };

    var Event = {
        expanded : 'expanded.pushMenu',
        collapsed: 'collapsed.pushMenu'
    };

    // PushMenu Class Definition
    // =========================
    var PushMenu = function (options) {
        this.options = options;
        this.init();
    };

    PushMenu.prototype.init = function () {
        if (this.options.expandOnHover
            || ($('body').is(Selector.mini + Selector.layoutFixed))) {
            this.expandOnHover();
            $('body').addClass(ClassName.expandFeature);
        }

        $(Selector.contentWrapper).click(function () {
            // Enable hide menu when clicking on the content-wrapper on small screens
            if ($(window).width() <= this.options.collapseScreenSize && $('body').hasClass(ClassName.open)) {
                this.close();
            }
        }.bind(this));

        // __Fix for android devices
        $(Selector.searchInput).click(function (e) {
            e.stopPropagation();
        });
    };

    PushMenu.prototype.toggle = function () {
        var windowWidth = $(window).width();
        var isOpen      = !$('body').hasClass(ClassName.collapsed);

        if (windowWidth <= this.options.collapseScreenSize) {
            isOpen = $('body').hasClass(ClassName.open);
        }

        if (!isOpen) {
            this.open();
        } else {
            this.close();
        }
    };

    PushMenu.prototype.open = function () {
        var windowWidth = $(window).width();

        if (windowWidth > this.options.collapseScreenSize) {
            $('body').removeClass(ClassName.collapsed)
                .trigger($.Event(Event.expanded));
        }
        else {
            $('body').addClass(ClassName.open)
                .trigger($.Event(Event.expanded));
        }
    };

    PushMenu.prototype.close = function () {
        var windowWidth = $(window).width();
        if (windowWidth > this.options.collapseScreenSize) {
            $('body').addClass(ClassName.collapsed)
                .trigger($.Event(Event.collapsed));
        } else {
            $('body').removeClass(ClassName.open + ' ' + ClassName.collapsed)
                .trigger($.Event(Event.collapsed));
        }
    };

    PushMenu.prototype.expandOnHover = function () {
        $(Selector.mainSidebar).hover(function () {
            if ($('body').is(Selector.mini + Selector.collapsed)
                && $(window).width() > this.options.collapseScreenSize) {
                this.expand();
            }
        }.bind(this), function () {
            if ($('body').is(Selector.expanded)) {
                this.collapse();
            }
        }.bind(this));
    };

    PushMenu.prototype.expand = function () {
        setTimeout(function () {
            $('body').removeClass(ClassName.collapsed)
                .addClass(ClassName.expanded);
        }, this.options.expandTransitionDelay);
    };

    PushMenu.prototype.collapse = function () {
        setTimeout(function () {
            $('body').removeClass(ClassName.expanded)
                .addClass(ClassName.collapsed);
        }, this.options.expandTransitionDelay);
    };

    // PushMenu Plugin Definition
    // ==========================
    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data  = $this.data(DataKey);

            if (!data) {
                var options = $.extend({}, Default, $this.data(), typeof option == 'object' && option);
                $this.data(DataKey, (data = new PushMenu(options)));
            }

            if (option === 'toggle') data.toggle();
        });
    }

    var old = $.fn.pushMenu;

    $.fn.pushMenu             = Plugin;
    $.fn.pushMenu.Constructor = PushMenu;

    // No Conflict Mode
    // ================
    $.fn.pushMenu.noConflict = function () {
        $.fn.pushMenu = old;
        return this;
    };

    // Data API
    // ========
    $(document).on('click', Selector.button, function (e) {
        e.preventDefault();
        Plugin.call($(this), 'toggle');
    });
    $(window).on('load', function () {
        Plugin.call($(Selector.button));
    });
}(jQuery);


/* TodoList()
 * =========
 * Converts a list into a todoList.
 *
 * @Usage: $('.my-list').todoList(options)
 *         or add [data-widget="todo-list"] to the ul element
 *         Pass any option as data-option="value"
 */
+function ($) {
    'use strict';

    var DataKey = 'lte.todolist';

    var Default = {
        onCheck  : function (item) {
            return item;
        },
        onUnCheck: function (item) {
            return item;
        }
    };

    var Selector = {
        data: '[data-widget="todo-list"]'
    };

    var ClassName = {
        done: 'done'
    };

    // TodoList Class Definition
    // =========================
    var TodoList = function (element, options) {
        this.element = element;
        this.options = options;

        this._setUpListeners();
    };

    TodoList.prototype.toggle = function (item) {
        item.parents(Selector.li).first().toggleClass(ClassName.done);
        if (!item.prop('checked')) {
            this.unCheck(item);
            return;
        }

        this.check(item);
    };

    TodoList.prototype.check = function (item) {
        this.options.onCheck.call(item);
    };

    TodoList.prototype.unCheck = function (item) {
        this.options.onUnCheck.call(item);
    };

    // Private

    TodoList.prototype._setUpListeners = function () {
        var that = this;
        $(this.element).on('change ifChanged', 'input:checkbox', function () {
            that.toggle($(this));
        });
    };

    // Plugin Definition
    // =================
    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data  = $this.data(DataKey);

            if (!data) {
                var options = $.extend({}, Default, $this.data(), typeof option == 'object' && option);
                $this.data(DataKey, (data = new TodoList($this, options)));
            }

            if (typeof data == 'string') {
                if (typeof data[option] == 'undefined') {
                    throw new Error('No method named ' + option);
                }
                data[option]();
            }
        });
    }

    var old = $.fn.todoList;

    $.fn.todoList             = Plugin;
    $.fn.todoList.Constructor = TodoList;

    // No Conflict Mode
    // ================
    $.fn.todoList.noConflict = function () {
        $.fn.todoList = old;
        return this;
    };

    // TodoList Data API
    // =================
    $(window).on('load', function () {
        $(Selector.data).each(function () {
            Plugin.call($(this));
        });
    });

}(jQuery);


/* Tree()
 * ======
 * Converts a nested list into a multilevel
 * tree view menu.
 *
 * @Usage: $('.my-menu').tree(options)
 *         or add [data-widget="tree"] to the ul element
 *         Pass any option as data-option="value"
 */
+function ($) {
    'use strict';

    var DataKey = 'lte.tree';

    var Default = {
        animationSpeed: 500,
        accordion     : true,
        followLink    : false,
        trigger       : '.treeview a'
    };

    var Selector = {
        tree        : '.tree',
        treeview    : '.treeview',
        treeviewMenu: '.treeview-menu',
        open        : '.menu-open, .active',
        li          : 'li',
        data        : '[data-widget="tree"]',
        active      : '.active'
    };

    var ClassName = {
        open: 'menu-open',
        tree: 'tree'
    };

    var Event = {
        collapsed: 'collapsed.tree',
        expanded : 'expanded.tree'
    };

    // Tree Class Definition
    // =====================
    var Tree = function (element, options) {
        this.element = element;
        this.options = options;

        $(this.element).addClass(ClassName.tree);

        $(Selector.treeview + Selector.active, this.element).addClass(ClassName.open);

        this._setUpListeners();
    };

    Tree.prototype.toggle = function (link, event) {
        var treeviewMenu = link.next(Selector.treeviewMenu);
        var parentLi     = link.parent();
        var isOpen       = parentLi.hasClass(ClassName.open);

        if (!parentLi.is(Selector.treeview)) {
            return;
        }

        if (!this.options.followLink || link.attr('href') === '#') {
            event.preventDefault();
        }

        if (isOpen) {
            this.collapse(treeviewMenu, parentLi);
        } else {
            this.expand(treeviewMenu, parentLi);
        }
    };

    Tree.prototype.expand = function (tree, parent) {
        var expandedEvent = $.Event(Event.expanded);

        if (this.options.accordion) {
            var openMenuLi = parent.siblings(Selector.open);
            var openTree   = openMenuLi.children(Selector.treeviewMenu);
            this.collapse(openTree, openMenuLi);
        }

        parent.addClass(ClassName.open);
        tree.slideDown(this.options.animationSpeed, function () {
            $(this.element).trigger(expandedEvent);
        }.bind(this));
    };

    Tree.prototype.collapse = function (tree, parentLi) {
        var collapsedEvent = $.Event(Event.collapsed);

        tree.find(Selector.open).removeClass(ClassName.open);
        parentLi.removeClass(ClassName.open);
        tree.slideUp(this.options.animationSpeed, function () {
            tree.find(Selector.open + ' > ' + Selector.treeview).slideUp();
            $(this.element).trigger(collapsedEvent);
        }.bind(this));
    };

    // Private

    Tree.prototype._setUpListeners = function () {
        var that = this;

        $(this.element).on('click', this.options.trigger, function (event) {
            that.toggle($(this), event);
        });
    };

    // Plugin Definition
    // =================
    function Plugin(option) {
        return this.each(function () {
            var $this = $(this);
            var data  = $this.data(DataKey);

            if (!data) {
                var options = $.extend({}, Default, $this.data(), typeof option == 'object' && option);
                $this.data(DataKey, new Tree($this, options));
            }
        });
    }

    var old = $.fn.tree;

    $.fn.tree             = Plugin;
    $.fn.tree.Constructor = Tree;

    // No Conflict Mode
    // ================
    $.fn.tree.noConflict = function () {
        $.fn.tree = old;
        return this;
    };

    // Tree Data API
    // =============
    $(window).on('load', function () {
        $(Selector.data).each(function () {
            Plugin.call($(this));
        });
    });

}(jQuery);


/*
 * 自定义事件
 * -----------------------
 */
(function ($) {
    // 打开tab页
    $(".ajax-template").on("click", "a[target='navTab']", function () {
        var that = $(this);
        var _text = that.text();
        var _href = that.attr("href");
        if (!$("#navTabs li[url='" + _href + "']").length) {
            //iframe支持
            if (that.attr('target_type') == 'iframe') {
                $("#navTabs").append('<li url="' + _href + '"><span>' + _text + '</span><a href="javascript:void(0);" class="fa fa-close"></a></li>');
                $("#content").append('<div class="tabs-panel mainContent"><iframe class="LRADMS_iframe" name="iframe0" width="100%" height="100%" src="' + _href + '" frameborder="0"></iframe></div>');
                showTab($("#navTabs li[url='" + _href + "']"));
            } else {
                $("#loading").show();
                $.ajax({
                    url: _href,
                    dataType: "html",
                    success: function (result) {
                        $("#loading").hide();
                        // $.each($(result),function(i,item){

                        //   if (item.nodeName == "LINK" || item.nodeName == "link") {
                        //     require1(item.href);
                        //   }
                        //   if (item.nodeName == "SCRIPT" || item.nodeName == "script" && !!item.src) {
                        //     require1(item.src);
                        //   }
                        // })
                        $("#navTabs").append('<li url="' + _href + '"><span>' + _text + '</span><a href="javascript:void(0);" class="fa fa-close"></a></li>');
                        $("#content").append('<div class="tabs-panel">' + result + '</div>');
                        showTab($("#navTabs li[url='" + _href + "']"));
                    },
                    error: function (err) {
                        $("#loading").hide();
                        console.log(err)
                    }
                })
            }
        } else {
            showTab($("#navTabs li[url='" + _href + "']"));
        }

        if (that.parents(".sidebar-menu").length) {
            that.parent("li").addClass("active").siblings().removeClass("active");
        }
        return false;
    });

    // 点击tab标签
    $("#navTabs").on("click", "li", function () {
        showTab($(this));
    });
    // tab标签右键菜单
    $("#navTabs").on("contextmenu", "li", function (e) {
        e.preventDefault();
        var that = $(this);
        var w = that.width();
        var i = that.index();
        var bl = $(".content-header-navtabs").offset().left;
        $("#contextMenu").show().css("left", e.clientX - bl).attr("is", i);
        return false;
    });
    // 关闭tab标签
    $("#navTabs").on("click", ".fa-close", function () {
        var index = $(this).parents("li").index();
        showTab($(this).parents("li").prev());
        $("#content .tabs-panel").eq(index).remove();
        $(this).parents("li").remove();
    });
    // 关闭tab标签
    $("#contextMenu").on("click", "li", function () {
        var rel = $(this).attr("rel");
        var i = $("#contextMenu").attr("is");
        if (rel === "reload") {
            var _href = $("#navTabs>li").eq(i).attr("url");
            if (!_href) return false;
            $("#loading").show();
            $.ajax({
                url: _href,
                dataType: "html",
                success: function (result) {
                    $("#loading").hide();
                    $("#content>.tabs-panel").eq(i).html(result)
                    showTab($("#navTabs li[url='" + _href + "']"));
                },
                error: function (err) {
                    $("#loading").hide();
                    console.log(err)
                }
            })

        } else if (rel === "closeCurrent") {
            if (i == 0) return false;
            if ($("#navTabs>li").eq(i).hasClass("active")) {
                $("#navTabs>li").eq(0).addClass("active");
                $("#content>.tabs-panel").eq(0).show();
            }

            $("#navTabs>li").eq(i).remove();
            $("#content>.tabs-panel").eq(i).remove();

        } else if (rel === "closeOther") {

            $("#navTabs>li").eq(0).nextAll().attr("sel", "temp");
            $("#navTabs>li").eq(i).addClass("active").removeAttr("sel");
            $("#navTabs>li[sel='temp']").remove();
            $("#content>.tabs-panel").eq(0).nextAll().attr("sel", "temp");
            $("#content>.tabs-panel").eq(i).show().removeAttr("sel");
            $("#content>.tabs-panel[sel='temp']").remove();

        } else if (rel === "closeAll") {

            $("#navTabs>li").eq(0).addClass("active").nextAll().remove();
            $("#content>.tabs-panel").eq(0).show().nextAll().remove();

        }
        $("#contextMenu").hide();
    });
    // tab标签上一页、下一页
    $("#navTabs").nextAll("a").on("click", function () {
        var ml = parseInt($("#navTabs").css("marginLeft"));
        var itemL = $("#navTabs>li").length;
        var itemW = $("#navTabs>li").eq(0).width();
        var boxW = $("#navTabs").parent().width();
        if ($(this).hasClass("next")) {
            if (itemL * itemW + ml - boxW > 0) {
                ml -= itemW * 2;
            }
        } else {
            if (ml > itemW * 2) {
                ml += itemW * 2;
            } else {
                ml = 0;
            }
        }
        $("#navTabs").css("marginLeft", ml);
    });

    // show tab页内容
    function showTab(that) {
        var itemL = $("#navTabs>li").length;
        var itemW = $("#navTabs>li").eq(0).width();
        var boxW = $("#navTabs").parent().width();
        that.addClass("active").siblings().removeClass("active");
        $("#content>.tabs-panel").eq(that.index()).show().siblings().hide();
        if (itemL * itemW > boxW - itemW) {
            $("#navTabs").width(itemL * itemW + itemW).parent().addClass("more");
            var pl = that.prevAll().length;
            if (pl * itemW > boxW - itemW) {
                $("#navTabs").css("marginLeft", boxW - pl * itemW - itemW - 30);
            } else {
                $("#navTabs").css("marginLeft", 0);
            }
        } else {
            $("#navTabs").width("100%").parent().removeClass("more");
        }
    }

// 打开对话框
    $(document).on("click", "a[target='modal']", function () {
        var that = $(this);
        var href = that.attr("href");
        var method = that.attr("method") == "post" ? "post" : "get";
        var modal = that.attr("modal")
        $("#loading").show();
        $.ajax({
            url: href,
            type: method,
            dataType: "html",
            success: function (result) {
                $("#loading").hide();
                $("#lgModal").find(".modal-dialog").attr("class", "modal-dialog modal-" + modal);
                $("#lgModal").find(".modal-body").html(result).end().modal("show");
            },
            error: function () {
                $("#loading").hide();
                console.error("加载失败");
            }
        })
        return false;
    })

// 确认对话框
    $(document).on("click", "a[target='ajaxTodo']", function () {
        var that = $(this);
        var href = that.attr("href");
        var title = that.attr("data-body");
        var cb = that.attr("callback");
        $("#smModal").attr("action", href).attr("callback", cb).find(".modal-body").html(title).end().modal("show");

        return false;
    });
// 点击界面
    $(document).on("click", function () {
        $("#contextMenu").hide();
    });
    $("#smModal").on("click", ".modal-footer>.btn-primary", function () {
        var action = $("#smModal").attr("action");
        var clcb = $("#smModal").attr("callback");
        if (!action) {
            $("#smModal").modal("hide");
            return false;
        }

        $.get(action, function () {
            $("#smModal").modal("hide");
            if (!!clcb) {
                // console.log(clcb);
                eval(clcb);
            } else {
                alertMsg("操作成功", "success");
            }
        })

    })

}(jQuery));

var alertsetTime;

function alertMsg(text, type) {
    if (!$("#alertMsgBox").length) {
        var html = '<div class="box box-danger box-solid" id="alertMsgBox">'
            + '  <div class="box-header with-border">'
            + '    <h3 class="box-title">提示</h3>'
            + '    <div class="box-tools pull-right">'
            + '      <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>'
            + '    </div>'
            + '  </div>'
            + '  <div class="box-body"></div>'
            + '</div>'
        $("body").append(html)
    }
    if (!text) text = "提示内容不可为空";
    if (!type) type ? type : "default";
    clearTimeout(alertsetTime);
    $("#alertMsgBox").attr("class", "box box-" + type + " box-solid").stop().slideDown("slow").find(".box-body").html(text);
    alertsetTime = setTimeout(function () {
        $("#alertMsgBox").slideUp("slow");
    }, 3000)
}

// 动态提示
function modal1() {
    if ($("#modalMain").length == 0) {
        var html = '<div class="modal fade" id="modalMain">'
            + '  <div class="modal-dialog modal-sm">'
            + '    <div class="modal-content">'
            + '      <div class="modal-header">'
            + '        <button type="button" class="close" data-dismiss="modal" aria-label="Close">'
            + '          <span aria-hidden="true">×</span></button>'
            + '        <h4 class="modal-title">提示</h4>'
            + '      </div>'
            + '      <div class="modal-body">'
            + '        <p>提示什么？</p>'
            + '     </div>'
            + '      <div class="modal-footer">'
            + '        <button type="button" aria-label="Close" class="btn btn-default" data-dismiss="modal">close</button>'
            + '        <button type="button" class="btn btn-primary" aria-label="primary">确认</button>'
            + '      </div>'
            + '    </div>'
            + '    <!-- /.modal-content -->'
            + '  </div>'
            + '  <!-- /.modal-dialog -->'
            + '</div>'
        $("body").append(html)
    }

}

