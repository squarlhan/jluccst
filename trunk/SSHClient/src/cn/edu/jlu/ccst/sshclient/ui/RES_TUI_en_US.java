package cn.edu.jlu.ccst.sshclient.ui;

import java.util.ListResourceBundle;

public class RES_TUI_en_US extends ListResourceBundle
{
    static final Object[][] contents = {
    	{"TITLE_NEW","New Task"}, 
        {"TITLE_MOD","Modify Task"}, 
        {"TASK_NAME","Task Name"},
        {"WORK_DIR","Work Dir"}, 
        {"TASK_COMMAND","Task Command"}, 
        {"TIP_TEXT_SEP","Please use ';' to separate multiple options!"}, 
        {"RESULT_FILE","Result Flie"},
        {"PARAMETERS","Parameters"}, 
        {"SELECT_INPUT_FILE","Input File"}, 
        {"OUTPUT_DIR_SEL","Select the Output Dir"}, 
        {"TASK_MEMO","Task Memo"}, 
        {"RESET","Reset"}, 
        {"SUBMIT","Submit"},
        {"BROWSER","Browser"},
        {"INPUT_TASK_NAME","Please Input the Task Name"}, 
        {"INPUT_WORK_DIR","Please Input the Work Directory"}, 
        {"WRONG_DIR","Directory Format Incorrect, Start with \"/\""}, 
        {"NEW_TASK_CMD","Please Input the Task Command"}, 
        {"OUTPUT_DIR","Output Dir"}, 
        {"NEW_TASK_SUC","Create Task Successfully"}, //TODO test
        {"MOD_TASK_SUC","Modify Task Successfully"}, 
        {"SET_UP_DIR","Setting Up Directory"},
        {"SET_UP_DIR_SUC","Directory Set Up Successfully"},
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
