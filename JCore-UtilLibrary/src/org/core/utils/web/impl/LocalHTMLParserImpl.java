package org.core.utils.web.impl;

import java.io.File;
import java.io.IOException;

import org.core.utils.web.interf.HTMLParserable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * <p>
 * 我是一个HTML解析工具，
 * 我负责解析本地的HTML文件
 * </p>
 * Create Date: 2015年12月15日
 * Last Modify: 2016年5月26日
 * 
 * @author <a href="http://weibo.com/u/5131020927">Q-WHai</a>
 * @see <a href="http://blog.csdn.net/lemon_tree12138">http://blog.csdn.net/lemon_tree12138</a>
 * @version 0.1.1
 */
public final class LocalHTMLParserImpl implements HTMLParserable {

    @Override
    public String getTag() {
        return getClass().getName();
    }

    @Override
    public void description() {
        System.out.println("我是一个解析本地HTML文件的工具类");
    }

    /**
     * 解析本地的HTML文件
     * 
     * @param localFilePath
     *      本地HTML文件路径
     * @param charsetName
     *      编码格式
     * @return
     *      网页页面信息
     * @throws IOException
     *      读写异常
     */
    public Document requestHTML(String localFilePath, String charsetName) throws IOException {
        File localFile = new File(localFilePath);
        Document document = Jsoup.parse(localFile, charsetName);
        
        return document;
    }
    
    /**
     * 解析本地的HTML文件
     * （默认编码方式为UTF-8）
     * 
     * @param localFilePath
     *      本地HTML文件路径
     * @return
     *      网页页面信息
     * @throws IOException
     *      读写异常
     */
    @Override
    public Document requestHTML(String localFilePath) throws IOException {
        return requestHTML(localFilePath, "UTF-8");
    }

    @Override
    public String requestHTMLToString(String localFilePath) throws IOException {
        return requestHTML(localFilePath).toString();
    }

    @Override
    public String requestHTMLText(String localFilePath) throws IOException {
        return requestHTML(localFilePath).text();
    }

    @Deprecated
    @Override
    public void downloadHTML(String url, String localFilePath) throws IOException {
        System.out.println("当前已经是在本地，不需要下载");
    }
    
    @Deprecated
    @Override
    public void downloadHTML(String url, String savePath, int delay)
            throws IOException {
        System.out.println("当前已经是在本地，不需要下载");
    }

    @Deprecated
    @Override
    public Document requestHTML(String localFilePath, int delay) throws IOException {
        return requestHTML(localFilePath);
    }

    @Deprecated
    @Override
    public String requestHTMLToString(String localFilePath, int delay)
            throws IOException {
        return requestHTMLToString(localFilePath);
    }

    @Deprecated
    @Override
    public String requestHTMLText(String localFilePath, int delay) throws IOException {
        return requestHTMLText(localFilePath);
    }

    @Deprecated
    @Override
    public Document requestHTML(String localFilePath, int delay, boolean redirect)
            throws IOException {
        return requestHTML(localFilePath);
    }

    @Deprecated
    @Override
    public String requestHTMLToString(String localFilePath, int delay, boolean redirect)
            throws IOException {
        return requestHTMLToString(localFilePath);
    }

    @Deprecated
    @Override
    public String requestHTMLText(String localFilePath, int delay, boolean redirect)
            throws IOException {
        return requestHTMLText(localFilePath);
    }
}
