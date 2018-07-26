package org.core.utils.screen;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.core.utils.excep.CannotInstanceException;
import org.core.utils.interf.UtilsInterface;

/**
 * <p>
 * 截图工具
 * </p>
 * Create Date: 2015‎年‎11‎月‎27‎日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public class ShotcutUtils implements UtilsInterface {

    // 禁止实例化
    private ShotcutUtils() throws CannotInstanceException {
        throw new CannotInstanceException("请不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return this.getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("你可以通过两种方式来截取屏幕");
    }

    /**
     * 运行后将当前屏幕截取，并最大化显示。 拖拽鼠标，选择自己需要的部分。
     * 按Esc键保存图片到桌面，并退出程序。
     * 点击右上角（没有可见的按钮），退出程序，不保存图片。
     */
    public static void shotFullScreen() {
        RectFullScreen rd = new RectFullScreen();
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        gd.setFullScreenWindow(rd);
    }
    
    /**
     * 通过选取屏幕中的某一块来截取屏幕
     * 
     * @param path
     *      截图保存路径
     *      
     * @throws IOException
     *      保存图片出错
     */
    public static void shotScreenNow(String path) throws IOException {
        File tempFile = new File(path);
        ScreenCapture capture = ScreenCapture.getInstance();
        
        capture.captureImage();
        
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel imagebox = new JLabel();
        panel.add(BorderLayout.CENTER, imagebox);
        imagebox.setIcon(capture.getPickedIcon());
        capture.saveToFile(tempFile);
        capture.captureImage();
        imagebox.setIcon(capture.getPickedIcon());
        frame.setContentPane(panel);
        frame.setSize(400, 300);
//        frame.show();
        frame.setVisible(true);
        
        System.out.println("Over");
    }
}
