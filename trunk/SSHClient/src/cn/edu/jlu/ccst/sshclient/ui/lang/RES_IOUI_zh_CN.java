package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_IOUI_zh_CN extends ListResourceBundle
{
    static final Object[][] contents = {
            {"TITLE","输入所有任务参数"}, 
            {"INPUT_1","请输入第"}, 
            {"INPUT_2","个任务的参数"},
            {"RESET","重置"}, 
            {"SUBMIT","提交"}, 
            {"TIP_TIP","请用半角分号隔开多个参数！"}, 
            {"TIP_SUCCESS","输入任务参数成功！"}, 
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
