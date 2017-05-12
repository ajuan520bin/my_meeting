package com.wllman.servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class IncomeTaxServlet
 */
public class IncomeTaxServlet extends HttpServlet {
	
	   public double getTax(double charge){
           double tax = 0;
           if(charge<=0){
                 tax = 0;
           }else if(charge>0&&charge<=1500){
                 tax = charge*0.03;
           }else if(charge>1500&&charge<=4500){
                 tax = charge*0.1-105;
           }else if(charge>4500&&charge<=9000){
                 tax = charge*0.2-555;
           }else if(charge>9000&&charge<=35000){
                 tax = charge*0.25-1005;
           }else if(charge>35000&&charge<=55000){
                 tax = charge*0.30-2755;
           }else if(charge>55000&&charge<=80000){
                 tax = charge*0.35-5505;
           }else if(charge>60000&&charge<=80000){
                 tax = charge*0.35-6375;
           }else if(charge>80000){
                 tax = charge*0.45-13505;
           }
           return tax;
     }
	   public double getTaxmin(double charge){
           double tax = 0;
           if(charge<=0){
                 tax = 0;
           }else if(charge>0&&charge<=1500){
                 tax =0;
           }else if(charge>1500&&charge<=4500){
                 tax = 105;
           }else if(charge>4500&&charge<=9000){
                 tax =555;
           }else if(charge>9000&&charge<=35000){
                 tax =1005;
           }else if(charge>35000&&charge<=55000){
                 tax = 2755;
           }else if(charge>55000&&charge<=80000){
                 tax =5505;
           }else if(charge>60000&&charge<=80000){
                 tax = 6375;
           }else if(charge>80000){
                 tax = 13505;
           }
           return tax;
     }
	   public double getsuilv(double charge){
           double tax = 0;
           if(charge<=0){
                 tax = 0;
           }else if(charge>0&&charge<=1500){
                 tax = 0.03;
           }else if(charge>1500&&charge<=4500){
                 tax =0.1;
           }else if(charge>4500&&charge<=9000){
                 tax = 0.2;
           }else if(charge>9000&&charge<=35000){
                 tax =0.25;
           }else if(charge>35000&&charge<=55000){
                 tax =0.30;
           }else if(charge>55000&&charge<=80000){
                 tax =0.35;
           }else if(charge>60000&&charge<=80000){
                 tax = 0.35;
           }else if(charge>80000){
                 tax =0.45;
           }
           return tax;
     }
	   
	   
	   public double getyanglao(double charge){
		   double tax=0;
		   tax=charge*0.08;
		   return tax;
	   }
	   public double getyiliao(double charge){
		   double tax=0;
		   tax=charge*0.02;
		   return tax;
	   }
	   public double getshiye(double charge){
		   double tax=0;
		   tax=charge*0.01;
		   return tax;
	   }
	   public double getgongshang(double charge){
		   double tax=0;
		   tax=charge*0.00;
		   return tax;
	   }
	   public double getshengyu(double charge){
		   double tax=0;
		   tax=charge*0.0;
		   return tax;
	   }
	   public double getgongjijin(double charge){
		   double tax=0;
		   tax=charge*0.07;
		   return tax;
	   }
	   
	   public double get5total(double total){
		   double tax=0;
		   double charge=0;
		   
		   if(total>9481){
			   charge=9481;
		   }
		   else{
			   charge=total;
		   }
		   tax=getyanglao(charge)+getyiliao(charge)+getshiye(charge)+getgongshang(charge)+getshengyu(charge)+getgongjijin(charge);
		   return tax;
	   }
	   
	   public double get5(double total){
		   double tax=0;
		   double charge=0;
		   
		   if(total>9481){
			   charge=9481;
		   }
		   else{
			   charge=total;
		   }
		   tax=charge-getyanglao(charge)-getyiliao(charge)-getshiye(charge)-getgongshang(charge)-getshengyu(charge)-getgongjijin(charge);
		   return tax;
	   }
	   public double getf(double total){
		   double charge=0;
		   
		   if(total>9481){
			   charge=9481;
		   }
		   else{
			   charge=total;
		   }
		   return charge;
	   }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  double laborage = Double.parseDouble(request.getParameter("laborage"));        //获得表单提交的工资收入
          double startPoint = Double.parseDouble(request.getParameter("startpoint"));//获得表单提交的征税起点金额      
          double total5=this.get5total(laborage);
          double  myTax = this.getTax(laborage - startPoint-total5);//调用计算个人所得税的方法
          double taxmin=this.getTaxmin(laborage - startPoint-total5);
          double suilu=this.getsuilv(laborage - startPoint-total5);
       
          DecimalFormat df = new DecimalFormat("#.00");
         

          
          System.out.println(laborage);
          System.out.println(startPoint);
          System.out.println(df.format(total5));
          System.out.println(df.format(myTax));
          System.out.println(taxmin);
          System.out.println();
          
          
          
 
          request.setAttribute("laborage",  df.format(laborage)); 
          request.setAttribute("startPoint",  df.format(startPoint)); 
          request.setAttribute("Tax",  df.format(myTax)); 
          request.setAttribute("taxmin",  df.format(taxmin));
          request.setAttribute("total5",  df.format(total5));
          request.setAttribute("suilu",  df.format(suilu));
          request.setAttribute("gongzi",  df.format(laborage-myTax));
         
         
          double charge=getf(laborage);
          System.out.println(getyanglao(charge));
          System.out.println(getyiliao(charge));
          System.out.println( getshiye(charge));
          System.out.println(getgongshang(charge));
          System.out.println(getshengyu(charge));
          System.out.println( getgongjijin(charge));
          request.setAttribute("yanglao", df.format(getyanglao(charge)));
          request.setAttribute("yilao",  df.format(getyiliao(charge)));
          request.setAttribute("shiye",  df.format(getshiye(charge)));
          request.setAttribute("gongshang",  df.format(getgongshang(charge)));
          request.setAttribute("shengyu",  df.format(getshengyu(charge)));
          request.setAttribute("gongjijin", df.format(getgongjijin(charge)));
          
          HttpSession session=request.getSession();
         int role = (Integer)session.getAttribute("role");
  		if (role == 1) {
  			request.getRequestDispatcher("calresult.jsp").forward(request, response);      //请求转发到result.jsp页
  		}else{
  			request.getRequestDispatcher("usercalresult.jsp").forward(request, response);      //请求转发到result.jsp页
  		}
          
   
	}

}
