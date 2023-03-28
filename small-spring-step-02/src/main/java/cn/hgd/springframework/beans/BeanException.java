package cn.hgd.springframework.beans;

/**
 * @author hgd
 * 定义bean异常
 */
public class BeanException extends RuntimeException{
    public BeanException(String msg) {
        super(msg);
    }
    
    public BeanException(String msg, Throwable cause){
        super(msg, cause);
    }
}
