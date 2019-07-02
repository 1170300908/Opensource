/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.src.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteVerticesGraph<L> implements Graph<L> {
    
    private final List<Vertex> vertices = new ArrayList<>();
    
    // Abstraction function:
    //   TODO add:add vertex to graph,remove:remove vertex from graph,set:set weight to edge,vertices:return set of vertex,targets:return a map construct by targets and its weight of every single weight
    // Representation invariant:
    //   TODO vertices contains all the vertex in the graph , edges contains spec info of every single edge,including source vertex,target vertex and weight
    // Safety from rep exposure:
    //   TODO transfer a copy of rep in the exposure
    
    // TODO constructor
    public ConcreteVerticesGraph ConcreteVerticesGraph(){
    	return new ConcreteVerticesGraph();
    }
    // TODO checkRep
    private void checkRep(){
    	//assert
    }
    @Override public boolean add(L vertex) {
        //throw new RuntimeException("not implemented");
    	for(int i = 0;i < vertices.size();i++){
    		if(vertices.get(i).vertax.equals(vertex)){
    			return false;
    		}
    	}
    	Vertex ver = new Vertex();
    	ver.vertax = vertex;
    	vertices.add(ver);
    	return true;
    }
    
    @Override public int set(L source, L target, int weight) {
        //throw new RuntimeException("not implemented");
    	for(int i = 0;i < vertices.size();i++){
    		if(vertices.get(i).vertax.equals(source)){
    			if(vertices.get(i).map.containsKey(target)){
    				int temp = vertices.get(i).map.get(target);
    				vertices.get(i).map.put(target, weight);
    				return temp;
    			}
    			else{
    				vertices.get(i).map.put(target, weight);
    				return 0;
    			}
    		}
    	}
    	return -1;
    }
    
    @Override public boolean remove(L vertex) {
        //throw new RuntimeException("not implemented");
        for(int i = 0;i < vertices.size();i++){
        	if(vertices.get(i).vertax.equals(vertex)){
        		vertices.remove(i);
        		return true;
        	}
        }
        return false;
    }
    
    @Override public Set<L> vertices() {
        //throw new RuntimeException("not implemented");
    	Set<L> set = new HashSet<L>();
    	for(int i = 0;i < vertices.size();i++){
    		set.add(vertices.get(i).vertax);
    	}
    	return set;
    }
    
    @Override public Map<L, Integer> sources(L target) {
        //throw new RuntimeException("not implemented");
    	Map<L,Integer> map = new HashMap<L,Integer>();
    	for(int i = 0;i < vertices.size();i++){
    		if(vertices.get(i).map.containsKey(target)){
    			map.put(vertices.get(i).vertax,vertices.get(i).map.get(target));
    		}
    	}
    	return map;
    }
    
    @Override public Map<L, Integer> targets(L source) {
        //throw new RuntimeException("not implemented");
    	Map<L,Integer> map = new HashMap<L,Integer>();
    	for(int i = 0;i < vertices.size();i++){
    		if(vertices.get(i).vertax.equals(source)){
    			return vertices.get(i).map;
    		}
    	}
    	return map;
    }
    
    // TODO toString()
    public String toString(){
    	String result = " ";
    	for(int i = 0;i < vertices.size();i++){
    		result = result.concat(vertices.get(i).toString());
    	}
    	return result;
    }
    
    /**
     * @author Siren
     * @param void
     * @return List<Vertex> return a copy of rep invariant : vertices
     */
    public List<Vertex> allVertex(){
    	List<Vertex> copy = vertices;
    	return copy;
    }
    
    /**
     * TODO specification
     * Mutable.
     * This class is internal to the rep of ConcreteVerticesGraph.
     * 
     * <p>PS2 instructions: the specification and implementation of this class is
     * up to you.
     */
    public class Vertex {
        
        // TODO fields
        private L vertax;
        private Map<L,Integer> map = new HashMap<L,Integer>();
        // Abstraction function:
        //   TODO checkRep:to check rep invariant,equals:compare with two Vertex,toString:convert a Vertex type to string
        // Representation invariant:
        //   TODO vertax : the source vertex, map: key reps target that the source point to ,integer reps the weight
        // Safety from rep exposure:
        //   TODO
        
        // TODO constructor
        public Vertex Vertex(){
        	return new Vertex();
        }
        // TODO checkRep
        public void checkRep(){
        	assert map.size() >= 0;
        }
        // TODO methods
        public boolean equals(Vertex vertex){
        	if(!vertex.equals(vertax)){
        		return false;
        	}
        	if(!vertex.map.equals(map)){
        		return false;
        	}
        	return true;
        }
        
        public L source(Vertex vertex){
        	L copy = vertex.vertax;
        	return copy;
        }
        
        public Map<L,Integer> targetMap(Vertex vertex){
        	Map<L,Integer> copy = vertex.map;
        	return copy;
        }
        // TODO toString()
        public String toString(){
        	String result = "source: ".concat((String)vertax);
        	result = result.concat(map.toString());
        	return result;
        }
    }
}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
/*
class Vertex {
    
    // TODO fields
    protected String vertax;
    Map<String,Integer> map = new HashMap<String,Integer>();
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    public Vertex Vertex(){
    	return new Vertex();
    }
    // TODO checkRep
    public void checkRep(){
    	assert map.size() >= 0;
    }
    // TODO methods
    public boolean equals(Vertex vertex){
    	if(!vertex.equals(vertax)){
    		return false;
    	}
    	if(!vertex.map.equals(map)){
    		return false;
    	}
    	return true;
    }
    // TODO toString()
    public String toString(){
    	String result = "source: ".concat(vertax);
    	result = result.concat(map.toString());
    	return result;
    }
}
*/
