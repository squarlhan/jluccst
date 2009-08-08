package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_IRUI_zh_CN extends ListResourceBundle
{
    static final Object[][] contents = {
            {"TITLE","输入参数规则"}, 
            {"LOWER_BOUND_1","请输入第"}, 
            {"LOWER_BOUND_2","个参数的下界"}, 
            {"UPPER_BOUND","上界"}, 
            {"NUMBER","个数"}, 
            {"RESET","重置"}, 
            {"SUBMIT","提交"}, 
            {"TIP_SUCCESS","输入任务参数规则成功！"}, 
            {"TIP_NO_SAME","各参数个数乘积必须与任务个数相同！"}, 
            {"TIP_NO_LOWER_1","请输入第"}, 
            {"TIP_NO_LOWER_2","个参数的下界！"}, 
            {"TIP_NO_UPPER_1","请输入第"}, 
            {"TIP_NO_UPPER_2","个参数的上界！"},
            {"TIP_NO_NUMBER_1","请输入第"}, 
            {"TIP_NO_NUMBER_2","个参数的个数！"},
            {"TIP_LOWER_1","第"},
            {"TIP_LOWER_2","个参数上界必须是小数或整数"},
            {"TIP_UPPER_1","第"},
            {"TIP_UPPER_2","个参数下界必须是小数或整数"},
            {"TIP_NUMBER_1","第"},
            {"TIP_NUMBER_2","个参数个数是大于0整数"},
            {"TIP_LOWER_UPPER_1","第"},
            {"TIP_LOWER_UPPER_2","个参数上界必须大于等于下界"},
    };

    public Object[][] getContents()
    {
        return contents;
    }
}
