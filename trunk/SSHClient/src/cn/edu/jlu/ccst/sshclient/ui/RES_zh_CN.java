package cn.edu.jlu.ccst.sshclient.ui;

import java.util.ListResourceBundle;

public class RES_zh_CN extends ListResourceBundle
{
    static final Object[][] contents = {
            {"FILE","文件"}, 
            {"TASK","任务"}, 
            {"HELP","帮助"},
            {"LANGUAGE","Language"},
            {"CN","中文"},
            {"EN","English"},
            {"COPY","复制"},
            {"CLOSE","关闭窗口"},
            {"CLEAR","清空"},
            {"CREATE","新建"},
            {"COMPUTER","计算机"},
            {"GROUP","任务组"},
            {"TASK","任务"},
            {"QUIT","退出"},
            {"MODIFY","修改"},
            {"DELETE","删除"},
            {"SERIAL_START_GROUP","串行启动组内所有任务"},
            {"PARALLEL_START_GROUP","同时启动组内所有任务"},
            {"STOP_GROUP","停止组内所有任务"},
            {"START_ALL","启动所有任务"},
            {"STOP_ALL","停止所有任务"},
            {"START_RIGHT_NOW","立即启动任务"},
            {"STOP_ANYWAY","停止当前任务"},
            {"INDEX","索引"},
            {"ABOUT","关于"},
            {"ADD_GROUP","添加任务组"},
            {"DELETE_COMPUTER","删除此电脑"},
            {"MODIFY_COMPUTER","修改此电脑"},
            {"ADD_TASK","添加一新任务"},
            {"ADD_MANY_TASK","添加批量任务"},
            {"DELETE_GROUP","删除此任务组"},
            {"MODIFY_GROUP","修改此任务组"},
            {"DOWNLOAD_GROUP","下载组内所有任务结果"},
            {"DELETE_TASK","删除此任务"},
            {"MODIFY_TASK","修改此任务"},
            {"EXECLUDE_TASK","执行任务命令"},
            {"STOP_TASK","停止任务命令"},
            {"DOWNLOAD_TASK","下载结果文件"},
            {"UPLOAD_TASK","上传输入文件"},
            {"SHOW_RESULT","查看任务结果"},
            {"ADD_COMPUTER","添加一新电脑"},
            {"DELETE_ALL","删除所有电脑"},
            {"TIP_NOT_DELETE","有任务执行，不能删除!"},
            {"TIP_NETWORK","网络连接不可用!"},
            {"TITLE_NETWORK","连接报错"},
            {"TIP_NO_SOURCE","源文件不存在!"},
            {"TITLE_NO_SOURCE","传输报错"},
            {"TIP_FILE_EXIST","目标文件已存在，是否覆盖?"},
            {"TITLE_FILE_EXIST","确认覆盖"},
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
