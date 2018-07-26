package org.core.utils.math.bean.factory;

import org.core.utils.math.bean.Ball;
import org.core.utils.math.bean.interf.Angle;
import org.core.utils.math.bean.interf.Curve;

/**
 * <p>
 * 具体生产有弧形几何体的工厂
 * </p>
 * Create Date: 2015年12月10日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class CurveFactory extends ShapeFactory {

    @Override
    public Angle createAngle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Curve createCurve() {
        return new Ball();
    }

}
