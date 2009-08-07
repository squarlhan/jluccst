package cn.edu.jlu.ccst.sshclient.ui;

import java.util.ListResourceBundle;

public class RES_MTASKUI_zh_CN extends ListResourceBundle{
	static final Object[][] contents = {
        {"CREATEBATCHTASKS","新建批量任务"}, 
        {"TASKSAMOUNT","请输入任务个数"}, 
        {"ONLYSTARTWITHINT","任务个数只能是正整数:"},
        {"NOTSTARTWITHZERO","任务个数不能以0开头"}, 
        {"ENTERPARAMETER","请输入参数"}, 
        {"ENTERVARPARAMETER","请输入可变参数"}, 
        {"VARREPLACEFROMONE","可变参数从1开始替换"}, 
        {"TASKNAME","任务名字:"}, 
        {"WORKDIR","工作目录:"}, 
        {"TASKCOMMAND","任务命令:"},
        {"RESULTFILE","结果文件"},
        {"SEPARATEWITHSEMICOLON","请用半角分号隔开"},
        {"PARAMETEREXPLANATION","参数之间请用半角分号隔开，\n可变参数请用(),例如第一个可变参数是(1)"},
        {"CHECKPARAMETERS","输入/查看全部参数:"},
        {"PARAMETERRULE","输入参数规则:"},
        {"INPUTFILE","选择输入文件"},
        {"OUTPUTDIR","选择输出目录"},
        {"TASKMEMO","任务备注:"},
        {"RESET","重置:"},
        {"SUBMIT","提交:"},
        {"DIREXPLANATION","目录格式不对，请以“/”开头"},
        {"CREATETASKSUCC","创建任务成功！"},
        {"DIRSETTING","正在设置目录..."},
        {"CREATEDIRSUCC","设置目录成功！"}
        
	};

	public Object[][] getContents()
	{
	    return contents;
	}
}
