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
          bean.Build();
      }
}
