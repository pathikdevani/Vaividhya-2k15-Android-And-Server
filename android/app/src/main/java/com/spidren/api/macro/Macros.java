package com.spidren.api.macro;

import java.util.HashMap;
import java.util.Map;

public class Macros {
	Map<MacroTag, Macro> list;

	public Macros() {
		list = new HashMap<MacroTag, Macro>();
	}

	public void addMacro(Macro macro) {
		if (list.containsKey(macro.getTag())) {
			list.remove(macro);
		}
		list.put(macro.getTag(), macro);
	}

	public void removeMacro(Macro macro) {
		list.remove(macro.getTag());
	}

	public void run(MacroTag tag,Object obj) {
		if (list.containsKey(tag)) {
			Macro macro = list.get(tag);
			macro.run(obj);
		}
	}
	
	public void run(MacroTag tag) {
		run(tag, null);
	}
	
	public boolean isExites(MacroTag tag){
		if(list.containsKey(tag)){
			return true;
		}
		
		return false;
	}
}
