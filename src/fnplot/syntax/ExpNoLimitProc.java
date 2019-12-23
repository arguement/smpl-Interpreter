/*
 * ExpFunction.java
 * Created on 14-Nov-2016, 9:41:02 PM
 */

/*
 * Copyright (C) 2016 newts
 * Produced as part of course software for COMP3652 at UWI, Mona
 * If you have any questions about this software, please contact
 * the author.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fnplot.syntax;

import fnplot.semantics.Visitor;
import fnplot.sys.FnPlotException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author newts
 */
public class ExpNoLimitProc extends Exp {

    ArrayList<String> parameters;
    Exp body;
    private String id;

    public ExpNoLimitProc() {
        super();
    }

    public ExpNoLimitProc(String id,Exp body) {

        this.body = body;
        this.id = id;
        this.parameters = new ArrayList<>();
    }
   
    public ArrayList<String> getParameters(){
        return this.parameters;
    }
    public Exp getBody() {
        return body;
    }

    public String getId(){
        return this.id;
    }
    
    @Override
    public <S, T> T visit(Visitor<S, T> v, S state) throws FnPlotException {
        
        return v.visitNoLimitProcDefn(this, state);
    }

    @Override
    public String toString() {
        
        return "no limit proc";
    }

}
