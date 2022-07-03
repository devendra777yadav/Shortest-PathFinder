package main;

import java.util.ArrayList;
import java.util.HashMap;

public class dijkstra {
    
    private static final int  length=80; // Toplam þehir sayýsý   
    private static final int noparent=-1;
    
    ArrayList  <Integer> distancetogo = new ArrayList <Integer>();
    ArrayList  <Integer> roads = new ArrayList <Integer>();
    ArrayList  <Integer> targetcity = new ArrayList <Integer>();
    ArrayList  <Integer> city = new ArrayList <Integer>();
    ArrayList  <Integer> roadsD = new ArrayList <Integer>();
    private int returncity;
    
  private void roads(int available , int parent []){
         if(available == noparent){
             return;                 
         }
         roads(parent[available],parent);
         roads.add(available);
    }
  
  private void roadsD(int available , int parent []){
      if(available == noparent){
          return;                 
      }
      	roadsD(parent[available],parent);
      	roadsD.add(available);
 }
  
  private void regulator(ArrayList  <Integer> roads) {
    	 int  before=roads.get(0);
   		 for(int i : roads) {
   			if(i==before) {	
   				continue;
   			}
   			before=i;
   			city.add(i);
   		}
       }
             
  public int totaldistancetogo(ArrayList <Integer> distancetogo ){
        int sum=0;
        for(int i =0; i<distancetogo.size(); i++){
            sum=sum+distancetogo.get(i);
        }
        return sum;
    }
       
  private int minFinder(ArrayList <Integer> choice,int distance[]){
    	  HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
          int minIndex=-1;
          for(int i=0; i<choice.size(); i++) {
        	  for(int j=0; j<distance.length; j++) {
        		  if(j==choice.get(i)) {      			  
        			  map.put(j, distance[j]);
        			  break;
        		  }
        	  }
          }                    
          int min=Integer.MAX_VALUE;               
          for(int i  : map.keySet()) {
        	  if(map.get(i)<min){
                  min=map.get(i);           
                  minIndex=i;
        	  }
          }                 
        return minIndex;
      }
      
  public int dijkstra(int neighborhoodMatrix [][], int start, ArrayList <Integer> choice){
      for(int o=0; o<choice.size(); o++) {
    		   targetcity.add(choice.get(o));
    	   }
    	   if(choice.size()==0){
               return dijkstraReturn(neighborhoodMatrix,returncity);
           }                    
           else{                    	
               if(choice.size()==1){        	
                  returncity=choice.get(0);
                    	}  	
           int distances[] = new int[length]; // Kaynaktan hedeflere olan uzaklýk
           boolean situation[]= new boolean[length]; // Ziyaret edilme distancesu               
           
      for(int i=0; i<length; i++){
               // Baþlangýçta tüm düðümlere "sonsuz" ve "false" yani uðranmamýþ atadýk
               distances[i]=Integer.MAX_VALUE;
               situation[i]=false;
    }
           
            distances[start]=0; // Kaynaðýn kendine olan uzaklýðý her zaman 0 olur
            int  parent[]  = new int[length]; // gidilen kýsa yolu tutacak
            parent[start]=noparent; // Baþlangýçýn ebeveyni yok
                
      for(int j=0; j<length; j++){
          int theClosestIndex=-1;
          int dis=Integer.MAX_VALUE;
        
        for(int k=0; k<length; k++){
            if(!situation[k] && distances[k]<dis){
                theClosestIndex=k;
                dis=distances[k];
            }
        }
            situation[theClosestIndex]=true; // Seçilene uðrandý
        
        for(int k=0; k<length; k++){ 
        int distance = neighborhoodkMatrix[theClosestIndex][k];   
            if(distance > 0 &&((dis + distance)<distances[k])){
                parent[k]=theClosestIndex;
                distances[k]=distance + dis;
            }
        }    
    }   
    
    int u=minFinder(choice,distances);
    this.distancetogo.add(distances[u]);
    roads(u,parent);         
    choice.remove(choice.indexOf(u));        
                        return dijkstra(neighborhoodkMatrix,u,choice);
           }
       }                   
       
  private int dijkstraReturn(int neighborhoodkMatrix [][], int start){
    	 
           int distances[] = new int[length]; // Kaynaktan hedeflere olan uzaklýk
           boolean distances[]= new boolean[length]; // Ziyaret edilme distancesu
           
           		for(int i=0; i<length; i++){
           			// Baþlangýçta tüm düðümlere "sonsuz" ve "false" yani uðranmamýþ atadýk
           			distances[i]=Integer.MAX_VALUE;
           			distances[i]=false;
    }
           
           			distances[start]=0; // Kaynaðýn kendine olan uzaklýðý her zaman 0 olur
           			int  parent[]  = new int[length]; // gidilen kýsa yolu tutacak
           			parent[start]=noparent; // Baþlangýçýn ebeveyni yok
                
            	for(int j=1; j<length; j++){
            		int theClosestIndex=-1;
            		int dis=Integer.MAX_VALUE;
        
            	for(int k=0; k<length; k++){
            		if(!distances[k] && distances[k]<dis){
            			theClosestIndex=k;
            			dis=distances[k];
            }
        }
            		distances[theClosestIndex]=true; // Seçilene uðrandý
        
            	for(int k=0; k<length; k++){
            
            		int distance = neighborhoodMatrix[theClosestIndex][k];
            
            		if(distance>0 &&((dis+distance)<distances[k])){           
            			parent[k]=theClosestIndex;
            			distances[k]=distance+dis;
            }
        }    
    }   
   
            			int u=40;
            			this.distancetogo.add(distances[u]);
            			roads(u,parent);
            			regulator(roads);
            			roadsD(u,parent);

   return -1;                     
     		}
       }

