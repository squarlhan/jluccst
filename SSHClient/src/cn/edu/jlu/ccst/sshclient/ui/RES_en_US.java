package cn.edu.jlu.ccst.sshclient.ui;

import java.util.ListResourceBundle;

public class RES_en_US extends ListResourceBundle
{
    static final Object[][] contents = {
            { "FILE", "File" }, 
            { "TASK", "Task" }, 
            { "HELP", "Help" },
            { "LANGUAGE", "语言" },
            {"CN","中文"},
            {"EN","English"}
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
