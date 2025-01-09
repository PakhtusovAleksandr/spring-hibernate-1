package ru.be_prog.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Метод, указывающий на класс основной конфигурации
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfiguration.class
        };
    }


    // Настраиваем url по которому будет доступно наше приложение
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
