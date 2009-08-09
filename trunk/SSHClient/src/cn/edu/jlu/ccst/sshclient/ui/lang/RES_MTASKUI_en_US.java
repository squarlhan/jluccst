package cn.edu.jlu.ccst.sshclient.ui.lang;

import java.util.ListResourceBundle;

public class RES_MTASKUI_en_US extends ListResourceBundle{
	static final Object[][] contents = {

        {"CREATEBATCHTASKS","Create A Batch Of Tasks"}, 
        {"TASKSAMOUNT","Task Amount:"}, 
        {"TIP_TASKSAMOUNT","Please Input Task Amount!"}, 
        {"ONLYSTARTWITHINT","Task Amount Only Be Positive Integer!"},
        {"NOTSTARTWITHZERO","Task Amount Can't Start With Zero!"}, 
        {"ENTERPARAMETER","Options:"}, 
        {"TIP_ENTERPARAMETER","Please Input Task Options!"}, 
        {"ENTERVARPARAMETER","Enter Var Options!"}, 
        {"VARREPLACEFROMONE","VarOption Replace From One"}, 
        {"TASKNAME","Task Name:"}, 
        {"TIP_TASKNAME","Please Input Task Name!"}, 
        {"WORKDIR","Working Dir:"}, 
        {"TIP_WORKDIR","Please Input Working Dir!"}, 
        {"TASKCOMMAND","Command:"},
        {"TIP_TASKCOMMAND","Please Input Task Command!"}, 
        {"RESULTFILE","Result File:"},
        {"SEPARATEWITHSEMICOLON","Please use ';' to separate multiple result files!"},
        {"PARAMETEREXPLANATION","Please use ';' to separate multiple options! For Example, The First VarParameter Is (1)"},
        {"CHECKPARAMETERS","Enter/Check Options"},
        {"PARAMETERRULE","EnterOptionRule"},
        {"INPUTFILE","Input File:"},
        {"OUTPUTDIR","Output Dir:"},
        {"TIP_OUTPUTDIR","Please Input Output Dir!"},
        {"TASKMEMO","Memo:"},
        {"RESET","Reset"},
        {"SUBMIT","Submit"},
        {"DIREXPLANATION","Dir Format Is Wrong! Please Start With “/”"},
        {"CREATETASKSUCC","Create Task Success!"},
        {"DIRSETTING","Setting Dir..."},
        {"CREATEDIRSUCC","Set Dir Success!"},
        {"BROWSE","Browse"},
        {"SET_UPLOAD","Upload"}
        

	};

	public Object[][] getContents()
	{
	    return contents;
	}
}
