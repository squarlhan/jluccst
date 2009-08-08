package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_GUI_en_US extends ListResourceBundle
{
    static final Object[][] contents = {
            {"TITLE","New Work Group"}, 
            {"MODIFY_GROUP","Modify Work Group"}, 
            {"GROUP_NAME","Group Name"},
            {"NEW","New"}, //TODO test
            {"WORK_DIR","Work Dir"}, 
            {"MEMO","Memo"}, 
            {"RESET","Reset"}, 
            {"SUBMIT","Submit"}, 
            {"INPUT_GROUP_NAME","Please Input the Group Name"}, 
            {"INPUT_WORK_DIR","Please Input the Work Directory"}, 
            {"WRONG_DIR","Directory Format Incorrect, Start with \"/\""}, 
            {"CREAT_GROUP_SUC","Create group successful"}, //TODO test
            {"MODIFY_GP_SUC","Modified Group Successfully"}, 
            {"SET_UP_DIR","Setting up Directory"},
            {"SET_UP_DIR_SUC","Directory Set up Duccessfully"}, 
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
