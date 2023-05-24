package com.lgcns.test;

public class MultiThread {
	
	public void start(int threadCount) {
		NewThread[] newThread = new NewThread[threadCount];
	}
}


class NewThread extends Thread
{
	String url;
	String port;
	
	
	NewThread(String url,int number,String post){
    	this.url=url;
    	this.port=post;
    }
    public void run(){
        try{
        	
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}