package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This is servlet initializer class replace for web.xml file.
 * 
 * @author Ankit Tyagi
 * @since 1.0
 */
public class ServletContainerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        super.onStartup(servletContext);
    }


    /**
     * Common configuration.
     */
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]
        {
            AppConfig.class
        };
    }

    /**
     * SpringMVC configuration.
     */
    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]
        {
        	AppConfig.class
        };
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]
        {
            "/"
        };
    }
    /*
    @Override
    protected String getServletName()
    {
        return "springmvc";
    }

    @Override
    protected boolean isAsyncSupported()
    {
        return true;
    }*/
}
