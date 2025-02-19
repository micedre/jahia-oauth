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
package org.jahia.modules.jahiaoauth.service;

import java.util.List;
import java.util.Map;

/**
 * Service to be implemented by a connector to allow Jahia OAuth to work
 *
 * @author dgaillard
 */
public interface ConnectorService {
    /**
     * This method get the connector service name
     * @return String connector service name
     */
    String getServiceName();

    /**
     * This method return the url that will allow Jahia OAuth to get the user data
     * @return String url to request to get the user data
     */
    String getProtectedResourceUrl();

    /**
     * This method get the list of available properties with this connector
     * @return List the list of available properties
     */
    List<Map<String, Object>> getAvailableProperties();

    /**
     * Nested interface implemented by FranceConnect connector to allow Jahia OAuth
     * to work with the right mode
     */
    interface DevMode {
        /**
         * This method return a boolean value that will allow to use the right URL
         *
         * @return boolean value
         */
        boolean isDevMode();
    }
}
