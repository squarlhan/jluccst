package cn.edu.jlu.ccst.sshclient.ui;

import java.util.ListResourceBundle;

public class RES_zh_CN extends ListResourceBundle
{
    static final Object[][] contents = {
            { "FILE", "文件" }, 
            { "TASK", "任务" }, 
            { "HELP", "帮助" },
            { "LANGUAGE", "Language" },
            {"CN","中文"},
            {"EN","English"}
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
