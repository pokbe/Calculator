package com.activity;
import com.example.android_calculator.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;


public class MainActivity extends Activity{
	private Button[] btn=new Button[10];
	private EditText input;
	private TextView mem;
	private TextView _drg;
	private TextView tip;
	private Button
		div,mul,sub,add,equal,sin,cos,tan,log,ln,
		sqrt,square,factorial,bksp,left,right,dot,exit,drg,mc,c;
	public String str_old;
	public String str_new;
	public boolean vbegin=true;
	public boolean drg_flag=true;
	public double pi=4*Math.atan(1);
	public boolean tip_lock=true;
	public boolean equals_flag=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		input=(EditText)findViewById(R.id.input);
		mem=(TextView)findViewById(R.id.mem);
		tip=(TextView)findViewById(R.id.tip);
		_drg=(TextView)findViewById(R.id._drg);
		btn[0]=(Button)findViewById(R.id.zero);
		btn[1]=(Button)findViewById(R.id.one);
		btn[2]=(Button)findViewById(R.id.two);
		btn[3]=(Button)findViewById(R.id.three);
		btn[4]=(Button)findViewById(R.id.four);
		btn[5]=(Button)findViewById(R.id.five);
		btn[6]=(Button)findViewById(R.id.six);
		btn[7]=(Button)findViewById(R.id.seven);
		btn[8]=(Button)findViewById(R.id.eight);
		btn[9]=(Button)findViewById(R.id.nine);
		div=(Button)findViewById(R.id.divide);
		mul=(Button)findViewById(R.id.mul);
		sub=(Button)findViewById(R.id.sub);
		add=(Button)findViewById(R.id.add);
		equal=(Button)findViewById(R.id.equal);
		sin=(Button)findViewById(R.id.sin);
		cos=(Button)findViewById(R.id.cos);
		tan=(Button)findViewById(R.id.tan);
		log=(Button)findViewById(R.id.log);
		ln=(Button)findViewById(R.id.ln);
		sqrt=(Button)findViewById(R.id.sqrt);
		square=(Button)findViewById(R.id.square);
		factorial=(Button)findViewById(R.id.factorial);
		bksp=(Button)findViewById(R.id.bksp);
		left=(Button)findViewById(R.id.left);
		right=(Button)findViewById(R.id.right);
		dot=(Button)findViewById(R.id.dot);
		exit=(Button)findViewById(R.id.exit);
		drg=(Button)findViewById(R.id.drg);
		mc=(Button)findViewById(R.id.mc);
		c=(Button)findViewById(R.id.c);
		for(int i=0;i<10;i++){
			btn[i].setOnClickListener(actionPerformed);
		}
		div.setOnClickListener(actionPerformed);
		mul.setOnClickListener(actionPerformed);
		sub.setOnClickListener(actionPerformed);
		add.setOnClickListener(actionPerformed);
		equal.setOnClickListener(actionPerformed);
		sin.setOnClickListener(actionPerformed);
		cos.setOnClickListener(actionPerformed);
		tan.setOnClickListener(actionPerformed);
		log.setOnClickListener(actionPerformed);
		ln.setOnClickListener(actionPerformed);
		sqrt.setOnClickListener(actionPerformed);
		square.setOnClickListener(actionPerformed);
		factorial.setOnClickListener(actionPerformed);
		bksp.setOnClickListener(actionPerformed);
		left.setOnClickListener(actionPerformed);
		right.setOnClickListener(actionPerformed);
		dot.setOnClickListener(actionPerformed);
		exit.setOnClickListener(actionPerformed);
		drg.setOnClickListener(actionPerformed);
		mc.setOnClickListener(actionPerformed);
		c.setOnClickListener(actionPerformed);
	}
	
	String[] Tipcommand=new String[500];
	int tip_i=0;
	private OnClickListener actionPerformed=new OnClickListener(){
		public void onClick(View v){
			String command=((Button)v).getText().toString();
			String str=input.getText().toString();
			if(equals_flag==false&&"0123456789.()sincostanlnlogn!+-*¡Â^¡Ì".indexOf(command)!=-1){
				if(right(str)){
					
				}
			}
		}
	};
	
	private void print(String str){
		if(vbegin){
			input.setText(str);
		}else{
			input.append(str);
		}
		vbegin=false;
	}
	
	private boolean right(String str){
		int i=0;
		String reg="0123456789.+-*¡Â¡Ì^incotasslg()!*";
		for(i=0;i<str.length();i++){
			int se=reg.indexOf(str.charAt(i));
			if(se==-1){
				break;
			}
		}
		if(i==str.length()){
			return true;
		}else{
			return false;
		}
	}
	
	private int TTO(String str){
		if((str.charAt(str.length()-1)=='n'&&str.charAt(str.length()-2)=='i'&&str.charAt(str.length()-3)=='s')
				||(str.charAt(str.length()-1)=='s'&&str.charAt(str.length()-2)=='o'&&str.charAt(str.length()-3)=='c')
				||(str.charAt(str.length()-1)=='n'&&str.charAt(str.length()-2)=='a'&&str.charAt(str.length()-3)=='t')
				||(str.charAt(str.length()-1)=='g'&&str.charAt(str.length()-2)=='o'&&str.charAt(str.length()-3)=='l')){
					return 3;
				}
				else if((str.charAt(str.length()-1)=='n'&&str.charAt(str.length()-2)=='l')
						||(str.charAt(str.length()-1)=='!'&&str.charAt(str.length()-2)=='n')){
					return 2;
				}
				else{
					return 1;
				}
	}
}
