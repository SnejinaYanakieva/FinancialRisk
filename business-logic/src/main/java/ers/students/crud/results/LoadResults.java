/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.results;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The LoadResults class provides by given ErrorCode corresponding list of
 * errors. It also contains information about loaded entities.
 *
 * @author Irina
 */
public class LoadResults<E> {

    List<E> entities = new ArrayList<>();
    Map<ErrorCode, List<String>> errors = new HashMap<>();
}
