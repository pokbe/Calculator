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
			if(equals_flag==false&&"0123456789.()sincostanlnlogn!+-*��^��".indexOf(command)!=-1){
				if(right(str)){
					if("+-*��^��")
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
		String reg="0123456789.+-*�¡�^incotasslg()!*";
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
	
	private void TipChecker(String tipcommand1,String tipcommand2){
		int Tipcode1=0,Tipcode2=0;
		int tiptype1=0,tiptype2=0;
		int bracket=0;
		if(tipcommand1.compareTo("#")==0&&(tipcommand2.compareTo("��")==0||tipcommand2.compareTo("*")==0||tipcommand2.compareTo("+")==0||tipcommand2.compareTo(")")==0||tipcommand2.compareTo("��")==0
				||tipcommand2.compareTo("^")==0)){
			Tipcode1=-1;
		}
		
		else if(tipcommand1.compareTo("#")!=0){
			if(tipcommand1.compareTo("(")==0){
				tiptype1=1;
			}else if(tipcommand1.compareTo(")")==0){
				tiptype1=2;
			}else if(tipcommand1.compareTo(".")==0){
				tiptype1=3;
			}else if("0123456789".indexOf(tipcommand1)!=-1){
				tiptype1=4;
			}else if("+-*��".indexOf(tipcommand1)!=-1){
				tiptype1=5;
			}else if("^��".indexOf(tipcommand1)!=-1){
				tiptype1=6;
			}else if("sincostanloglnn!".indexOf(tipcommand1)!=-1){
				tiptype1=7;
			}
			if(tipcommand2.compareTo("(")==0){
				tiptype2=1;
			}else if(tipcommand2.compareTo(")")==0){
				tiptype2=2;
			}else if(tipcommand2.compareTo(".")==0){
				tiptype2=3;
			}else if("0123456789".indexOf(tipcommand2)!=-1){
				tiptype2=4;
			}else if("+-*��".indexOf(tipcommand2)!=-1){
				tiptype2=5;
			}else if("^��".indexOf(tipcommand2)!=-1){
				tiptype2=6;
			}else if("sincostanloglnn!".indexOf(tipcommand2)!=-1){
				tiptype2=7;
			}
			
			switch(tiptype1){
			case 1:
				if(tiptype2==2||(tiptype2==5&&tipcommand2.compareTo("-")!=0)||tiptype2==6)
					Tipcode1=1;
				break;
			case 2:
				if(tiptype2==1||tiptype2==3||tiptype2==4||tiptype2==7)
					Tipcode1=2;
				break;
			case 3:
				if(tiptype2==1||tiptype2==7)
					Tipcode1=3;
				if(tiptype2==3)
					Tipcode1=8;
				break;
			case 4:
				if(tiptype2==1||tiptype2==7)
					Tipcode1=4;
				break;
			case 5:
				if(tiptype2==2||tiptype2==5||tiptype2==6)
					Tipcode1=5;
				break;
			case 6:
				if(tiptype2==2||tiptype2==5||tiptype2==6||tiptype2==7)
					Tipcode1=6;
				break;
			case 7:
				if(tiptype2==2||tiptype2==5||tiptype2==6||tiptype2==7)
					Tipcode1=7;
				break;
			}
		}
		
		if(Tipcode1==0&&tipcommand2.compareTo(".")==0){
			int tip_point=0;
			for(int i=0;i<tip_i;i++){
				if(Tipcommand[i].compareTo(".")==0){
					tip_point++;
				}
				if(Tipcommand[i].compareTo("sin")==0||Tipcommand[i].compareTo("cos")==0||Tipcommand[i].compareTo("tan")==0||Tipcommand[i].compareTo("log")==0||
						Tipcommand[i].compareTo("ln")==0||Tipcommand[i].compareTo("n!")==0||Tipcommand[i].compareTo("��")==0||Tipcommand[i].compareTo("^")==0||
						Tipcommand[i].compareTo("��")==0||Tipcommand[i].compareTo("*")==0||Tipcommand[i].compareTo("-")==0||Tipcommand[i].compareTo("+")==0||
						Tipcommand[i].compareTo("(")==0||Tipcommand[i].compareTo(")")==0){
					tip_point=0;
				}
			}
			if(tip_point>1){
				Tipcode1=8;
			}
		}
		if(Tipcode1==0&&tipcommand2.compareTo(")")==0){
			int tip_right_bracket=0;
			for(int i=0;i<tip_i;i++){
				if(Tipcommand[1].compareTo("(")==0){
					tip_right_bracket++;
				}
				if(Tipcommand[i].compareTo(")")==0){
					tip_right_bracket--;
				}
			}
			if(tip_right_bracket==0){
				Tipcode1=10;
			}
		}
		
		if(Tipcode1==0&&tipcommand2.compareTo("=")==0){
			int tip_bracket=0;
			for(int i=0;i<tip_i;i++){
				if(Tipcommand[i].compareTo("(")==0){
					tip_bracket++;
				}
				if(Tipcommand[i].compareTo(")")==0){
					tip_bracket--;
				}
			}
			if(tip_bracket>0){
				Tipcode1=9;
				bracket=tip_bracket;
			}else if(tip_bracket==0){
				if("��^sincostanloglnn!".indexOf(tipcommand1)!=-1){
					Tipcode1=6;
				}
				if("+-*��".indexOf(tipcommand1)!=-1){
					Tipcode1=5;
				}
			}
		}
		
		if(tipcommand2.compareTo("MC")==0)
			Tipcode2=1;
		if(tipcommand2.compareTo("C")==0)
			Tipcode2=2;
		if(tipcommand2.compareTo("DRG")==0)
			Tipcode2=3;
		if(tipcommand2.compareTo("bk")==0)
			Tipcode2=4;
		if(tipcommand2.compareTo("sin")==0)
			Tipcode2=5;
		if(tipcommand2.compareTo("cos")==0)
			Tipcode2=6;
		if(tipcommand2.compareTo("tan")==0)
			Tipcode2=7;
		if(tipcommand2.compareTo("log")==0)
			Tipcode2=8;
		if(tipcommand2.compareTo("ln")==0)
			Tipcode2=9;
		if(tipcommand2.compareTo("n!")==0)
			Tipcode2=10;
		if(tipcommand2.compareTo("��")==0)
			Tipcode2=11;
		if(tipcommand2.compareTo("^")==0)
			Tipcode2=12;
		
		TipShow(bracket,Tipcode1,Tipcode2,tipcommand1,tipcommand2);
		
	}
	
	private void TipShow(int bracket,int tipcode1,int tipcode2,String tipcommand1,String tipcommand2){
		String tipmessage="";
		if(tipcode1!=0){
			tip_lock=false;
		}
		switch(tipcode1){
		case -1:
			tipmessage=tipcommand2+ " ������Ϊ��һ�����\n";
			break;
		case 1:
			tipmessage=tipcommand1+ " ��Ӧ�������/(/,/-/����\n";
			break;
		case 2:
			tipmessage=tipcommand1+ " ��Ӧ���룺��/��� \n";
			break;
		case 3:
			tipmessage=tipcommand1+" ��Ӧ���룺)/���֡����\n";
			break;
		case 4:
			tipmessage=tipcommand1+" ��Ӧ���룺��/./����/���\n";
			break;
		case 5:
			tipmessage=tipcommand1+ " ��Ӧ���룺(/./����/���� \n";
			break;
		case 6:
			tipmessage=tipcommand1+ " ��Ӧ���룺(/./���� \n";
			break;
		case 7:
			tipmessage=tipcommand1+ " ��Ӧ���룺 (/./���� \n";
			break;
		case 8:
			tipmessage="С�����ظ�\n";
			break;
		case 9:
			tipmessage="���ܼ��㣬ȱ��"+bracket+"��)";
			break;
		case 10:
			tipmessage="����Ҫ )";
			break;
		}
		switch(tipcode2) {
        case 1:
            tipmessage = tipmessage + "[MC �÷�: ������� MEM]";
            break;
        case 2:
            tipmessage = tipmessage + "[C �÷�: ����]";
            break;
        case 3:
            tipmessage = tipmessage + "[DRG �÷�: ѡ�� DEG �� RAD]";
            break;
        case 4:
            tipmessage = tipmessage + "[Bksp �÷�: �˸�]";
            break;
        case 5:
            tipmessage = tipmessage + "sin �����÷�ʾ����\n" +
                    "DEG��sin30 = 0.5      RAD��sin1 = 0.84\n" +
                    "ע������������һ��ʹ��ʱҪ�����ţ��磺\n" +
                    "sin(cos45)��������sincos45" ;
            break;
        case 6:
            tipmessage = tipmessage + "cos �����÷�ʾ����\n" +
                    "DEG��cos60 = 0.5      RAD��cos1 = 0.54\n" +
                    "ע������������һ��ʹ��ʱҪ�����ţ��磺\n" +
                    "cos(sin45)��������cossin45" ;
            break;
        case 7:
            tipmessage = tipmessage + "tan �����÷�ʾ����\n" +
                    "DEG��tan45 = 1      RAD��tan1 = 1.55\n" +
                    "ע������������һ��ʹ��ʱҪ�����ţ��磺\n" +
                    "tan(cos45)��������tancos45" ;
            break;
        case 8:
            tipmessage = tipmessage + "log �����÷�ʾ����\n" +
                    "log10 = log(5+5) = 1\n" +
                    "ע������������һ��ʹ��ʱҪ�����ţ��磺\n" +
                    "log(tan45)��������logtan45" ;
            break;
        case 9:
            tipmessage = tipmessage + "ln �����÷�ʾ����\n" +
                    "ln10 = le(5+5) = 2.3   lne = 1\n" +
                    "ע������������һ��ʹ��ʱҪ�����ţ��磺\n" +
                    "ln(tan45)��������lntan45" ;
            break;
        case 10:
            tipmessage = tipmessage + "n! �����÷�ʾ����\n" +
                    "n!3 = n!(1+2) = 3��2��1 = 6\n" +
                    "ע������������һ��ʹ��ʱҪ�����ţ��磺\n" +
                    "n!(log1000)��������n!log1000" ;
            break;
        case 11:
            tipmessage = tipmessage + "�� �÷�ʾ����������θ���\n" +
                    "�磺27��3�θ�Ϊ  27��3 = 3\n" +
                    "ע������������һ��ʹ��ʱҪ�����ţ��磺\n" +
                    "(����)��(����) �� (n!3)��(log100) = 2.45";
            break;
        case 12:
            tipmessage = tipmessage + "^ �÷�ʾ�����������ƽ��\n" +
                    "�磺2��3�η�Ϊ  2^3 = 8\n" +
                    "ע������������һ��ʹ��ʱҪ�����ţ��磺\n" +
                    "(����)��(����) �� (n!3)^(log100) = 36";
            break;
        }
        //����ʾ��Ϣ��ʾ��tip
        tip.setText(tipmessage);
		
	}
	
	
}
