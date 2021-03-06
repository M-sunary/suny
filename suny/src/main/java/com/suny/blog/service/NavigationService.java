package com.suny.blog.service;

import com.suny.blog.model.Navigation;

import java.util.List;

public interface NavigationService {
    public List<Navigation> getNavList();
    public List<Navigation> getNavListsByType(Navigation navigation);
    public void updateNavigation(Navigation navigation);
}
