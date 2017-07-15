package com.kostya.chatProject;

import com.kostya.chatProject.configs.MainConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Костя on 15.07.2017.
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MainConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
