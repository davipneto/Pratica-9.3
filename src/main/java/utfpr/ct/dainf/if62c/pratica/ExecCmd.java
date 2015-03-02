/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.IOException;

/**
 *
 * @author davip_000
 */
public class ExecCmd extends Thread {
    
    private Process proc;
    private final String cmd;
    
    public ExecCmd(String cmd){
        this.cmd = cmd;
    }
    
    public String getCmd(){
        return cmd;
    }
    
    public Process getProcesso(){
        return proc;
    }
    
    @Override
    public void run(){
        try{
            proc = Runtime.getRuntime().exec(cmd);
            synchronized(proc){
                proc.waitFor();
            }
        }  catch(IOException ex){
            System.out.println("Não foi possível executar o comando.");    
        } catch (InterruptedException ex){
            System.out.println("O processo terminou.");
        }
    }
    
    public synchronized void cancela(){
        proc.destroy();
    }
    
    public synchronized boolean terminado(){
        return !proc.isAlive();
    }
}
