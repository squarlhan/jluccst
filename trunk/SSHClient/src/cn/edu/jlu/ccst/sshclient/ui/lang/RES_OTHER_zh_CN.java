package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

import javax.swing.JOptionPane;

public class RES_OTHER_zh_CN extends ListResourceBundle
{
    static final Object[][] contents = {
            {"TEST_CONC","测试结束"}, 
            {"TEST_SUCCESS","连接成功！"}, 
            {"TEST_FAILD","连接失败！"},
            {"DEL_TASK","删除任务？"},
            {"DEL_GROUP","删除任务组？"},
            {"DEL_COMPUTER","删除计算机？"},
            {"DEL_CONFIRM","确认删除"},
            {"DEL_DIR","删除任务工作目录？"},
            {"DEL_DIR_CONFIRM","删除目录"},
    };

    public Object[][] getContents()
    {
        return contents;
    }
}