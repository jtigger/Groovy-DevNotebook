package com.infosysengr

class ShellPlay {

	static void main(String[] args) {
		def shell = new GroovyShell()
		def greeting = "Hello"
		boolean flag = false
		
		shell.evaluate("println \"${greeting}, world!\"; flag = true");
		
		println flag
	}
}
