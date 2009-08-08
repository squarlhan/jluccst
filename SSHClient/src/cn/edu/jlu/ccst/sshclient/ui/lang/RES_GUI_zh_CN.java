package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_GUI_zh_CN extends ListResourceBundle
{
    static final Object[][] contents = {
            {"TITLE","新建工作组"}, 
            {"MODIFY_GROUP","修改工作组"}, 
            {"GROUP_NAME","工作组名字"},
            {"NEW","新建"}, 
            {"WORK_DIR","工作目录"}, 
            {"MEMO","备注"}, 
            {"RESET","重置"}, 
            {"SUBMIT","提交"}, 
            {"INPUT_GROUP_NAME","请输入工作组的名字"}, 
            {"INPUT_WORK_DIR","请输入工作组目录"}, 
            {"WRONG_DIR","目录格式不对，请以“/”开头"}, 
            {"CREAT_GROUP_SUC","创建组成功"}, 
            {"MODIFY_GP_SUC","修改组成功"}, 
            {"SET_UP_DIR","正在设置目录"}, 
            {"SET_UP_DIR_SUC","设置目录成功"}, 
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
