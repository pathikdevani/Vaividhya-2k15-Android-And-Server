package com.spidren.ui.drawer.menu;

public enum MenuItemEnum {
	Events          ("Events"),
	My_Schedule     ("My Schedule"),
	News             ("News"),
	
	Ssasit          ("Ssasit"),
	Vavidhya        ("Vaividhya 15"),
	
	Our_Team        ("Our Team"),
	Sponsor         ("Sponsor"),
	
	Feedback        ("App Feedback"),
	Developer       ("Developer"),
	
	lable_Event     ("Event"),
	lable_Connect   ("Connect"),
	lable_Dev       ("{ }")
	;
	
	
	public final String name;
	
	private MenuItemEnum(String s) {
		this.name = s;
    }
	
	@Override
	public String toString() {
		return name;
	}
	
}
