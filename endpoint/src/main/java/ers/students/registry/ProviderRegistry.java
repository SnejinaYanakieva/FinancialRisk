/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.registry;

import java.util.HashMap;

/**
 *
 * @author martinstoynov
 */

public class ProviderRegistry {
    
    private static ProviderRegistry instance = null;
    private HashMap registry = null;
    
    private ProviderRegistry() {
        registry = new HashMap();
    }
    
    static public void addToRegistry(Object key, Object value){
        if(instance == null)
            instance = new ProviderRegistry();
        instance.registry.put(key, value);
    }
    
    public static Object getProvider(Object key) {
        if(instance == null)
            instance = new ProviderRegistry();
        return instance.registry.get(key);
    }

}
