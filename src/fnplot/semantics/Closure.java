package fnplot.semantics;

import java.util.*;

import fnplot.syntax.Exp;
import fnplot.values.FnPlotType;
import fnplot.values.FnPlotValue;

public class Closure extends FnPlotValue<Closure>  {
    private ArrayList<String> parameters;
    private String rest = null;
    private String id = null;
    private Exp body;
    private Environment<FnPlotValue<?>> env;

    public Closure(ArrayList<String> params,Exp body,Environment<FnPlotValue<?>> env){
        this.parameters = params;
        this.body = body;
        this.env = env;
    }

    public ArrayList<String> getParameters(){
        return parameters;
    }
    public Environment<FnPlotValue<?>> getEnvironment(){
        return env;
    }
    public Exp getBody(){
        return body;
    }
    public void setRest(String rest){
        this.rest = rest;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getRestParameters() {
        return this.rest;
    }
    public String getId() {
        return this.id;
    }
    @Override
    public FnPlotType getType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String toString() {
        return "Closure [body=" + body + ", env=" + env + ", parameters=" + parameters + "]";
    }

    
}