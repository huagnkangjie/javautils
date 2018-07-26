package org.core.utils.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.core.utils.excep.CannotInstanceException;
import org.core.utils.interf.UtilsInterface;

/**
 * <p>
 * 写文件的工具类
 * </p>
 * Create Date: 2015年11月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public final class FileWriteUtils implements UtilsInterface {

    // 禁止实例化
    private FileWriteUtils() throws CannotInstanceException {
        throw new CannotInstanceException("不要试图实例化我");
    }
    
    @Override
    public String getTag() {
        return this.getClass().getName();
    }
    
    @Override
    public void description() {
        System.out.println("写文件的工具类");
    }
    
    /**
     * 在文件的结尾写入数据
     * 
     * @param path
     *      文件被写入的路径
     * @param content
     *      写入的数据
     * @throws IOException
     *      读写异常
     */
    public static void appendFile(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        
        FileOutputStream outputStream = new FileOutputStream(file, true);
        outputStream.write(content.getBytes("utf-8"));
        outputStream.close();
    }
    
    /**
     * 写文件(会覆盖原文件内容)
     * 
     * @param path
     *      文件被写入的路径
     * @param content
     *      写入的数据
     * @throws IOException
     *      读写异常
     */
    public static void writeFileCover(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        
        FileOutputStream outputStream = new FileOutputStream(file, false);
        outputStream.write(content.getBytes("utf-8"));
        outputStream.close();
    }
    
    /**
     * 从指定内容偏移的地方开始覆盖文件内容
     * 
     * @param path
     *      文件路径
     * @param content
     *      待写入的内容
     * @param seek
     *      文件偏移
     * @throws IOException
     *      读写异常
     */
    public static void replaceFileData(String path, String content, long seek) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
        
        // TODO 处理文件不存在的情况
        
        randomAccessFile.seek(seek);
        randomAccessFile.writeBytes(content);
        
        randomAccessFile.close();
    }
    
    /**
     * 从指定内容偏移的地方开始覆盖文件内容
     * 
     * @param path
     *      文件路径
     * @param content
     *      待写入的内容
     * @throws IOException
     *      读写异常
     */
    public static void replaceFileData(String path, String content) throws IOException {
        replaceFileData(path, content, 0);
    }
    
    public static void insertFile(String path, String content, long seek) throws IOException {
        File file = new File(path, "w");
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
