package com.bit2017.emailList.web;

import com.bit2017.web.Action;
import com.bit2017.web.ActionFactory;

public class EmailListActionFactory extends ActionFactory{
	public Action getAction(String actionName){
		Action action = null;
		
		if("form".equals(actionName)){
			action = new FormAction();
		}else if("add".equals(actionName)){
			action = new AddAction();
		}else{
			action = new  ListAction();
		}
		return action;
	}
}
