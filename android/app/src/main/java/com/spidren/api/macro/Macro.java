package com.spidren.api.macro;

public abstract class Macro implements MacroCall {

	private MacroTag tag;

	public Macro(MacroTag tag) {
		this.tag = tag;
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) {
			return true;
		}
		if (o == null || !(o instanceof Macro)) {
			return false;
		}

		Macro call = (Macro) o;
		if (call.tag == tag)
			return true;

		return false;
	}

	public MacroTag getTag() {
		return tag;
	}
	
}

interface MacroCall{
	public void run(Object obj);
}
