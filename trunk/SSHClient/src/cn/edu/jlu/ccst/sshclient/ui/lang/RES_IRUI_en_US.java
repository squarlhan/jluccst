package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_IRUI_en_US extends ListResourceBundle
{
    static final Object[][] contents = {
            {"TITLE","Input Option Rules"}, 
            {"LOWER_BOUND_1","Input Lower of Opt"}, 
            {"LOWER_BOUND_2",""}, 
            {"UPPER_BOUND","Upper"}, 
            {"NUMBER","Number"}, 
            {"RESET","Reset"}, 
            {"SUBMIT","Submit"}, 
            {"TIP_SUCCESS","Input option rules Success!"}, 
            {"TIP_NO_SAME","Product of the number of each option must be the same number of tasks!"}, 
            {"TIP_NO_LOWER_1","Please Input the Lower Bound of Option "}, 
            {"TIP_NO_LOWER_2","!"}, 
            {"TIP_NO_UPPER_1","Please Input the Upper Bound of Option "}, 
            {"TIP_NO_UPPER_2","!"},
            {"TIP_NO_NUMBER_1","Please Input the Number of Option "}, 
            {"TIP_NO_NUMBER_2","!"},
            {"TIP_LOWER_1","Lower Bound of Option "},
            {"TIP_LOWER_2","  must be a Decimal or Integer!"},
            {"TIP_UPPER_1","Upper Bound of Option "},
            {"TIP_UPPER_2","  must be a Decimal or Integer!"},
            {"TIP_NUMBER_1","Number of Option "},
            {"TIP_NUMBER_2"," must be a Positive Integer!"},
            {"TIP_LOWER_UPPER_1","Option "},
            {"TIP_LOWER_UPPER_2","'s Upper must be greater than or equal to Lower!"},
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
