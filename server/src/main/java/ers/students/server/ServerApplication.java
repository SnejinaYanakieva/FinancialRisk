/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.server;

/**
 *
 * @author Viktor
 */
public class ServerApplication {

    public static void main(String args[]) throws Exception {
        
        JaxrsServerFactoryBean bean = new JaxrsServerFactoryBean();
        
        for (int i = 0; i < args.length; i++) {
            if(args[i].equals("start")){
                System.out.println("Starting..");
                bean.Build();
                System.out.println("Started..");
            }
            else if(args[i].equals("stop")){
                bean.serverStop();
                System.out.println("Stopped..");
            }
            else{
                System.out.println("Unknown command!");
            }
        }
    }
}
