package chess.core.shiro;

import chess.domain.model.permission.Permission;
import chess.domain.service.auth.IAuthService;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YJH on 2016/4/5 0005.
 */
public class ShiroFilterChainManager {

    private final CustomDefaultFilterChainManager filterChainManager;

    private final IAuthService authService;

    private Map<String, NamedFilterList> defaultFilterChains;

    @Autowired
    public ShiroFilterChainManager(CustomDefaultFilterChainManager filterChainManager, IAuthService authService) {
        this.filterChainManager = filterChainManager;
        this.authService = authService;
    }

    @PostConstruct
    public void init() {
        defaultFilterChains = new HashMap<String, NamedFilterList>(filterChainManager.getFilterChains());
        initFilterChains();
    }

    public void initFilterChains() {
        List<Permission> permissions = authService.findAllPermission();
        //1、首先删除以前老的filter chain并注册默认的
        filterChainManager.getFilterChains().clear();
        if (defaultFilterChains != null) {
            filterChainManager.getFilterChains().putAll(defaultFilterChains);
        }

        //2、循环URL Filter 注册filter chain
        for (Permission permission : permissions) {
            //注册perms filter
            filterChainManager.addToChain(permission.getValue(), "perms", permission.getName());
        }
    }

}
