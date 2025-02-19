/*
 * ==========================================================================================
 * =                   JAHIA'S DUAL LICENSING - IMPORTANT INFORMATION                       =
 * ==========================================================================================
 *
 *                                 http://www.jahia.com
 *
 *     Copyright (C) 2002-2019 Jahia Solutions Group SA. All rights reserved.
 *
 *     THIS FILE IS AVAILABLE UNDER TWO DIFFERENT LICENSES:
 *     1/GPL OR 2/JSEL
 *
 *     1/ GPL
 *     ==================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE GPL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *     2/ JSEL - Commercial and Supported Versions of the program
 *     ===================================================================================
 *
 *     IF YOU DECIDE TO CHOOSE THE JSEL LICENSE, YOU MUST COMPLY WITH THE FOLLOWING TERMS:
 *
 *     Alternatively, commercial and supported versions of the program - also known as
 *     Enterprise Distributions - must be used in accordance with the terms and conditions
 *     contained in a separate written agreement between you and Jahia Solutions Group SA.
 *
 *     If you are unsure which license is appropriate for your use,
 *     please contact the sales department at sales@jahia.com.
 */
package org.jahia.modules.jahiaoauth.impl.cache;

import org.jahia.modules.jahiaoauth.service.JahiaOAuthCacheService;
import org.jahia.osgi.BundleUtils;
import org.jahia.settings.SettingsBean;

import java.util.HashMap;

/**
 * @author dgaillard
 */
public class JahiaOAuthCacheServiceImpl implements JahiaOAuthCacheService {
    private JahiaOAuthCacheService defaultCacheService;
    private JahiaOAuthCacheService service;
    private SettingsBean settingsBean;

    public void initService() {
        service = settingsBean.isClusterActivated() ?
                BundleUtils.getOsgiService(JahiaOAuthCacheService.class, "(clustered=true)") : null;

        if (service == null) {
         service = defaultCacheService;
        }
    }

    @Override
    public void cacheMapperResults(String cacheKey, HashMap<String, Object> mapperResult) {
        service.cacheMapperResults(cacheKey, mapperResult);
    }

    @Override
    public HashMap<String, Object> getMapperResultsCacheEntry(String cacheKey) {
        return service.getMapperResultsCacheEntry(cacheKey);
    }

    @Override
    public void updateCacheEntry(String originalSessionId, String newSessionId) {
        service.updateCacheEntry(originalSessionId, newSessionId);
    }

    public void setDefaultCacheService(JahiaOAuthCacheService defaultCacheService) {
        this.defaultCacheService = defaultCacheService;
    }

    public void setSettingsBean(SettingsBean settingsBean) {
        this.settingsBean = settingsBean;
    }
}
