package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_OTHER_en_US extends ListResourceBundle
{
    static final Object[][] contents = {
            {"TEST_CONC","Test Complete"}, 
            {"TEST_SUCCESS","Connection Success!"}, 
            {"TEST_FAILD","Connection Failed!"},
            {"DEL_TASK","Delete the Task?"},
            {"DEL_GROUP","Delete the Group?"},
            {"DEL_COMPUTER","Delete the Computer?"},
            {"DEL_CONFIRM","Delete Confirm"},
            {"DEL_DIR","Delete the Working Directory?"},
            {"DEL_DIR_CONFIRM","Delete Directory"},
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
