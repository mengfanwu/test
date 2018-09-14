package handler;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import parser.UserParser;

public class BeanSpaceHandler extends NamespaceHandlerSupport {
    public void init() {
        registerBeanDefinitionParser("user", new UserParser());
    }
}
