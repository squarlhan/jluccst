package cn.edu.jlu.ccst.sshclient.ui;

import java.util.ListResourceBundle;

public class RES_MTASKUI_en_US extends ListResourceBundle{
	static final Object[][] contents = {
        {"CREATEBATCHTASKS","CreateABatchOfTasks"}, 
        {"TASKSAMOUNT","EnterTaskAmount"}, 
        {"ONLYSTARTWITHINT","TaskAmountOnlyBePositiveInt"},
        {"NOTSTARTWITHZERO","TaskAmountCan'tStartWithZero"}, 
        {"ENTERPARAMETER","EnterParameter"}, 
        {"ENTERVARPARAMETER","EnterVarParameter"}, 
        {"VARREPLACEFROMONE","VarParameterReplaceFromOne"}, 
        {"TASKNAME","TaskName:"}, 
        {"WORKDIR","WorkDir:"}, 
        {"TASKCOMMAND","TaskCommand:"},
        {"RESULTFILE","ResultFile"},
        {"SEPARATEWITHSEMICOLON","SeparateWithSemicolonOfDBCCase"},
        {"PARAMETEREXPLANATION","SeparateParametersWithSemiconlonOfDBCCase，\nExpressVarParameterWith(),ForExampleTheFirstVarParameterIs(1)"},
        {"CHECKPARAMETERS","Enter/CheckAllParameters:"},
        {"PARAMETERRULE","EnterParameterRule:"},
        {"INPUTFILE","ChooseInputFile"},
        {"OUTPUTDIR","ChooseOutputDir"},
        {"TASKMEMO","TaskMemo:"},
        {"RESET","Reset:"},
        {"SUBMIT","Submit:"},
        {"DIREXPLANATION","DirFormatIsWrong，PleaseStartWith“/”"},
        {"CREATETASKSUCC","CreateTaskSucc！"},
        {"DIRSETTING","SettingDir..."},
        {"CREATEDIRSUCC","SetDirSucc！"}
        
	};

	public Object[][] getContents()
	{
	    return contents;
	}
}
