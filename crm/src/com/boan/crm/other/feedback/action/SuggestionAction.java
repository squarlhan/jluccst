package com.boan.crm.other.feedback.action;

import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.boan.crm.backstagemanage.common.ProductType;
import com.boan.crm.common.Message;
import com.boan.crm.groupmanage.model.Menu;
import com.boan.crm.groupmanage.service.IMenuService;
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
	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService = null;

	private Pagination<Suggestion> pagination = new Pagination<Suggestion>();

	private Suggestion suggestion = null;

	private List<Menu> menuList = null;

	private Message message = new Message();
	
	private String suggestionId = null;
	
	private String[] suggestionIds = null;

	/**
	 * 显示列表用于意见反馈
	 * 
	 * @return
	 */
	public String showList() {
		pagination = service.findSuggestionForPage(null, pagination);
		return "show-list";
	}
	
	/**
	 * 显示列表用于查看反馈
	 * 
	 * @return
	 */
	public String showListForFeedback() {
		pagination = service.findSuggestionForPage(null, pagination);
		return "show-list";
	}

	/**
	 * 显示信息页
	 * 
	 * @return
	 */
	public String showInfo() {
		
		menuList = menuService.getOneLevelMenuListByProductType(ProductType.CRM, null, 1);
		return "show-info";
	}
	
	/**
	 * 显示意见及反馈详情
	 * @return
	 */
	public String showSuggestionDetail()
	{
		suggestion = service.get(suggestionId);
		return "show-info-detail";
	}

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String saveInfo() {
		try {
			suggestion.setUserId(sessionUserId);
			suggestion.setUserName(sessionUserCName);
			suggestion.setOrganId(sessionDeptId);
			suggestion.setOrganName(sessionDeptName);
			suggestion.setUnitId(sessionCompanyId);
			suggestion.setUnitName(sessionCompanyName);
			suggestion.setCreateTime(Calendar.getInstance());
			if (StringUtils.isNotBlank(suggestion.getMenuKey())) {
				Menu menu = menuService.getMenuByKey(suggestion.getMenuKey());
				if (menu != null) {
					suggestion.setMenuName(menu.getMenuName());
				}
			}
			service.save(suggestion);
			message.setContent("意见已成功提交！");
			return SUCCESS;
		} catch (Exception e) {
			message.setContent("意见保存发生异常，请联系管理员！");
			return ERROR;
		}
	}

	/**
	 * 删除多条
	 * 
	 * @return
	 */
	public String deleteItem() {
		if( StringUtils.isNotBlank(suggestionId) )
		{
			service.delete(new String[]{suggestionId});
		}
		return this.showList();
	}
	
	/**
	 * 删除单条
	 * 
	 * @return
	 */
	public String deleteItems() {
		if( suggestionIds != null && suggestionIds.length > 0 )
		{
			service.delete(suggestionIds);
		}
		return this.showList();
	}

	public ISuggestionService getService() {
		return service;
	}

	public void setService(ISuggestionService service) {
		this.service = service;
	}

	public Pagination<Suggestion> getPagination() {
		return pagination;
	}

	public void setPagination(Pagination<Suggestion> pagination) {
		this.pagination = pagination;
	}

	public Suggestion getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}

	public IMenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(IMenuService menuService) {
		this.menuService = menuService;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public String getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(String suggestionId) {
		this.suggestionId = suggestionId;
	}

	public String[] getSuggestionIds() {
		return suggestionIds;
	}

	public void setSuggestionIds(String[] suggestionIds) {
		this.suggestionIds = suggestionIds;
	}
}
