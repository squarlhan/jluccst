package com.boan.crm.other.feedback.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.other.feedback.model.Suggestion;
import com.boan.crm.other.feedback.service.ISuggestionService;
import com.boan.crm.utils.action.BaseActionSupport;
import com.boan.crm.utils.page.Pagination;

/**
 * 意见反馈功能Action类
 * 
 * @author Administrator
 * 
 */
@Controller("suggestionAction")
@Scope("prototype")
public class SuggestionAction extends BaseActionSupport {

	private static final long serialVersionUID = -39809965567960159L;

	@Autowired
	@Qualifier("suggestionService")
	private ISuggestionService service = null;

	private Pagination<Suggestion> pagination = new Pagination<Suggestion>();

	/**
	 * 显示列表
	 * 
	 * @return
	 */
	public String showList()  {
		pagination = service.findSuggestionForPage(null, pagination);
		return SUCCESS;
	}

	/**
	 * 显示信息页
	 * 
	 * @return
	 */
	public String showInfo() {
		return SUCCESS;
	}

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String saveInfo() {
		// 保存日志结束
		return SUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String deleteInfo()
	{
		return this.showList();
	}
}