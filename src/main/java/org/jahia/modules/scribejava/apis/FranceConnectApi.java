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
package org.jahia.modules.scribejava.apis;

import com.github.scribejava.core.builder.api.DefaultApi20;
import org.jahia.modules.jahiaoauth.service.ConnectorService;
import org.jahia.modules.jahiaoauth.service.JahiaOAuthConstants;
import org.jahia.osgi.BundleUtils;

public class FranceConnectApi extends DefaultApi20 {

    protected FranceConnectApi() {
    }

    private static class InstanceHolder {
        private static final FranceConnectApi INSTANCE = new FranceConnectApi();
    }

    public static FranceConnectApi instance() {
        return InstanceHolder.INSTANCE;
    }

    @Override
    public String getAccessTokenEndpoint() {
        ConnectorService.DevMode connectorService = (ConnectorService.DevMode) BundleUtils.getOsgiService(
                ConnectorService.class,
                "(" + JahiaOAuthConstants.CONNECTOR_SERVICE_NAME + "=FranceConnectApi)"
        );
        String result = "https://app.franceconnect.gouv.fr/api/v1/token";
        if (connectorService.isDevMode()) {
            result = "https://fcp.integ01.dev-franceconnect.fr/api/v1/token";
        }
        return result;
    }

    @Override
    protected String getAuthorizationBaseUrl() {
        ConnectorService.DevMode connectorService = (ConnectorService.DevMode) BundleUtils.getOsgiService(
                ConnectorService.class,
                "(" + JahiaOAuthConstants.CONNECTOR_SERVICE_NAME + "=FranceConnectApi)"
        );
        String result = "https://app.franceconnect.gouv.fr/api/v1/authorize";
        if (connectorService.isDevMode()) {
            result = "https://fcp.integ01.dev-franceconnect.fr/api/v1/authorize";
        }
        return result;
    }
}