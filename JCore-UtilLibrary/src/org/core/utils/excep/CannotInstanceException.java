package org.core.utils.excep;

/**
 * <p>
 * 这个异常主要是针对：强行对一个不允许实例化的类进行实例化操作
 * </p>
 * <p>
 * 而且应该被定义成一个非受检的异常
 * </p>
 * Create Date: 2015‎年‎11‎月‎25‎日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.2
 */
public class CannotInstanceException extends RuntimeException {

    private static final long serialVersionUID = 7758358824103995400L;

    public CannotInstanceException() {
        super();
    }
    
    public CannotInstanceException(String msg) {
        super(msg);
    }
    
    public CannotInstanceException(Throwable cause) {
        super(cause);
    }
    
    public CannotInstanceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
