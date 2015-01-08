package com.trenduce.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by prafulmantale on 1/4/15.
 * Registers the {@link org.springframework.web.filter.DelegatingFilterProxy} to use the
 * springSecurityFilterChain before any other registered {@link javax.servlet.Filter}. When
 * used with , it
 * will also register a {@link org.springframework.web.context.ContextLoaderListener}.
 */
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

}
