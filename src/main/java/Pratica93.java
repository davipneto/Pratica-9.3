
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.ExecCmd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author davip_000
 */
public class Pratica93 {
    public static void main(String[] args){
        Runtime rt = Runtime.getRuntime();
        List<ExecCmd> comandos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String cmd;
        
        while(true){
            System.out.print("comando> ");
            cmd = scanner.next();
            
            if(!cmd.toLowerCase().equals("fim")){
                comandos.add(new ExecCmd(cmd));
                comandos.get(comandos.size()-1).start();
            }
            else{
                int soma = 0;
                char resposta;
                
                for(ExecCmd c: comandos)
                    soma += c.terminado()?0:1;
                
                System.out.print("Há " + soma + 
                        " processos em execução. Deseja terminá-los? <y/n>");
                
                do
                    resposta = scanner.next().charAt(0);
                while(resposta != 'y' && resposta != 'n');
                
                if(resposta == 'y'){
                    for(ExecCmd c: comandos)
                        c.cancela();
                    break;
                }
                
            }
        }
    }
}
