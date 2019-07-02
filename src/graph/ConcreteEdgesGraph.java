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
public class ConcreteEdgesGraph<L> implements Graph<L> {
    
    private final Set<L> vertices = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();
    
    // Abstraction function:
    //   TODO add:add vertex to graph,remove:remove vertex from graph,set:set weight to edge,vertices:return set of vertex,targets:return a map construct by targets and its weight of every single weight
    // Representation invariant:
    //   TODO  vertices contains all the vertex in the graph , edges contains spec info of every single edge,including source vertex,target vertex and weight
    // Safety from rep exposure:
    //   TODO transfer a copy of rep in the exposure
    
    // TODO constructor
    public ConcreteEdgesGraph ConcreteEdgesGraph() {
    	return new ConcreteEdgesGraph<L>();
    }
    // TODO checkRep
    public void checkRep() {
    	assert vertices.size() >= 0;
    	assert edges.size() >= 0;
    }
    
    @Override public boolean add(L vertex) {
        //throw new RuntimeException("not implemented");
    	if(vertices.contains(vertex))  return false;
    	vertices.add(vertex);
    	return true;
    }
    
    @Override public int set(L source, L target, int weight) {
        //throw new RuntimeException("not implemented");
    	if(!vertices.contains(source)) throw new RuntimeException("No such source:  "+source);
    	if(!vertices.contains(target)) throw new RuntimeException("No such target:  "+target);
    	Edge edge = new Edge();
    	edge.vertaxSource = source;
    	edge.vertaxTarget = target;
    	for(int i = 0;i < edges.size();i++){
    		if(edges.get(i).vertaxSource.equals(source) && edges.get(i).vertaxTarget.equals(target)){
    			edge.edgeWeight = weight;
    			return edges.get(i).edgeWeight;
    		}
    	}
    	edge.edgeWeight = weight;
    	edges.add(edge);
    	return 0;
    }
    
    @Override public boolean remove(L vertex) {
        //throw new RuntimeException("not implemented");
    	if(!vertices.contains(vertex)) return false; 
    	for(int i = 0;i < edges.size();i++){
    		if(edges.get(i).vertaxSource.equals(vertex) || edges.get(i).vertaxTarget.equals(vertex)){
    			edges.remove(i);
    		}
    	}
    	vertices.remove(vertex);
    	return true;
    }
    
    @Override public Set<L> vertices() {
        //throw new RuntimeException("not implemented");
    	Set<L> copy = vertices;
    	return copy;
    }
    
    @Override public Map<L, Integer> sources(L target) {
       // throw new RuntimeException("not implemented");
    	Map<L,Integer> result = new HashMap<L,Integer>();
    	for(int i = 0;i < edges.size();i++){
    		if(edges.get(i).vertaxTarget.equals(target)){
    			result.put(edges.get(i).vertaxSource,edges.get(i).edgeWeight);
    		}
    	}
    	return result;
    }
    
    @Override public Map<L, Integer> targets(L source) {
        //throw new RuntimeException("not implemented");
    	Map<L,Integer> result = new HashMap<L,Integer>();
    	for(int i = 0;i < edges.size();i++){
    		if(edges.get(i).vertaxSource.equals(source)){
    			result.put(edges.get(i).vertaxTarget, edges.get(i).edgeWeight);
    		}
    	}
    	return result;
    }
    
    // TODO toString()
    public String toString(){
    	String result = " ";
    	for(int i = 0;i < edges.size();i++){
    		result = result.concat("source: "+edges.get(i).vertaxSource+" target: "+edges.get(i).vertaxTarget+" weight: "+edges.get(i).edgeWeight+" ; ");
    	}
    	return result;
    }
    /**
     * @author Siren
     * @param void
     * @return List<Edge> return a copy of the rep invariant: edges
     */
    public List<Edge> allEdge(){
    	List<Edge> copy = edges;
    	return copy;
    }
    
    
    /**
     * TODO specification
     * Immutable.
     * This class is internal to the rep of Concre
     * teEdgesGraph.
     * 
     * <p>PS2 instructions: the specification and implementation of this class is
     * up to you.
     */
    public class Edge {
        
        // TODO fields
        private  L vertaxSource;
        private L vertaxTarget;
        private int edgeWeight;
        // Abstraction function:
        //   TODO checkRep:to check rep invariant,equal:compare two edge type,source:return source of the type,target:return target of the type,weight,return weight of the weight
        // Representation invariant:
        //   TODO vertaxSouce reps the start vertex of an single edge,vertaxTarget reps the end of the same edge,edgeWeight reps weight of this edge.
        // Safety from rep exposure:
        //   TODO
        
        // TODO constructor
        public Edge Edge(){
        	return new Edge();
        }
        // TODO checkRep
        private void checkRep(){
        	assert (int)edgeWeight > 0;
        }
        // TODO methods
        /**
         * @author Siren
         * @param edge
         * @return true if the two edge instance equals,otherwise return false
         */
        public boolean equals(Edge edge){
        	if(this.vertaxSource.equals(edge.vertaxSource) && this.vertaxTarget.equals(edge.vertaxTarget) && this.edgeWeight == edge.edgeWeight){
        		return true;
        	}
        	return false;
        }
        /**
         * @author Siren
         * @param edge
         * @return a string source
         */
        public L source(Edge edge){
        	L copy = edge.vertaxSource;
        	return copy;
        }
        /**
         * @author Siren
         * @param edge
         * @return a string target
         */
        public L target(Edge edge){
        	L copy = edge.vertaxTarget;
        	return copy;
        }
        /**
         * @author Siren
         * @param edge
         * @return a integer ,the weight
         */
        public int weight(Edge edge){
        	int copy = edge.edgeWeight;
        	return copy;
        }
        
        // TODO toString()
        public String toString(){
        	String result = ((String)vertaxSource).concat("--("+edgeWeight+")-->").concat((String)vertaxTarget);
        	
        	return result;
        }
    }
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of Concre
 * teEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
/*
class Edge {
    
    // TODO fields
    protected String vertaxSource;
    protected String vertaxTarget;
    protected int edgeWeight;
    // Abstraction function:
    //   TODO 
    // Representation invariant:
    //   TODO vertaxSouce reps the start vertex of an single edge,vertaxTarget reps the end of the same edge,edgeWeight reps weight of this edge.
    // Safety from rep exposure:
    //   TODO
    
    // TODO constructor
    public Edge Edge(){
    	return new Edge();
    }
    // TODO checkRep
    private void checkRep(){
    	assert edgeWeight > 0;
    }
    // TODO methods
    public boolean equals(Edge edge){
    	if(this.vertaxSource.equals(edge.vertaxSource) && this.vertaxTarget.equals(edge.vertaxTarget) && this.edgeWeight == edge.edgeWeight){
    		return true;
    	}
    	return false;
    }
    // TODO toString()
    public String toString(){
    	String result = vertaxSource.concat("--->").concat(vertaxTarget);
    	return result;
    }
}
*/
