/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ers.students.crud.results;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Irina
 */
public class LoadResult <E> {
    E entity;
    Map<ErrorCode, List<String> > errors = new HashMap<>();
}
