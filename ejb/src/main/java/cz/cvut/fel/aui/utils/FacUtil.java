package cz.cvut.fel.aui.utils;

import javax.enterprise.context.ContextNotActiveException;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * Utilities for Facelets
 */
@Named("FacUtil")
public class FacUtil {

    @SuppressWarnings("unused")
    public static Object getBeanByName(String name) {

        BeanManager bm = getBeanManager();
        Set<Bean<?>> beansFound = bm.getBeans(name);
        if (!beansFound.isEmpty()) {
            Bean<?> bean = beansFound.iterator().next();
            CreationalContext<?> ctx = bm.createCreationalContext(bean);
            return bm.getReference(bean, bean.getBeanClass(), ctx);
        } else {
            return null;
        }
    }

    public static <T> Object getBeanByClass(Class<T> c, Annotation... anotations) {
        BeanManager bm = getBeanManager();
        Set<Bean<?>> beansFound = bm.getBeans(c, anotations);
        if (!beansFound.isEmpty()) {
            Bean<?> bean = beansFound.iterator().next();
            CreationalContext<?> ctx = bm.createCreationalContext(bean);
            return bm.getReference(bean, bean.getBeanClass(), ctx);
        } else {
            return null;
        }
    }

    public static BeanManager getBeanManager() {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isContextActivate(Class<? extends Annotation> scope) {
        try {
            getBeanManager().getContext(scope);
        } catch (ContextNotActiveException e) {
            return false;
        }
        return true;
    }

}
