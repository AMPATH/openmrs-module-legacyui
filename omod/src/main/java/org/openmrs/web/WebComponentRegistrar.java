/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

@Component
public class WebComponentRegistrar implements ServletContextAware {

    @Override
    public void setServletContext(ServletContext servletContext) {
        ServletRegistration openmrsServletReg = servletContext.getServletRegistration("openmrs");
        addMappings(openmrsServletReg, "*.htm", "*.form", "*.list", "*.json", "*.field", "*.portlet");
    }

    private void addMappings(ServletRegistration reg, String... mappings) {
        for (String mapping : mappings) {
            reg.addMapping(mapping);
        }
    }

}
