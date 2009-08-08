package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_TUI_zh_CN extends ListResourceBundle
{
    static final Object[][] contents = {
            {"TITLE_NEW","新建任务"}, 
            {"TITLE_MOD","修改任务"}, 
            {"TASK_NAME","任务名字"},
            {"WORK_DIR","工作目录"}, 
            {"TASK_COMMAND","任务命令"}, 
            {"RESULT_FILE","结果文件"},
            {"TIP_TEXT_SEP","请用半角分号隔开"}, 
            {"PARAMETERS","任务参数"}, 
            {"SELECT_INPUT_FILE","选择输入文件"}, 
            {"OUTPUT_DIR_SEL","请选择输出目录"}, 
            {"TASK_MEMO","任务备注"}, 
            {"RESET","重置"}, 
            {"SUBMIT","提交"},
            {"BROWSER","打开"},
            {"INPUT_TASK_NAME","请输入任务命令的名字"}, 
            {"INPUT_WORK_DIR","请输入工作组目录"}, 
            {"WRONG_DIR","目录格式不对，请以“/”开头"}, 
            {"NEW_TASK_CMD","请输入新建任务的命令"}, 
            {"OUTPUT_DIR","输出目录"}, 
            {"NEW_TASK_SUC","创建任务成功！"}, 
            {"MOD_TASK_SUC","修改任务成功！"}, 
            {"SET_UP_DIR","正在设置目录"}, 
            {"SET_UP_DIR_SUC","设置目录成功"}, 
            {"SET_UPLOAD","提交后上传"}, 
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
