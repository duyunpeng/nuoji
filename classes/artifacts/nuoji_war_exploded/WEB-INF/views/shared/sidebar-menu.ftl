<aside class="sidebar-menu fixed">
    <div class="sidebar-inner scrollable-sidebar">
        <div class="main-menu">
            <ul class="accordion" id="sidebar">
                <li class="menu-header">
                    Main Menu
                </li>
                <li class="bg-palette1 active">
                    <a href="/admin">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-home fa-lg"></i></span>
                            <span class="text m-left-sm">首页</span>
                        </span>
                    </a>
                </li>
                <li class="bg-palette1">
                    <a href="[@spring.url '/history/pagination'/]">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-arrows fa-lg"></i></span>
                            <span>开奖管理</span>
                        </span>
                    </a>
                </li>
                <li class="bg-palette2">
                    <a href="[@spring.url '/advert/pagination'/]">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-adn fa-lg"></i></span>
                            <span>广告管理</span>
                        </span>
                    </a>
                </li>
                <li class="openable bg-palette4">
                    <a href="#">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa fa-list fa-lg"></i></span>
                            <span class="text m-left-sm">系统设置</span>
                            <span class="submenu-icon"></span></span>
                        <span class="menu-content-hover block">Menu</span>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="[@spring.url '/permission/pagination'/]">
                                <span class="submenu-label">权限管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="[@spring.url '/role/pagination'/]">
                                <span class="submenu-label">角色管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="[@spring.url '/account/pagination'/]">
                                <span class="submenu-label">账号管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="[@spring.url '/app_Version/pagination'/]">
                                <span class="submenu-label">版本管理</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="bg-palette1">
                    <a href="[@spring.url '/logout'/]">
                        <span class="menu-content block">
                            <span class="menu-icon"><i class="block fa ion-log-out fa-lg"></i></span>
                            <span class="text m-left-sm">退出</span>
                        </span>
                    </a>
                </li>
            </ul>
        </div>
    </div><!-- sidebar-inner -->
</aside>