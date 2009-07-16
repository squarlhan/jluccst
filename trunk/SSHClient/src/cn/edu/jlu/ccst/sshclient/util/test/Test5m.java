/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.edu.jlu.ccst.sshclient.util.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Woden
 */
public class Test5m {

    public static void main(String[] args){
    	String cmd=".//squarlhan//line i.txt o.txt 1";
    	String rem=cmd.substring(cmd.indexOf(" "), cmd.length());
		//System.out.println("rem"+rem);
		rem=rem.trim();
		System.out.println("rem:"+rem);
		System.out.println("rem.indexOf():"+rem.indexOf(" "));
		rem=rem.substring(rem.indexOf(" "),rem.length());
		//System.out.println("rem"+rem);
		rem=rem.trim();
		System.out.println("rem:"+rem);
		
		System.out.println("rem.indexOf():"+rem.indexOf(" "));
		
		rem=rem.substring(0,rem.indexOf(" "));
		
		System.out.println("rem:"+rem);
    }

}
